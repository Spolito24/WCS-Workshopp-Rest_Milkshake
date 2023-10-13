package com.wildcodeschool.springmilkshake;

import com.wildcodeschool.springmilkshake.entity.Recipe;
import com.wildcodeschool.springmilkshake.entity.Seller;
import com.wildcodeschool.springmilkshake.repository.RecipeRepository;
import com.wildcodeschool.springmilkshake.repository.SellerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMilkshakeApplication {

	private final RecipeRepository recipeRepository;
	private final SellerRepository sellerRepository;

	public SpringMilkshakeApplication(RecipeRepository recipeRepository, SellerRepository sellerRepository) {
		this.recipeRepository = recipeRepository;
		this.sellerRepository = sellerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMilkshakeApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (String[] args) -> {
			Recipe recipe1 = new Recipe("Strawberry Milkshake", 30, "Strawberry");
			Recipe recipe2 = new Recipe("Chocolate Milkshake", 40, "Chocolate");
			Recipe recipe3 = new Recipe("Blueberry Milkshake", 35, "Strawberry");
			Recipe recipe4 = new Recipe("Vanilla Milkshake", 20, "Vanilla");

			recipeRepository.save(recipe1);
			recipeRepository.save(recipe2);
			recipeRepository.save(recipe3);
			recipeRepository.save(recipe4);

			Seller seller1 = new Seller("Bernard", 50);
			Seller seller2 = new Seller("Michelle", 46);

			sellerRepository.save(seller1);
			sellerRepository.save(seller2);
		};
	}
}
