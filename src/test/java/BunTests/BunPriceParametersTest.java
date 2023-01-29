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
    private final boolean expectedResult;

    public BunPriceParametersTest(float actualValue, float expectedValue, boolean expectedResult) {
        this.actualValue = actualValue;
        this.expectedValue = expectedValue;
        this.expectedResult = expectedResult;
        this.bun = new Bun("black bun", this.actualValue);
    }

    @Parameterized.Parameters(name = "Тестовые данные : Передаваемая цена {0}, Ожидаемая цена : {1},Ожидаемый результат: {2}")
    public static Object[][] getPriceBun() {
        return new Object[][]{
                {100, 100, true}, // Позитивная проверка, данные существуют
                {200, 200, true}, // Позитивная проверка, данные существуют
                {300, 300, true}, // Позитивная проверка, данные существуют
                {0, 300, false}, // Негативная проверка, данных нет
        };
    }

    @Test
    public void checkBunPrice() {
        if (this.expectedResult) {
            Assert.assertEquals(this.actualValue, this.expectedValue, 0);
        } else {
            Assert.assertNotEquals(this.actualValue, this.expectedValue, 0);
        }
    }
}
