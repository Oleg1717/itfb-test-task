package ru.yandex.market.data;

public enum Category {

    PHARMACY("Аптека"),
    PET_SUPPLIES("Зоотовары")
    ;

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
