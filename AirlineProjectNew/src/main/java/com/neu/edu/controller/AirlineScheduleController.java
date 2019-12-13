package com.neu.edu.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.AirlineDao;
import com.neu.edu.dao.FlightScheduleDao;
import com.neu.edu.exception.AirlineException;
import com.neu.edu.exception.FlightScheduleException;
import com.neu.edu.pojo.Airline;
import com.neu.edu.pojo.FlightSchedule;

@Controller
public class AirlineScheduleController {
	
private static final Log LOGGER = LogFactory.getLog(AirlineController.class);
	
	@Autowired
	FlightScheduleDao fsDao;
	
	@Autowired
	AirlineDao airlineDao;
	
	
	@RequestMapping("/AddFlightSchedule.htm")
	public ModelAndView addSchedulePage(@ModelAttribute("fs")FlightSchedule fs,HttpServletRequest request) throws FlightScheduleException {
		
		long airlineId= Long.parseLong(request.getParameter("airlineID"));
		request.setAttribute("airlineId", airlineId);
		return new ModelAndView("addFlightSchedule") ;
		
			
		}
	
		// Method to save schedule to database if it does not exist
		@RequestMapping(value = "/addSchedule")
		public ModelAndView addFlightSchedule(@ModelAttribute("fs")FlightSchedule fs,BindingResult result, HttpServletRequest request, HttpSession session) throws FlightScheduleException, AirlineException
		{
			LOGGER.debug(fs);
			
			long airlineId= Long.parseLong(request.getParameter("airlineId"));

			String departureTime = fs.getDepartureTime();
			
			String departureDate = fs.getDepartureDate();
			String arrivalDate = fs.getArrivalDate();
			String arrivalTime = fs.getArrivalTime();
			String sourceAirport = fs.getSourceAirport();
			String destinationAirport = fs.getDestinationAirport();
			
			long fare = fs.getFare();
			
			fs.setDepartureDate(departureDate);
			fs.setDepartureTime(departureTime);
			fs.setArrivalDate(arrivalDate);
			fs.setArrivalTime(arrivalTime);
			fs.setSourceAirport(sourceAirport);
			fs.setDestinationAirport(destinationAirport);
			fs.setFare(fare);

			Set<FlightSchedule> setSchedule = new HashSet<FlightSchedule>();
			setSchedule.add(fs);
			
			Airline airline = airlineDao.getAirlineById(airlineId);
			fs.setAirline(airline);
			

			fsDao.addSchedule(fs);
			
			
			return new ModelAndView("addScheduleSuccess","airlineName",airline.getAirlineName());

			
		}
		
		@RequestMapping("/update")
		public ModelAndView updateRedirect() throws FlightScheduleException 
		{
			List<FlightSchedule> flightScheduleList = fsDao.getAllFlightSchedule();
			return new ModelAndView("updateFlightSchedule","flightScheduleList",flightScheduleList) ;
			
				
		}
		
		@RequestMapping("/getScheduleForFlight")
		public ModelAndView updateFlightSchedule(HttpServletRequest request) throws FlightScheduleException 
		{
			
			long flightId= Long.parseLong(request.getParameter("flightId"));
			request.setAttribute("flightId", flightId);
			
			FlightSchedule flightSchedule = fsDao.getScheduleById(flightId);
			return new ModelAndView("updateScheduleJSP","flightSchedule",flightSchedule) ;
			
				
		}
		
		@RequestMapping("/updateSchedule")
		public ModelAndView updateSchedule(HttpServletRequest request) throws FlightScheduleException 
		{
			
			long flightId= Long.parseLong(request.getParameter("flightId"));
			
			int newFare = Integer.parseInt(request.getParameter("fare"));
			System.out.println("newFare value: "+newFare);
			String newDestinationAirport = request.getParameter("destinationAirport");
			System.out.println("newDestinationAirport value: "+newDestinationAirport);
			//Call the update schedule method in dao
				fsDao.updateSchedule(flightId, newFare, newDestinationAirport);
			
			
				FlightSchedule updatedSchedule = fsDao.getScheduleById(flightId);
				
			return new ModelAndView("updateSuccess","updatedSchedule",updatedSchedule) ;
				
		}

}
