package com.ibuki101.admob;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MyApplication extends Application {

	@Override
	public void start(Stage stage) {

		StringProperty message = new SimpleStringProperty(getMessage());
		Label label = new Label();
		label.textProperty().bind(message);

		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(new StackPane(label), bounds.getWidth(), bounds.getHeight());
		stage.setScene(scene);
		stage.show();

		try{
			IPlatformProvider provider = PlatformService.getInstance().getProvider();
			IAdViewService adViewService = provider.getAdviewService();
			adViewService.displayAdUnit(true, message);
		} catch (Exception ex){
			message.set("Exception: " + ex.getMessage());
		}
	}

	public String getMessage(){
		return "admob was not loaded";
	}

	public static void main(String[] args) {
		launch(args);
	}
}
