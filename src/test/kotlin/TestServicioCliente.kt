import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actions.*
import net.serenitybdd.screenplay.targets.Target
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver




class TestServicioCliente {


    var webDriver: WebDriver? = null

    @Test
    fun navigateToContactPage(){
        // /Users/dridenalexanderburbano/Downloads/chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/dridenalexanderburbano/Downloads/chromedriver")


        webDriver = ChromeDriver()

        val driden = Actor.named("Driden")
        driden.can(BrowseTheWeb.with(webDriver))

        val emailAddress = Target.the("Email address")
            .located(By.cssSelector("input#email"))

        val orderReference = Target.the("Order Reference")
            .located(By.cssSelector("input#id_order"))

        val message = Target.the("Message")
            .located(By.cssSelector("textarea#message"))

        val submitMessage = Target.the("Submit Message")
            .located(By.cssSelector("button#submitMessage"))

        val subject = Target.the("Subject")
            .located(By.cssSelector("select#id_contact"))

        with(driden) {


            attemptsTo(
                Open.url("http://automationpractice.com/index.php?controller=contact"),
                Enter.theValue("dridenb@gmail.com").into(emailAddress),
                Enter.theValue("Mensaje").into(message),
                Enter.theValue("12345678").into(orderReference),
                SelectFromOptions.byValue("1")
                    .from(subject),
                Click.on(submitMessage)


            )
        }


    }

}