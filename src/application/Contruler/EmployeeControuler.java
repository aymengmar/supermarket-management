package application.Contruler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import application.Model.EmployeeModel;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

public class EmployeeControuler {
	Statement st;
	
	public void insert(EmployeeModel em) {
		
		
		String sql="INSERT INTO `employee`(`Name`, `Salary`, `Join_Date`, `Rank`, `City`, `Street`) VALUES ('"+em.getName()+"','"+em.getSalary()+"','"+em.getJoin_Date()+"','"+em.getRank()+"','"+em.getCity()+"','"+em.getStreet()+"')";
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			st.executeUpdate(sql);
			ConnectionDB.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void delate(int id) {
		
		Statement st ; 
		
		
		String sql="DELETE FROM `employee` WHERE `id`= '"+id+"'";
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			st.executeUpdate(sql);
			ConnectionDB.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void Update(EmployeeModel em ) {
		
		Statement st ;
		
		String sql="UPDATE `employee` SET `Name`='"+em.getName()+"',`Salary`='"+em.getSalary()+"',`Join_Date`='"+em.getJoin_Date()+"',`Rank`='"+em.getRank()+"',`City`='"+em.getCity()+"',`Street`='"+em.getStreet()+"' WHERE `id`= '"+em.getId()+"'";
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			st.executeUpdate(sql);
			ConnectionDB.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ObservableList<EmployeeModel>getAllEmployee(){
		  
		
		ObservableList employee = FXCollections.observableArrayList();
		String sql="SELECT * FROM `employee`";
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
            
			
		while (rs.next()) {
			
			EmployeeModel emp = new EmployeeModel();
			
			
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getDouble(3));
			emp.setJoin_Date(rs.getDate(4));
			emp.setRank(rs.getString(5));
			emp.setCity(rs.getString(6));
			emp.setStreet(rs.getString(7));
			
			employee.add(emp);
			
			
		}
			
		ConnectionDB.closeConnection();	
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return employee;
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ObservableList<EmployeeModel>getSearchEmploye(String name){
		  
		
		ObservableList employee = FXCollections.observableArrayList();
		
		String sql="SELECT * FROM `employee` WHERE `Name` LIKE '%"+name+"%'";
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
            
			
		while (rs.next()) {
			
			EmployeeModel emp = new EmployeeModel();
			
			
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getDouble(3));
			emp.setJoin_Date(rs.getDate(4));
			emp.setRank(rs.getString(5));
			emp.setCity(rs.getString(6));
			emp.setStreet(rs.getString(7));
			
			employee.add(emp);
			
			
		}
			
		ConnectionDB.closeConnection();	
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return employee;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
