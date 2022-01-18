package com.hospital.Entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doctor  {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int dId;
private String dName;
private int age;
private String gender;
private String specialistField;
private int patientsAttended;
@OneToMany(mappedBy="doctor")
@JsonManagedReference
private List<Patient> patients;
public Doctor() {

}
public Doctor(int dId, String dName, int age, String gender, String specialistField, int patientsAttended) {
	this.dId = dId;
	this.dName = dName;
	this.age = age;
	this.gender = gender;
	this.specialistField = specialistField;
	this.patientsAttended = patientsAttended;
}
public int getdId() {
	return dId;
}
public void setdId(int dId) {
	this.dId = dId;
}
public String getdName() {
	return dName;
}
public void setdName(String dName) {
	this.dName = dName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getSpecialistField() {
	return specialistField;
}
public void setSpecialistField(String specialistField) {
	this.specialistField = specialistField;
}
public int getPatientsAttended() {
	return patientsAttended;
}
public void setPatientsAttended(int patientsAttended) {
	this.patientsAttended = patientsAttended;
}
public List<Patient> getPatient() {
	return patients;
}
public void setPatient(List<Patient> patient) {
	this.patients = patient;
}
@Override
public String toString() {
	return "Doctor [dId=" + dId + ", dName=" + dName + ", age=" + age + ", gender=" + gender + ", specialistField="
			+ specialistField + ", patientsAttended=" + patientsAttended + ", patient=" + patients + "]";
}
}