package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(Map<String,Object> params, List<String> typeCodes) ;
}
