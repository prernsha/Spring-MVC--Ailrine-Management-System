package com.neu.edu.pojo;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Booking")
public class Booking {
	
	@Id
	@SequenceGenerator(name = "bookIdSequence", sequenceName = "bookIdSequence", initialValue = 2001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookIdSequence")
	@Column
	private long bookingId;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
	@Column
	private String seatNo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="passengerId")
	private PassengerDetails passengerDetails;
	
	@ManyToOne
	@JoinColumn(name="flightId")
	private FlightSchedule flightSchedule;


	public Booking() {
		
	}

	

	public Date getBookingDate() {
		return bookingDate;
	}



	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}



	public String getSeatNo() {
		return seatNo;
	}



	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}



	public PassengerDetails getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(PassengerDetails passengerDetails) {
		this.passengerDetails = passengerDetails;
	}



	public long getBookingId() {
		return bookingId;
	}


	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}


	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}


	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}



	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", seatNo=" + seatNo
				+ ", passengerDetails=" + passengerDetails + ", flightSchedule=" + flightSchedule + "]";
	}


}
