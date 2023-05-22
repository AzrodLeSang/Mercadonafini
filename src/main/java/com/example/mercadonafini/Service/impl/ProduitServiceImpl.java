package com.example.mercadonafini.Service.impl;

import com.example.mercadonafini.Service.ProduitService;
import com.example.mercadonafini.model.ProduitModel;
import com.example.mercadonafini.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService {

    private ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public List<ProduitModel> getAllProduits(){
        return produitRepository.findAll();
    }

    @Override
    public ProduitModel saveProduit(ProduitModel produitModel){
        return produitRepository.save(produitModel);
    }


    @Override
    public ProduitModel getProduitsById(Long id){
        return produitRepository.findById(id).get();
    }

    @Override
    public ProduitModel updateProduits(ProduitModel produitModel){
        return produitRepository.save(produitModel) ;
    }

    @Override
    public void deleteProduitById(Long id){
        produitRepository.deleteById(id);
    }
}
