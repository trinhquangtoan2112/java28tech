package com.example.demo.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.builder.BuildingSearchBuilder;


import ultil.MapUltil;


@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String,Object> params, List<String> typeCodes ) {
    	BuildingSearchBuilder builderSearchBuilder = new BuildingSearchBuilder.Builder()
    			.setName(MapUltil.getObject(params, "name", String.class))
				.setStreet(MapUltil.getObject(params, "street", String.class))
				.setWard(MapUltil.getObject(params, "ward", String.class))
				.setDistrictid(MapUltil.getObject(params, "districtid", Integer.class))
				.setNumberofbasement(MapUltil.getObject(params, "numberofbasement", Integer.class))
				.setFloorarea(MapUltil.getObject(params, "floorarea", Integer.class))
				.setLevel(MapUltil.getObject(params, "level", String.class))
				.setRentpricefrom(MapUltil.getObject(params, "rentpricefrom", Integer.class))
				.setRentpriceto(MapUltil.getObject(params, "rentpriceto", Integer.class))
				.setRentareafrom(MapUltil.getObject(params, "rentareafrom", Integer.class))
				.setRentareato(MapUltil.getObject(params, "rentareato", Integer.class))
				.setBrokeragefee(MapUltil.getObject(params, "brokeragefee", Long.class))
				.setManagername(MapUltil.getObject(params, "managername", String.class))
				.setManagerphonenumber(MapUltil.getObject(params, "managerphonenumber", String.class))
				.setStaffid(MapUltil.getObject(params, "staffid", Integer.class)).setTypeBuilding(typeCodes).build();
    			;
    	
    	return builderSearchBuilder;
    }
}
