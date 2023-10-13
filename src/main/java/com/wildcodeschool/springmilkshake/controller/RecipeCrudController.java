package com.wildcodeschool.springmilkshake.controller;

import com.wildcodeschool.springmilkshake.entity.Recipe;
import com.wildcodeschool.springmilkshake.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeCrudController {
    private final RecipeRepository recipeRepository;

    public RecipeCrudController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipe")
    public List<Recipe> index() {
        return recipeRepository.findAll();
    }

    @GetMapping("/recipe/{id}")
    public Recipe show(@PathVariable Long id) {
        return recipeRepository.findById(id).get();
    }

    @PostMapping("/recipe")
    public Recipe create(@RequestBody Recipe recipe){
        return recipeRepository.save(recipe);
    }

    @PutMapping("/recipe/{id}")
    public Recipe update(@PathVariable Long id, @RequestBody Recipe recipe){
        Recipe recipeToUpdate = recipeRepository.findById(id).get();
        recipeToUpdate.setName(recipe.getName());
        recipeToUpdate.setQuantity(recipe.getQuantity());
        recipeToUpdate.setMainIngredient(recipe.getMainIngredient());
        return recipeRepository.save(recipeToUpdate);
    }

    @DeleteMapping("recipe/{id}")
    public boolean delete(@PathVariable Long id){
        recipeRepository.deleteById(id);
        return true;
    }
}
