package aplicacion;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Memoria;

public class App extends Application {
	Controller controller;
	Memoria configuracion = new Memoria();

	@Override
	public void init() throws Exception {
		configuracion.cargarFichero();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new Controller();
		// Bindeos entre el modelo y el archivo con la "memoria"
		controller.getModel().redProperty().bindBidirectional(configuracion.redProperty());
		controller.getModel().blueProperty().bindBidirectional(configuracion.blueProperty());
		controller.getModel().greenProperty().bindBidirectional(configuracion.greenProperty());

		Scene scene = new Scene(controller.getView(), configuracion.getAncho(), configuracion.getAlto());
		// Bindeo el tama�o a la ESCENA
		configuracion.anchoProperty().bind(scene.widthProperty());
		configuracion.altoProperty().bind(scene.heightProperty());

		//Se le pone primero la posici�n y luego se le bindea porque sino no abre donde estuvo previamente
		primaryStage.setX(configuracion.getPosX());
		primaryStage.setY(configuracion.getPosY());
		configuracion.posXProperty().bind(primaryStage.xProperty());
		configuracion.posYProperty().bind(primaryStage.yProperty());

		primaryStage.setTitle("Ventana con memoria");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		configuracion.guardarfichero();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
