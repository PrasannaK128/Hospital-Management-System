package com.HMSApp.Hospital.Management.System.controller;

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

import com.HMSApp.Hospital.Management.System.Entity.Patient;
import com.HMSApp.Hospital.Management.System.Repository.patientRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class patientController {
	@Autowired
private patientRepository patientRepo;

public patientController(patientRepository repo) {
	super();
  this.patientRepo=patientRepo;
}
@PostMapping("/insert")
public Patient createPatient(@RequestBody Patient patient)
{
	return patientRepo.save(patient);
	
}
@GetMapping
public List<Patient> getAllPatients()
{
	return patientRepo.findAll();
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<Map<String,Boolean>>deletePatient(@PathVariable long id) throws AttributeNotFoundException
{
  Patient patient=	patientRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id "+id));
  patientRepo.delete(patient);
  Map<String,Boolean>response=new HashMap<String, Boolean>();
  response.put("Deleted", Boolean.TRUE);
  return ResponseEntity.ok(response);
}
@PutMapping("/patient-update/{id}")
public ResponseEntity<Patient> updatePatientById(@PathVariable long id,@RequestBody Patient patient) throws AttributeNotFoundException
{
	Patient pat=patientRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("No record found"));
	pat.setAge(patient.getAge());
	pat.setBlood(patient.getBlood());
	pat.setDose(patient.getBlood());
	pat.setFees(patient.getFees());
	pat.setName(patient.getName());
	pat.setPrescription(patient.getPrescription());
	pat.setUrgency(patient.getUrgency());
	patientRepo.save(pat);
	return ResponseEntity.ok(pat);
}
}
