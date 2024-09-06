package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Config.ModelMapperConfig;
import com.example.demo.Model.BuildingDTO;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.RentAreaRepository;
import com.example.demo.repository.entity.BuildingEntity;
import com.example.demo.repository.entity.DistrictEntity;
import com.example.demo.repository.entity.RentAreaEntity;

@Component
public class BuildingConverter {
	   @Autowired
	    private BuildingRepository buildingRepository;	
		//private BuildingRepositoryImpl buildingRepositoryImpl = new BuildingRepositoryImpl();
		@Autowired
		private DistrictRepository districtRepository;
		@Autowired
		private RentAreaRepository rentAreaRepository;
		
		@Autowired
		private ModelMapper modelMapper; 
		public BuildingDTO toBuild(BuildingEntity result1) {
			BuildingDTO buildingRespone =modelMapper.map(result1, BuildingDTO.class);
			buildingRespone.setName(result1.getName());
			DistrictEntity districtEntity = districtRepository.findNameById(result1.getDistrictid());
			buildingRespone.setAddress(result1.getStreet() + " "+ result1.getWard()+" "+ districtEntity.getName());
			buildingRespone.setNumberOfBasement(result1.getNumberofbasement());
			List<RentAreaEntity> rentAreaEntities =  rentAreaRepository.getVauleByBuilding(result1.getId());
			String areaResult =rentAreaEntities.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
			/*
			 * buildingRespone.setRentArea(areaResult);
			 * buildingRespone.setBrokerageFee(result1.getBrokeragefee());
			 * buildingRespone.setEmptyArea(result1.getEmptyArea());
			 * buildingRespone.setFloorArea(result1.getFloorarea());
			 * buildingRespone.setManagerName(result1.getManagername());
			 * buildingRespone.setManagerPhoneNumber(result1.getManagerphonenumber());
			 */
			return buildingRespone;
		}
}
