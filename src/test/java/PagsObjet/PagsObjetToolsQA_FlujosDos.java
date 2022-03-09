package PagsObjet;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import MapsObjet.MapsObjetToolsQA_FlujosDos;
import ProyectoTQA.ClasesBase;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetToolsQA_FlujosDos extends MapsObjetToolsQA_FlujosDos {
	public PagsObjetToolsQA_FlujosDos(WebDriver driver) {
		super(driver);
		ClasesBase.driver = driver;
	}

	public void IngresoaWidgets(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {

		// SELECCION FECHA
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		tiempoEspera(1000);
		clic(btnWidgets, rutaCarpeta);
		@SuppressWarnings("unused")
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		clic(btnDatePïcker, rutaCarpeta);
		comando(txtSelectDate, rutaCarpeta);
		bspace(txtSelectDate, rutaCarpeta);
		tiempoEspera(5000);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 2), txtSelectDate, rutaCarpeta);
		intro(txtSelectDate, rutaCarpeta);
		tiempoEspera(1000);
		// SELECCION DE FECHA Y HORA
		comando(txtDateTime, rutaCarpeta);
		bspace(txtDateTime, rutaCarpeta);
		tiempoEspera(5000);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 3) + " "
				+ leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 4), txtDateTime, rutaCarpeta);
		tiempoEspera(5000);
		intro(txtDateTime, rutaCarpeta);
		tiempoEspera(2000); 

	}
}