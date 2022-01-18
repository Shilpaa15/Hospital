package com.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.hospital.Entity.Doctor;
import com.hospital.Repository.DoctorRepository;
import com.hospital.Service.DoctorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	@Autowired
	DoctorRepository drepo;
	
	@PostMapping("/doctors")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor Doctor){
		return new ResponseEntity<Doctor>(doctorService.createDoctor(Doctor), HttpStatus.CREATED);
	}
	//build get all Doctor rest API
	@GetMapping("/getdoctors")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	@GetMapping("doctors/{dId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("dId") int dId){
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(dId), HttpStatus.OK);	
	}  //500 or above=code error., 400 and above=prob with url
	
	//build update Doctor rest api
	//http://localhost:8080/api/Doctors/1
	@PutMapping("doctors/{dId}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("dId") int dId, @RequestBody Doctor Doctor){
		return  new ResponseEntity<Doctor>(doctorService.updateDoctor(Doctor,dId), HttpStatus.OK);	
	}
	// build delete Doctor rest api
	@DeleteMapping("doctors/{dId}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("dId") int dId){
		//delete Doctor from db
		doctorService.deleteDoctorById(dId);
		return new ResponseEntity<String>("Doctor deleted successfully!.", HttpStatus.OK);	
	}
	@GetMapping("/getdoctors/byname")
	public  List<String> getDoctorsByName(){
		return drepo.getDName();
	}

}
