package ru.bork.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainFormPage {

  private String urlCart;
  private final SelenideElement
          iconSideMenu = $(".bork-header-modern__button-catalog");

  @Step("Открытие главной страницы")
  public MainFormPage openPage() {
    open(baseUrl);

    return this;
  }

  @Step("Открытие раздела {section} из бокового меню")
  public MainFormPage openSideMenu(String section, String subsection) {
    iconSideMenu.click();
    $(byText(section)).click();
    $x("//div[text()='" + subsection + "']/ancestor::a").click();
    return this;
  }

  @Step("Проверка отображения {count} товаров на странице")
  public MainFormPage checkArticle(int count) {
    $$("article").shouldHave(size(count));
    return this;
  }

  @Step("Переход на страницу с картой бутиков")
  public MainFormPage openMap() {
    $("#wrapper .bork-header-modern__boutiques").click();
    return this;
  }

  @Step("Проверка отображения карты и списка бутиков")
  public MainFormPage checkMapList() {
    $("#boutique-map").shouldHave(Condition.visible);
    $(".boutique-map__list").shouldHave(Condition.visible);
    return this;
  }

  @Step("Переход на карточку товара")
  public MainFormPage openArticle() {
    $("article a").click();
    return this;
  }

  @Step("Добавление товара в корзину")
  public MainFormPage addArticleInCart() {
    $(byText("Купить")).click();
    return this;
  }

  @Step("Проверка открытия корзины")
  public MainFormPage checkOpenCart() {
    urlCart = WebDriverRunner.url();
    urlCart = "https://www.bork.ru/eShop/basket/";
    return this;
  }

  @Step("Открытие поисковика")
  public MainFormPage clickSearch() {
    $(".bork-header-modern__button-search").click();
    return this;
  }

  @Step("Вводи в поиск значения {value}")
  public MainFormPage inputSearch(String value) {
    $("[data-test=search-input-element]").setValue(value).pressEnter();
    return this;
  }

  @Step("Проверка открытия нужной страницы товара")
  public MainFormPage checkResultSearch(String value) {
    urlCart = WebDriverRunner.url();
    urlCart = value;
    return this;
  }

  @Step("Клик по тексту {value}")
  public MainFormPage clickByText(String value) {
    $(byText(value)).click();
    return this;
  }

  @Step("Проверка видимости элемента {value} на странице")
  public MainFormPage checkVisibleElement(String value) {
    $(byText(value)).shouldBe(Condition.visible);
    return this;
  }

}
