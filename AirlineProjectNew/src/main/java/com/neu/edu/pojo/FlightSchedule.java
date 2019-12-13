package com.neu.edu.pojo;




import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity(name = "FlightSchedule")
//@NamedQuery(name="flightSchedule.getSchedueleById", query="from FlightSchedule s where s.flightId= :flightId")
@NamedQueries({@NamedQuery(name="flightSchedule.getAll", query="from FlightSchedule f"), @NamedQuery(name="flightSchedule.getSchedueleById", query="from FlightSchedule s where s.flightId= :flightId")})
public class FlightSchedule {
	
	@Id
	@SequenceGenerator(name = "flightIdSequence", sequenceName = "flightIdSequence", initialValue = 4001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightIdSequence")
	@Column
	private long flightId;
	
	@Column(nullable = false)
	private String departureDate;
	
	@Column(nullable = false)
	private String departureTime;
	
	@Column(nullable = false)
	private String arrivalDate;
	
	@Column(nullable = false)
	private String arrivalTime;
	
	@Column(nullable = false)
	private String sourceAirport;
	
	@Column(nullable = false)
	private String destinationAirport;
	
	@Column(nullable = false)
	private long fare;
	
	@Column(nullable = false)
	private int noOfSeats;
	
	@Column(nullable = false)
	private int availSeats;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="airlineId") 
	private Airline airline;
	

	@OneToMany(mappedBy="flightSchedule",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Booking> booking;
	
	public FlightSchedule() {
		
	}
	
	
	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}




	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}


	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public long getFare() {
		return fare;
	}

	public void setFare(long fare) {
		this.fare = fare;
	}


	public Airline getAirline() {
		return airline;
	}


	public void setAirline(Airline airline) {
		this.airline = airline;
	}


	public Set<Booking> getBooking() {
		return booking;
	}


	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}


	public int getNoOfSeats() {
		return noOfSeats;
	}


	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	

	public int getAvailSeats() {
		return availSeats;
	}


	public void setAvailSeats(int availSeats) {
		this.availSeats = availSeats;
	}


	@Override
	public String toString() {
		return "FlightSchedule [flightId=" + flightId + ", departureDate=" + departureDate + ", departureTime="
				+ departureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", sourceAirport="
				+ sourceAirport + ", destinationAirport=" + destinationAirport + ", fare=" + fare + ", noOfSeats="
				+ noOfSeats + ", availSeats=" + availSeats + ", airline=" + airline + ", booking=" + booking + "]";
	}




	



}
