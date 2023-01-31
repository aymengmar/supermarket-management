package application.ViewControler;


import java.io.IOException;
import javafx.event.Event;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeForm {

	
	
	   @FXML
	    private Button btn_employees;

	    @FXML
	    private Button btn_products;

	    @FXML
	    private Button btn_services;

	    @FXML
	    private Button btn_statistics;

	    @SuppressWarnings("exports")
		@FXML
	     public void open_emplyees(Event e) throws IOException {

	    	Node node = (Node) e.getSource();
			Stage  stage = (Stage) node.getScene().getWindow();
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Employees.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    	
	    	
	    	
	    	
	    }
	    
	    
	  
	    @SuppressWarnings("exports")
		@FXML
	     public void open_product(Event e) throws IOException {
	    	Node node = (Node) e.getSource();
			Stage  stage = (Stage) node.getScene().getWindow();
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Products.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }
	  
	    @SuppressWarnings("exports")
		@FXML
	    public void open_services(Event e ) throws IOException {
	    	Node node = (Node) e.getSource();
			Stage  stage = (Stage) node.getScene().getWindow();
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Services.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }
	
	    @SuppressWarnings("exports")
		@FXML
	    public void open_statistics(Event e) throws IOException {
	    	Node node = (Node) e.getSource();
			Stage  stage = (Stage) node.getScene().getWindow();
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/statistics.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
