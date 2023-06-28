package camp6.RestMany.controllers;

import camp6.RestMany.entities.Category;
import camp6.RestMany.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category>getAllCategories(){
        return categoryService.getAllCategory();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
}
