package com.neu.edu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.FlightScheduleException;
import com.neu.edu.exception.PassengerException;
import com.neu.edu.pojo.PassengerDetails;


public class PassengerDao extends Dao {
	
	public PassengerDao() {
	}
	//Add Passenger Details into the Database
		public PassengerDetails addPassenger(PassengerDetails pass) throws PassengerException {
	        try {
	        	
	            begin();            
	            getSession().save(pass);     
	            commit();
	            return pass;
	            
	        } 
	        catch (HibernateException e) 
	        {
	            rollback();
	            throw new PassengerException("Exception while adding passenger: " + e.getMessage());
	        }
	    }
		
		public PassengerDetails getPassengerById(long passengerId) throws FlightScheduleException
		{
			Query q = getSession().getNamedQuery("passengerDetails.getPassengerById");
			q.setLong("passengerId", passengerId);
			PassengerDetails passengerDet = (PassengerDetails) q.uniqueResult();
			
			return passengerDet;
		}


}
