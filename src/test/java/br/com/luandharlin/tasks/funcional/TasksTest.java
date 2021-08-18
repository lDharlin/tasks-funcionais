package br.com.luandharlin.tasks.funcional;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.DriverFactory;

public class TasksTest {
	WebDriver driver;
	
	@Test
	public void deveCadastrarNovaTask() throws MalformedURLException {
		try {
			driver = DriverFactory.getDriver();
			driver.findElement(By.id("addTodo")).click();
			driver.findElement(By.id("task")).sendKeys("Teste Selenium");
			driver.findElement(By.id("dueDate")).sendKeys("20/08/2039");
			driver.findElement(By.id("saveButton")).click();
			String msg = driver.findElement(By.id("message")).getText();
			assertEquals("Success!", msg);
		} finally {
			DriverFactory.killDriver();
		}
	}
	
	@Test
	public void naodeveCadastrarTaskSemDescricao() throws MalformedURLException {
		try {
			driver = DriverFactory.getDriver();
			driver.findElement(By.id("addTodo")).click();
			driver.findElement(By.id("dueDate")).sendKeys("20/08/2039");
			driver.findElement(By.id("saveButton")).click();
			String msg = driver.findElement(By.id("message")).getText();
			assertEquals("Fill the task description", msg);
		}finally {
			DriverFactory.killDriver();
		}
	}

}
