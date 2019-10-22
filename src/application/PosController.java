package application;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PosController {
	
	@FXML
	TableView productTV;
	@FXML
	TableColumn productNameTC;
	@FXML
	TableColumn productPriceTC;
	@FXML
	TableView checkoutTV;
	@FXML
	TableColumn checkoutTCName;
	@FXML
	TableColumn checkoutTCPrice;
	
	@FXML
	Label totalAmount;
	
	//bind back to main
	Main main;
	
	@FXML
	private void initialize(){
		//Initialize the person table
		
		productNameTC.setCellValueFactory(
				new PropertyValueFactory<Product,String>("name"));
		productPriceTC.setCellValueFactory(
				new PropertyValueFactory<Product,String>("price"));
		checkoutTCName.setCellValueFactory(
				new PropertyValueFactory<Product,String>("name"));
		checkoutTCPrice.setCellValueFactory(
				new PropertyValueFactory<Product,String>("price"));
		
	}
	
	public void setMain(Main main){
		
		this.main = main;
		totalAmount.textProperty().bindBidirectional(main.amount);
		
		productTV.setItems(main.data);
		checkoutTV.setItems(main.cdata);
		checkoutTV.getItems().addListener(new ListChangeListener(){

			@Override
			public void onChanged(Change c) {
				// TODO Auto-generated method stub
				double total = 0;
				for (Object p : checkoutTV.getItems()){
					Product e = (Product)p;
					total = total + e.getPrice();
					
				}
				
				main.amount.setValue(total + "");
			}});
	}
	
	@FXML
	public void handleAdd(ActionEvent e){
		Product pro = (Product) productTV.getSelectionModel().getSelectedItem();
		
		if (pro != null)
			checkoutTV.getItems().add(pro);
		
	}
}
