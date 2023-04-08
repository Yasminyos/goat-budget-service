package by.yanodincov.goat.budget.handlers.controller;

import by.yanodincov.goat.budget.handlers.model.request.GetCategoryRequest;
import by.yanodincov.goat.budget.service.category.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/category")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping(name = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void GetCategory(@RequestBody @Validated GetCategoryRequest request) {

    }
}
