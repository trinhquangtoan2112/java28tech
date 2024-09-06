package com.example.demo.repository.Imp;

import com.example.demo.repository.entity.BuildingEntity;

import ultil.NumberUntil;
import ultil.StringUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.builder.BuildingSearchBuilder;
import com.example.demo.repository.BuildingRepository;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	private String hostName = "localhost:3306";
	private String dbName = "estatebasic";
	private String username = "root";
	private String password = "#Quangtoan2112";
	private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		String staffID = buildingSearchBuilder.getStaffid() !=null?buildingSearchBuilder.getStaffid() .toString():null;
		if (staffID != null) {
			sql.append(" INNER JOIN assignmentbuilding ON b.id =assignmentbuilding.buildingid ");
		}
		List<String> typeCodes = buildingSearchBuilder.getTypeBuilding();
		if (typeCodes != null && typeCodes.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype ON b.id =buildingrenttype.buildingid ");
			sql.append("  INNER JOIN renttype ON renttype.id =buildingrenttype.renttypeid ");
		}

		String rentAreaTo = buildingSearchBuilder.getRentareato().toString();
		String rentAreaFrom = buildingSearchBuilder.getRentareafrom().toString();
		if (rentAreaTo != null || rentAreaFrom != null) {
			sql.append(" INNER JOIN rentarea ON rentarea.buildingid = b.id ");
		}
	}

	public static void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		/*
		 * for(Map.Entry<String, Object> it :params.entrySet()) {
		 * if(!it.getKey().equals("staffId") && !it.getKey().equals("typeCode")
		 * &&!it.getKey().startsWith("area") &&!it.getKey().startsWith("rentPrice")) {
		 * String vaule =it.getValue().toString(); if(StringUtil.checkString(vaule)) {
		 * if(NumberUntil.isNumber(vaule)) { where.append(" AND b." + it.getKey() +
		 * " = " + vaule); }else { where.append(" AND b." + it.getKey() + " like '%" +
		 * vaule+ "%'"); } } } }
		 */
		try {
			Field[] field = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field item : field) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if (!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("area")
						&& !fieldName.startsWith("rentPrice")) {
					Object value = item.get(buildingSearchBuilder);
					if (value != null) {
						if (item.getType().equals("java.lang.long") || item.getType().equals("java.lang.Integer")) {
							where.append(" AND b." + fieldName + " = " + value);
						} else if (item.getType().equals("java.lang.String")) {
							where.append(" AND b." + fieldName + " like '%" + value + "%' ");
						}
					}

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		String staffID = buildingSearchBuilder.getStaffid() !=null?buildingSearchBuilder.getStaffid() .toString():null;
		if (staffID != null) {
			where.append(" AND assignmentbuilding.staffid =  " + staffID);
		}
		String rentAreaTo = buildingSearchBuilder.getRentareato().toString();
		String rentAreaFrom = buildingSearchBuilder.getRentareafrom().toString();
		if (rentAreaTo != null || rentAreaFrom != null) {
			where.append(" AND EXISTS (SELECT * FROM rentarea r where b.id =r.buildingid ");

			if (rentAreaFrom != null) {
				where.append(" AND rentarea.value >= " + rentAreaFrom);
			}
			if (rentAreaTo != null) {
				where.append(" AND rentarea.value <= " + rentAreaTo);
			}
			where.append(" ) ");
		}

		/*
		 * String rentPriceTo = buildingSearchBuilder.getRentpriceto().toString();
		 * String rentPriceFrom = buildingSearchBuilder.getRentpricefrom().toString();
		 * if (StringUtil.checkString(rentPriceFrom)) {
		 * where.append(" AND b.rentprice >= " + rentPriceFrom); } if
		 * (StringUtil.checkString(rentPriceTo)) { where.append(" AND b.rentprice <= " +
		 * rentPriceTo); }
		 */
		List<String> typeCodes = buildingSearchBuilder.getTypeBuilding();
		if (typeCodes != null && typeCodes.size() != 0) {
//		where.append(" AND renttype.code IN  ('" + String.join("", typeCodes) + "' ) ");
			where.append(" AND( ");
			String sql = typeCodes.stream().map(it -> "renttype.code Like '%" + it + "%'")
					.collect(Collectors.joining(" OR "));
			where.append(sql);
			where.append(" ) ");
		}
	}

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		List<BuildingEntity> building = new ArrayList<BuildingEntity>();
		StringBuilder Sql = new StringBuilder("SELECT * FROM building b ");
		joinTable(buildingSearchBuilder, Sql);

		StringBuilder where = new StringBuilder("where 1=1");
		queryNormal(buildingSearchBuilder, where);
		querySpecial(buildingSearchBuilder, where);
		Sql.append(where);
		System.out.println(Sql);
//		if(name !=null && !name.equals("")) {
//			Sql.append("and name like '% "+name+"%'");
//		};
//		if(distanitid !=null) {
//			Sql.append("and districtid = "+distanitid+"");
//		}
		try (Connection conn = DriverManager.getConnection(connectionURL, username, password);) {
			Statement sstt = conn.createStatement();
			ResultSet rs = sstt.executeQuery(Sql.toString());
			while (rs.next()) {
				BuildingEntity ketqua = new BuildingEntity();
				ketqua.setId(rs.getInt("id"));
				ketqua.setName(rs.getString("b.name"));
				ketqua.setWard(rs.getString("b.ward"));
				ketqua.setDistrictid(rs.getLong("b.districtid"));
				ketqua.setStreet(rs.getString("b.street"));
				ketqua.setFloorarea(rs.getLong("b.floorarea"));
				ketqua.setRentprice(rs.getLong("b.rentprice"));
				ketqua.setServicefee(rs.getLong("b.servicefee"));
				ketqua.setBrokeragefee(rs.getLong("b.brokeragefee"));
				ketqua.setManagername(rs.getString("b.managername"));
				ketqua.setManagerphonenumber(rs.getString("b.managerphonenumber"));
				ketqua.setNumberofbasement(rs.getInt("b.numberofbasement"));
//            	ketqua.setEmptyArea(rs.getString("emptyarea"));
				ketqua.setManagerphonenumber(rs.getString("b.managerphonenumber"));

				building.add(ketqua);
			}
			System.out.println("Kết nối thành công");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return building;
	}
}
