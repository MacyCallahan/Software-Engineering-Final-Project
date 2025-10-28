import java.io.*;
import java.util.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class IngredientStorage {
    private static final String FILE_PATH = "ingredients.json";
    private List<Ingredient> ingredients = new ArrayList<>();

    public void loadIngredients() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            ingredients = new Gson().fromJson(reader, new TypeToken<List<Ingredient>>(){}.getType());
        } catch (IOException e) {
            ingredients = new ArrayList<>();
        }
    }

    public void saveIngredients() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(ingredients, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        if (!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
            saveIngredients();
        }
    }
}
