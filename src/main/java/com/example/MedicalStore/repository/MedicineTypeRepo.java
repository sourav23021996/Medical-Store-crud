package com.example.MedicalStore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.MedicalStore.model.MedicalStore;
import com.example.MedicalStore.model.Medicine;
import com.example.MedicalStore.model.MedicineType;

public interface MedicineTypeRepo extends JpaRepository<MedicineType,Long>{

	MedicineType getById(long id);
	
}
