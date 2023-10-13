package com.wildcodeschool.springmilkshake.controller;

import com.wildcodeschool.springmilkshake.entity.Seller;
import com.wildcodeschool.springmilkshake.repository.SellerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SellerCrudController {

    private final SellerRepository sellerRepository;

    public SellerCrudController(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    @GetMapping("/seller")
    public String getSeller(Model model,
                            @RequestParam(required = false) Long id) {

        Seller seller = new Seller();
        if (id != null) {
            Optional<Seller> optionalSeller = sellerRepository.findById(id);
            if (optionalSeller.isPresent()) {
                seller = optionalSeller.get();
            }
        }
        model.addAttribute("seller", seller);

        return "seller";
    }

    @GetMapping("/sellers")
    public String getAll(Model model) {

        model.addAttribute("sellers", sellerRepository.findAll());

        return "sellers";
    }

    @PostMapping("/seller")
    public String postSeller(@ModelAttribute Seller seller) {

        sellerRepository.save(seller);
        return "redirect:/sellers";
    }

    @GetMapping("/seller/delete")
    public String deleteSeller(@RequestParam Long id) {

        sellerRepository.deleteById(id);

        return "redirect:/sellers";
    }
}
