package com.example.mercadonafini.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roleModel")
    private List<UserModel> userModels;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserModel> getUsers() {
        return userModels;
    }

    public void setUsers(List<UserModel> userModels) {
        this.userModels = userModels;
    }
}
