package tacos;


import org.springframework.data.repository.CrudRepository;

import tacos.Model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{

}
