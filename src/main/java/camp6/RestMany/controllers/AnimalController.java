package camp6.RestMany.controllers;
import camp6.RestMany.entities.AnimalDto;
import camp6.RestMany.entities.Category;
import camp6.RestMany.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<AnimalDto> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @PostMapping
    public AnimalDto addAnimal(@RequestBody AnimalDto animalDto){
        return animalService.addAnimal(animalDto);
    }

    @PutMapping
    public AnimalDto updateAnimal(@RequestBody AnimalDto updAnimal){
        return animalService.updateAnimal(updAnimal);
    }

    @DeleteMapping(value = "/{id}")
    void deleteAnimalDto(@PathVariable(name = "id") Long id){
        animalService.deleteAnimalDto(id);
    }

    @PutMapping(value = "/{id}")
    public AnimalDto deleteAnimalCategory(@PathVariable(name = "id")Long id,
                                          @RequestBody Category category){
        return animalService.deleteCategoryAnimalDto(id,category);
    }
}
