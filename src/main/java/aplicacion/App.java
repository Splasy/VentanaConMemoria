package aplicacion;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Memoria;

public class App extends Application {
	Controller controller;
	Memoria configuracion;
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new Controller();
		configuracion  = new Memoria();
		
		Scene scene = new Scene(controller.getView(), configuracion.getWidth(), configuracion.getHeight());
		primaryStage.setTitle("Ventana con memoria");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
