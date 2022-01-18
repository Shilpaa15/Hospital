package com.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.Entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


}
