package com.neu.edu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AirlineException;
import com.neu.edu.pojo.Airline;

public class AirlineDao extends Dao {
	
	public AirlineDao() {
	}
	
	//Add Airline Name into the Database
	public Airline add(Airline airline) throws AirlineException {
        try {
        	
            begin();            
            getSession().save(airline);     
            commit();
            return airline;
        } 
        catch (HibernateException e) 
        {
            rollback();
            throw new AirlineException("Exception while inserting airline: " + e.getMessage());
        }
    }
	
	
	//Check if airline name already exists in the database
	public int checkAirlineExists(String airlineName) throws AirlineException {
		int result;
		try {
			
			begin();
			Query q = getSession().createQuery("from Airline where airlineName = :airlineName");
			q.setString("airlineName", airlineName);
			Airline airline = (Airline) q.uniqueResult();
			commit();
			
			
			if(airline == null)
			{
				result = 0;
			}
			else
			{
				result=1;
			}
			return result;
		} catch (HibernateException e) {
			rollback();
			throw new AirlineException("Could not get airline with name: " +airlineName, e);
		}
	}
	
	//Delete airline information
	public int deleteAirlineById(long id) throws AirlineException
	{
		int result;
		
        try {
        	 
        	begin();
            Query q = getSession().createQuery("from Airline where id= :id");
            q.setLong("id", id);
            Airline airlineToDelete = (Airline)q.uniqueResult();
            getSession().delete(airlineToDelete);
            commit();
            
            if(airlineToDelete == null)
			{
				result=0;
			}
			else
			{
				result=1;
			}
 
            	return result;
        	} 
        catch (HibernateException e) {
        
            rollback();
            throw new AirlineException("Could not get airline with id: " +id, e);
        }	
        catch(IllegalArgumentException ex)
        {
        	rollback();
            throw new AirlineException("Could not get airline with id: " +id, ex);
        }

    }
	
	public List<Airline> getAllAirlines() throws AirlineException
	{
		try
		{
			
			begin();
		Query q = getSession().getNamedQuery("airline.getAll");
		
		List<Airline> airlines = q.list();
		commit();
		return airlines;
		}
		
		catch (HibernateException e) {
	        
            rollback();
            throw new AirlineException("Could not get airlines ", e);
        }
		
	}
	
	public Airline getAirlineById(long airlineId) throws AirlineException
	{
		try
		{
			begin();
		
		Query q = getSession().getNamedQuery("airline.getAirlineById");
		q.setLong("airlineId", airlineId);
		Airline airline = (Airline) q.uniqueResult();
		commit();
		return airline;
		}
		catch (HibernateException e) {
	        
            rollback();
            throw new AirlineException("Could not get airline with airlineId: "+airlineId, e);
        }
	}
	

	

}
