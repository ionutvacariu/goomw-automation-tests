package smoke

import geb.spock.GebSpec
import org.openqa.selenium.By
import pages.LoginPage
import utils.ConfigReader

class LoginSmoke extends GebSpec {

    public static ConfigObject config
    static LoginPage loginPage

    def setupSpec() {
        ConfigObject cfg = ConfigReader.getConfiguration()
        config = cfg
    }

    def "should login"() {
        when:
        browser.driver.get(config.login)
        browser.baseUrl = config.signIn
        waitFor { js.('document.readyState') == 'complete' }
        LoginSmoke.loginPage = new LoginPage(browser)
        LoginSmoke.loginPage.logInWith(username, password)
        waitFor { js.('document.readyState') == 'complete' }

        then:
        browser.driver
                .findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-direction-xs-column MuiGrid-justify-xs-center']"))
        browser.driver
                .findElement(By.xpath("//span[text() = 'Contul meu']"))
                .isDisplayed()

        where:
        username | password
        'user'   | 'pass'
    }
}
