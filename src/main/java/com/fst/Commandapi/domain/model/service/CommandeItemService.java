/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.model.service;

import com.fst.Commandapi.domain.bean.Commande;
import com.fst.Commandapi.domain.bean.CommandeItem;
import java.util.List;

/**
 *
 * @author BlackAngel
 */
public interface CommandeItemService {
    public int save(Commande commande,List<CommandeItem> commandeItems);
        public List<CommandeItem> findByReference(String reference);

}
