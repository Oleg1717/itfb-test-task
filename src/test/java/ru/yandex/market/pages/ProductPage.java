package ru.yandex.market.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private SelenideElement productName = $("h1[data-tid='c0924aa2']");
    private SelenideElement compareLink = $("div[data-tid='aadfe947 99fc66c c3b53bc8']");
    private SelenideElement comparePanel = $("._2fKkE");
    private SelenideElement compareButton = comparePanel.$("._1cFTt");

    public ProductPage addProductNameToList(List<String> productNamesList) {
        productNamesList.add(productName.getText());
        return this;
    }

    @Step("Добавить продукт в сравнение")
    public ProductPage clickCompareLink() {
        compareLink.click();
        return this;
    }

    @Step("Перейти в список сравнения")
    public ProductPage clickCompareButton() {
        compareButton.click();
        return this;
    }
}
