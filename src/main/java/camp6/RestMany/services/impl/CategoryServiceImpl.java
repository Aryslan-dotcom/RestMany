package camp6.RestMany.services.impl;

import camp6.RestMany.entities.Category;
import camp6.RestMany.repositories.CategoryRepositories;
import camp6.RestMany.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepositories categoryRepositories;

    @Override
    public Category addCategory(Category category) {
        return categoryRepositories.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepositories.findAll();
    }
}
