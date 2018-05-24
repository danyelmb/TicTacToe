
package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;


public class SystemTest{
    private WebDriver driver1;
    private WebDriver driver2;
    private String name1;
    private String name2;
    private String alert1;
    private String alert2;
    private String win_lose;    

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
        //System.setProperty("webdriver.chrome.driver", "/Users/Daniel/Downloads/chromedriver_win32");
        WebApp.start();
    }
    
    @AfterClass
    public static void teardownClass() {
        WebApp.stop();
    }
    
    @Before
    public void setUp() throws Exception {
        driver1 = new ChromeDriver();
        driver2 = new ChromeDriver();
        
        driver1.get("http://localhost:8080/");
        driver2.get("http://localhost:8080/");
        
        name1 = "Mark";
        name2 = "Dany";
        
        driver1.findElement(By.id("nickname")).sendKeys(name1);
        driver1.findElement(By.id("startBtn")).click();
        driver2.findElement(By.id("nickname")).sendKeys(name2);
        driver2.findElement(By.id("startBtn")).click();
        
        
    }   

    
    @After
    public void tearDown() throws Exception{
        if (driver1 != null){
            driver1.quit();
        }
        if (driver2 != null){
            driver2.quit();
        }
        name1 = null;
        name2 = null;
        alert1 = null;
        alert2 = null;
        win_lose = null;
    }
    
    @Test
    public void testJuegoP1() {
        
        driver1.findElement(By.id("cell-0")).click();
        driver2.findElement(By.id("cell-4")).click();
        driver1.findElement(By.id("cell-8")).click();
        driver2.findElement(By.id("cell-6")).click();
        driver1.findElement(By.id("cell-2")).click();
        driver2.findElement(By.id("cell-1")).click();
        driver1.findElement(By.id("cell-5")).click();
        
        alert1 = driver1.switchTo().alert().getText();
        alert2 = driver2.switchTo().alert().getText();
        win_lose = name1 +" wins! "+ name2 +" looses.";
        assertEquals(name1 + " should win",alert1,win_lose);
        assertEquals(name1 + " should win",alert2,win_lose);
        
    }
            
    @Test
    public void testJuegoP2() {
        
        driver1.findElement(By.id("cell-0")).click();
        driver2.findElement(By.id("cell-4")).click();
        driver1.findElement(By.id("cell-8")).click();
        driver2.findElement(By.id("cell-3")).click();
        driver1.findElement(By.id("cell-2")).click();
        driver2.findElement(By.id("cell-5")).click();
        
        alert1 = driver1.switchTo().alert().getText();
        alert2 = driver2.switchTo().alert().getText();
        win_lose = name2 +" wins! "+ name1 +" looses.";
        assertEquals(name2 + " should win",alert1,win_lose);
        assertEquals(name2 + " should win",alert2,win_lose);
    }
    

    @Test
    public void testJuegoEmpate() {
        
        driver1.findElement(By.id("cell-0")).click();
        driver2.findElement(By.id("cell-4")).click();
        driver1.findElement(By.id("cell-8")).click();
        driver2.findElement(By.id("cell-3")).click();
        driver1.findElement(By.id("cell-5")).click();
        driver2.findElement(By.id("cell-2")).click();
        driver1.findElement(By.id("cell-6")).click();
        driver2.findElement(By.id("cell-7")).click();
        driver1.findElement(By.id("cell-1")).click();
       
        alert1 = driver1.switchTo().alert().getText();
        alert2 = driver2.switchTo().alert().getText();
        assertEquals("Match should be draw!",alert1,"Draw!");
        assertEquals("Match should be draw!",alert2,"Draw!");
    }

}
