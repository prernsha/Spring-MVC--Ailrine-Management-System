package com.neu.edu.controller;

import java.io.File;
import java.io.FileOutputStream;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.neu.edu.dao.AirlineDao;
import com.neu.edu.dao.BookingDao;
import com.neu.edu.dao.FlightScheduleDao;
import com.neu.edu.dao.MyPdfViewImplementation;
import com.neu.edu.dao.PassengerDao;
import com.neu.edu.exception.AirlineException;
import com.neu.edu.exception.BookingException;
import com.neu.edu.exception.FlightScheduleException;
import com.neu.edu.exception.PassengerException;
import com.neu.edu.pojo.Airline;
import com.neu.edu.pojo.Booking;
import com.neu.edu.pojo.FlightSchedule;
import com.neu.edu.pojo.PassengerDetails;

@Controller
public class PassengerController {
	
	@Autowired
	PassengerDao passengerDao;
	
	@Autowired
	FlightScheduleDao fsDao;
	
	@Autowired
	AirlineDao airlineDao;
	
	@Autowired
	BookingDao bookingDao;
	
	//This method redirects to enter passenger information page
			@RequestMapping(value = "/addPassenger")
			public ModelAndView addPassenger(@ModelAttribute("passengerDetails")PassengerDetails passengerDetails,@RequestParam("flightId") long flightId, HttpServletRequest request) throws PassengerException, FlightScheduleException, AirlineException
			{
				String locaLpath="/Users/prerna/Desktop/WebImages";
				long id = Long.parseLong(request.getParameter("flightId"));
				request.setAttribute("flightId",flightId);
				
				String idProof = generateFileName(passengerDetails.getIdProof());
				
				try {
					File file = new File(locaLpath+"/"+idProof);
					FileOutputStream fos = new FileOutputStream(file);
					fos.write(passengerDetails.getIdProof().getBytes());
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				PassengerDetails passengerDet=passengerDao.addPassenger(passengerDetails);
				
				long passengerId = passengerDet.getPassengerId();
				request.setAttribute("passengerId", passengerId);
				
				FlightSchedule schedule= fsDao.getScheduleById(flightId);
				
				//To retrieve the airline information corresponding the flightId to print in the table
				FlightSchedule airlineIdResult = fsDao.getScheduleById(flightId);
				long airlineId = airlineIdResult.getAirline().getAirlineId();
				request.setAttribute("airlineId", airlineId);
				
				Airline airlineNameResult  = airlineDao.getAirlineById(airlineId);
				String airlineName = airlineNameResult.getAirlineName();
				request.setAttribute("airlineName", airlineName);
				
				
				
				return new ModelAndView("confirmBooking", "schedule",schedule);
				
			}
			
			//Method to upload the file
			private String generateFileName(MultipartFile multiPart) {
				return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
			}
			
			//Method to send the confirmation email to passenger
			public void SendEmail(PassengerDetails passengerDetails, Booking bookingResult, String airlineName, String autoSeatNum) throws EmailException {
				
				
				
				Email email = new SimpleEmail();
				email.setHostName("smtp.googlemail.com");
				email.setSmtpPort(465);
				//User your gmail username and password
				email.setAuthenticator(new DefaultAuthenticator("buyeazee@gmail.com", "buyeazee@123"));
				email.setSSLOnConnect(true);
				email.setFrom("no-reply@msis.neu.edu");
				email.setSubject("Booking Confirmation");
				email.setMsg("Congratulations!! " +passengerDetails.getName()+ "\n Your flight booking is confirmed."+"\nBooking Reference Number - "+bookingResult.getBookingId()+" and Seat Number is: "+autoSeatNum+"\nWe hope to see you again soon"+"\nRegards,"+"\n"+airlineName);
				email.addTo(passengerDetails.getEmail());
				email.send();
			}
		
			//To enter data into booking table
					@RequestMapping(value = "/bookingConfirm", method = RequestMethod.GET)
					public String addIntoBooking(HttpServletRequest request, Booking booking) throws BookingException, FlightScheduleException
					{
						long flightId = Long.parseLong(request.getParameter("flightId"));
						FlightSchedule flightSchedule = fsDao.getScheduleById(flightId);
						booking.setFlightSchedule(flightSchedule);
						
						long passengerId= Long.parseLong(request.getParameter("passengerId"));
						PassengerDetails passengerDetails = passengerDao.getPassengerById(passengerId);
						booking.setPassengerDetails(passengerDetails);
						
						String airlineName = request.getParameter("airlineName");
						
						Date bookingDate = new Date();
						booking.setBookingDate(bookingDate);
						System.out.println("bookingDate: "+bookingDate);
						
						
						int availSeats = flightSchedule.getAvailSeats();
						int newAvailSeats = availSeats-1;
						
						
						String autoSeatNum = newAvailSeats+"A";
						
						booking.setSeatNo(autoSeatNum);
						
						
						Booking bookingResult = bookingDao.create(booking);
						
						updateSeats(flightId,newAvailSeats);
						
						
						
						try {
							SendEmail(passengerDetails,bookingResult,airlineName,autoSeatNum);
						}catch (Exception e) {
							 e.printStackTrace();
						}	
						
						ModelAndView mv = new ModelAndView();
						request.setAttribute("passengerDetails",passengerDetails);
						mv.addObject(flightSchedule);
						//getReport();
						return "bookingSuccess";
						
					}
					
					
					public void updateSeats(long flightId, int newAvailSeats) throws FlightScheduleException
					{
						fsDao.updateAvailSeats(flightId, newAvailSeats);
					}
					
					
					public View getReport()
					{
						View view = new MyPdfViewImplementation();
						
						return view;
						
					}


}
