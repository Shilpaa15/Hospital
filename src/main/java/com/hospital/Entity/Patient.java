package com.hospital.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Patient{
	@Id
	private int pId;
	private int dId;
	private String pName;
	private String visitedDoctor;
	private String dateOfVisit;
	private String prescription;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "doctor_id", referencedColumnName="dId")
	private Doctor doctor;
	public Patient() {
		
	}
	
	public Patient(int pId, String pName, String visitedDoctor, String dateOfVisit, String prescription,
			Doctor doctor) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription= prescription;
		this.doctor = doctor;
	}

	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	@Override
	public String toString() {
		return "Patient [pId=" + pId + ", pName=" + pName + ", visitedDoctor=" + visitedDoctor + ", dateOfVisit="
				+ dateOfVisit + ", prescription=" + prescription + ", doctor=" + doctor + "]";
	}
}