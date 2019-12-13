package com.neu.edu.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import com.neu.edu.exception.FlightScheduleException;
import com.neu.edu.pojo.FlightSchedule;

public class FlightScheduleDao extends Dao {
	
	public FlightScheduleDao() {
	}

	//Add Flight Schedule  into the Database
		public FlightSchedule addSchedule(FlightSchedule fs) throws FlightScheduleException {
	        try {
	        	
	            begin();            
	            getSession().save(fs);     
	            commit();
	            return fs;
	        } 
	        catch (HibernateException e) 
	        {
	            rollback();
	            throw new FlightScheduleException("Exception while creating flight schedule: " + e.getMessage());
	        }
	    }
		
		public FlightSchedule getScheduleById(long flightId) throws FlightScheduleException
		{
			try
			{
				begin();
				Query q = getSession().getNamedQuery("flightSchedule.getSchedueleById");
				q.setLong("flightId", flightId);
				FlightSchedule schedule = (FlightSchedule) q.uniqueResult();
				commit();
				return schedule;
				
			}
			catch (HibernateException e) 
	        {
	            rollback();
	            throw new FlightScheduleException("Exception while creating flight schedule: " + e.getMessage());
	        }
			
		}
		
		public FlightSchedule getAirlineId(long flightId) throws FlightScheduleException
		{
			try
			{
				begin();
				String sql = "Select airlineId from FlightSchedule where flightId= :flightId";
				
				SQLQuery q= getSession().createSQLQuery(sql);
				q.setLong("flightId", flightId);
				
				FlightSchedule results= (FlightSchedule) q.uniqueResult();
				commit();
				return results;
			}
			catch (HibernateException e) 
	        {
	            rollback();
	            throw new FlightScheduleException("Exception while creating flight schedule: " + e.getMessage());
	        }
			
		}
		
		public int updateAvailSeats(long flightId,int newAvailSeats) throws FlightScheduleException
		{
			try
			{
				
				begin();
			Query q= getSession().createQuery("UPDATE FlightSchedule SET availSeats= :newAvailSeats WHERE flightId= :flightId");
			q.setInteger("newAvailSeats", newAvailSeats);
			q.setLong("flightId", flightId);
			
			int modification = q.executeUpdate();
			commit();
			return modification;
			}
			catch (HibernateException e) 
	        {
	            rollback();
	            throw new FlightScheduleException("Exception while creating flight schedule: " + e.getMessage());
	        }
			
		}
		
		public List<FlightSchedule> getAllFlightSchedule() throws FlightScheduleException
		{
			try
			{
				begin();
			
				Query q = getSession().getNamedQuery("flightSchedule.getAll");
				
				List<FlightSchedule> flightSchedules = q.list();
				commit();
				return flightSchedules;
			
			}
			catch (HibernateException e) 
	        {
	            rollback();
	            throw new FlightScheduleException("Exception while creating flight schedule: " + e.getMessage());
	        }
		}
		
		public int updateSchedule(long flightId,int newFare,String newDestinationAirport) throws FlightScheduleException
		{
			try
			{
				begin();
			
				Query q= getSession().createQuery("UPDATE FlightSchedule SET fare= :newFare, destinationAirport= :newDestinationAirport WHERE flightId= :flightId");
				q.setInteger("newFare", newFare);
				q.setString("newDestinationAirport", newDestinationAirport);
				q.setLong("flightId", flightId);
				
				int modification = q.executeUpdate();
				commit();
				return modification;
			
			}
			catch (HibernateException e) 
	        {
	            rollback();
	            throw new FlightScheduleException("Exception while creating flight schedule: " + e.getMessage());
	        }
			
		}
		
		
}
