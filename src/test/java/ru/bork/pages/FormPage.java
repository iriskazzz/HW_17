package ru.bork.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ru.bork.components.Searcher;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormPage {

  private String urlCurrent;
  private final SelenideElement
          basketTitle = $(".purchase-basket__title");

  @Step("Открытие главной страницы")
  public FormPage openPage() {
    open(baseUrl);
    return this;
  }

  @Step("Проверка открытия корзины")
  public FormPage checkOpenCart() {
    urlCurrent = WebDriverRunner.url();
    assertEquals("https://www.bork.ru/eShop/basket/", urlCurrent);
    return this;
  }

  @Step("Проверка отображения {count} товаров на странице")
  public FormPage checkArticle(int count) {
    $$("article").shouldHave(size(count));
    return this;
  }


  @Step("Переход на карточку товара")
  public FormPage openArticle() {
    $("article a").click();
    return this;
  }

  @Step("Добавление товара в корзину")
  public FormPage addArticleInCart() {
    $(byText("Купить")).click();
    basketTitle.shouldBe(Condition.visible);
    return this;
  }

  @Step("Клик по тексту {value}")
  public FormPage clickByText(String value) {
    $(byText(value)).click();
    return this;
  }

  @Step("Проверка видимости элемента {value} на странице")
  public FormPage checkVisibleElement(String value) {
    $(byText(value)).shouldBe(Condition.visible);
    return this;
  }

}
