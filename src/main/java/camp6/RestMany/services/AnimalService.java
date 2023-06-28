package camp6.RestMany.services;

import camp6.RestMany.entities.Animal;
import camp6.RestMany.entities.AnimalDto;
import camp6.RestMany.entities.Category;

import java.util.List;

public interface AnimalService {
    AnimalDto addAnimal(AnimalDto animalDto);
    List<AnimalDto>getAllAnimals();
    AnimalDto updateAnimal(AnimalDto updAnimalDto);
    void deleteAnimalDto(Long id);
    AnimalDto deleteCategoryAnimalDto(Long id,Category category);
}
