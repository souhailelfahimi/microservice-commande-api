package com.fst.Commandapi.domain.model.service;

import com.fst.Commandapi.domain.bean.Commande;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BlackAngel
 */
public interface CommandeService {

    public Commande save(Commande commande);

    public Commande findByReference(String reference);
    public List<Commande> findAll();

}
