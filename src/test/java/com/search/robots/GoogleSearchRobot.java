package com.search.robots;

import com.search.managers.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class GoogleSearchRobot {

    private BrowserManager browserManager = new BrowserManager(new ChromeDriver());

    public void loadGooglePage() {
        browserManager.openBrowserWitUrl("https://google.com");
    }

    public void closeBrowser() {
        browserManager.closeBrowser();
    }

    public void performSearchWithText(String text) {
        browserManager.getDriver().findElement(By.name("q")).sendKeys(text);
        browserManager.getDriver().findElement(By.name("btnK")).click();
    }

    public void checkGumtreeLinksNumber() {
        List<WebElement> links = browserManager.getDriver().findElements(By.xpath("//cite[contains(text(),'www.gumtree.com')]"));
        System.out.println("Number of the Gumtree links found is: " + links.size() + "\n");
    }

    public void selectAllGumtreeLinksAndVerifyTitlesAndResults() {
        List<WebElement> links = browserManager.getDriver().findElements(By.xpath("//cite[contains(text(),'www.gumtree.com')]"));
        if (links.isEmpty()) {
            System.out.println("Gumtree links not found\n");
        } else {
            for (int i = 0; i < links.size(); i++) {
                links.get(i).click();
                System.out.println("Window title = " + browserManager.getDriver().getTitle());
                String resultText = browserManager.getDriver().findElement(By.xpath("//h1[contains(text(), 'Used Cars for Sale in London')]")).getText();
                System.out.println(resultText);
                browserManager.getDriver().navigate().back();
            }
        }
    }
}
