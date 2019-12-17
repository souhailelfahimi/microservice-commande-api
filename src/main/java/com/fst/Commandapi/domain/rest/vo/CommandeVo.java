/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.rest.vo;

import com.fst.Commandapi.domain.bean.CommandeItem;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author BlackAngel
 */
public class CommandeVo {
    private Long id;
    private String reference;
    private String total;
    private List<CommandeItemVo>  commandeItemVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<CommandeItemVo> getCommandeItemVos() {
        return commandeItemVos;
    }

    public void setCommandeItemVos(List<CommandeItemVo> commandeItemVos) {
        this.commandeItemVos = commandeItemVos;
    }

    

    @Override
    public String toString() {
        return "CommandeVo{" + "id=" + id + ", reference=" + reference + ", total=" + total + '}';
    }
 
     
    
}
