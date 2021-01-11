import com.openhtmltopdf.util.XRLog.junit
import io.cucumber.junit.CucumberSerenityRunner
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.actions.Enter
import net.serenitybdd.screenplay.actions.Open
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.Managed
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class LoginTest {

    @Managed
    var webDriver: WebDriver? = null

    @Test
    fun navigateToContactPage(){
        // /Users/dridenalexanderburbano/Downloads/chromedriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/jean_/Downloads/chromedriver_win32/chromedriver.exe")
        webDriver = ChromeDriver()
        val driden = Actor.named("Driden")
        driden.can(BrowseTheWeb.with(webDriver))
        val email = Target.the("Email address")
            .located(By.cssSelector("[name='email']"))
        val passwd = Target.the("Password")
            .locatedBy("[name='passwd']")
        val submitLogin = Target.the("Submit Login")
            .locatedBy("[name='SubmitLogin']")
        driden.attemptsTo(
            Open.url("http://automationpractice.com/index.php?controller=authentication"),
            Enter.theValue("dridenb@gmail.com").into(email),
            Enter.theValue("321driden").into(passwd),
            Click.on(submitLogin)
        )
    }

    @Test
    fun invalidEmail(){
        // /Users/dridenalexanderburbano/Downloads/chromedriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/jean_/Downloads/chromedriver_win32/chromedriver.exe")
        webDriver = ChromeDriver()
        val driden = Actor.named("Driden")
        driden.can(BrowseTheWeb.with(webDriver))
        val email = Target.the("Email address")
            .located(By.cssSelector("input#email"))
        val passwd = Target.the("Password")
            .locatedBy("input#passwd")
        val submitLogin = Target.the("Submit Login")
            .locatedBy("button#SubmitLogin")
        val errorMessage = Target.the("Error Message#")
            .located(By.cssSelector("div.alert-danger"))
        driden.attemptsTo(
            Open.url("http://automationpractice.com/index.php?controller=authentication"),
            Enter.theValue("dridenb@gmail.com").into(email),
            Enter.theValue("321driden").into(passwd),
            Click.on(submitLogin)
        )
        val error = errorMessage.resolveFor(driden).text
        print("No se pudo iniciar sesión, mensaje de error: $error");
    }

}