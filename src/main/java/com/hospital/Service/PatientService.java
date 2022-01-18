package com.hospital.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Entity.Patient;
import com.hospital.Exception.ResourceNotFoundException;
import com.hospital.Repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository prepo;
public Patient createPatient(Patient patient) {
	return prepo.save(patient);
}

public Patient getPatientById(int pId) { 
	  return prepo.findById(pId).orElseThrow(() -> 
		new ResourceNotFoundException("Patient", "pId", pId));
} 
	public List<Patient> getAllPatients()
	{
		return prepo.findAll();	
	}
	public Patient updatePatient(Patient patient, int pId) {
		// we need to check whether doctor with given id is exist in DB or not
				Patient existingPatient = prepo.findById(pId).orElseThrow(
						() -> new ResourceNotFoundException("Patient", "pId", pId)); 
				existingPatient.setpName(patient.getpName());
				existingPatient.setVisitedDoctor(patient.getVisitedDoctor());
				existingPatient.setDateOfVisit(patient.getDateOfVisit());
				// save existing doctor to DB
				prepo.save(existingPatient);
				return existingPatient;
			}


public void deletePatientById(int pId)
{
	prepo.findById(pId);	
	prepo.deleteById(pId);
}
}
