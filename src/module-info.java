module SuperMarket2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires mysql.connector.j;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.ViewControler to javafx.graphics, javafx.fxml;
	opens application.Contruler to javafx.graphics, javafx.fxml;
	opens application.Model to javafx.graphics, javafx.fxml;
	
	exports application.ViewControler;
	exports application.Contruler;
	exports application.Model;
	



}
