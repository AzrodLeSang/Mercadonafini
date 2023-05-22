package com.example.mercadonafini.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "produits")
public class ProduitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "libelle", nullable = false)
    private String libelle;
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "prix", nullable = false)
    private float prix;

    @Column(name ="categorie", nullable = false)
    private String categorie;

    @Column(name ="reduction")
    private float reduction;

    @DateTimeFormat(pattern = "dd/mm/yyyy")

    @Column(name = "date_debut")
    private Date date_debut;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Past(message="date invalide")
    @Column(name = "date_fin")
    private Date date_fin;



    public ProduitModel (){

    }
    public ProduitModel(String libelle, String description, float prix, String categorie, float reduction, Date date_debut, Date date_fin ) {
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
        this.reduction = reduction;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public Date  getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date  date_debut) {
        this.date_debut = date_debut;
    }

    public Date  getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date  date_fin) {
        this.date_fin = date_fin;
    }
}
