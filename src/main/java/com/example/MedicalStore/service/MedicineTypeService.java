package com.example.MedicalStore.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.MedicalStore.model.MedicineType;
import com.example.MedicalStore.repository.MedicineTypeRepo;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MedicineTypeService {
	@Autowired
	MedicineTypeRepo medRepo;
	@Transactional
	public MedicineType addmedicine(MedicineType newMedicine1) {
		MedicineType medtype = new MedicineType();
		medtype.setMedTypeName(newMedicine1.getMedTypeName());
		medtype.setDescription(newMedicine1.getDescription());
		return medRepo.save(medtype);
	}
	
	@Transactional(readOnly=true)
	public List<MedicineType> fetchAllMedicine(MedicineType medtype) {
		return medRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public Optional<MedicineType> fetchMedicineById(Long id) {
		return medRepo.findById(id);
	}
	
	@Transactional
	public Optional<MedicineType> updateMedicines(MedicineType newMedicine1) {
		Optional<MedicineType> medtype = medRepo.findById(newMedicine1.getId());
		medtype.get().setMedTypeName(newMedicine1.getMedTypeName());
		medtype.get().setDescription(newMedicine1.getDescription());
	medRepo.save(medtype.get());
	return medtype;
}
	
	@Transactional
	public void DeleteMedicineById(Long id) {
		medRepo.deleteById(id);
	}
}
