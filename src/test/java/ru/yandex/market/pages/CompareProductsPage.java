package ru.yandex.market.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class CompareProductsPage {

    private ElementsCollection nameElementsList = $$(".PzFNv");
    private ElementsCollection priceElementsList = $$("._3NaXx");
    private SelenideElement compareListDeleteButton = $("._1KU3s");

    @Step("Удалить товар производителя '{manufacturer}' из списка сравнения")
    public CompareProductsPage deleteProductFromList(String manufacturer) {
        nameElementsList.findBy(text(manufacturer))
                .hover().parent().$("._24eXc").click();
        sleep(1000);
        return this;
    }

    @Step("Удалить список сравнения")
    public CompareProductsPage clickCompareListDeleteButton() {
        compareListDeleteButton.click();
        sleep(1000);
        return this;
    }

    @Step("Проверить, что список сравнения содержит верные наименования")
    public CompareProductsPage checkThatComparisonListContains(List<String> productNamesList) {
        for (SelenideElement element : nameElementsList) {
            assertThat(productNamesList).anyMatch(n -> n.contains(element.getText()));
        }
        return this;
    }

    @Step("Проверить, что товар производителя '{manufacturer}' не отображается")
    public CompareProductsPage checkThatComparisonListNotContains(String manufacturer) {
        assertThat(nameElementsList.stream().map(SelenideElement::getText))
                .noneMatch(p -> p.contains(manufacturer));
        return this;
    }

    @Step("Проверить, что сумма стоимостей товаров не превышает {maxSum} руб ")
    public CompareProductsPage checkThatProductPricesSumLessOrEqual(int maxSum) {
        assertThat(
                priceElementsList.stream()
                        .mapToInt(element -> Integer.parseInt(element.$("span").getAttribute("data-autotest-value"))).sum()
        ).isLessThanOrEqualTo(maxSum);
        return this;
    }

    @Step("Проверить, что список сравнения пуст")
    public CompareProductsPage checkThatComparisonListIsEmpty() {
        assertThat(nameElementsList).isEmpty();
        return this;
    }

}
