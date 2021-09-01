package com.example.MedicalStore.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MedicalStore.model.MedicalStore;
import com.example.MedicalStore.model.Medicine;
import com.example.MedicalStore.model.MedicineType;
import com.example.MedicalStore.model.StoreType;
import com.example.MedicalStore.repository.MedicineRepository;
import com.example.MedicalStore.repository.MedicineStoreRepository;
import com.example.MedicalStore.repository.MedicineTypeRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicineService {

	
	@Autowired
	MedicineRepository medicineRepo;
	

	@Autowired
	MedicineStoreRepository medstorerepo;
	
	@Autowired
	MedicineTypeRepo medRepo;
	
	
	
	@Transactional
	public Medicine addMedicine(Medicine newmedicine) {
		Medicine medicine = new Medicine();
		medicine.setMedName(newmedicine.getMedName());
		medicine.setMedDetail(newmedicine.getMedDetail());
		medicine.setMedPrice(newmedicine.getMedPrice());
		medicine.setQuantitiy(newmedicine.getQuantitiy());
		medicine.setExpiry(newmedicine.getExpiry());
		MedicalStore medstore = medstorerepo.getById(newmedicine.getStoreId().getId());
		medicine.setStoreId(medstore);
		
//		MedicalStore store = medstorerepo.getById(newmedicine.getStoreId());
		System.out.println("Store type ----------------------------------------------------" + newmedicine.getStoreId());
//		medicine.setStoreId(store);
//		
//		
//		MedicineType medtype = medRepo.getById(newmedicine.getMedId());
//		medicine.setMedId(medtype);
		
		MedicineType medType = medRepo.getById(newmedicine.getMedId().getId());
		medicine.setMedId(medType);
		
		
		return medicineRepo.save(medicine);
		
		
	}


	@Transactional(readOnly=true)
	public List<Medicine> fetchAllMedicine(Medicine medicine) {
		return medicineRepo.findAll();
	}

	
	@Transactional(readOnly=true)
	public Optional<Medicine> fetchById(Long id) {
		return medicineRepo.findById(id);
	}

	@Transactional
	public Optional<Medicine> updateMedicine(Medicine medicine) {
		Optional<Medicine> med = medicineRepo.findById(medicine.getId());
		med.get().setMedName(medicine.getMedName());
		med.get().setMedDetail(medicine.getMedDetail());
		med.get().setMedPrice(medicine.getMedPrice());
		med.get().setQuantitiy(medicine.getQuantitiy());
		med.get().setExpiry(medicine.getExpiry());
		
		MedicalStore medstore = medstorerepo.getById(medicine.getStoreId().getId());
		med.get().setStoreId(medstore);
		
		MedicineType medType = medRepo.getById(medicine.getMedId().getId());
		med.get().setMedId(medType);
		
		
		
//		med.get().setStoreId(medicine.getStoreId());
//		med.get().setMedId(medicine.getMedId());
		medicineRepo.save(med.get());
		return  med;
	}

	@Transactional
	public void deleteMedicineById(Long id) {
		
		medicineRepo.deleteById(id);
	}


	
	
//	FOR THYME LEAF
	
	@Transactional(readOnly=true)
	public Object getAllMedicine() {
		
		return medicineRepo.findAll();
	}
	
	
	@Transactional
	public void saveMedicine(Medicine medicineweb) {
		this.medicineRepo.save(medicineweb);
	}


	public Medicine findById(Long id) {
		return findById(id);
	}

	
	
}
