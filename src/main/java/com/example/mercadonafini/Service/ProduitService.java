package com.example.mercadonafini.Service;

import com.example.mercadonafini.model.ProduitModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProduitService {



    @Autowired

    List<ProduitModel> getAllProduits();


    ProduitModel saveProduit(ProduitModel produitModel);

    ProduitModel getProduitsById(Long id);
    ProduitModel updateProduits(ProduitModel produitModel);

    void deleteProduitById(Long id);




    }

