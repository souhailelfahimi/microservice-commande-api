/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.model.service.impl;

import com.fst.Commandapi.domain.model.dao.CommandeItemDao;
import com.fst.Commandapi.domain.bean.Commande;
import com.fst.Commandapi.domain.bean.CommandeItem;
import com.fst.Commandapi.domain.model.service.CommandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackAngel
 */
@Service
public class CommandeItemServiceImpl implements CommandeItemService {

    @Autowired
    private CommandeItemDao commandeItemDao;

    @Override
    public int save(Commande commande, List<CommandeItem> commandeItems) {

        if (commandeItems != null || !commandeItems.isEmpty()) {
            for (CommandeItem commandeItem : commandeItems) {
                commandeItem.setCommande(commande);
                commandeItemDao.save(commandeItem);
            }
            return 1;
        } else {
            return -1;
        }

    }

    public List<CommandeItem> findByReference(String reference) {
        return commandeItemDao.findByCommandeReference(reference);
    }

    public CommandeItemDao getCommandeItemDao() {
        return commandeItemDao;
    }

    public void setCommandeItemDao(CommandeItemDao commandeItemDao) {
        this.commandeItemDao = commandeItemDao;
    }

}
