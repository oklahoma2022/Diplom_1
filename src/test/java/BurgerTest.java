import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertNotNull(burger.ingredients);
    }

    // Удаление ингридиента
    @Test
    public void removeIngredientTest() {
        int expectedSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size() - 1);
        assertEquals(expectedSize, burger.ingredients.size());
    }

    //Меняю ингридиенты
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(SAUCE, "sour cream", 100));
        burger.addIngredient(new Ingredient(FILLING, "dinosaur", 200));
        burger.moveIngredient(0, 1);
        assertEquals("sour cream", burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(new Bun("black bun", 100));
        burger.addIngredient(new Ingredient(FILLING, "dinosaur", 200));
        assertEquals(400, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(new Bun("black bun", 100));
        burger.addIngredient(new Ingredient(FILLING, "dinosaur", 200));
        String FinalExpected = "(==== black bun ====)\r\n= filling dinosaur =\r\n(==== black bun ====)\r\n\r\nPrice: 400,000000\r\n";
        assertEquals(FinalExpected, burger.getReceipt());
    }
}
