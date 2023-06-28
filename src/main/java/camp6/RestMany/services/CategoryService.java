package camp6.RestMany.services;

import camp6.RestMany.entities.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category);
    public List<Category> getAllCategory();

}
