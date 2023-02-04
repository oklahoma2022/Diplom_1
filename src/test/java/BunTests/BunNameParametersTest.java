package BunTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunNameParametersTest {
    Bun bun;
    public String actualValue;
    public String expectedValue;

    public BunNameParametersTest(String actualValue, String expectedValue) {
        this.actualValue = actualValue;
        this.expectedValue = expectedValue;
        this.bun = new Bun(this.actualValue, 100);
    }

    @Parameterized.Parameters(name = "Тестовые данные : Передаваемое имя {0}, Ожидаемое имя : {1}")
    public static Object[][] getNameBun() {
        return new Object[][]{
                {"black bun", "black bun"}, // Позитивная проверка, данные существуют
                {"white bun", "white bun"}, // Позитивная проверка, данные существуют
                {"red bun", "red bun"}, // Позитивная проверка, данные существуют
                {" ", " "}, // Позитивная проверка пустые значения ( по тз не сказано о запрете)
                {null, null}, // Позитивная проверка  значения по дефолту типа null ( по тз не сказано о запрете)
                {"b", "b"}, // Позитивная проверка минимальная проверка ( по тз не сказано о запрете)
                {
                        "black bun black bun black bun black bun white bun white bun white bun",
                        "black bun black bun black bun black bun white bun white bun white bun",
                }, // Позитивная проверка длинные строки ( по тз не сказано о запрете)
                {"!@$({))_=+*/", "!@$({))_=+*/"}, // Позитивная проверка спецсимволы ( по тз не сказано о запрете)
                {"987456123", "987456123"}, // Позитивная проверка цифровые значения ( по тз не сказано о запрете)
                {"Белая булка", "Белая булка"}, // Позитивная проверка кириллица, иной алфавит  ( по тз не сказано о запрете)
        };
    }

    @Test
    public void checkBunName() {
        Assert.assertEquals(this.actualValue, this.expectedValue);
    }
}
