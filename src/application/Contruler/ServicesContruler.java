package application.Contruler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Model.ProductModel;
import application.Model.ServicesModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServicesContruler {
	Statement st ;
	
	
	public void Update(String name,int Number) {
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			String sql="UPDATE `products` SET `Number`='"+Number+"' WHERE `Name`= '"+name+"'";
			st.executeUpdate(sql);
			ConnectionDB.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public ObservableList<String> getNamesproduct(){
		ObservableList<String> product=FXCollections.observableArrayList();
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			String sql="SELECT `Name`FROM `products`";
		    ResultSet rs=st.executeQuery(sql);
		    
		    
		    while (rs.next()) {
		    	ProductModel pr = new ProductModel();
		    	//pr.setName(rs.getString(1));
		    	
		    	product.add(rs.getString(1));
		    	
		    	ConnectionDB.closeConnection();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return product;
		
	}
	
	
	
	public ObservableList<String> getSerchNamesProduct(String Names){
		
		ObservableList<String> product=FXCollections.observableArrayList();
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			String sql="SELECT  `Name` FROM `products` WHERE `Name` LIKE '%"+Names+"%'";
			ResultSet re=st.executeQuery(sql);
			
			
			while (re.next()) {
				
				product.add(re.getString(1));
				ConnectionDB.closeConnection();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return product;
		
	}
	
	public ProductModel getProduct(String name) {
		
		ProductModel pr= new ProductModel();
		
		try {
			st=ConnectionDB.openConnection().createStatement();
			
			String sql="SELECT * FROM `products` WHERE `Name`= '"+name+"'";
			ResultSet re=st.executeQuery(sql);
			
			
			while (re.next()) {
				
				pr.setId(re.getInt(1));
				pr.setName(re.getString(2));
				pr.setNumber(re.getInt(3));
				pr.setPrice(re.getDouble(4));
				pr.setType(re.getString(5));
				pr.setDiscount(re.getInt(6));
				
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pr;
		
	}
	
	

}
