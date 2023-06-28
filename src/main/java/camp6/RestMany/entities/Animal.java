package camp6.RestMany.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "animals")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int weight;
    private String promocode;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

}
