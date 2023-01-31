package application.ViewControler;


import java.io.IOException;
import java.sql.SQLException;

import application.Contruler.LoginControuler;
import application.Model.Admin;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginForm_Controler {
	
	 @FXML
	  Button btn_singIn;

	    @FXML
	     Label lblMessage;

	    @FXML
	    PasswordField txt_password;

	    @FXML
	     TextField txt_userName;

	   
    
    Admin ad = new Admin();
    LoginControuler lo= new LoginControuler();
    
    
    @SuppressWarnings("exports")
	@FXML
     public void issign(Event e) throws IOException, SQLException {
    	ad.setUserName(txt_userName.getText());
    	ad.setPassword(txt_password.getText());
    	
    	
    	if (lo.isLogin(ad)) {
			Node node = (Node) e.getSource();
			Stage  stage = (Stage) node.getScene().getWindow();
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Home.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			
		}
    	
    	else 
    		lblMessage.setText("username or password is wrong");
    	
    }
	
	
	
	

}
