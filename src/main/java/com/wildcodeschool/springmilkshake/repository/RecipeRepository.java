package com.wildcodeschool.springmilkshake.repository;

import com.wildcodeschool.springmilkshake.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
