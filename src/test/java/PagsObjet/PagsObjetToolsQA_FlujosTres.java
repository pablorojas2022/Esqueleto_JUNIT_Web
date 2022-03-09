package PagsObjet;

import java.io.File;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import MapsObjet.MapsObjetToolsQA_FlujosTres;
import ProyectoTQA.ClasesBase;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetToolsQA_FlujosTres extends MapsObjetToolsQA_FlujosTres {
	public PagsObjetToolsQA_FlujosTres(WebDriver driver) {
		super(driver);
		ClasesBase.driver = driver;
	}

	public void IngresoaAlert(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception  {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		clic(botonAlerts, rutaCarpeta);
		tiempoEspera(500); 
		clic(botonAlerts1, rutaCarpeta);
		tiempoEspera(500); 
		clic(btnClic1, rutaCarpeta);
		driver.switchTo().alert().dismiss();
		tiempoEspera(100);
		clic(btnClic2, rutaCarpeta);
		tiempoEspera(7000);
		driver.switchTo().alert().dismiss();
		tiempoEspera(500);
		clic(btnClic3, rutaCarpeta);
		tiempoEspera(500);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		tiempoEspera(500);
		clic(btnClic3, rutaCarpeta);
		tiempoEspera(500);
		driver.switchTo().alert().dismiss();
		tiempoEspera(500);
		clic(btnClic4, rutaCarpeta);
		tiempoEspera(1000);
		driver.switchTo().alert().sendKeys(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DateA", 1, 0));
		alert(rutaCarpeta);
		tiempoEspera(1000); 
	}
}