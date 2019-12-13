package com.neu.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserDao;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/*")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/login")
	public ModelAndView loginPage(@ModelAttribute("user")User user) {
		
		return new ModelAndView("login") ;
		
			
		}
	
	@RequestMapping("/logout")
	public ModelAndView logoutPage(@ModelAttribute("user")User user, HttpServletRequest request) {
		
		request.getSession().invalidate();
		return new ModelAndView("login", "DisplayMessage", "You have been Logged out successfully") ;
		
			
		}
	
	
	@RequestMapping("/check")
	public ModelAndView checkUser(@ModelAttribute("user")User user, BindingResult result, HttpSession session, HttpServletRequest request) throws UserException 
	{
		
		String username= user.getUsername();
		String password = user.getPassword();
		String type= user.getType();
		
		String checkButton = request.getParameter("checkButton");
		
		
		if(checkButton.equals("Login"))
		{
		
			if(result.hasErrors())
			{
				return new ModelAndView("home");
			}
			else
			{
				try
				{
					if(type.equalsIgnoreCase("admin"))
					{
						User loggedUser= userDao.authenticateUser(username, password,type);
						
						if (loggedUser==null)
						{
							return new ModelAndView("error","eMsg","Please check the credentials");
						}
						else
						{
							session.setAttribute("USER", loggedUser);
							
							return new ModelAndView("admin");
							 
						}
						
						
					}
					
					else if(type.equalsIgnoreCase("customer"))
					{
						User loggedUser = userDao.authenticateUser(username, password,type);
						
						if (loggedUser==null)
						{
							return new ModelAndView("error","eMsg","Please check the credentials"); 
							
						}
						else
						{
							session.setAttribute("USER", loggedUser);
							return new ModelAndView("search");
							
						}
												
					}
					
					else
					{
						return new ModelAndView("error");
					}
				}
				catch(UserException e)
				{
					return new ModelAndView("error","eMsg",e.getMessage());
					
				}
			}
		}
		else
		{
			return new ModelAndView("register");
		}
			
		}

}
