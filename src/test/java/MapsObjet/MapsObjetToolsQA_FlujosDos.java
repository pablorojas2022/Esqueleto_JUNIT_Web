package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ProyectoTQA.ClasesBase;

public class MapsObjetToolsQA_FlujosDos extends ClasesBase {
	// CONSTRUCTOR DE LA CLASE

	public MapsObjetToolsQA_FlujosDos(WebDriver driver) {
		super(driver);
		ClasesBase.driver = driver;
	}

	// INGRESAR A WIDGETS
	protected By btnWidgets = By.xpath("//*[@class='left-pannel']/div/div[4]");
	protected By btnDatePïcker = By.xpath("//span[contains(text(),'Date Picker')]");

	// INGRESAR DATOS DE DATE
	protected By txtSelectDate = By.xpath("//input[@id='datePickerMonthYearInput']");

	// INGRESAR DATOS DE DATE AND TIME
	protected By txtDateTime = By.xpath("//input[@id='dateAndTimePickerInput']");

}