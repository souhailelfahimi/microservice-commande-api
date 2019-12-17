/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.rest;

import com.fst.Commandapi.domain.bean.Commande;
import com.fst.Commandapi.domain.bean.CommandeItem;
import com.fst.Commandapi.domain.model.service.CommandeItemService;
import com.fst.Commandapi.domain.rest.converter.AbstractConverter;
import com.fst.Commandapi.domain.rest.vo.CommandeItemVo;
import com.fst.Commandapi.domain.rest.vo.CommandeVo;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BlackAngel
 */
@Api(description = "API pour es opérations CRUD sur les produits.")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/commande-api/commande-items")
public class CommandeItemRest {

    @Autowired
    private CommandeItemService commandeItemService;

    @Autowired
    @Qualifier("commandeItemConverter")
    private AbstractConverter<CommandeItem, CommandeItemVo> commandeItemConverter;

    @Autowired
    @Qualifier("commandeConverter")
    private AbstractConverter<Commande, CommandeVo> commandeConverter;

    

    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }

    public AbstractConverter<CommandeItem, CommandeItemVo> getCommandeItemConverter() {
        return commandeItemConverter;
    }

    public void setCommandeItemConverter(AbstractConverter<CommandeItem, CommandeItemVo> commandeItemConverter) {
        this.commandeItemConverter = commandeItemConverter;
    }

    public AbstractConverter<Commande, CommandeVo> getCommandeConverter() {
        return commandeConverter;
    }

    public void setCommandeConverter(AbstractConverter<Commande, CommandeVo> commandeConverter) {
        this.commandeConverter = commandeConverter;
    }

}
