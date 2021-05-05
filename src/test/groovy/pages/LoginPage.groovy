package pages

import geb.Browser
import io.qameta.allure.Step
import org.openqa.selenium.By
import spock.lang.Stepwise

@Stepwise
class LoginPage extends GeneralPage {
    LoginPage(Browser browser) {
        this.browser = browser
    }

    @Step("Login into GOOMW with credentials { 0,1 }")
    static def logInWith(String username, String password) {
        def userNameInput = "//input[starts-with(@id, 'username-Username-Username-')]"
        waitForElementToLoad(By.xpath(userNameInput))
        browser.driver.findElement(By.xpath(userNameInput)).sendKeys(username)

        def passwordNameInput = "//input[starts-with(@id, 'password-Password-Password-')]"
        browser.driver.findElement(By.xpath(passwordNameInput)).sendKeys(password)

        def element = browser.driver
                .findElement(By.xpath("//span[contains(text(), \"Submit\") ]"))

        element.submit()

        def myAccount = "//span[text() = 'Contul meu']"
        waitForElementToLoad(By.xpath(myAccount))
    }
}
