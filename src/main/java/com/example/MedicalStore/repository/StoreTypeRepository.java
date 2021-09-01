package com.example.MedicalStore.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Convert;

import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.MedicalStore.model.MedicalStore;
import com.example.MedicalStore.model.StoreType;

public interface StoreTypeRepository extends JpaRepository<StoreType, Long> {

	StoreType getById(long id);

	
//	@javax.persistence.Transient
	@Convert
	@Query("SELECT new StoreType(s.id, s.typeName) from StoreType s")
	List<StoreType> findAllStore();

	

}
