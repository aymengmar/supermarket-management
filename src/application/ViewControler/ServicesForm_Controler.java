package application.ViewControler;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Contruler.ServicesContruler;
import application.Model.ProductModel;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class ServicesForm_Controler implements Initializable {
	 @FXML 
	    private Button back;

	  @FXML
	    private TextField bill12;
	    

	    @FXML
	    private Button btnAdd;

	    @FXML
	    private Button btnSearch;

	    @FXML
	    private Label ltotal;

	    @FXML
	    private Button print;

	    @SuppressWarnings("rawtypes")
		@FXML
	    private ComboBox  table;

	    @FXML
	    private TextField txtDiscount;

	    @FXML
	    private TextField txtNumber;

	    @FXML
	    private TextField txtPrice;

	    @FXML
	    private TextField txtSearch;

	    int numProduct;
	    ServicesContruler seC=new ServicesContruler();
	    ProductModel seM = new ProductModel();
	    double total=0;
	    int num =0;
	    
	    
	    @SuppressWarnings("exports")
		public void Back(Event e) {
	    	
			try {
				//****************************close actuali Window**************************
				javafx.scene.Node node = (javafx.scene.Node) e.getSource();
	            javafx.stage.Stage stage = (javafx.stage.Stage) node.getScene().getWindow();                  
	            stage.close();
	            //*******************************pass the next window*********************
	            javafx.scene.Parent root;
				root = FXMLLoader.load(getClass().getResource("/application/View/Home.fxml"));
				
				
				javafx.scene.Scene scene = new javafx.scene.Scene(root);       
	            stage.setScene(scene);
	            stage.show();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}       
            
	    	
	    }
	    
	    
	    
		@SuppressWarnings("unchecked")
		public void search() {
	    	
			table.getItems().clear();
			table.getItems().addAll(seC.getSerchNamesProduct(txtSearch.getText()));
	    }
	    
	    
		@SuppressWarnings("exports")
		public void ClickTable(Event e) {
			
			String product = (String) table.getSelectionModel().getSelectedItem();
			
			seM=seC.getProduct(product);
			
			txtPrice.setText(seM.getPrice()+"");
			txtDiscount.setText(seM.getDiscount()+"");
			numProduct=seM.getNumber();
			
		}
	    
	    
	    public void Buy() {
	    	String s= bill12.getText();
	    	seC.Update(table.getValue()+"", numProduct-(Integer.parseInt(txtNumber.getText() )));
	    	bill12.setText(s+"Name Of Product : "+table.getValue()+"\n"
	    	+"Price Of Product : "+txtPrice.getText()+"\n"
	    		      +"Discount Of Product : "+txtDiscount.getText()+"%\n--------------------------------------\n");
	    		      
	    	
	    	txtNumber.setText("");
	    	
	    	
	    	double x = Double.parseDouble(txtPrice.getText());
	        int y = Integer.parseInt(txtDiscount.getText());
	        total+=x-(x*(y/100.0));
	        ltotal.setText(total+"");
	    	
	    }
	    public void Print() {

	        
	         
	        try {
	            num++;
	            
	             PrintWriter f = new PrintWriter("bill "+String.valueOf(num)+".txt");
	             f.println(bill12.getText());
	            f.close();
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(ServicesForm_Controler.class.getName()).log(Level.SEVERE, null, ex);
	        }
	                 
	        bill12.setText("");
	  
	  }
	    

		@SuppressWarnings("unchecked")
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			bill12.setText("*****************************  Facture******************************\n\n\n");

			table.getItems().addAll(seC.getNamesproduct());
			
			
			
		}

}
