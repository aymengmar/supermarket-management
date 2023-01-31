package application.ViewControler;

import java.net.URL;
import java.util.ResourceBundle;

import application.Contruler.productControuler;
import application.Model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductForm_Controler implements Initializable {
	
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
	    private TableColumn discount;

	    @SuppressWarnings("rawtypes")
		@FXML
	    private TableColumn id;

	    @SuppressWarnings("rawtypes")
		@FXML
	    private TableColumn name;

	    @SuppressWarnings("rawtypes")
		@FXML
	    private TableColumn number;

	    @SuppressWarnings("rawtypes")
		@FXML
	    private TableColumn price;

	    @SuppressWarnings("rawtypes")
		@FXML
	    private TableView table;

	    @FXML
	    private TextField txtDiscount;

	    @FXML
	    private TextField txtName;

	    @FXML
	    private TextField txtNumber;

	    @FXML
	    private TextField txtPrice;

	    @FXML
	    private TextField txtSearch;

	    @SuppressWarnings("rawtypes")
		@FXML
	    private TableColumn type;

	    
	    
	 productControuler pc = new productControuler();
	 
	 int ID;
	String typeValue[]= {"Fruits","foods","water"};
	ObservableList<String> allType = FXCollections.observableArrayList(typeValue);

	
	@SuppressWarnings("unchecked")
	public void Search() {
		table.setItems(pc.getSearchProducts(txtSearch.getText()));
		
	}
	
	@SuppressWarnings({ "exports", "unchecked" })
	public void add(Event e ) {
		
		ProductModel pr = new ProductModel();
		
		pr.setName(txtName.getText());
		pr.setNumber(Integer.parseInt(txtNumber.getText()));
		pr.setPrice(Double.parseDouble(txtPrice.getText()));
		pr.setType(Type.getValue()+"");
		pr.setDiscount(Integer.parseInt(txtDiscount.getText()));
		
		this.pc.insert(pr);
		table.setItems(pc.getAllProducts());
		txtName.setText("");
		txtNumber.setText("");
		txtPrice.setText("");
		txtDiscount.setText("");
		
		
	}
	
	
@SuppressWarnings({ "unchecked", "exports" })
public void update(Event e) {
		
		ProductModel pr = new ProductModel();
		
		pr.setName(txtName.getText());
		pr.setNumber(Integer.parseInt(txtNumber.getText()));
		pr.setPrice(Double.parseDouble(txtPrice.getText()));
		pr.setType(Type.getValue()+"");
		pr.setDiscount(Integer.parseInt(txtDiscount.getText()));
		pr.setId(ID); 
		this.pc.update(pr);
		table.setItems(pc.getAllProducts());
		
		
		
		txtName.setText("");
		txtNumber.setText("");
		txtPrice.setText("");
		txtDiscount.setText("");
		
		
		System.out.println("test update ");
	}
	
	@SuppressWarnings({ "exports", "unchecked" })
	public void ClikTable(Event e) {
	ProductModel pm = (ProductModel) table.getSelectionModel().getSelectedItem();
	
	txtName.setText(pm.getName());
	txtNumber.setText(pm.getNumber()+"");
	txtPrice.setText(pm.getPrice()+"");
	txtDiscount.setText(pm.getDiscount()+"");
	Type.setValue(pm.getType());
	ID=pm.getId();
	
	
	
	
	
	}
	
	
	@SuppressWarnings({ "exports", "unchecked" })
	public void delate(Event e) {
		
		this.pc.delete(ID);
		table.setItems(pc.getAllProducts());
		
		
		txtName.setText("");
		txtNumber.setText("");
		txtPrice.setText("");
		txtDiscount.setText("");
		
		
		
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		number.setCellValueFactory(new PropertyValueFactory<>("Number"));
		price.setCellValueFactory(new PropertyValueFactory<>("Price"));
		type.setCellValueFactory(new PropertyValueFactory<>("Type"));
		discount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
		
		table.setItems(pc.getAllProducts());
		
		
		Type.getItems().addAll(allType);
		
	}
	
	
	
	
	
	
	
	
	

}
