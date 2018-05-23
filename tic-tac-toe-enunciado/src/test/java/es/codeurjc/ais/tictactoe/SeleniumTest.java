/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.codeurjc.ais.tictactoe;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;





/**
 *
 * @author Daniel
 */
public class SeleniumTest{
    private WebDriver driver1;
    private WebDriver driver2;


    @BeforeClass
    public static void setupClass() {
        //WebDriverManager;
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
        
        
    }   

    
    @After
    public void tearDown() throws Exception {

    }
    
    @Test
    public void testJuegoP1() {
        driver1.get("http://localhost:8080/");
        driver2.get("http://localhost:8080/");
        
        String name1 = "Mark";
        String name2 = "Dany";
        
        driver1.findElement(By.id("nickname")).sendKeys(name1);
        driver1.findElement(By.id("startBtn")).click();
        driver2.findElement(By.id("nickname")).sendKeys(name2);
        driver2.findElement(By.id("startBtn")).click();
        
        driver1.findElement(By.id("cell-0")).click();
        driver2.findElement(By.id("cell-4")).click();
        driver1.findElement(By.id("cell-8")).click();
        driver2.findElement(By.id("cell-6")).click();
        driver1.findElement(By.id("cell-2")).click();
        driver2.findElement(By.id("cell-1")).click();
        driver1.findElement(By.id("cell-5")).click();
        
        String alert = driver1.switchTo().alert().getText();
        String win_lose = name1 +" wins! "+ name2 +" looses.";
        //assertEquals(alert,win_lose);
    }


}
