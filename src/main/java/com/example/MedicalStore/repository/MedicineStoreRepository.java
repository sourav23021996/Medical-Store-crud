package com.example.MedicalStore.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Convert;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.MedicalStore.model.MedicalStore;



//@Transactional
@Repository
//@EnableJpaRepositories
//@EnableTransactionManagement
public interface MedicineStoreRepository extends JpaRepository<MedicalStore, Long>, JpaSpecificationExecutor<MedicalStore> {
	
	@Override
	@EntityGraph("storeEntityGraph")
	Optional<MedicalStore> findById(Long id);
	
	@Override
	@EntityGraph("storeEntityGraph")
	List<MedicalStore> findAll();
	
	MedicalStore getById(long id);


	@Query("SELECT new MedicalStore(m.id, m.storeName) from MedicalStore m")
List<MedicalStore> findAllStore();
	
//	@Transactional
	@Modifying	
	@Query("SELECT storeName from MedicalStore")
//	@EntityGraph(value="storeEntityGraph")
	List<MedicalStore> viewstore();
}