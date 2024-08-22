package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(Map<String,Object> params) ;
}
