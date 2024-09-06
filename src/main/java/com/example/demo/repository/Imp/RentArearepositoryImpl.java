package com.example.demo.repository.Imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.repository.RentAreaRepository;
import com.example.demo.repository.entity.RentAreaEntity;
import com.mysql.cj.xdevapi.Result;

import ultil.ConnectionUntil;
@Repository
public class RentArearepositoryImpl implements RentAreaRepository {

	@Override
	public List<RentAreaEntity> getVauleByBuilding(Integer id) {

		String sql = "Select * from rentarea r where r.buildingid = " + id;
		List<RentAreaEntity> rentArea = new ArrayList<>();
         try(Connection con = ConnectionUntil.getConnection()) {
			Statement stms =con.createStatement();
			ResultSet rs = stms.executeQuery(sql);
			while(rs.next()) {
				RentAreaEntity areaEntity =new RentAreaEntity();
				areaEntity.setValue(rs.getString("value"));
				rentArea.add(areaEntity);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rentArea;
	}

}
