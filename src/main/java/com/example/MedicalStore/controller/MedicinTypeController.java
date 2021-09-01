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
import com.example.MedicalStore.model.MedicineType;
import com.example.MedicalStore.service.MedicineTypeService;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("/medstype")
public class MedicinTypeController {
	@Autowired
	MedicineTypeService medservice;
	@PostMapping("/medicine")
	public MedicineType getMedicine(@RequestBody MedicineType newMedicine1) {
		return medservice.addmedicine(newMedicine1);
	}
	@GetMapping("/medid")
	public List<MedicineType> fetchAllMedicine(MedicineType medtype) {
		List<MedicineType> medicine = medservice.fetchAllMedicine(medtype);
		return medicine;
	}
	@PutMapping("/med/{id}")
	public Optional<MedicineType> fetchMedicineById(@PathVariable("id") Long id) {
		Optional<MedicineType> medicine = medservice.fetchMedicineById(id);
		return medicine;
	}
	@PatchMapping("/updatemed")
	public Optional<MedicineType> updateMedicine(@RequestBody MedicineType newMedicine1) {
		Optional<MedicineType> medicine = medservice.updateMedicines(newMedicine1);
		return medicine;
	}
	@DeleteMapping("/deletemed/{id}")
	public void DeleteMedicineById(@PathVariable("id") Long id) {
		medservice.DeleteMedicineById(id);
	}
}
