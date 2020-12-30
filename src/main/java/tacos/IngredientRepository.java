package tacos;


import tacos.Model.Ingredient;

public interface IngredientRepository {

	Ingredient findOne(int id);
	
    Iterable<Ingredient> findAll();
	
    Ingredient save(Ingredient ingredient);
}
