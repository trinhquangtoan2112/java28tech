package com.example.demo.repository.Imp;
import com.example.demo.repository.entity.BuildingEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.repository.BuildingRepository;



@Service
public class BuildingRepositoryImpl implements BuildingRepository {
	private String hostName = "localhost:3306";
	private String dbName = "estatebasic";
	private String username = "root";
	private String password = "#Quangtoan2112";
	private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
	
	public static void joinTable(Map<String,Object> params,StringBuilder sql) {
		Long staffID = (Long)params.get("staffId");
		if(staffID !=null) {
			sql.append("INNER JOIN assignmentbuilding ON id =assignmentbuilding.buildingid");
		}
	}
 @Override 
 public List<BuildingEntity> findAll(Map<String,Object> params){
		List<BuildingEntity> building = new ArrayList<BuildingEntity>();
		StringBuilder Sql =new StringBuilder( "SELECT * FROM building  " );
		joinTable(params,Sql);
		StringBuilder where  =new StringBuilder("where 1=1");
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
				ketqua.setName(rs.getString("name"));
				ketqua.setStreet(rs.getString("street"));
				ketqua.setNumberofbasement(rs.getInt("numberofbasement"));
				ketqua.setWard(rs.getString("ward"));
				building.add(ketqua);
			}
			System.out.println("Kết nối thành công");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return building;
 }
} 
