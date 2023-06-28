package camp6.RestMany.entities;

import lombok.*;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalDto {
    private Long id;
    private String name;
    private int age;
    private int weight;
    private List<Category>categories;
}
