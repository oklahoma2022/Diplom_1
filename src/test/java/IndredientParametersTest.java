import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IndredientParametersTest {
    Ingredient ingredient;
    public IngredientType type;
    public String name;
    public float price;

    public IndredientParametersTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;

        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Тестовые данные : Ожидаемый тип начинки {0}, Ожидаемое имя {1}, Ожидаемая цена {2}")
    public static Object[][] getNameAndPriceBun() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100}, // Позитивная проверка, данные существуют
                {IngredientType.SAUCE, "sour cream", 200}, // Позитивная проверка, данные существуют
                {IngredientType.SAUCE, "chili sauce", 300}, // Позитивная проверка, данные существуют

                {IngredientType.FILLING, "cutlet", 100}, // Позитивная проверка, данные существуют
                {IngredientType.FILLING, "dinosaur", 200}, // Позитивная проверка, данные существуют
                {IngredientType.FILLING, "sausage", 300}, // Позитивная проверка, данные существуют
        };
    }

    @Test
    public void checkIngredientType() {
        Assert.assertEquals(this.type, ingredient.getType());
    }

    @Test
    public void checkIngredientName() {
        Assert.assertEquals(this.name, ingredient.getName());
    }

    @Test
    public void checkIngredientPrice() {
        Assert.assertEquals(this.price, ingredient.getPrice(), 0);
    }
}
