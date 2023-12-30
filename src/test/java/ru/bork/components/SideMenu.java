package ru.bork.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SideMenu {

    private final SelenideElement iconSideMenu = $(".bork-header-modern__button-catalog");

    @Step("Открытие бокового меню")
    public SideMenu openSideMenu() {
        iconSideMenu.click();
        return this;
    }

    @Step("Открытие раздела {section}")
    public SideMenu openSectionSideMenu(String section) {
        $(byText(section)).click();
        return this;
    }

    @Step("Открытие подраздела {subsection}")
    public SideMenu openSubsectionMenu(String subsection) {
        $x("//div[text()='" + subsection + "']/ancestor::a").click();
        return this;
    }
}
