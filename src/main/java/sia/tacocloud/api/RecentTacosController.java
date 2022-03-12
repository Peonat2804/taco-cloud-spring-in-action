package sia.tacocloud.api;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import sia.tacocloud.Taco;
import sia.tacocloud.data.TacoRepository;

@RepositoryRestController
public class RecentTacosController {
    private TacoRepository tacoRepository;

    public RecentTacosController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

   @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
   public ResponseEntity<CollectionModel<TacoEntityModel>> recentTaco() {
       PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());

       List<Taco> tacos = tacoRepository.findAll(page).getContent();

       CollectionModel<TacoEntityModel> tacoResources = new TacoEntityModelAssembler().toCollectionModel(tacos);

       tacoResources.add(linkTo(methodOn(RecentTacosController.class).recentTaco()).withRel("recents"));
       return new ResponseEntity<>(tacoResources, HttpStatus.OK);
   }
}
