/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.model.dao;

import com.fst.Commandapi.domain.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackAngel
 */
@Repository
public interface CommandeDao extends JpaRepository<Commande,Long>{
 
    
    public Commande findByReference(String reference);
    
}
