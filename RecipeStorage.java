import java.io.*;
import java.util.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class RecipeStorage {
    private static final String FILE_PATH = "recipes.json";
    private List<Recipe> recipes = new ArrayList<>();

    public void loadRecipes() {
            try (Reader reader = new FileReader(FILE_PATH)) {
                recipes = new Gson().fromJson(reader, new TypeToken<List<Recipe>>(){}.getType());
            } catch (IOException e) {
                recipes = new ArrayList<>();
            }
        }

    public void saveRecipes() {
            try (Writer writer = new FileWriter(FILE_PATH)) {
                new Gson().toJson(recipes, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        saveRecipes();
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
        saveRecipes();
    }

}