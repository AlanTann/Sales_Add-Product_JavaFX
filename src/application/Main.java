package application;
	
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public ObservableList<Product> data = FXCollections.observableArrayList();
	public ObservableList<Product> cdata = FXCollections.observableArrayList();
	
	
	public SimpleStringProperty amount = new SimpleStringProperty();
	
	
	@Override
	public void start(Stage primaryStage) {
		
		
		data.add(new Product("milo",30));
		data.add(new Product("rice", 10));
		data.add(new Product("washer",5.4));
		
		
		
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("pos.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			PosController control = loader.getController();
			control.setMain(this);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
