package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement encontrarElemento(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public void clicar(By locator) {
        WebElement elemento = encontrarElemento(driver, locator);
        elemento.click();
    }


    public void escrever(By locator, String texto) {
        WebElement elemento = encontrarElemento(driver, locator);
        elemento.sendKeys(texto);
    }

}

