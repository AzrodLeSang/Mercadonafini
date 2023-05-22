package com.example.mercadonafini.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer user_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;


    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
    private List<RoleModel> roleModel;





    public UserModel() {

    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public List<RoleModel> getRoles()
    {
        return roleModel;
    }
    public void setRoles(List<RoleModel> roleModel)
    {
        this.roleModel = roleModel;
    }

}
