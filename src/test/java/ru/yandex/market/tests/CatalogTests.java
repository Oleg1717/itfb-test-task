package ru.yandex.market.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.market.data.Category;
import ru.yandex.market.data.DeliveryMethod;
import ru.yandex.market.data.ProductType;
import ru.yandex.market.data.Manufacturer;
import ru.yandex.market.data.ProductBlock;
import ru.yandex.market.pages.CompareProductsPage;
import ru.yandex.market.pages.MarketPage;
import ru.yandex.market.pages.ProductPage;
import ru.yandex.market.pages.ProductsListPage;

import java.util.ArrayList;
import java.util.List;

public class CatalogTests extends TestBase {

    final static int PRICE_FILTER_MIN = 50;
    final static int PRICE_FILTER_MAX = 150;
    final static int MAX_SUM = 300;
    List<String> productsNameList = new ArrayList<>();

    MarketPage marketPage = new MarketPage();
    ProductsListPage productsListPage = new ProductsListPage();
    ProductPage productPage = new ProductPage();
    CompareProductsPage compareProductsPage = new CompareProductsPage();

    @Test
    @Owner("OlegV")
    @DisplayName("Тестирование списка сравнения товаров")
    @Description("Добавление товаров в список сравнения по фильтрам, " +
            "проверка корректности имен добавленных товаров, " +
            "проверка суммы цен на товары, " +
            "проверка удаления товаров из списка сравнения")
    void checkComparisonList() {
        marketPage
                .openMarketPage()
                .clickCaptchaCheckbox()
                .getMarketHeader()
                    .clickCatalogButton()
                    .selectCategory(Category.PET_SUPPLIES.value())
                    .selectProductType(ProductBlock.FOR_CATS.value(), ProductType.GOODIES.value());
        productsListPage
                .setPriceFilterMin(PRICE_FILTER_MIN)
                .setPriceFilterMax(PRICE_FILTER_MAX)
                .selectDeliveryMethod(DeliveryMethod.BY_COURIER.value())
                .clickManufacturerItem(Manufacturer.DREAMIES.value())
                .clickProductLinkByNum(0);
        Selenide.switchTo().window(1);
        productPage
                .addProductNameToList(productsNameList)
                .clickCompareLink();
        Selenide.switchTo().window(0);
        productsListPage
                .clickManufacturerItem(Manufacturer.DREAMIES.value())
                .clickManufacturerItem(Manufacturer.DEREVENSKIE_LAKOMSTVA.value())
                .clickProductLinkByNum(1);
        Selenide.switchTo().window(2);
        productPage
                .addProductNameToList(productsNameList)
                .clickCompareLink()
                .clickCompareButton();
        compareProductsPage
                .checkThatComparisonListContains(productsNameList)
                .checkThatProductPricesSumLessOrEqual(MAX_SUM)
                .deleteProductFromList(Manufacturer.DREAMIES.value())
                .checkThatComparisonListNotContains(Manufacturer.DREAMIES.value())
                .clickCompareListDeleteButton()
                .checkThatComparisonListIsEmpty();
    }
}
