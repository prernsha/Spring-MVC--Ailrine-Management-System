package com.neu.edu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.User;

public class UserDao extends Dao {
	
	public UserDao() {
	}

	//Check if username already exists in the database
	public User authenticateUser(String username, String password, String type) throws UserException {
		
		try {
			
			begin();
			Query q = getSession().createQuery("from User where username = :username AND password = :password AND type= :type");
			q.setString("username", username);
			q.setString("password", password);
			q.setString("type", type);
			
			commit();
			User user = (User) q.uniqueResult();
						
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user: " + username, e);
		}
	}
	
	//Add UserName and password into the Database
	public User create(User user)
            throws UserException {
        try {
            begin();            
            getSession().save(user);     
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }
	
	//Add UserName and password into the Database
		public int checkUniqueUsername(String username)
	            throws UserException {
			int result;
			try
			{
				
			
				begin();
				Query q = getSession().createQuery("from User where username = :username");
				q.setString("username", username);
				User user = (User) q.uniqueResult();
				commit();
				
				
				if(user == null)
				{
					result = 0;
				}
				else
				{
					result=1;
				}
				return result;
			} 
			catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get username: " +username, e);
		}
		}
}



