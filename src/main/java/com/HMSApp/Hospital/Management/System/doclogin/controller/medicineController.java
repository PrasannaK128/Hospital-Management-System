package com.HMSApp.Hospital.Management.System.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.System.doclogin.entity.medicins;
import com.HMSApp.Hospital.Management.System.doclogin.repository.medicineRepository;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin(origins = "http://localhost:4200")
public class medicineController {
    @Autowired
    private medicineRepository medicineRepo;

	public medicineController(medicineRepository medicineRepo) {
		super();
		this.medicineRepo = medicineRepo;
	}
	@PostMapping("/insert")
    public medicins addMedicine(@RequestBody medicins meds)
    {
    	return medicineRepo.save(meds);
    }
	
	@GetMapping("/medicines")
	public List<medicins> getAllMedicines()
	{
		return medicineRepo.findAll();
	}
	@PutMapping("/update-medicine/{id}")
	public ResponseEntity<medicins> updateMedicines(@PathVariable long id,@RequestBody medicins Meds) throws AttributeNotFoundException
	{
		medicins med=medicineRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("No data with this id available"));
		med.setDrugName(Meds.getDrugName());
		med.setStock(Meds.getStock());
		medicineRepo.save(med);
		return ResponseEntity.ok(med);
	}
	@DeleteMapping("/delete-medicine/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteMedicine(@PathVariable long id) throws AttributeNotFoundException
	{
		medicins med=medicineRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("No data with such id exists"));
        medicineRepo.delete(med);
        Map<String,Boolean>response=new HashMap<String,Boolean>();	
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
        }
}

