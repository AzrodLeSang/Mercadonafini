package com.example.mercadonafini.repository;

import com.example.mercadonafini.model.ProduitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProduitRepository  extends JpaRepository<ProduitModel, Long> {

    @Query(value = "select * from produits  where categorie like %:keyword%", nativeQuery = true)
    List<ProduitModel> findByKeyword(@Param("keyword") String keyword);


    @Query(value = "select * from produits  where categorie like %:kw%", nativeQuery = true)
    List<ProduitModel> findByKW(@Param("kw") String kw);

    public ProduitModel findByCategorie(String categorie);
}



