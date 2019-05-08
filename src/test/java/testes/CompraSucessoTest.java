package testes;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CompraSucessoTest {
    @Test
    public void testEfetuarCompraComSucesso () {
        // Abrindo navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\krnla\\drivers1\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Abrindo a página da loja
        navegador.get("http://automationpractice.com");

        // Clicar no link que possui o texto Blouse
        navegador.findElement(By.linkText("Blouse")).click();

        // Adicionar o produto ao carrinho
        navegador.findElement(By.name("Submit")).click();


        // Validar se o produto foi corretamente adicionado ao carrinho
/*
        WebElement iconok = navegador.findElement(By.tagName("h2"));
        String textoSucessoCarrinho = iconok.getText();
        assertEquals("Product successfully added to your shopping cart", textoSucessoCarrinho);
*/
        // Clicar no botão Checkout
        navegador.findElement(By.linkText("Proceed to checkout")).click();

        // Clicar no segundo botão Checkout
        navegador.findElement(By.linkText("Proceed to checkout")).click();

        // Incluindo novo email para cadastro
        navegador.findElement(By.id("email_create")).click();
        navegador.findElement(By.id("email_create")).sendKeys("testekl123467890@teste.com.br");
        navegador.findElement(By.id("SubmitCreate")).click();

        // Preenchendo formulário de cliente novo
        navegador.findElement(By.id("id_gender2")).click();
        navegador.findElement(By.id("customer_firstname")).sendKeys("KarenNOVE");
        navegador.findElement(By.id("customer_lastname")).sendKeys("TesteNOVE");
        navegador.findElement(By.id("passwd")).sendKeys("123456");
        navegador.findElement(By.id("days")).sendKeys("25");
        navegador.findElement(By.id("months")).sendKeys("july");
        navegador.findElement(By.id("years")).sendKeys("1990");
        navegador.findElement(By.id("address1")).sendKeys("Ipiranga 7200");
        navegador.findElement(By.id("city")).sendKeys("Porto Alegre");
        navegador.findElement(By.id("id_state")).sendKeys("Alabama");
        navegador.findElement(By.id("postcode")).sendKeys("91872");
        navegador.findElement(By.id("phone_mobile")).sendKeys("99887766");

        navegador.findElement(By.id("submitAccount")).click();

        // Validar se endereço está correto e prosseguir
        navegador.findElement(By.name("processAddress")).click();

        // Aceitar os termos e prosseguir
        navegador.findElement(By.id("cgv")).click();
        navegador.findElement(By.name("processCarrier")).click();

        // Validar o valor total da compra
        WebElement price = navegador.findElement(By.id("total_price"));
        String valorCompraPrice = price.getText();
        assertEquals("$30.16", valorCompraPrice);

        // Selecionar pagamento e prosseguir
        navegador.findElement(By.className("bankwire")).click();
        navegador.findElement(By.tagName("button")).click();

        // Confirmar a compra e validar sucesso
        WebElement dark = navegador.findElement(By.className("dark"));
        String sucessoCompra = dark.getText();
        assertEquals("Your order on My Store is complete.", sucessoCompra);

        // Fechar o navegador
        navegador.quit();

    }


}
