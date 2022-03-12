package sia.tacocloud.api;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import sia.tacocloud.Ingredient;
import sia.tacocloud.Ingredient.Type;

@Relation(value = "ingredient", collectionRelation = "ingredients")
public class IngredientEntityModel extends RepresentationModel<IngredientEntityModel> {
    @Getter
    public String name;

    @Getter
    public Type type;

    public IngredientEntityModel(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
