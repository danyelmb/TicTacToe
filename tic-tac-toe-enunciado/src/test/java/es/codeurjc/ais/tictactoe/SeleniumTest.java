/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.codeurjc.ais.tictactoe;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Daniel
 */
public class SeleniumTest extends TestCase{
    private WebDriver driver1;
    private WebDriver driver2;
    
    
    
    
    @Before
    @Override
    public void setUp() throws Exception {
        driver1 = new ChromeDriver();
        driver2 = new ChromeDriver();
        
        
    }
    
    @After
    @Override
    public void tearDown() throws Exception {

    }
    
    @Test
    public void JuegoP1() {
        driver1.get("http://localhost:8080/");
        driver2.get("http://localhost:8080/");
        
        String name1 = "Mark";
        String name2 = "Dany";
        
        driver1.findElement(By.id("nickname")).sendKeys(name1);
        driver1.findElement(By.id("startBtn")).click();
        driver2.findElement(By.id("nickname")).sendKeys(name2);
        driver2.findElement(By.id("startBtn")).click();
        
        String juega = driver1.findElement(By.className("Active")).getText();
        System.out.println(juega);
        assertEquals(juega,"Active");
        
    }
}
