package sia.tacocloud.api;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import sia.tacocloud.Taco;
import sia.tacocloud.web.DesignTacoController;

public class TacoEntityModelAssembler extends RepresentationModelAssemblerSupport<Taco, TacoEntityModel> {
    public TacoEntityModelAssembler() {
        super(DesignTacoController.class, TacoEntityModel.class);
    }

    @Override
    protected TacoEntityModel instantiateModel(Taco taco) {
        return new TacoEntityModel(taco);
    }

    @Override
    public TacoEntityModel toModel(Taco taco) {
        return createModelWithId(taco.getId(), taco);
    }
}
