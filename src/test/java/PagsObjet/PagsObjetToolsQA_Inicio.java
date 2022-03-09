package PagsObjet;

import org.openqa.selenium.WebDriver;
import MapsObjet.MapsObjetToolsQA_Inicio;
import ProyectoTQA.ClasesBase;


public class PagsObjetToolsQA_Inicio extends MapsObjetToolsQA_Inicio {

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetToolsQA_Inicio(WebDriver driver) {

		super(driver);   
		ClasesBase.driver = driver;
	}

}
