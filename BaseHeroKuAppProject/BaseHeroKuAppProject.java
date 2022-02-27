package BaseHeroKuAppProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHeroKuAppProject {
    protected static WebDriver driver;
    protected static WebDriverWait wdWait;
    protected static JavascriptExecutor js;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
