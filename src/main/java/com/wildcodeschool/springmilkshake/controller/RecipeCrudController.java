package com.wildcodeschool.springmilkshake.controller;

import com.wildcodeschool.springmilkshake.entity.Recipe;
import com.wildcodeschool.springmilkshake.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class RecipeCrudController {
    private final RecipeRepository recipeRepository;

    public RecipeCrudController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipe")
    public String getRecipe(Model model,
                            @RequestParam(required = false) Long id) {
        Recipe recipe = new Recipe();
        if (id != null) {
            Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
            if (optionalRecipe.isPresent()) {
                recipe = optionalRecipe.get();
            }
        }
        model.addAttribute("recipe", recipe);

        return "recipe";
    }

    @GetMapping("/recipes")
    public String getAll(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());

        return "recipes";
    }

    @PostMapping("/recipe")
    public String postRecipe(@ModelAttribute Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/recipes";
    }

    @PostMapping("/recipe/delete")
    public String deleteRecipe(@ModelAttribute Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/recipes";
    }
}
