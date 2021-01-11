import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actions.*
import net.serenitybdd.screenplay.targets.Target
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class TestEliminacionCarrito {
    var webDriver: WebDriver? = null

    @Test
    fun navigateToContactPage(){
        // /Users/dridenalexanderburbano/Downloads/chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/dridenalexanderburbano/Downloads/chromedriver")


        webDriver = ChromeDriver()

        val driden = Actor.named("Driden")
        driden.can(BrowseTheWeb.with(webDriver))


        val deleteToCart = Target.the("Delete to cart")
            .located(By.cssSelector("cart_quantity_delete#1_1_0_0"))



        with(driden) {


            attemptsTo(
                Open.url("http://automationpractice.com/index.php?controller=order"),
                Click.on(deleteToCart)


            )
        }


    }
}