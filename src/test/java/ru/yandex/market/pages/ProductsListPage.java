package ru.yandex.market.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.yandex.market.data.DeliveryMethod;
import ru.yandex.market.data.Manufacturer;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class ProductsListPage {

    private SelenideElement priceFilter = $("div[data-filter-id='glprice']");
    private SelenideElement priceFilterMin = priceFilter.$("input#glpricefrom");
    private SelenideElement priceFilterMax = priceFilter.$("input#glpriceto");
    private SelenideElement deliveryMethodFilter = $("div[data-filter-id='offer-shipping']");
    private SelenideElement manufacturerFilter = $("div[data-filter-id='7893318']");
    private SelenideElement manufacturerMoreLink = manufacturerFilter.$("._2Pukk");
    private ElementsCollection productDataList = $$("article[data-autotest-id='product-snippet']");


    private SelenideElement getProductDataByNum(int productOrderNumber) {
        return productDataList.get(productOrderNumber);
    }

    @Step("Установить фильтр по цене от: {value}")
    public ProductsListPage setPriceFilterMin(int value) {
        priceFilterMin.setValue(String.valueOf(value));
        sleep(1000);
        return this;
    }

    @Step("Установить фильтр по цене до: {value}")
    public ProductsListPage setPriceFilterMax(int value) {
        priceFilterMax.setValue(String.valueOf(value));
        sleep(1000);
        return this;
    }

    @Step("В фильтре 'Производитель' нажать на '{manufacturer}'")
    public ProductsListPage clickManufacturerItem(String manufacturer) {
        manufacturerFilter.scrollTo().find(byText(manufacturer)).click();
        sleep(1000);
        return this;
    }

    @Step("Выбрать метод доставки '{deliveryMethod}'")
    public ProductsListPage selectDeliveryMethod(String deliveryMethod) {
        deliveryMethodFilter.scrollTo().find(byText(deliveryMethod)).click();
        sleep(1000);
        return this;
    }

    @Step("Перейти на страницу продукта")
    public ProductsListPage clickProductLinkByNum(int productOrderNumber) {
        getProductDataByNum(productOrderNumber).scrollTo().$("._24Q6d").click();
        return this;
    }

}
