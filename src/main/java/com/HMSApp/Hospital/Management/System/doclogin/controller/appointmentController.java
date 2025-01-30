package com.HMSApp.Hospital.Management.System.doclogin.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.System.doclogin.entity.appointments;
import com.HMSApp.Hospital.Management.System.doclogin.repository.appointmentRepository;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v2")
public class appointmentController {
    @Autowired
    private appointmentRepository appointmentRepo;

	public appointmentController(appointmentRepository appointmentRepo) {
		super();
		this.appointmentRepo = appointmentRepo;
	}
	@PostMapping("/insert")
	public appointments createAppointments(@RequestBody appointments appointment)
	{
		return appointmentRepo.save(appointment);
		
	}
	@GetMapping
	public List<appointments> getAllAppointments()
	{
		return appointmentRepo.findAll();
	}
	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Map<String, String>> deleteAppointment(@PathVariable("id") Long id) {
	    Optional<appointments> appointment = appointmentRepo.findById(id);
	    if (!appointment.isPresent()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "Appointment not found"));
	    }

	    // Proceed with deletion
	    appointmentRepo.deleteById(id);
	    return ResponseEntity.ok(Collections.singletonMap("message", "Appointment deleted successfully"));
	}

}
