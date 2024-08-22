package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.BuildingDTO;
import com.example.demo.Service.BuildingService;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.Imp.BuildingRepositoryImpl;
import com.example.demo.repository.entity.BuildingEntity;



@Service
public class BuldingServiceImpl implements BuildingService {
	
	
	
	
     @Autowired
    private BuildingRepository buildingRepository;	
	//private BuildingRepositoryImpl buildingRepositoryImpl = new BuildingRepositoryImpl();
	
	
	@Override
	public List<BuildingDTO> findAll(Map<String,Object> params) {
		Long distintId = (long) 3.0;
		//List<BuildingEntity>  buildingEntity =buildingRepository.findAll(name);
		List<BuildingEntity>  buildingEntity =buildingRepository.findAll(params);
		List<BuildingDTO>  result =new ArrayList<BuildingDTO>();	
		for(BuildingEntity result1 : buildingEntity) {
			BuildingDTO buildingRespone =new BuildingDTO();
			buildingRespone.setName(result1.getName());
			buildingRespone.setAddress(result1.getStreet() + " "+ result1.getWard());
			buildingRespone.setNumberOfBasement(result1.getNumberofbasement());
			result.add(buildingRespone);
			
		}
		return result;
	}

}
