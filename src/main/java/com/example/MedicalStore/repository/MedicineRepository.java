package com.example.MedicalStore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.MedicalStore.model.MedicalStore;
import com.example.MedicalStore.model.Medicine;


@Repository
//@EnableTransactionManagement
//@Transactional
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	
	
	@Override
	@EntityGraph("MedicineStoreEntityGraph")
	Optional<Medicine> findById(Long id);
	
	@Override
	@EntityGraph("MedicineStoreEntityGraph")
	List<Medicine> findAll();
	
}
