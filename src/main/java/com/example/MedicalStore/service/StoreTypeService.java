package com.example.MedicalStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MedicalStore.model.StoreType;
import com.example.MedicalStore.repository.StoreTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreTypeService {

	
	@Autowired
	StoreTypeRepository storerepo;
	
	
	@Transactional
	public StoreType addstore(StoreType newstore) {
		StoreType store = new StoreType();
		store.setTypeName(newstore.getTypeName());
		return storerepo.save(store);
	}


	@Transactional(readOnly=true)
	public List<StoreType> fetchAllStore(StoreType store) {
		return storerepo.findAll();
	}


	@Transactional(readOnly=true)
	public Optional<StoreType> fetchById(Long id) {
		Optional<StoreType> stores = storerepo.findById(id);
		return stores;
	}


	@Transactional
	public Optional<StoreType> updateById(StoreType newstore) {
		Optional<StoreType> store = storerepo.findById(newstore.getId());
		store.get().setTypeName(newstore.getTypeName());
		storerepo.save(store.get());
		return store;
	}


	@Transactional
	public void deleteStoreById(Long id) {
		storerepo.deleteById(id);
	}

	
}
