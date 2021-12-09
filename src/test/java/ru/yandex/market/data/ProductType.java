package ru.yandex.market.data;

public enum ProductType {

    DRY_FEED("Сухие корма"),
    WET_FEED("Влажные корма"),
    GOODIES ("Лакомства");

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
