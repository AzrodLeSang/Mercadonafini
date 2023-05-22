package com.example.mercadonafini.Service;

import com.example.mercadonafini.model.ProduitModel;
import com.example.mercadonafini.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
public class produitService2 {

    @Autowired
    private ProduitRepository produitRepository;


     public List<ProduitModel> findByKeyword(String keyword){
         return produitRepository.findByKeyword(keyword);
     }

     public List<ProduitModel> findByKW(String kw){
         return produitRepository.findByKW(kw);
     }

}
