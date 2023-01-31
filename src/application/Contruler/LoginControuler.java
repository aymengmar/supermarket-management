package application.Contruler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Model.Admin;








public class LoginControuler {
	
	Statement st ;
	
	
public boolean isLogin(Admin ad) throws SQLException  {
	
	
		st=ConnectionDB.openConnection().createStatement();
	 
	
	
	
	String sql="SELECT * FROM `admins` WHERE `userName`= '"+ad.getUserName()+"'and `password`='"+ad.getPassword()+"' ";      

	
	

	ResultSet result = st.executeQuery(sql);
	
	
	
	
		if (result.next()) 
			return true;
	
	
	 
	
	
	return false ;
}
}


		
		

	

	
	
	
	
	
	


