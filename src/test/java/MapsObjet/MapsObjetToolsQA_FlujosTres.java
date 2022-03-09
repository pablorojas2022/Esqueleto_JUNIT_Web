package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ProyectoTQA.ClasesBase;

public class MapsObjetToolsQA_FlujosTres extends ClasesBase {
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetToolsQA_FlujosTres(WebDriver driver) {
		super(driver);
	}
	protected By botonAlerts = By.xpath("//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[3]/span[1]/div[1]/div[1]");
	protected By botonAlerts1 = By.xpath("//div[contains(@class,'element-list collapse show')]//li[@id='item-1']");
	protected By btnRecoWidget = By.xpath("//div[1]//div[1]//div[4]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
	protected By btnFrame = By.xpath("//*[@class='left-pannel']/div/div[3]");
	protected By btnAlerts = By.xpath("//span[normalize-space()='Alerts']");
	protected By btnClic1 = By.xpath("//button[@id='alertButton']");
	protected By btnClic2 = By.xpath("//button[@id='timerAlertButton']");
	protected By btnClic3 = By.xpath("//button[@id='confirmButton']");
	protected By btnClic4 = By.xpath("//button[@id='promtButton']"); 
	protected By textAlerts = By.xpath("//span[contains(text(),'Alerts')]");
}
