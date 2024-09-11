package com.example.demo.repository.Imp;

import java.util.List;

import com.example.demo.builder.BuildingSearchBuilder;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.entity.BuildingEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class JpaBuildingRepositoryImpl  implements BuildingRepository{

	
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder builderSearchBuilder) {
		String sql = "From BuildingEntity b";
		Query query = entityManager.createQuery(sql,BuildingEntity.class);
		return query.getResultList();
	}

}
