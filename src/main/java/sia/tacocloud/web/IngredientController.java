package sia.tacocloud.web;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import sia.tacocloud.Ingredient;
import sia.tacocloud.data.IngredientRepository;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientRepository ingredientRepo;

    public IngredientController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Ingredient getIngredient(@PathVariable String id) {
        Optional<Ingredient> optIngredient = this.ingredientRepo.findById(id);
        if (!optIngredient.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        return optIngredient.get();
    }
}
