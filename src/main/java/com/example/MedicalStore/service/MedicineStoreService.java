package com.example.MedicalStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MedicalStore.model.MedicalStore;
import com.example.MedicalStore.model.Medicine;
import com.example.MedicalStore.model.StoreType;
import com.example.MedicalStore.repository.MedicineStoreRepository;
import com.example.MedicalStore.repository.StoreTypeRepository;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
//@RequiredArgsConstructor//why this
public class MedicineStoreService {

	
	@Autowired
	MedicineStoreRepository medstorerepo;
	
	@Autowired
	StoreTypeRepository storerepo;
	
	
	
	@Transactional
	public MedicalStore addMedicine(MedicalStore medstore) {
		MedicalStore meds = new MedicalStore();
		meds.setStoreName(medstore.getStoreName());
		meds.setUserName(medstore.getUserName());
		meds.setPassword(medstore.getPassword());
		meds.setStoreEmailId(medstore.getStoreEmailId());
		meds.setMobileNumber(medstore.getMobileNumber());
		meds.setAddressone(medstore.getAddressone());
		meds.setAddresstwo(medstore.getAddresstwo());
		meds.setStoreLicense(medstore.getStoreLicense());
		System.out.println("Store type ----------------------------------------------------+++++++");
		StoreType store = storerepo.getById(medstore.getStoreType().getId());
		System.out.println("Store type ----------------------------------------------------" + medstore.getStoreType());
		meds.setStoreType(store);
		System.out.println("Store type ----------------------------------------------------////////" + 		meds.getStoreType());
//		
		
		meds.setStoreRegistration(medstore.getStoreRegistration());
		return medstorerepo.save(meds);
	
	}


	@Transactional(readOnly = true)
	public List<MedicalStore> fetchAllStore(MedicalStore medicalstore) {
		return medstorerepo.findAll();
	}



	@Transactional(readOnly = true)
	public Optional<MedicalStore> fetchById(Long id) {
		return medstorerepo.findById(id); 
	}


	@Transactional
	public Optional<MedicalStore> updateById(MedicalStore medicine) {
		Optional<MedicalStore> store = medstorerepo.findById(medicine.getId());
		store.get().setStoreName(medicine.getStoreName());
		store.get().setUserName(medicine.getUserName());
		store.get().setPassword(medicine.getPassword());
		store.get().setStoreEmailId(medicine.getStoreEmailId());
		store.get().setMobileNumber(medicine.getMobileNumber());
		store.get().setAddressone(medicine.getAddressone());
		store.get().setAddresstwo(medicine.getAddresstwo());
		store.get().setStoreLicense(medicine.getStoreLicense());
		store.get().setStoreRegistration(medicine.getStoreRegistration());
//		medstorerepo.save(store.get());
		StoreType storeType = storerepo.getById(medicine.getStoreType().getId());
		store.get().setStoreType(storeType);
		
		medstorerepo.save(store.get());
		return store;
		
//		System.out.println("Store type ----------------------------------------------------+++++++");
//		System.out.println("Store type ----------------------------------------------------+++++++");
//		StoreType storenew = storerepo.getById(medicine.getStoreType().getId());
//		System.out.println("Store type ----------------------------------------------------" + medicine.getStoreType());
//		storenew.setStoreType(store);
//		System.out.println("Store type ----------------------------------------------------////////" + 		medicine.getStoreType());
//		
		
		
		
	}


	@Transactional
	public void deleteById(Long id) {
		medstorerepo.deleteById(id);		
	}




	
//	FOR THYME LEAF
	
	
//	@Transient
	@Transactional(readOnly = true)
	public List<MedicalStore> findAllStore() {
		return medstorerepo.findAllStore();
		
	}



	@Transient
	@Transactional(readOnly = true)
	public List<MedicalStore> viewstore(MedicalStore medicalstore) {
		return medstorerepo.viewstore();
	}

	@Transactional
	public void saveMedicine(@Valid MedicalStore newstore) {
		this.medstorerepo.save(newstore);
	}


	@Transactional
	public void deleteStoreById(Long id) {
		medstorerepo.deleteById(id);
		
	}


//	public void deleteStoreByIda(Long id) {
//		// TODO Auto-generated method stub
//		
//	}


}
