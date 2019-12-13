package com.neu.edu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.AirlineDao;
import com.neu.edu.exception.AirlineException;
import com.neu.edu.pojo.Airline;
import com.neu.edu.pojo.FlightSchedule;

@Controller
public class AirlineController {
	
private static final Log LOGGER = LogFactory.getLog(AirlineController.class);
	
	@Autowired
	AirlineDao airlineDao;
	
	
	//Method to redirect to the Add airline information Page 
	@RequestMapping(value = "/AddAirline.htm")
	public ModelAndView addAirlineInfo(@ModelAttribute("airline")Airline airline) throws AirlineException
	{
		List<Airline> airlineList = airlineDao.getAllAirlines();
		
		return new ModelAndView("addAirline","airlineList", airlineList);
	}
	
	
	//Method to save airline to database if it does not exist
	@RequestMapping(value = "/add")
	public ModelAndView addAirline(@ModelAttribute("airline")Airline airline, FlightSchedule fs, BindingResult result, HttpServletRequest request, HttpSession session) throws AirlineException
	{
		LOGGER.debug(airline);
		
		String operation = request.getParameter("operation");
		
		String airlineName= request.getParameter("airlineName");
		
		int checkResult;
		
		if (operation.equals("Add Airline"))
		{
			//Check if airline Already exists
			checkResult= airlineDao.checkAirlineExists(airlineName);
			
			
			if (checkResult==1)
				{
					
					JOptionPane.showMessageDialog(null, "Airline Already exists");
					return new ModelAndView("addAirline"); 
					
				}
			
			else
				{
					
					Airline addResult= airlineDao.add(airline);
					System.out.println("ADD result"+addResult);
					fs.setAirline(airline);
					
					
					long airlineId= addResult.getAirlineId();
					request.setAttribute("airlineId",airlineId);
					
					List<Airline> airlineList = airlineDao.getAllAirlines();	
					
					return new ModelAndView("addAirline","airlineList",airlineList);
				
				}
			}
		
		else
		{
			return new ModelAndView("addFlightSchedule");
		}
		
		
		}
	
	     //Method to redirect to the Delete airline information Page 
			@RequestMapping(value = "/deleteAirline")
			public ModelAndView deleteAirlineInfo(@ModelAttribute("airline")Airline airline) throws AirlineException
			{
				List<Airline> airlineList = airlineDao.getAllAirlines();
				return new ModelAndView("deleteAirline","airlineList", airlineList);
			}
			
		
			//Method to save airline to database if it does not exist
			@RequestMapping(value = "/DeleteAirline.htm")
			public ModelAndView deleteAirline(@ModelAttribute("airline")Airline airline, HttpServletRequest request, HttpSession session) throws AirlineException
			{
				int delResult;
				
				long id= Long.parseLong(request.getParameter("airlineID"));
				
				delResult= airlineDao.deleteAirlineById(id);
				
				List<Airline> airlineList = airlineDao.getAllAirlines();
				return new ModelAndView("addAirline","airlineList",airlineList);
			
			}
			
			//Method to retrieve All airlines in the Database
			@RequestMapping(value = "/retrieveAllAirlines")
			public ModelAndView AllAirlines() throws AirlineException
			{
				
				List<Airline> airline = new ArrayList<Airline>();
				
					airline = airlineDao.getAllAirlines();
				
				return new ModelAndView ("displayAllAirlines","airlineList", airline);
				
			}
			
		

}
