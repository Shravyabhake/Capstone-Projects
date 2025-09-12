package com.orangehrm; 
import java.util.List; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory; 
public class Adminpage{ 
private WebDriver driver; 


public Adminpage(WebDriver d) { 
this.driver = d; 
PageFactory.initElements(driver, this); 
} 

@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li") 
private List<WebElement> menuitems;

@FindBy(linkText = "Admin")  WebElement adminlink; 

@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input") 
private WebElement username; 

@FindBy(xpath = "//button[@type=\"submit\"]") 
private WebElement searchbutton; 

@FindBy(xpath = "//span[contains(normalize-space(.), 'Records Found')]")WebElement recordsfound; 

@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i") 
WebElement dropdown; 

@FindBy(xpath="(//div[text()=\"Admin\"])[1]")WebElement userroleadmin;

@FindBy(xpath="//div[text()=\"-- Select --\"]")WebElement selectstatus;

@FindBy(xpath="(//div[text()=\"Enabled\"])[1]")WebElement enabled;

@FindBy(xpath="//button[contains(normalize-space(.), 'Reset')]") WebElement Reset;

public void admin() {
	for (WebElement m : menuitems) {
        System.out.println(m.getText());
    }

		adminlink.click();
		
	}

public void Searchbyusername(String un) throws InterruptedException {
	username.sendKeys(un);
	searchbutton.click();
	Thread.sleep(4000);
	String text = recordsfound.getText(); // e.g., "35 Records Found"
	String count = text.split(" ")[0];    // splits at space, takes first part "35"
	System.out.println("Total records for search by username: " + count);
	Reset.click();
}

public void searchbyrole() throws InterruptedException {
	dropdown.click();
	userroleadmin.click();
	Thread.sleep(4000);

	String text = recordsfound.getText(); // e.g., "35 Records Found"
	String count = text.split(" ")[0];    // splits at space, takes first part "35"
	System.out.println("Total records for search by role: " + count);
	Reset.click();

}

public void userstatus() throws InterruptedException {
	selectstatus.click();
	enabled.click();
	Thread.sleep(4000);

	String text = recordsfound.getText(); // e.g., "35 Records Found"
	String count = text.split(" ")[0];    // splits at space, takes first part "35"
	System.out.println("Total records for search by userstatus: " + count);	
	Reset.click();

}
}

