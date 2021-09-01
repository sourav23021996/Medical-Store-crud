package com.example.MedicalStore.controller;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MedicalStore.model.Medicine;
import com.example.MedicalStore.service.MedicineService;
//import com.example.MedicalStore.repository.MedicineRepository;

@RestController
@RequestMapping("/medicinedetails")
public class MedicinDetailsController {

	@Autowired
	MedicineService medicineservice;
	
	
	

//	POST MAPPING
	@PostMapping(path="/addmedicine")
	public Medicine addMedicine(@RequestBody Medicine newmedicine) 
	{
		return medicineservice.addMedicine(newmedicine);	
		
	}
	

	
	
//	GET MAPPING 
	
	@GetMapping("/medicines")
	public List<Medicine> fetchAllMedicine(Medicine medicine){
		List<Medicine> allmedicine = medicineservice.fetchAllMedicine(medicine);
		return allmedicine;
	}
	
	
//Put MAPPING By ID
	
	@PutMapping("/medicines/{id}")
	public Optional<Medicine> fetchById(@PathVariable("id") Long id) {
		Optional<Medicine> medicine = medicineservice.fetchById(id);
		return medicine;
}
		
	
//	Patch(UPDATE) MAPPING
	
	@PatchMapping("/medicine")
	public Optional<Medicine> updateMedicine(@RequestBody Medicine medicine) {
	Optional<Medicine> medicineid = medicineservice.updateMedicine(medicine);
		return medicineid;
	}
	
	
//	Delete Mapping

	@DeleteMapping("/medicine/{id}")
	public void deleteMedicineById(@PathVariable("id") Long id)
 {
		medicineservice.deleteMedicineById(id);
//		return medicine;
	}
	
	
	
}