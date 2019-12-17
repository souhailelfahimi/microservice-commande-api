/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.model.service.impl;

import com.fst.Commandapi.domain.model.dao.CommandeDao;
import com.fst.Commandapi.domain.bean.Commande;
import com.fst.Commandapi.domain.bean.CommandeItem;
import com.fst.Commandapi.domain.model.service.CommandeItemService;
import com.fst.Commandapi.domain.model.service.CommandeService;
import com.fst.Commandapi.domain.rest.proxy.ProduitProxy;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BlackAngel
 */
@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;
    @Autowired
    private ProduitProxy produitProxy;

    @Override
    public Commande save(Commande commande) {
        for (CommandeItem item : commande.getCommandeItems()) {
            System.out.println(item.getReferencePProduit());
        }
        if (productValidate(commande.getCommandeItems()) == true) {
            calculeTotal(commande);
            commandeDao.save(commande);
            commandeItemService.save(commande, commande.getCommandeItems());
            return commande;

        } else {
            System.out.println("falseeeeeeeeeeeee");

            return null;
        }

    }

    public void calculeTotal(Commande commande) {
        if (commande.getCommandeItems() != null && !commande.getCommandeItems().isEmpty()) {
            BigDecimal total = BigDecimal.ZERO;
            for (CommandeItem ci : commande.getCommandeItems()) {
                total = total.add(ci.getPrix().multiply(ci.getQte()));
            }
            commande.setTotal(total);
        }

    }

    public boolean productValidate(List<CommandeItem> items) {
        if (items == null || items.isEmpty()) {
            for (CommandeItem item : items) {
                System.out.println(item.getReferencePProduit());
            }
            return false;
        } else {
            int cmp = 0;
            for (CommandeItem item : items) {
                if (produitProxy.findByReference(item.getReferencePProduit()) != null) {
                    cmp++;
                }
            }
            return (cmp == items.size());
        }
    }

    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }

    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }

    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

    @Override
    public List<Commande> findAll() {
           return this.commandeDao.findAll();
    }

}
