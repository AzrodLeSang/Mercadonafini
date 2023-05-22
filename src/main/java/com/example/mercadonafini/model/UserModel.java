package com.example.mercadonafini.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(user_id, userModel.user_id) && Objects.equals(username, userModel.username) && Objects.equals(password, userModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                '}';
    }
}
