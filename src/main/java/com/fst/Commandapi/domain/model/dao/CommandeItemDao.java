/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.model.dao;

import com.fst.Commandapi.domain.bean.Commande;
import com.fst.Commandapi.domain.bean.CommandeItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BlackAngel
 */
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long>{
    
    public List<CommandeItem> findByCommandeReference(String refeString);
}
