package camp6.RestMany.repositories;

import camp6.RestMany.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category,Long> {
}
