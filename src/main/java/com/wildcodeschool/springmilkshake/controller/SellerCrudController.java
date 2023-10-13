package com.wildcodeschool.springmilkshake.controller;

import com.wildcodeschool.springmilkshake.entity.Seller;
import com.wildcodeschool.springmilkshake.repository.SellerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SellerCrudController {

    private final SellerRepository sellerRepository;

    public SellerCrudController(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    @GetMapping("/seller")
    public List<Seller> index(){
        return sellerRepository.findAll();
    }

    @GetMapping("/seller/{id}")
    public Seller show(@PathVariable Long id){
        return sellerRepository.findById(id).get();
    }

    @PostMapping("/seller")
    public Seller create(@RequestBody Seller seller){
        return sellerRepository.save(seller);
    }

    @PutMapping("/seller/{id}")
    public Seller update(@PathVariable Long id, @RequestBody Seller seller){
        Seller sellerToUpdate = sellerRepository.findById(id).get();
        sellerToUpdate.setName(seller.getName());
        sellerToUpdate.setAge(seller.getAge());
        return sellerRepository.save(sellerToUpdate);
    }

    @DeleteMapping("seller/{id}")
    public boolean delete(@PathVariable long id){
        sellerRepository.deleteById(id);
        return true;
    }

}
