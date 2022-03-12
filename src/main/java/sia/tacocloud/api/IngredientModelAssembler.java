package sia.tacocloud.api;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import sia.tacocloud.Ingredient;
import sia.tacocloud.web.IngredientController;

public class IngredientModelAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientEntityModel> {
    public IngredientModelAssembler() {
        super(IngredientController.class, IngredientEntityModel.class);
    }

    @Override
    public IngredientEntityModel toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientEntityModel instantiateModel(Ingredient ingredient) {
        return new IngredientEntityModel(ingredient);
    }
}
