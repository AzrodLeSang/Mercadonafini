package com.example.mercadonafini;

import com.example.mercadonafini.Service.ProduitService;
import com.example.mercadonafini.model.ProduitModel;
import com.example.mercadonafini.model.UserModel;
import com.example.mercadonafini.repository.ProduitRepository;
import com.example.mercadonafini.repository.UserRepository;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProduitRepositoryTests {


    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    public void testSaveProduit() {
        // Crée un objet Produit fictif pour le test
        ProduitModel produitModel = new ProduitModel();
        produitModel.setLibelle("test1produitlib");
        produitModel.setDescription("test1produitdesc");
        produitModel.setPrix(20);

        produitModel.setCategorie("test1");


       ProduitModel savedproduit = produitRepository.save(produitModel);

       assertNotNull(savedproduit);
    }

    @Test
    public void testFindProduitByCategorie(){
        String categorie = "test1";
        ProduitModel produitModel = produitRepository.findByCategorie(categorie);

        Assertions.assertThat(produitModel.getCategorie()).isEqualTo(categorie);
    }


    @Test
    public void testFindProduitByCategorieNotExist(){
        String categorie = "vroom";
        ProduitModel produitModel = produitRepository.findByCategorie(categorie);

        assertNull(produitModel);
    }


        @Test
        @Rollback(value = false)
        public void testUpdateProduit(){
        String categorie = "motosport";
        ProduitModel produitModel = new ProduitModel();
        produitModel.setCategorie(categorie);


        produitRepository.save(produitModel);

        ProduitModel updatedProduit = produitRepository.findByCategorie(categorie);

        Assertions.assertThat(updatedProduit.getCategorie()).isEqualTo(categorie);
        }


        @Test
        public void testListProducts(){
        List<ProduitModel> produitModelList = produitRepository.findAll();

        for(ProduitModel produitModel : produitModelList){
            System.out.println(produitModel);
        }

        Assertions.assertThat(produitModelList).size().isGreaterThan(0);
        }

        @Test
        public void testDeleteProduct(){
        Integer id = 2;

        boolean isExistBeforeDelete = produitRepository.findById(Long.valueOf(id)).isPresent();


        produitRepository.deleteById(Long.valueOf(id));

        boolean NotExistAfterDelete = produitRepository.findById(Long.valueOf(id)).isPresent();

        assertTrue(isExistBeforeDelete);
        assertFalse(NotExistAfterDelete);
        }

    // users

    @Test
    @Rollback(value = false)
    public void testNewUser() {
        // Crée un objet Produit fictif pour le test
        UserModel userModel = new UserModel();
        userModel.setUsername("jeremie");
        userModel.setPassword("jeremiemdp");


        UserModel savedUser = userRepository.save(userModel);

        assertNotNull(savedUser);
    }

    @Test
    public void testFindUserByUsername(){
        String username = "admin123";
        UserModel userModel = userRepository.findByUsername(username);

        Assertions.assertThat(userModel.getUsername()).isEqualTo(username);
    }


    @Test
    public void testFindUserByUsernameNotExist(){
        String username = "Jean-Luc";
        UserModel userModel = userRepository.findByUsername(username);

        assertNull(userModel);
    }



}
