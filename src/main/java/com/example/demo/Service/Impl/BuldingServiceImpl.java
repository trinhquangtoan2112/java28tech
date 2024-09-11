package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.BuildingDTO;
import com.example.demo.Service.BuildingService;
import com.example.demo.builder.BuildingSearchBuilder;
import com.example.demo.converter.BuildingConverter;
import com.example.demo.converter.BuildingSearchBuilderConverter;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.RentAreaRepository;
import com.example.demo.repository.Imp.JDBCBuildingRepositoryImpl;
import com.example.demo.repository.entity.BuildingEntity;
import com.example.demo.repository.entity.DistrictEntity;
import com.example.demo.repository.entity.RentAreaEntity;



@Service
public class BuldingServiceImpl implements BuildingService {
	
	
	
	
     @Autowired
    private BuildingRepository buildingRepository;	
	//private BuildingRepositoryImpl buildingRepositoryImpl = new BuildingRepositoryImpl();
	
	@Autowired
	private BuildingConverter buildingConverter;
	
	@Autowired
	private BuildingSearchBuilderConverter builderConverter; 
	@Override
	public List<BuildingDTO> findAll(Map<String,Object> params,List<String> typeCode) {
		Long distintId = (long) 3.0;
		//List<BuildingEntity>  buildingEntity =buildingRepository.findAll(name);
		BuildingSearchBuilder buildingSearchBuilder = builderConverter.toBuildingSearchBuilder(params, typeCode);
		List<BuildingEntity>  buildingEntity =buildingRepository.findAll(buildingSearchBuilder);
		List<BuildingDTO>  result =new ArrayList<BuildingDTO>();	
		/*
		 * for(BuildingEntity result1 : buildingEntity) { BuildingDTO buildingRespone =
		 * buildingConverter.toBuild(result1);
		 * 
		 * result.add(buildingRespone); }
		 */
		for(BuildingEntity result1 : buildingEntity) {
			BuildingDTO buildingRespone = buildingConverter.toBuild(result1);
		
			result.add(buildingRespone);
		}
		return result;
	}

}
