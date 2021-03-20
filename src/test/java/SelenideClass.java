import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Value;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideClass {
    @Test
    public void firstTest() {
        open("https://simplenote.com/");
        $(By.xpath("//a[@href=\"https://app.simplenote.com/signup/\"]/parent::div")).click();
        $(By.xpath("//input[@type=\"submit\"]")).shouldHave(new Value("Sign up"));
        $(By.xpath("//input[@id='email' and @placeholder='Email']")).setValue("34");
        $(By.xpath("//input[@type=\"submit\"]")).click();
        $(By.cssSelector("#status")).shouldHave(text("Please include an '@' in the email address."));
        $(By.xpath("//input[@id='email' and @placeholder='Email']")).setValue("my@gmail.com");
        $(By.xpath("//input[@type=\"submit\"]")).click();
        $(By.xpath("//a[@href='mailto:support@simplenote.com']")).shouldBe(visible);
        $(By.cssSelector("#successEmail")).shouldHave(text("my@gmail.com"));
    }

    @Test
    public void secondTest() {
        open("https://jsonformatter.curiousconcept.com/");
        $("#jsontemplate").selectOptionByValue("2");
        $$(By.xpath("//option[@value='2']")).get(0).shouldBe(selected);
        $("#jsonspec").selectOptionByValue("3");
        $$(By.xpath("//option[@value='3']")).get(1).shouldBe(selected);
        $(By.xpath("//input[@type='checkbox']")).isSelected();
        $(By.xpath("//button[@name='process']")).shouldBe(visible);
        $(By.xpath("//textarea[@class='textarea is-code will-clear']")).setValue("{m:\"1a\",e:\"12d\"}");
        $(By.xpath("//button[@name='process']")).click();
        $(By.xpath("//div[@class='bottom']")).shouldHave(text("Valid"));
    }

    @Test
    public void thirdTest() {
        open("https://www.sammy-icon.com/ru");
        $(By.xpath("//div[@id='search-button']")).click();
        $(By.xpath("//input[@name='search']")).setValue("knee");
        $(By.xpath("//input[@name='search']")).pressEnter();
        $$(By.xpath("//div[@class='search-item searchflex-block']")).shouldHave(CollectionCondition.sizeGreaterThanOrEqual(5));
        $$(By.xpath("//a[@href='https://www.sammy-icon.com/ru/socks/golfs/ash-knee']")).get(1).click();
        $(By.xpath("//input[@name='quantity']")).setValue("3");
        $$(By.xpath("//div[@class='owl-item active']")).get(0).shouldHave(attribute("style", "width: 390px; margin-right: 5px;"));
        $(By.xpath("//h1[@class='zaglav_page product_main_name']")).shouldBe(exist);
        $(By.xpath("//a[@href='tel:+380442214363' and @class='animation bold phone one']")).shouldHave(Condition.text("+38 (044) 221-43-63"));
    }

    @Test
    public void fourthTest() {
        open("https://www.sammy-icon.com/ru/beige-knee");
        $(By.xpath("//input[@name='quantity']")).setValue("3");
        $(By.xpath("//button[@class='my_buy_butt animation']")).click();
        $(By.xpath("//div[@id='cart']")).click();
        Configuration.timeout = 8000;
        $(By.cssSelector("#checkout-btn")).click();
        $$(By.xpath("//span[@class='quantity']")).get(1).shouldHave(Condition.text("3"));
        $(By.xpath("//input[@name='coupon']")).setValue("sammy10");
        $(By.xpath("//button[@id='button-coupon']")).click();
        $$(By.xpath("//td[@class='strong_td']")).shouldHave(CollectionCondition.sizeGreaterThanOrEqual(6));
        $$(By.xpath("//img[@alt='plus']")).get(1).click();
        $$(By.xpath("//span[@class='quantity']")).get(1).shouldHave(text("4"));
        $$(By.xpath("//img[@src='/catalog/view/theme/default/image/icon/esc-img.png']")).get(2).click();
//        Configuration.timeout = 8000;
//        $(By.className("common-home")).shouldBe(exist);
//        $(By.xpath("//span[@id]")).shouldHave(text("0"));
    }

    @Test
    public void fifthTest() {
        open("https://www.wonderzine.com/wonderzine/health/wellness/254813-platsebo");
        $$(By.xpath("//a[@href='/wonderzine/health/wellness']")).get(0).shouldHave(text("Здоровье"));
        $(By.xpath("//input[@class='digest-form-email']")).setValue("a");
        $(By.className("digest-form-submit")).click();
        $(By.className("error-popup")).shouldBe(visible);
        $(By.xpath("//input[@class='digest-form-email']")).setValue("e@gmail.com");
        $(By.className("digest-form-submit")).click();
        $(By.className("error-popup")).shouldNotBe(visible);
        $(By.xpath("//h6[@class='email']")).shouldHave(text("e@gmail.com"));
        $$(By.xpath("//strong[@class='stk-reset']")).get(1).shouldHave(text("текст:"));
    }
}


