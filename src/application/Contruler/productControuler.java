package application.Contruler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.protocol.Resultset;

import application.Model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class productControuler {
Statement state ;
    
    public void insert(ProductModel  product)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();//open connection 
            state.executeUpdate("INSERT INTO `products` ( `Name`, `Number`, `Price`, `Type`, `Discount`) VALUES ( '"+product.getName()+"' , "+product.getNumber()+","+product.getPrice()+",'"+product.getType()+"' ,"+product.getDiscount()+")");
             ConnectionDB.closeConnection();//close connection 
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(productControuler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("Delete FROM `products` WHERE id = " + id);
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(productControuler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(ProductModel product)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("UPDATE products set  `Name` = "+"'"+product.getName()+"'"+", `Number` = "+product.getNumber() +", `Price` = " + product.getPrice() +", `Type` = "+"'"+product.getType()+"'"+", `Discount` = "+product.getDiscount()+" WHERE id = "+product.getId() );
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(productControuler.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public ObservableList<ProductModel> getAllProducts(){
		
    	ObservableList products=FXCollections.observableArrayList();
    	String sql="SELECT * FROM `products";
    	
    	try {
			state=ConnectionDB.openConnection().createStatement();
			ResultSet rs=  state.executeQuery(sql);
			
			while (rs.next()) {
				
				ProductModel abj = new ProductModel();
				
				
				abj.setId(rs.getInt(1));
				abj.setName(rs.getString(2));
				abj.setNumber(rs.getInt(3));
				abj.setPrice(rs.getDouble(4));
				abj.setType(rs.getString(5));
				abj.setDiscount(rs.getInt(6));
				
				products.add(abj);
			}
			ConnectionDB.closeConnection();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    	return products;
    	
    }
    
 public ObservableList<ProductModel> getSearchProducts(String name){
		
    	ObservableList   products=FXCollections.observableArrayList();
    	String sql="SELECT * FROM `products` WHERE `Name` LIKE '%"+name+"%'";
    	
    	try {
			state=ConnectionDB.openConnection().createStatement();
			ResultSet rs=  state.executeQuery(sql);
			
			while (rs.next()) {
				
				ProductModel abj = new ProductModel();
				
				
				abj.setId(rs.getInt(1));
				abj.setName(rs.getString(2));
				abj.setNumber(rs.getInt(3));
				abj.setPrice(rs.getDouble(4));
				abj.setType(rs.getString(5));
				abj.setDiscount(rs.getInt(6));
				
				products.addAll(abj);
			}
			ConnectionDB.closeConnection();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    	return products;
    	
    }
    
 
    
}
