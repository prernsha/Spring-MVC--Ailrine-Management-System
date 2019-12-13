package com.neu.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserDao;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.User;

@Controller
public class RegistrationController {
	
	private static final Log LOGGER = LogFactory.getLog(RegistrationController.class);
	@Autowired
	UserDao userdao;

	
	@RequestMapping(value = "/register")
	public ModelAndView registerPage(@ModelAttribute("user")User user) 
	{
		
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/registerUser")
	public ModelAndView registerUser(@ModelAttribute("user")User user, HttpServletRequest request) throws UserException 
	{
		LOGGER.debug(user);
		
		String username= request.getParameter("username");
		
			
			int checkresult = userdao.checkUniqueUsername(username);
			
			if(checkresult==0)
				{
			
					userdao.create(user);
					
					return new ModelAndView("userAddSuccess");
				}
		
			else
			{
				JOptionPane.showMessageDialog(null, "The username: '" +username+ "'already exists please use another username");
				return new ModelAndView ("register");
			}
		
	}
	

}
