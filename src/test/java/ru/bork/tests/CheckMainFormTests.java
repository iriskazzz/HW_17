package ru.bork.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.bork.components.Map;
import ru.bork.components.Searcher;
import ru.bork.components.SideMenu;
import ru.bork.pages.FormPage;

public class CheckMainFormTests extends TestBase {
  FormPage formPage = new FormPage();
  SideMenu sideMenu = new SideMenu();
  Searcher searcher = new Searcher();

  Map map = new Map();

  @Tag("smoke")
  @CsvSource(value = {
          "Красота и здоровье,  Все для спорта , 8",
          "Дом и климат,  Пылесосы , 5",
          "Кухня, Тостеры, 3"
  })
  @ParameterizedTest(name = "Проверка открытия раздела {0} и подраздела {1} с карточками товаров {2} штук")
  void OpenSectionsFromSideMenu(String section, String subsection, int count) {
    formPage.openPage();
    sideMenu.openSideMenu(section, subsection);
    formPage.checkArticle(count);
  }

  @Test
  @Tag("regress")
  @DisplayName("Проверка отображения карты")
  void CheckMap() {
    formPage.openPage();
    map.openMap()
            .checkMapList();
  }

  @Test
  @DisplayName("Проверка добавления товара в корзину")
  void CheckCart() {
    formPage.openPage();
    sideMenu.openSideMenu("Кухня", "Чайники");
    formPage.openArticle()
            .addArticleInCart()
            .checkOpenCart();
  }

  @Test
  @Tag("regress")
  @DisplayName("Проверка работы поисковика")
  void CheckSearch() {
    formPage.openPage();
    searcher.clickSearch()
            .inputSearch("Электросамокат L602")
            .checkResultSearch("https://www.bork.ru/eShop/Sports-Equipment/L602/");
  }

  @Test
  @Tag("regress")
  @DisplayName("Проверка смены языка")
  void CheckLang() {
    formPage.openPage()
            .clickByText("Личный кабинет")
            .clickByText("Eng")
            .checkVisibleElement("Cleanliness and climate");
  }

}
