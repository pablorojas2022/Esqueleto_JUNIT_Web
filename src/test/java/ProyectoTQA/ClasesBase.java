package ProyectoTQA;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidadesExcel.ReadExcelFile;

public class ClasesBase {
	protected static WebDriver driver; 

	// CONSTRUCTOR DE CLASE
	public ClasesBase(WebDriver driver) {
		super();
	}

	// METODO NAVEGADOR
	public static WebDriver chromeDriverConnection() {
		WebDriver _driver = null;
		try {
			// SETEAR LAS OPCIONES DEL NAVEGADOR
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

			// SETEAR LAS PROPIEDADES DEL NAVEGADOR
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			_driver = new ChromeDriver();

			// MAXIMIZAR NAVEGADOR
			_driver.manage().window().maximize();
			return _driver;
		} catch (Exception e) {
			System.out.println(e);
		}
		return _driver;
	}

	// METODO CLICK
	public void clic(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).click();
		tiempoEspera(5000);
		captureScreen(rutaCarpeta);
	}

	// METODO BORRAR
	public void borrar(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	}

	// METODO ENVIAR TEXTO
	public void sendKey(String inputText, By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta);
	}

	// METODO ENTER SUBMIT
	public void submit(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta);
	}

	// METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}

	public String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;

	}

	public String HoraSistema() {
		// TOMAMOS LA HORA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		// DEFINIR FORMATO HORA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		// DAR FORMATO A LA HORA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;

	}

	public void captureScreen(File rutaCarpeta) throws Exception {
		String hora = HoraSistema();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(rutaCarpeta + "/" + "Evidencia" + hora + ".jpg"));
	}

	public File crearCarpeta(Properties propiedades, String nomTest) {
		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		// CREAREMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest + "-" + fecha;
		// OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/" + nomCarpeta);
		// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}

	public void dateAndTime(String xpathHh, Object fechaExcel, String xpathDd, By DateTime, By month, By year,
			File rutaCarpeta) throws Exception {

		String fecha = fechaExcel.toString();
		String dd = fecha.split("/")[0];
		String mm = fecha.split("/")[1];
		String aa = fecha.split("/")[2];
		String hh = fecha.split("/")[3];

		String xpathdd = xpathDd + dd + "']";
		String xpathmm = xpathDd + mm + "']";
		String xpathaa = xpathDd + aa + "']";
		String xpathhh = xpathHh + hh + "']";

		driver.findElement(DateTime).click();
		driver.findElement(month).click();
		driver.findElement(By.xpath(xpathmm)).click();
		driver.findElement(year).click();
		driver.findElement(By.xpath(xpathaa)).click();
		driver.findElement(By.xpath(xpathdd)).click();
		driver.findElement(By.xpath(xpathhh)).click();

		tiempoEspera(2000);
		captureScreen(rutaCarpeta);

	}

	public void desplazarseElemento(By locator) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		executor.executeScript("argument[0].scrollIntoView(true);", element);
	}

	public void selectDate(String xpathDd, Object fechaExcel, String xpathMn, String xpathAa, File rutaCarpeta)
			throws Exception {
		String fecha = fechaExcel.toString();
		String dd = fecha.split("/")[0];
		String mm = fecha.split("/")[1];
		String aa = fecha.split("/")[2];

		String xpathMonth = xpathMn + mm + "']";
		String xpathYear = xpathAa + aa + "']";
		String xpathDay = xpathDd + dd + "']";

		driver.findElement(By.xpath(xpathMonth)).click();
		driver.findElement(By.xpath(xpathYear)).click();
		driver.findElement(By.xpath(xpathDay)).click();

		tiempoEspera(2000);
		captureScreen(rutaCarpeta);
	}

	// METODO INICIAL
	public void urlAcceso(String url) throws InterruptedException

	{
		driver.get(url);
		tiempoEspera(2000);
		// busquedaInicial();
	}

	// METODO SCROLL
	public void scrollPage(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");
	}

	// METODO ALERTA EMERGENTE
	@SuppressWarnings("deprecation")
	public void alert(File rutaCarpeta) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(3000);
			captureScreen(rutaCarpeta);
			tiempoEspera(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// SELECCIONAR LISTA
	public Select seleccionarLista(ReadExcelFile leer, By locator, Properties propiedades, String numHoja, int file,
			int column) throws IOException {
		Select objSelect = new Select(driver.findElement(locator));
		objSelect.selectByValue(leer.getCellValue(propiedades.getProperty("filePathExcel"), numHoja, file, column));
		return objSelect;
	}

	public Select seleccionarListaTexto(ReadExcelFile leer, By locator, Properties propiedades, String numHoja,
			int file, int column) throws IOException {
		Select objSelect = new Select(driver.findElement(locator));
		objSelect.selectByVisibleText(
				leer.getCellValue(propiedades.getProperty("filePathExcel"), numHoja, file, column));
		return objSelect;
	}

	// METODO CONTROL + A
	public void comando(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
		captureScreen(rutaCarpeta);
	}

	// METODO CONTROL + A
	public void bspace(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
		captureScreen(rutaCarpeta);
	}

	// METODO ENTER
	public void intro(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.ENTER);
		captureScreen(rutaCarpeta);
	}

	// METODO ESPACIO
	public void espacio(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.SPACE);
		captureScreen(rutaCarpeta);
	}

}
