package com.example.MedicalStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MedicalStore.model.StoreType;
import com.example.MedicalStore.service.StoreTypeService;

@RestController
@RequestMapping("/storetype")
public class StoreController {

	@Autowired
	StoreTypeService storeservice;

	
	@PostMapping("/addstore")
	public StoreType addStore(@RequestBody StoreType newstore) {
		return storeservice.addstore(newstore);
	}
	
	
	@GetMapping("/storess")
	public List<StoreType> fetchAllStore(StoreType store)
	{
		return storeservice.fetchAllStore(store);
	}
	
	
	@PutMapping("/stores/{id}")
	public Optional<StoreType> fetchById(@PathVariable("id") Long id)
	{
		return storeservice.fetchById(id);
	}
	
	
	@PatchMapping("/Stores/{id}")
	public Optional<StoreType> updateById(@RequestBody StoreType newstore)
	{
		Optional<StoreType> store = storeservice.updateById(newstore);
		return store;
	}
	
	
	@DeleteMapping("/stores/{id}")
	public void deleteStoreById(@PathVariable("id") Long id)
	{
		storeservice.deleteStoreById(id);
	}
}
