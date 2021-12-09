package ru.yandex.market.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://market.yandex.ru";
    }
}
