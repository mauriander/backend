/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.User;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface IUserService {
    public List<User> verUsers();
    public void crearUser(User p);
    public void borrarUser(Long id);
    public User buscarUser(Long id);
}
