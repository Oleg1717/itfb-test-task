package ru.yandex.market.data;

public enum DeliveryMethod {

    BY_COURIER("Доставка курьером"),
    PICKUP("Самовывоз"),
    NO_MATTER("Любой");

    private final String value;

    DeliveryMethod(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
