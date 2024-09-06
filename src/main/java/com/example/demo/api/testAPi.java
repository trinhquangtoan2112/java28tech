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
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.Imp.BuildingRepositoryImpl;
import com.example.demo.repository.entity.DistrictEntity;

@RestController
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
	@GetMapping("TestSql")
	public List<BuildingDTO> connect(@RequestParam Map<String,Object> params,@RequestParam(name = "typeCode", required = false) List<String> typeCode) {
	//List<BuildingDTO> result =buldingService.findAll(name);
		
		List<BuildingDTO> result =buldingService.findAll(params,typeCode);
		
		return 	result; 
	}
	@GetMapping("TestSql123")
	public DistrictEntity connect123(@RequestParam Long id) {
	//List<BuildingDTO> result =buldingService.findAll(name);
		System.out.println("124124");
		DistrictEntity dis = districtRepository.findNameById(id);
		return 	dis; 
	}
}
