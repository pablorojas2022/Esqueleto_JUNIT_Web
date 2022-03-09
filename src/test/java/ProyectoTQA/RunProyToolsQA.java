package ProyectoTQA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import PagsObjet.PagsObjetToolsQA_Inicio;
import PagsObjet.PagsObjetToolsQA_Flujos;
import PagsObjet.PagsObjetToolsQA_FlujosDos;
import PagsObjet.PagsObjetToolsQA_FlujosTres;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunProyToolsQA {

	private WebDriver driver;
	PagsObjetToolsQA_Inicio pagHome;
	PagsObjetToolsQA_Flujos pagFlujos;
	PagsObjetToolsQA_FlujosDos pagFlujosDos;
	PagsObjetToolsQA_FlujosTres pagFlujosTres;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	String url = null;
	ClasesBase claseBase;

	@Before
	public void setUp() throws IOException {
		driver = ClasesBase.chromeDriverConnection();
		pagHome = new PagsObjetToolsQA_Inicio(driver);
		pagFlujos = new PagsObjetToolsQA_Flujos(driver);
		pagFlujosDos = new PagsObjetToolsQA_FlujosDos(driver);
		pagFlujosTres = new PagsObjetToolsQA_FlujosTres(driver);
// INSTANCIAR  LAS CLASE PROPIEDADES DE JAVA UTIL
		propiedades = new Properties();
// INSTANCIAR LAS CLASES DE EXCEL
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
// CREAR VARIABLE TIPO INPUTSTREAM
		InputStream entrada = null;
// VALIDAR SI GENERAR ERROR AL NO ENCONTRAR EL ARCHIVO		
		try {
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e); 
		}

	}

	@Test
	public void test() throws Exception {

		// OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		File rutaCarpeta = pagHome.crearCarpeta(propiedades, nomTest);
		// ALMACENO EN LA VARIABLE EL VALOR DE URL DEL EXCEL
		url = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Data", 1, 0);
		// ACCEDER AL METODO DE ABRIR PAGINA
		pagHome.urlAcceso(url);
		pagFlujos.IngresoaToolsQAElement(leer, propiedades, rutaCarpeta);
		pagFlujos.IngresoaWebtables(leer, propiedades, rutaCarpeta);
		pagFlujos.AddaRegistro(leer, propiedades, rutaCarpeta);
		pagFlujos.EliminarenRegistro(leer, propiedades, rutaCarpeta);
		pagFlujosDos.IngresoaWidgets(leer, propiedades, rutaCarpeta);
		pagFlujosTres.IngresoaAlert(leer, propiedades, rutaCarpeta);

	}

	@After
	public void cerrar() {
// CERRAR PROCESO
		driver.quit();
	} 

}
