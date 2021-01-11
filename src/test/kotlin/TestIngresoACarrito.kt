import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actions.*
import net.serenitybdd.screenplay.targets.Target
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class TestIngresoACarrito {
    var webDriver: WebDriver? = null

    @Test
    fun navigateToContactPage(){
        // /Users/dridenalexanderburbano/Downloads/chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/dridenalexanderburbano/Downloads/chromedriver")


        webDriver = ChromeDriver()

        val driden = Actor.named("Driden")
        driden.can(BrowseTheWeb.with(webDriver))


        val addToCart = Target.the("Add to cart")
            .located(By.cssSelector("buttons_bottom_block#add_to_cart"))



        with(driden) {


            attemptsTo(
                Open.url("http://automationpractice.com/index.php?id_product=1&controller=product"),
                Click.on(addToCart)


            )


        }


    }
}