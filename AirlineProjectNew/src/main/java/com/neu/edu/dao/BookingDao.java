package com.neu.edu.dao;

import org.hibernate.HibernateException;

import com.neu.edu.exception.BookingException;
import com.neu.edu.pojo.Booking;




public class BookingDao extends Dao {

	//Add UserName and password into the Database
		public Booking create(Booking booking) throws BookingException {
	        try {
	            begin();            
	            getSession().save(booking);     
	            commit();
	            return booking;
	        } catch (HibernateException e) {
	            rollback();
	            throw new BookingException("Exception while creating booking: " + e.getMessage());
	        }
	    }
}
