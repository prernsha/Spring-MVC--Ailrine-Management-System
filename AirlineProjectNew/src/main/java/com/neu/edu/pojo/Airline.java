package com.neu.edu.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity(name = "Airline")
//@NamedQuery(name="airline.getAll", query="from Airline a")
@NamedQueries({@NamedQuery(name="airline.getAll", query="from Airline a"), @NamedQuery(name="airline.getAirlineById", query="from Airline a where a.airlineId= :airlineId")})
public class Airline {
	
	@Id
	@SequenceGenerator(name = "airlineIdSequence", sequenceName = "airlineIdSequence", initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airlineIdSequence")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long airlineId;
	
	@Column(nullable = false)
	private String airlineName;
	
	@OneToMany( mappedBy="airline",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FlightSchedule> flightSchedule;
	
	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	
	public Set<FlightSchedule> getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(Set<FlightSchedule> flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airlineName=" + airlineName + "]";
	}
	
	

}
