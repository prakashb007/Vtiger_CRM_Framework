package crm.crm.vtiger.genericLibrary;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


/**
 * This Class contains WebDriver specific methods. 
 * @author rohit
 *
 */
public class WebDriverUtility 
{
	/**
	 * This Method is used to maximise the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This Method wait for loading the page for 20 secs.
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This Method will Wait Till the Element is visible.
	 * @param driver
	 * @param element
	 */
	public void waitTillElementIsVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait =  new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitTillElementIsClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This Method will select the Drop Down/ Combo Box based on Index. 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This Method will select the Drop Down/ Combo Box based on Value 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This Method will do Mouse Hover activity to the selected Element.
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * This Method is used to drag and drop a particular Element.
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}

	/**
	 * This Method is used to perform Right Click on an Element of a Web Page.
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	/**
	 * This Method helps to switch from One window from Another by The Help of Partial Title.
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();
		while(itr.hasNext())
		{
			String winId=itr.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWindowTitle))
			{
				driver.switchTo().window(winId);
				break;
			}
		}
	}

	/**
	 * This Method will Accept the Alert Pop Up
	 * @param driver
	 */
	public void acceptAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 *This Method will Cancel the ALert Pop Up 
	 * @param driver
	 */
	public void dismissAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This Method will Scroll to Particular element of the WebPage.
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y= element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	/**
	 * This Method is used to Switch Frame according to Index.
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index) 
	{
    	driver.switchTo().frame(index);
    }   
    
	/**
	 * This Method is used to Switch Frame according to Element.
	 * @param driver
	 * @param element
	 */
    public void switchFrame(WebDriver driver,WebElement element) 
    {
    	driver.switchTo().frame(element);
    } 
	
    /**
     * This Method is used to Switch Frame according to Id or Name.
     * @param driver
     * @param idOrName
     */
    public void switchFrame(WebDriver driver,String idOrName) 
    {
    	driver.switchTo().frame(idOrName);
    } 

    /**
     * This Method is used to take ScreenShot
     * @param driver
     * @param screenshotName
     * @throws Throwable
     */
    public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./screenshot/"+screenshotName+".PNG");
    	Files.copy(src, dest);
    }


}
