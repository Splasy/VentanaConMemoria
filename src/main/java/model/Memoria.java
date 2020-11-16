package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Memoria {
	private String pathDirectorio;
	private String pathFichero;
	private DoubleProperty red;
	private DoubleProperty blue;
	private DoubleProperty green;
	private DoubleProperty alto;
	private DoubleProperty ancho;
	private DoubleProperty posX;
	private DoubleProperty posY;

	public Memoria() {
		pathDirectorio = System.getProperty("user.home") + File.separator + ".VentanaConMemoria";
		pathFichero = pathDirectorio + File.separator + "ventana.config";

		red = new SimpleDoubleProperty();
		blue = new SimpleDoubleProperty();
		green = new SimpleDoubleProperty();
		alto = new SimpleDoubleProperty();
		ancho = new SimpleDoubleProperty();
		posX = new SimpleDoubleProperty();
		posY = new SimpleDoubleProperty();
	}

	public void guardarfichero() throws FileNotFoundException, IOException {
		try (OutputStream fichero = new FileOutputStream(pathFichero)) {
			Properties prop = new Properties();

			prop.setProperty("background.red", red.get() + "");
			prop.setProperty("background.blue", blue.get() + "");
			prop.setProperty("background.green", green.get() + "");
			prop.setProperty("size.width", ancho.get() + "");
			prop.setProperty("size.height", alto.get() + "");
			prop.setProperty("location.x", posX.get() + "");
			prop.setProperty("location.y", posY.get() + "");

			prop.store(fichero, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cargarFichero() {
		try {

			File archivo = new File(pathDirectorio);
			archivo.mkdir();

			File memoria = new File(pathFichero);
			boolean creado = memoria.createNewFile();

			if (creado) {
				try (OutputStream output = new FileOutputStream(memoria.getPath())) {
					Properties prop = new Properties();

					prop.setProperty("background.red", "0");
					prop.setProperty("background.blue", "0");
					prop.setProperty("background.green", "0");
					prop.setProperty("size.width", "600");
					prop.setProperty("size.height", "300");
					prop.setProperty("location.x", "440");
					prop.setProperty("location.y", "244");

					prop.store(output, null);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

			try (InputStream input = new FileInputStream(pathFichero)) {
				Properties prop = new Properties();

				prop.load(input);

				red.set(Double.parseDouble(prop.getProperty("background.red")));
				blue.set(Double.parseDouble(prop.getProperty("background.blue")));
				green.set(Double.parseDouble(prop.getProperty("background.green")));
				alto.set(Double.parseDouble(prop.getProperty("size.height")));
				ancho.set(Double.parseDouble(prop.getProperty("size.width")));
				posX.set(Double.parseDouble(prop.getProperty("location.x")));
				posY.set(Double.parseDouble(prop.getProperty("location.y")));

			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
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

	public final DoubleProperty altoProperty() {
		return this.alto;
	}

	public final double getAlto() {
		return this.altoProperty().get();
	}

	public final void setAlto(final double alto) {
		this.altoProperty().set(alto);
	}

	public final DoubleProperty anchoProperty() {
		return this.ancho;
	}

	public final double getAncho() {
		return this.anchoProperty().get();
	}

	public final void setAncho(final double ancho) {
		this.anchoProperty().set(ancho);
	}

	public final DoubleProperty posXProperty() {
		return this.posX;
	}

	public final double getPosX() {
		return this.posXProperty().get();
	}

	public final void setPosX(final double posX) {
		this.posXProperty().set(posX);
	}

	public final DoubleProperty posYProperty() {
		return this.posY;
	}

	public final double getPosY() {
		return this.posYProperty().get();
	}

	public final void setPosY(final double posY) {
		this.posYProperty().set(posY);
	}

}
