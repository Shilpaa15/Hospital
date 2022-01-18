package com.hospital.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.hospital.Entity.Doctor;
import com.hospital.Exception.ResourceNotFoundException;
import com.hospital.Repository.DoctorRepository;

@Service
public class DoctorService {
@Autowired
private DoctorRepository drepo;
public Doctor createDoctor(Doctor doctor)
{
	return drepo.save(doctor);
}

public List<Doctor> findAllDoctors()
{
	return drepo.findAll();
}
public Doctor getDoctorById(int dId) { 
	  return drepo.findById(dId).orElseThrow(() -> 
		new ResourceNotFoundException("Doctor", "Id", dId));
		
  
  } 
	public List<Doctor> getAllDoctors()
	{
		return drepo.findAll();
		
	}
	public Doctor updateDoctor(Doctor doctor, int dId) {
		// we need to check whether doctor with given id is exist in DB or not
				Doctor existingDoctor = drepo.findById(dId).orElseThrow(
						() -> new ResourceNotFoundException("Doctor", "Id", dId)); 
				existingDoctor.setAge(doctor.getAge());
				existingDoctor.setdName(doctor.getdName());
				//existingDoctor.setGender(doctor.getGender());
				//existingDoctor.setSpecialistField(doctor.getSpecialistField());
				//existingDoctor.setPatientsAttended(doctor.getPatientsAttended());
				//existingDoctor.setPatient(doctor.getPatient());
				// save existing doctor to DB
				drepo.save(existingDoctor);
				return existingDoctor;
			}

	public void deleteDoctorById(int dId)
	{
		drepo.findById(dId);	
		drepo.deleteById(dId);
	}
	
}
