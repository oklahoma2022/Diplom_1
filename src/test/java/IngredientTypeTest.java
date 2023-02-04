import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    //Проверка что метод не пустой и в нем содержаться данные
    @Test
    public void values() {
        assertNotNull(IngredientType.FILLING);
        assertNotNull(IngredientType.SAUCE);
    }
}
