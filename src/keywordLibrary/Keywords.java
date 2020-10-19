package keywordLibrary;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Keywords {
	static WebDriver browser;
	
	
	public static void invokeKeyword(String methodName,String arg1,String arg2,String arg3) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method=Keywords.class.getDeclaredMethod(methodName, String.class,String.class, String.class);
           method.invoke(Keywords.class, arg1, arg2, arg3);
	}
	
	
	public static void launchBrowser(String arg1,String arg2,String arg3) throws Exception {
		WebDriver browser;
		if (arg1.equals("chrome")){
			 System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\deepesh\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe" );
			 browser=new ChromeDriver(); 
		 }
		 
		 else if (arg1.equals("firefox")) {
			 System.setProperty("webdriver.gecko.driver" ,"C:\\Users\\deepesh\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe" );
			 browser=new FirefoxDriver();  
		 }
		 else {
			 
			 throw new Exception ("Invalid Browser Name");
		 }
		browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  browser.manage().window().maximize();
		  browser.get(arg2);
	}
	
	    public static void enterText(String locator, String arg2,String arg3) {
	    if(locator.equals("id")) {
			browser.findElement(By.id(arg2)).sendKeys(arg3);
		} else if (locator.equals("xpath")) {
			browser.findElement(By.xpath(arg2)).sendKeys(arg3);
		}else if(locator.equals("name")) {
			browser.findElement(By.name(arg2)).sendKeys(arg3);
		}
	    
}

}
