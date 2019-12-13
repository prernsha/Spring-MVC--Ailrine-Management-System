package com.neu.edu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.neu.edu.exception.FlightScheduleException;
import com.neu.edu.pojo.FlightSchedule;

public class CustomerDao extends Dao {
	
	public CustomerDao() {
	}
	
	
		//Get search result for customer based on source airport, destination airport, departure Date and arrival Date
			public List<FlightSchedule> getCustSearchResult(String sourceAirport, String destinationAirport, String departureDate, String arrivalDate ) throws FlightScheduleException {
		        try {
		        	
		        	
		        	if (arrivalDate.equals(""))
		        	{
		            begin();            
		            Criteria criteria = getSession().createCriteria(FlightSchedule.class);
		            
		            Criterion matchSourceAir = Restrictions.ilike("sourceAirport",sourceAirport,MatchMode.EXACT);
		            Criterion matchDestAir = Restrictions.ilike("destinationAirport",destinationAirport,MatchMode.EXACT);
		            Criterion matchDepartDate = Restrictions.eq("departureDate",departureDate);
		            
		            Conjunction conjn = Restrictions.conjunction();
		            conjn.add(matchDestAir);
		            conjn.add(matchSourceAir);
		            conjn.add(matchDepartDate);
		            
		            criteria.add(conjn);
		            
		            
		           List<FlightSchedule> result= criteria.list();
		            commit();
		            return result;
		        	}
		        	else
		        	{
		        		begin();            
			            Criteria criteria = getSession().createCriteria(FlightSchedule.class);
			            
			            Criterion matchSourceAir = Restrictions.eq("sourceAirport",sourceAirport);
			            Criterion matchDestAir = Restrictions.eq("destinationAirport",destinationAirport);
			            Criterion matchDepartDate = Restrictions.eq("departureDate",departureDate);
			            Criterion matchArrivalDate = Restrictions.eq("arrivalDate",arrivalDate);
			            
			            Conjunction conjn = Restrictions.conjunction();
			            conjn.add(matchDestAir);
			            conjn.add(matchSourceAir);
			            conjn.add(matchDepartDate);
			            conjn.add(matchArrivalDate);
			            
			            criteria.add(conjn);
			          
			            List<FlightSchedule> result= criteria.list();
			            commit();
			            return result;
		        	}
		        } 
		        catch (HibernateException e) 
		        {
		            rollback();
		            throw new FlightScheduleException("Exception while getting customer desired flight schedule: " + e.getMessage());
		        }
		    }
	

}
