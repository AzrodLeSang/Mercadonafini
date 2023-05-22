package com.example.mercadonafini.Controller;

import com.example.mercadonafini.Service.ProduitService;
import com.example.mercadonafini.model.ProduitModel;
import com.example.mercadonafini.Service.produitService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private produitService2 proservice2;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }



    @GetMapping("/catalogue/admins")
    public String Productsadmin(Model model, String keyword){
            if(keyword != null){
                model.addAttribute("produits", proservice2.findByKeyword(keyword));
            }
            else {
                model.addAttribute("produits", produitService.getAllProduits());
            }
        return "produits_admin";
    }


    @GetMapping("/catalogue")
    public String KeywordProduit(Model model, String kw){
        if(kw != null){
            model.addAttribute("produits", proservice2.findByKW(kw));
        }
        else {
            model.addAttribute("produits", produitService.getAllProduits());
        }
        return "produits";
    }









    @GetMapping("/produits/nouveau")
    public String createProduitForm(Model model){
        ProduitModel produitModel = new ProduitModel();
        model.addAttribute("produit", produitModel);
        return "create_produit";
    }

    @PostMapping("/produits")
    public String saveProduit(@ModelAttribute ("produit") ProduitModel produitModel){
        produitService.saveProduit(produitModel);
        return "redirect:/catalogue/admins";
    }

    @GetMapping("/produits/modifier/{id}")
    public String editProduitForm(@PathVariable Long id, Model model){
        model.addAttribute("produit", produitService.getProduitsById(id));
        return "modif_produit";
    }

    @PostMapping("/produits/{id}")
    public String updateProduits(@PathVariable Long id, @ModelAttribute("produit") ProduitModel produitModel, Model model){
        ProduitModel existingProduit = produitService.getProduitsById(id);

        existingProduit.setLibelle(produitModel.getLibelle());
        existingProduit.setDescription(produitModel.getDescription());
        existingProduit.setPrix(produitModel.getPrix());
        existingProduit.setDate_debut(produitModel.getDate_debut());
        existingProduit.setDate_fin(produitModel.getDate_fin());
        existingProduit.setReduction(produitModel.getReduction());
        existingProduit.setCategorie(produitModel.getCategorie());


        produitService.updateProduits(existingProduit);
        return "redirect:/catalogue/admins";
    }

    @GetMapping("/produits/{id}")
    public String deleteProduit(@PathVariable Long id){
    produitService.deleteProduitById(id);
    return "redirect:/catalogue/admins";
    }

}
