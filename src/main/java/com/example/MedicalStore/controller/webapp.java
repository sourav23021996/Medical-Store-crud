package com.example.MedicalStore.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.MedicalStore.model.MedicalStore;
import com.example.MedicalStore.model.Medicine;
import com.example.MedicalStore.model.StoreType;
import com.example.MedicalStore.repository.MedicineStoreRepository;
import com.example.MedicalStore.repository.StoreTypeRepository;
import com.example.MedicalStore.service.MedicineService;
import com.example.MedicalStore.service.MedicineStoreService;

@Controller
public class webapp {

	
	@Autowired
	private MedicineService medicineservice;
	
	@Autowired
	private MedicineStoreService storeservice;
	
	@Autowired
	private MedicineStoreRepository storerepo;
	
	
	@Autowired
	private StoreTypeRepository storetyperepo;
	
//LIST(ViewMedicine)
	@GetMapping("/medicines")
	public String ViewHomePage(Model model)
	{
		model.addAttribute("listMedicines", medicineservice.getAllMedicine());
		return "ViewMedicine";
	}
	
	
//ADD MEDICINE
	@GetMapping("/addmedicine/new")
	public String viewMedicine(Model model)
	{
		Medicine newmedicine = new Medicine();
		List<MedicalStore> storeName = storeservice.findAllStore();
		model.addAttribute("medicalStoreName", storeName);
		model.addAttribute("newmedicine", newmedicine);
		return "new_medicine";
		
	}
	
	
//SAVE
	@RequestMapping(value="/saveMedicine", method= RequestMethod.POST)
	public String saveMedicine(Model model,@Valid @ModelAttribute("newmedicine") Medicine newmedicine,BindingResult result){
		medicineservice.saveMedicine(newmedicine);
		return "redirect:/medicines";
	}
	
//Update Medicine
	@RequestMapping(value="/updateMedicine/{id}", method=RequestMethod.GET)
	public String updateMedicine(@PathVariable("id") Long id,Model model) {
//		ModelAndView model = new ModelAndView("updateMedicine.html");
		
		Medicine medicine=medicineservice.findById(id);
		model.addAttribute("updateMedicine", medicine);
		return "new_medicine";
	}

//	FIND ALL STORE
	
	
	@GetMapping("/store")
	public String ViewStore(Model model)
	{
		model.addAttribute("listStore", storerepo.findAll());
		return "ViewStore";
	}
	
	
//	@Transient
	@GetMapping("/store/new")
	public String addStore(Model model)
	{
//		MedicalStore newstore = new MedicalStore();
		List<StoreType> storetype = storetyperepo.findAllStore();
		model.addAttribute("storetypename", storetype);
		model.addAttribute("medicalstore",new MedicalStore());
		return "AddStore";
		
	}
	
	
	@RequestMapping(value="/savestore", method= RequestMethod.POST)
	public String savestore(Model model,@Valid @ModelAttribute("newstore") MedicalStore newstore,BindingResult result){
		storeservice.saveMedicine(newstore);
		return "redirect:/store";
	}

	
//	UPDATE STORE
	@RequestMapping(value="/updateStore/{id}", method=RequestMethod.GET)
	public String updateStore(@PathVariable("id") Long id,Model model) {

		MedicalStore store= storerepo.findById(id).get();
		List<StoreType> storetype = storetyperepo.findAllStore();
		model.addAttribute("storetypename", storetype);
		model.addAttribute("medicalstore", store);
		return "AddStore";
	}

	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id){
		storeservice.deleteStoreById(id);
return "redirect:/store"; 
	}
}
