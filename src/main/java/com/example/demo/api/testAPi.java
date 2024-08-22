package com.example.demo.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.BuildingDTO;
import com.example.demo.Service.BuildingService;
import com.example.demo.Service.Impl.BuldingServiceImpl;
import com.example.demo.repository.Imp.BuildingRepositoryImpl;

@RestController
public class testAPi {
	private String hostName = "localhost:3306";
	private String dbName = "estatebasic";
	private String username = "root";
	private String password = "#Quangtoan2112";
	private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
	
	@Autowired(required = false)
     private BuildingService buldingService;
	
	//private BuldingServiceImpl buldingServiceImpl = new BuldingServiceImpl();
	@GetMapping("TestSql123")
	public List<BuildingDTO> connect(@RequestParam Map<String,Object> params) {
	//List<BuildingDTO> result =buldingService.findAll(name);
		List<BuildingDTO> result =buldingService.findAll(params);
		return 	result;
	}
}
