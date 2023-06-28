package camp6.RestMany.mapper;

import camp6.RestMany.entities.Animal;
import camp6.RestMany.entities.AnimalDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    AnimalDto mapToDto(Animal animal);
    Animal mapEntity(AnimalDto animalDto);
    List<AnimalDto> mapToDtoList(List<Animal>animals);
}
