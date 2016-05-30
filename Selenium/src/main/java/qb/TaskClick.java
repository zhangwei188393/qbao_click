package qb;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TaskClick {

	public static boolean CutAndDail() {
		ConnectNetWork cn = new ConnectNetWork();
		String adsl = "link";
		String username = "02502123058";
		String password = "111111";
		String phone = "#12345678";
		try {
			boolean ct = cn.cutAdsl(adsl);
			if (ct) {
				System.out.println("Cut the link");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		try {
			Thread.sleep(60000*4);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// rasdial "宽带名" 用户名 密码 /phone:#123456789
		try {
			boolean rt = cn.connAdsl(adsl, username, password, phone);
			if (rt) {
				System.out.println("conect!");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
		try {
			Thread.sleep(60000*1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		int i=120;
	    while(i >0)
		{
	    	i--;

			String url = "http://goods.qbao.com/info/product-detail.htm?spuId=2514964&channel=2&bizId=30004833&param=9A1C4915EC4CE5D1465A0119642AF89E2556C9CCA8C1A57F061200E2A807530F";
			ChromeDriverService service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("C:/chromedriver.exe")).usingAnyFreePort().build();
			try {
				service.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//
			// WebDriver driver = new RemoteWebDriver(service.getUrl(),
			// DesiredCapabilities.chrome());
			// driver.get("http://admin:admin@192.168.1.1/device-map/internet.asp");

			// //得到当前窗口的句柄
			// String currentWindow = driver.getWindowHandle();
			// //得到所有窗口的句柄
			// Set<String> handles = driver.getWindowHandles();
			//
			// Iterator<String> it = handles.iterator();
			// while(it.hasNext()){
			// String handle = it.next();
			// if(currentWindow.equals(handle)) {
			// continue;
			// }
			// WebDriver window = driver.switchTo().window(handle);
			// System.out.println("title,url =
			// "+window.getTitle()+","+window.getCurrentUrl());
			// }

			// WebElement btn = driver.findElement(By.id("iconInternet"));
			// btn.click();
			// WebElement btn = driver.findElement(By.id("WANIP4"));
			// System.out.println(btn.getText());
			
			CutAndDail();
			WebDriver driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());		
			driver.get(url);

			try {
				Thread.sleep(5000);
				driver.close();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.get("http://sina.com");

		}
	    
	    System.out.println("Shutdown in 10s");
	    try{ 
	    	Runtime.getRuntime().exec("shutdown -s -t 1");
	    }catch(IOException e){} 

	}

}
