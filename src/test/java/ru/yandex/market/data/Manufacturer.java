package ru.yandex.market.data;

public enum Manufacturer {

    DEREVENSKIE_LAKOMSTVA("Деревенские лакомства"),
    DREAMIES("Dreamies"),
    MNIAMS("Мнямс"),
    MOLINA("Molina"),
    SANABELLE("Sanabelle"),
    TITBIT("Titbit");

    private final String value;

    Manufacturer(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
