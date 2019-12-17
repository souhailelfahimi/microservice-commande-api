/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.rest.vo;

/**
 *
 * @author BlackAngel
 */
public class CommandeItemVo {
    private Long id;
    private String referencePProduit;
    private String prix;
    private String qte;
    private CommandeVo commandeVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferencePProduit() {
        return referencePProduit;
    }

    public void setReferencePProduit(String referencePProduit) {
        this.referencePProduit = referencePProduit;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    public CommandeVo getCommandeVo() {
        return commandeVo;
    }

    public void setCommandeVo(CommandeVo commandeVo) {
        this.commandeVo = commandeVo;
    }

    @Override
    public String toString() {
        return "CommandeItemVo{" + "referencePProduit=" + referencePProduit + ", prix=" + prix + ", qte=" + qte + ", commandeVo=" + commandeVo + '}';
    }
    
    
}
