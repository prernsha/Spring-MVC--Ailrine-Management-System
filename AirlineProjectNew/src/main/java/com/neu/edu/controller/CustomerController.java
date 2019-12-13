package com.neu.edu.controller;


import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import com.neu.edu.dao.CustomerDao;
import com.neu.edu.exception.FlightScheduleException;

import com.neu.edu.pojo.FlightSchedule;
import com.neu.edu.pojo.PassengerDetails;


@Controller
public class CustomerController {
	
private static final Log LOGGER = LogFactory.getLog(CustomerController.class);
	
	@Autowired
	CustomerDao customerDao;
	
	
	//Method to call the search flights in dao 
		@RequestMapping(value = "/searchFlights", method = RequestMethod.GET)
		public ModelAndView searchFlights(HttpServletRequest request) throws FlightScheduleException
		{
			String sourceAirport= request.getParameter("source");
			String destinationAirport= request.getParameter("destination");
			String departureDate= request.getParameter("departureDate");
			String arrivalDate = request.getParameter("arrivalDate");
			
			List<FlightSchedule> flightsList = customerDao.getCustSearchResult(sourceAirport, destinationAirport,departureDate, arrivalDate);
			
			List<FlightSchedule> toRemoveFlightList = new ArrayList<FlightSchedule>();
			
			//For loop to check if the avail seats against a flight is 0 then do not show in the search list
			if(flightsList!=null)
			{
				for(FlightSchedule list:flightsList)
				{
					if(list.getAvailSeats()==0)
					{
						toRemoveFlightList.add(list);
						
						
					}
				}
				
				 flightsList.removeAll(toRemoveFlightList);			
				return new ModelAndView("searchResult","flightsList",flightsList);
			}
			else
			{
				return new ModelAndView("searchResult");
			}
		}
	
		//This method redirects to enter passenger information page
		@RequestMapping(value = "/continue", method = RequestMethod.GET)
		public ModelAndView continueToBook(@ModelAttribute("passengerDetails")PassengerDetails passengerDetails, HttpServletRequest request) throws FlightScheduleException
		{
			long flightId= Long.parseLong(request.getParameter("flightId"));
			System.out.println("flight Id from the form: "+flightId);
			request.setAttribute("flightId",flightId);
			
			return new ModelAndView("passengerDetails");
		}


}
