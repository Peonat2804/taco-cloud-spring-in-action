package sia.tacocloud.api;

import java.util.Date;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import sia.tacocloud.Taco;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoEntityModel extends RepresentationModel<TacoEntityModel> {
    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final CollectionModel<IngredientEntityModel> ingredients;

    private static final IngredientModelAssembler ingredientAssembler = new IngredientModelAssembler();

    public TacoEntityModel(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toCollectionModel(taco.getIngredients());
    }
}
