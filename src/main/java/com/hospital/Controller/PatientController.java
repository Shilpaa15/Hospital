package com.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Entity.Patient;
import com.hospital.Service.PatientService;
@RestController
@RequestMapping("/api")
public class PatientController {
	
		@Autowired
		PatientService patientService;
		
		@PostMapping("/patients")
		public ResponseEntity<Patient> createPatient(@RequestBody Patient Patient){
			return new ResponseEntity<Patient>(patientService.createPatient(Patient), HttpStatus.CREATED);
		}
		//build get all Patient rest API
		@GetMapping("/patients")
		public List<Patient> getAllPatients(){
			return patientService.getAllPatients();
		}
		@GetMapping("patients/{pId}")
		public ResponseEntity<Patient> getPatientById(@PathVariable("pId") int pId){
			return new ResponseEntity<Patient>(patientService.getPatientById(pId), HttpStatus.OK);	
		}  //500 or above=code error., 400 and above=prob with url
		
		//build update Patient rest api
		//http://localhost:8080/api/Patients/1
		@PutMapping("patients/{pId}")
		public ResponseEntity<Patient> updatePatient(@PathVariable("pId") int pId, @RequestBody Patient Patient){
			return  new ResponseEntity<Patient>(patientService.updatePatient(Patient,pId), HttpStatus.OK);	
		}
		// build delete Patient rest api
		@DeleteMapping("patients/{pId}")
		public ResponseEntity<String> deletePatient(@PathVariable("pId") int pId){
			patientService.deletePatientById(pId);
			return new ResponseEntity<String>("Patient deleted successfully!.", HttpStatus.OK);	
		}

	}
