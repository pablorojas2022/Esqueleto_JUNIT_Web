package PagsObjet;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import MapsObjet.MapsObjetToolsQA_Flujos;
import ProyectoTQA.ClasesBase;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetToolsQA_Flujos extends MapsObjetToolsQA_Flujos {

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetToolsQA_Flujos(WebDriver driver) {

		super(driver);
		ClasesBase.driver = driver;
	}

	public void IngresoaToolsQAElement(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		tiempoEspera(1000);
		clic(botonElement, rutaCarpeta);
		tiempoEspera(500);  
	}

	public void IngresoaWebtables(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		tiempoEspera(1000);
		clic(botonWebtables, rutaCarpeta);
		tiempoEspera(500);
	}

	public void AddaRegistro(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {
		clic(botonAdd, rutaCarpeta);
		tiempoEspera(500);
		// Registration Form
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 0), txtfirstName, rutaCarpeta);
		tiempoEspera(50); 
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 1), txtlastName, rutaCarpeta);
		tiempoEspera(500);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 2), txtemail, rutaCarpeta);
		tiempoEspera(500);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 3), txtage, rutaCarpeta);
		tiempoEspera(500);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 4), txtsalary, rutaCarpeta);
		tiempoEspera(500);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 5), txtdepartament,
				rutaCarpeta);
		tiempoEspera(50);
		clic(botonsubmit, rutaCarpeta);
		tiempoEspera(50);

	}

	public void EliminarenRegistro(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {
		clic(celdasearch, rutaCarpeta);
		tiempoEspera(50);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 0), celdasearch, rutaCarpeta);
		tiempoEspera(50);
		clic(celdasearch, rutaCarpeta);
		tiempoEspera(50);
		clic(botonlupa, rutaCarpeta);
		tiempoEspera(50);
		clic(botonborrar, rutaCarpeta);
		tiempoEspera(50);
		clic(celdasearch, rutaCarpeta);
		tiempoEspera(500);
		borrar(celdasearch,rutaCarpeta);
		tiempoEspera(50);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 1), celdasearch, rutaCarpeta);
		tiempoEspera(50);
		clic(botonCElements, rutaCarpeta);
		tiempoEspera(50);
		
	}

}
