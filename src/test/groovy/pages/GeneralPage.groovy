package pages

import geb.Browser
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.NoSuchElementException
import java.util.concurrent.TimeUnit

class GeneralPage {

    static Browser browser

    @Step("Waiting for element to load {0}")
    static void waitForElementToLoad(By s) {
        FluentWait wait = new FluentWait(browser.getDriver())
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)

        wait.until(ExpectedConditions.visibilityOfElementLocated(s))
    }
}
