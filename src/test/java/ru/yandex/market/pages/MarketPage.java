package ru.yandex.market.pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.market.pages.components.MarketHeader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MarketPage {

    private MarketHeader marketHeader = new MarketHeader();
    private SelenideElement captchaCheckbox = $(".CheckboxCaptcha-Button");

    public MarketHeader getMarketHeader() {
        return marketHeader;
    }

    public MarketPage clickCaptchaCheckbox() {
        captchaCheckbox.click();
        return this;
    }

    public MarketPage openMarketPage() {
        open("");
        return this;
    }
}
