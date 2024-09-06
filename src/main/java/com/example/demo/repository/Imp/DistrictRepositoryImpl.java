package com.example.demo.repository.Imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.entity.DistrictEntity;

import ultil.ConnectionUntil;
@Repository

public class DistrictRepositoryImpl implements DistrictRepository {
	private String hostName = "localhost:3306";
	private String dbName = "estatebasic";
	private String username = "root";
	private String password = "#Quangtoan2112";
	private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
	@Override
	public DistrictEntity findNameById(Long id) {
		String sql = " SELECT *  from district d where d.id = " + id + " ;";
		System.out.println("Vao thành công");

		try(Connection conn = ConnectionUntil.getConnection()) {
	
			System.out.println("Kết nối thành công");
			Statement sstt = conn.createStatement();
			DistrictEntity districtEntity = new DistrictEntity();
			ResultSet rs = sstt.executeQuery(sql);
			while (rs.next()) {
			
				districtEntity.setName(rs.getString("name"));
				
			}
			
			System.out.println("Kết nối thành công"+ districtEntity.getName());
			return districtEntity;
		} catch (Exception e) {
			System.out.println("Lỗi");
		}
		return null;
	}
     
}
