package ru.bork.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.bork.pages.MainFormPage;

public class CheckMainFormTests extends TestBase {
  MainFormPage mainFormPage = new MainFormPage();

  @Tag("regress")
  @Tag("smoke")
  @CsvSource(value = {
          "Идеи подарков,  Для него , 18",
          "Дом и климат,  Пылесосы , 5",
          "Кухня, Тостеры, 3"
  })
  @ParameterizedTest(name = "Проверка открытия раздела {0} и подраздела {1} с карточками товаров {2} штук")
  void OpenSectionsFromSideMenu(String section, String subsection, int count) {
    mainFormPage.openPage()
            .openSideMenu(section, subsection)
            .checkArticle(count);
  }

  @Test
  @Tag("regress")
  @DisplayName("Проверка отображения карты")
  void CheckMap() {
    mainFormPage.openPage()
            .openMap()
            .checkMapList();
  }

  @Test
  @Tag("regress")
  @DisplayName("Проверка добавления товара в корзину")
  void CheckCart() {
    mainFormPage.openPage()
            .openSideMenu("Кухня", "Чайники")
            .openArticle()
            .addArticleInCart()
            .checkOpenCart();
  }


  @Test
  @Tag("regress")
  @DisplayName("Проверка работы поисковика")
  void CheckSearch() {
    mainFormPage.openPage()
            .clickSearch()
            .inputSearch("Электросамокат L602")
            .checkResultSearch("https://www.bork.ru/eShop/Sports-Equipment/L602/");
  }

  @Test
  @Tag("regress")
  @DisplayName("Проверка смены языка")
  void CheckLang() {
    mainFormPage.openPage()
            .clickByText("Личный кабинет")
            .clickByText("Eng")
            .checkVisibleElement("Cleanliness and climate");
  }

}
