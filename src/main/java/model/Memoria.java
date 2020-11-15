package model;

import java.io.File;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Memoria {
	private String pathDirectorio;
	private String pathFichero;
	private DoubleProperty red;
	private DoubleProperty blue;
	private DoubleProperty green;
	private DoubleProperty height;
	private DoubleProperty width;
	private DoubleProperty locationX;
	private DoubleProperty locationY;

	public Memoria() {
		pathDirectorio = System.getProperty("user.home") + File.separator + ".VentanaConMemoria";
		pathFichero = pathDirectorio + File.separator + "ventana.config";

		red = new SimpleDoubleProperty();
		blue = new SimpleDoubleProperty();
		green = new SimpleDoubleProperty();
		height = new SimpleDoubleProperty();
		width = new SimpleDoubleProperty();
		locationX = new SimpleDoubleProperty();
		locationY = new SimpleDoubleProperty();
	}

	public final DoubleProperty redProperty() {
		return this.red;
	}
	

	public final double getRed() {
		return this.redProperty().get();
	}
	

	public final void setRed(final double red) {
		this.redProperty().set(red);
	}
	

	public final DoubleProperty blueProperty() {
		return this.blue;
	}
	

	public final double getBlue() {
		return this.blueProperty().get();
	}
	

	public final void setBlue(final double blue) {
		this.blueProperty().set(blue);
	}
	

	public final DoubleProperty greenProperty() {
		return this.green;
	}
	

	public final double getGreen() {
		return this.greenProperty().get();
	}
	

	public final void setGreen(final double green) {
		this.greenProperty().set(green);
	}
	

	public final DoubleProperty heightProperty() {
		return this.height;
	}
	

	public final double getHeight() {
		return this.heightProperty().get();
	}
	

	public final void setHeight(final double height) {
		this.heightProperty().set(height);
	}
	

	public final DoubleProperty widthProperty() {
		return this.width;
	}
	

	public final double getWidth() {
		return this.widthProperty().get();
	}
	

	public final void setWidth(final double width) {
		this.widthProperty().set(width);
	}
	

	public final DoubleProperty locationXProperty() {
		return this.locationX;
	}
	

	public final double getLocationX() {
		return this.locationXProperty().get();
	}
	

	public final void setLocationX(final double locationX) {
		this.locationXProperty().set(locationX);
	}
	

	public final DoubleProperty locationYProperty() {
		return this.locationY;
	}
	

	public final double getLocationY() {
		return this.locationYProperty().get();
	}
	

	public final void setLocationY(final double locationY) {
		this.locationYProperty().set(locationY);
	}
	
	
}
