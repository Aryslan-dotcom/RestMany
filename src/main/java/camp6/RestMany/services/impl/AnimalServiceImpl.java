package camp6.RestMany.services.impl;

import camp6.RestMany.entities.Animal;
import camp6.RestMany.entities.AnimalDto;
import camp6.RestMany.entities.Category;
import camp6.RestMany.mapper.AnimalMapper;
import camp6.RestMany.repositories.AnimalRepositories;
import camp6.RestMany.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepositories animalRepositories;
    @Autowired
    private AnimalMapper animalMapper;
    @Override
    public AnimalDto addAnimal(AnimalDto animalDto) {

        Animal animal = Animal.builder()
                .name(animalDto.getName())
                .age(animalDto.getAge())
                .weight(animalDto.getWeight())
                .categories(animalDto.getCategories())
                .promocode(UUID.randomUUID().toString())
                .build();
        return animalMapper.mapToDto(animalRepositories.save(animal));
    }

    @Override
    public List<AnimalDto> getAllAnimals() {
        return animalMapper.mapToDtoList(animalRepositories.findAll());
    }

    @Override
    public AnimalDto updateAnimal(AnimalDto updAnimal) {
        Animal animal = animalRepositories.findAllById(updAnimal.getId());
        animal.setAge(updAnimal.getAge());
        animal.setName(updAnimal.getName());
        animal.setWeight(updAnimal.getWeight());
        for (int i = 0; i<updAnimal.getCategories().size();i++){
            boolean flag = false;
            for (int j = 0; j<animal.getCategories().size();j++){
                if (animal.getCategories().get(j).getId() == updAnimal.getCategories().get(i).getId()){
                    flag = true;
                }
            }
            if (flag==false){
                animal.getCategories().add(updAnimal.getCategories().get(i));
            }
        }
        return animalMapper.mapToDto(animalRepositories.save(animal));
    }

    @Override
    public void deleteAnimalDto(Long id) {
        animalRepositories.deleteById(id);
    }

    @Override
    public AnimalDto deleteCategoryAnimalDto(Long id,Category category) {
        Animal animal = animalRepositories.findAllById(id);
        for (int i = 0; i<animal.getCategories().size();i++){
            if (animal.getCategories().get(i).getId() == category.getId()){
                animal.getCategories().remove(i);
            }
        }
        return animalMapper.mapToDto(animalRepositories.save(animal));
    }


}
