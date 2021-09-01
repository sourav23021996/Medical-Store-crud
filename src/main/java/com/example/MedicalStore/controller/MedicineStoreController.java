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

import com.example.MedicalStore.model.MedicalStore;
import com.example.MedicalStore.service.MedicineStoreService;


@RestController
@RequestMapping("/medicinestore")
public class MedicineStoreController {

	
	@Autowired
	MedicineStoreService medicinestoreservice;
	
	@PostMapping("/addmedicinestore")
	public MedicalStore addMedicine(@RequestBody MedicalStore medicine)
	{
		return medicinestoreservice.addMedicine(medicine);
		
	}
	
	@GetMapping("/store")
	public List<MedicalStore> fetchAllStore(MedicalStore medicalstore)
	{
		return medicinestoreservice.fetchAllStore(medicalstore);
		
	}

	
	
	@PutMapping("/store/{id}")
	public Optional<MedicalStore> fetchById(@PathVariable("id") Long id){
		return medicinestoreservice.fetchById(id);
	}
	
	
	@PatchMapping("/Stores")
	public Optional<MedicalStore> updateById(@RequestBody MedicalStore medicine){
		Optional<MedicalStore> store= medicinestoreservice.updateById(medicine);
		return store;
		
		
	}
	
	
	@DeleteMapping("/store/{id}")
	public void deleteById(@PathVariable("id") Long id){
		medicinestoreservice.deleteById(id);
	}
	
	
	}
