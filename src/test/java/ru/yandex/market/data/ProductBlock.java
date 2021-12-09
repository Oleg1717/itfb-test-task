package ru.yandex.market.data;

public enum ProductBlock {

    FOR_CATS("Для кошек"),
    FOR_BIRDS("Для птиц")
    ;

    private final String itemName;

    ProductBlock(String itemName) {
        this.itemName = itemName;
    }

    public String value() {
        return itemName;
    }

}
