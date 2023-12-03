package ru.bork.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SideMenu {

  private final SelenideElement
          iconSideMenu = $(".bork-header-modern__button-catalog");

  @Step("Открытие раздела {section} из бокового меню")
  public SideMenu openSideMenu(String section, String subsection) {
    iconSideMenu.click();
    $(byText(section)).click();
    $x("//div[text()='" + subsection + "']/ancestor::a").click();
    return this;
  }
}
