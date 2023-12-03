package ru.bork.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Searcher {

  private String urlCart;

  private final SelenideElement
          buttonSearch = $(".bork-header-modern__button-search"),
          searchElement = $("[data-test=search-input-element]"),
          productTitle = $("[data-test=ui-product-tile-title-link]");

  @Step("Открытие поисковика")
  public Searcher clickSearch() {
    buttonSearch.click();
    return this;
  }

  @Step("Ввод в поиск значения {value}")
  public Searcher inputSearch(String value) {
    searchElement.setValue(value);
    productTitle.click();
    return this;
  }

  @Step("Проверка открытия нужной страницы товара")
  public Searcher checkResultSearch(String value) {
    urlCart = WebDriverRunner.url();
    assertEquals(value, urlCart);
    return this;
  }

}
