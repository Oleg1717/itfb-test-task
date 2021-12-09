package ru.yandex.market.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.yandex.market.data.Category;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MarketHeader {

    SelenideElement catalogButton = $("div[data-tid='5a689c45']");
    ElementsCollection categoryList = $$("._1hPrb");
    SelenideElement categoryData = $("div[data-tid='79124582']");
    ElementsCollection categoryDataBlocksList = categoryData.$$(".pEcbz");

    private SelenideElement getCategoryBlock(String blockName) {
        return categoryDataBlocksList.find(Condition.text(blockName));
    }

    @Step("Нажать на каталог")
    public MarketHeader clickCatalogButton() {
        catalogButton.click();
        return this;
    }

    @Step("Выбрать категорию '{category}'")
    public MarketHeader selectCategory(String category) {
        categoryList.find(Condition.text(category)).hover();
        return this;
    }

    @Step("Выбрать тип продукта '{productType}' в блоке '{block}'")
    public MarketHeader selectProductType(String block, String productType) {
        getCategoryBlock(block).find(byText(productType)).click();
        return this;
    }
}
