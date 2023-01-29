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
    private final boolean expectedResult;

    public BunNameParametersTest(String actualValue, String expectedValue, boolean expectedResult) {
        this.actualValue = actualValue;
        this.expectedValue = expectedValue;
        this.expectedResult = expectedResult;
        this.bun = new Bun(this.actualValue, 100);
    }

    @Parameterized.Parameters(name = "Тестовые данные : Передаваемое имя {0}, Ожидаемое имя : {1} ,Ожидаемый результат: {2}")
    public static Object[][] getNameBun() {
        return new Object[][]{
                {"black bun", "black bun", true}, // Позитивная проверка, данные существуют
                {"white bun", "white bun", true}, // Позитивная проверка, данные существуют
                {"red bun", "red bun", true}, // Позитивная проверка, данные существуют
                {"blue bun ", "red bun", false}, // Негативная проверка , такой булки нет
        };
    }

    @Test
    public void checkBunName() {
        if (this.expectedResult) {
            Assert.assertEquals(this.actualValue, this.expectedValue);
        } else {
            Assert.assertNotEquals(this.actualValue, this.expectedValue);
        }
    }
}
