package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ProyectoTQA.ClasesBase;

public class MapsObjetToolsQA_Flujos extends ClasesBase {
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetToolsQA_Flujos(WebDriver driver) {
		super(driver);
	}
	
	// ELEMENTOS PAGINA INICIAL
        //Option 1
	    protected By anuncios = By.xpath("//*[name()='path' and contains(@d,'M0,0l15,0l')]");
	    protected By canuncios = By.xpath("//img[@title='Ad.Plus Advertising']");
		protected By botonElement = By.xpath("(//div[@class='card mt-4 top-card'])[1]");
		protected By botonWebtables = By.xpath("//span[normalize-space()='Web Tables']");
		protected By botonAdd = By.xpath("//button[@id='addNewRecordButton']");
		protected By txtfirstName = By.xpath("//input[@id='firstName']");
		protected By txtlastName = By.xpath("//input[@id='lastName']");
		protected By txtemail = By.xpath("//input[@id='userEmail']");
		protected By txtage = By.xpath("//input[@id='age']");
		protected By txtsalary = By.xpath("//input[@id='salary']");
		protected By txtdepartament = By.xpath("//input[@id='department']");
		protected By botonsubmit = By.xpath("//button[@id='submit']");
		protected By celdasearch = By.xpath("//input[@id='searchBox']");
		protected By botonlupa = By.xpath("//span[@id='basic-addon2']");
		protected By botonborrar = By.xpath("(//*[name()='path'])[55]");
		protected By botonCElements = By.xpath("(//*[name()='svg'][contains(@stroke,'currentColor')])[2]");
		
}
