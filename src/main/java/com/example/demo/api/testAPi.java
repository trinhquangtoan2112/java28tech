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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.BuildingDTO;
import com.example.demo.Service.BuildingService;
import com.example.demo.Service.Impl.BuldingServiceImpl;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.Imp.JDBCBuildingRepositoryImpl;
import com.example.demo.repository.entity.DistrictEntity;

@RestController
@PropertySource("classpath:application.properties")
public class testAPi {
	private String hostName = "localhost:3306";
	private String dbName = "estatebasic";
	private String username = "root";
	private String password = "#Quangtoan2112";
	private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
	
	@Autowired(required = false)
     private BuildingService buldingService;
	@Autowired
	private DistrictRepository districtRepository; 
	//private BuldingServiceImpl buldingServiceImpl = new BuldingServiceImpl();
	
	@Value("${dev.nguyen}")
	private String data;
	@GetMapping("TestSql")
	public List<BuildingDTO> connect(@RequestParam Map<String,Object> params,@RequestParam(name = "typeCode", required = false) List<String> typeCode) {
	//List<BuildingDTO> result =buldingService.findAll(name);
		
		List<BuildingDTO> result =buldingService.findAll(params,typeCode);
		
		return 	result; 
	}
	@GetMapping("TestSql123")
	public void connect123(@RequestParam Long id) {
	//List<BuildingDTO> result =buldingService.findAll(name);
		System.out.println(data);
	
	}
}
