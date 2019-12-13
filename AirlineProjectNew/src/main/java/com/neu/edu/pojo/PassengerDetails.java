package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity(name = "PassengerDetails")
@NamedQuery(name="passengerDetails.getPassengerById", query="from PassengerDetails p where p.passengerId= :passengerId")
public class PassengerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long passengerId;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	
	public String getEmail() {
		return email;
	}

	@Transient
	private MultipartFile idProof;
	
	@Column
	private String idProofFile;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passengerDetails")
	private Booking booking;
	
	public PassengerDetails() {
		
	}
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getIdProof() {
		return idProof;
	}

	public void setIdProof(MultipartFile idProof) {
		this.idProof = idProof;
	}

	public String getIdProofFile() {
		return idProofFile;
	}

	public void setIdProofFile(String idProofFile) {
		this.idProofFile = idProofFile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerId=" + passengerId + ", name=" + name + ", email=" + email + ", idProof="
				+ idProof + ", idProofFile=" + idProofFile + ", booking=" + booking + "]";
	}
	
	

}
