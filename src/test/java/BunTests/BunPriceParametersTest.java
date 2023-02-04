package BunTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunPriceParametersTest {

    Bun bun;
    public float actualValue;
    public float expectedValue;

    public BunPriceParametersTest(float actualValue, float expectedValue) {
        this.actualValue = actualValue;
        this.expectedValue = expectedValue;
        this.bun = new Bun("black bun", this.actualValue);
    }

    @Parameterized.Parameters(name = "Тестовые данные : Передаваемая цена {0}, Ожидаемая цена : {1}")
    public static Object[][] getPriceBun() {
        return new Object[][]{
                {100, 100}, // Позитивная проверка, данные существуют
                {200, 200}, // Позитивная проверка, данные существуют
                {300, 300}, // Позитивная проверка, данные существуют
                {0, 0}, // Позитивная проверка ( нет ограничений по тз)
                {-100, -100}, // Позитивная проверка ( нет ограничений по тз)
                {0.65345345345345345345f, 0.65345345345345345345f}, // Позитивная проверка минимальная дробная цена( нет ограничений по тз)
                {999999999999999999999.0f, 999999999999999999999.0f},// Позитивная проверка, очень большая цена( нет ограничений по тз)
        };
    }

    @Test
    public void checkBunPrice() {
        Assert.assertEquals(this.actualValue, this.expectedValue, 0);
    }
}
