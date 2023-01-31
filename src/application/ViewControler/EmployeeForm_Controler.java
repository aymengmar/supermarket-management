package application.ViewControler;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import application.Contruler.EmployeeControuler;
import application.Model.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class EmployeeForm_Controler implements Initializable {


    @SuppressWarnings("rawtypes")
	@FXML
    private ComboBox Type;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableColumn city;

    @FXML
    private DatePicker date;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableColumn id;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableColumn join;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableColumn name;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableColumn  rank;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableColumn  salary;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableColumn  street;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableView  table;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtStreet;
    
    
    EmployeeControuler em=new EmployeeControuler();
    int ID;
    String Rank[]= {"Geront","Ingenieure","technicien"};
    ObservableList<String> allRank=FXCollections.observableArrayList(Rank);
	
    
    @SuppressWarnings("unchecked")
	public void ClickTable() {
    	 EmployeeModel emM = (EmployeeModel) table.getSelectionModel().getSelectedItem();
    	 
    	 txtName.setText(emM.getName());
    	 txtStreet.setText(emM.getStreet());
    	 txtCity.setText(emM.getCity());
    	 txtSalary.setText(emM.getSalary()+"");
    	 ID=emM.getId();
         Type.setValue(emM.getRank());
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    }
    
    @SuppressWarnings({ "exports", "unchecked" })
	public void update(Event e) {
EmployeeModel emM=new EmployeeModel();
    	
    	emM.setName(txtName.getText());
    	emM.setSalary(Double.parseDouble(txtSalary.getText()));
    	emM.setJoin_Date(java.sql.Date.valueOf(date.getValue()));
    	emM.setRank(Type.getValue()+"");
    	emM.setCity(txtCity.getText());
    	emM.setStreet(txtStreet.getText());
    	emM.setId(ID); 
    	em.Update(emM);;
    	
    	
    	table.setItems(em.getAllEmployee());
    	
    	
    	
    	
    	txtName.setText("");
    	txtSalary.setText("");
    	txtCity.setText("");
    	txtStreet.setText("");
    	
		
    }
    
    
    @SuppressWarnings("exports")
	public void Back(Event e) {
    	try {
            //add you loading or delays - ;-)
           javafx.scene.Node node = (javafx.scene.Node) e.getSource();
           javafx.stage.Stage stage = (javafx.stage.Stage) node.getScene().getWindow();                  
           stage.close();
           
           javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("/application/View/Home.fxml"));       
           javafx.scene.Scene scene = new javafx.scene.Scene(root);       
           stage.setScene(scene);
           stage.show();

        } catch (Exception ex) {
            System.out.println("y"+ex.getMessage());
        }
    }
    
    @SuppressWarnings({ "exports", "unchecked" })
	public void serch(Event e) {
    	
    	
    	table.setItems(em.getSearchEmploye(txtSearch.getText()));
    	
    	
    }
    
    @SuppressWarnings({ "exports", "unchecked" })
	public void add(Event e) {
    	EmployeeModel emM=new EmployeeModel();
    	
    	emM.setName(txtName.getText());
    	emM.setSalary(Double.parseDouble(txtSalary.getText()));
    	emM.setJoin_Date(java.sql.Date.valueOf(date.getValue()));
    	emM.setRank(Type.getValue()+"");
    	emM.setCity(txtCity.getText());
    	emM.setStreet(txtStreet.getText());
    	 
    	em.insert(emM);
    	
    	txtName.setText("");
    	txtSalary.setText("");
    	txtCity.setText("");
    	txtStreet.setText("");
    	
		table.setItems(em.getAllEmployee());

    	
    	
    	
    }
    
    
    
    @SuppressWarnings({ "exports", "unchecked" })
	public void Delate(Event e) {
    	
    	
    	
    	em.delate(ID);
    	
    	
    	table.setItems(em.getAllEmployee());
    	
    	txtName.setText("");
    	txtSalary.setText("");
    	txtCity.setText("");
    	txtStreet.setText("");
    	
		

    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("Name") );
		salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
		join.setCellValueFactory(new PropertyValueFactory<>("Join_Date"));
		rank.setCellValueFactory(new PropertyValueFactory<>("Rank"));
		city.setCellValueFactory(new PropertyValueFactory<>("City"));
		street.setCellValueFactory(new PropertyValueFactory<>("Street"));
		
		table.setItems(em.getAllEmployee());
		
		//*****Afficher les type 
		Type.getItems().addAll(allRank);
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
