/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.rest;

import com.fst.Commandapi.domain.bean.Commande;
import com.fst.Commandapi.domain.bean.CommandeItem;
import com.fst.Commandapi.domain.model.service.CommandeItemService;
import com.fst.Commandapi.domain.model.service.CommandeService;
import com.fst.Commandapi.domain.rest.converter.AbstractConverter;
import com.fst.Commandapi.domain.rest.converter.CommandeConverter;
import com.fst.Commandapi.domain.rest.vo.CommandeItemVo;
import com.fst.Commandapi.domain.rest.vo.CommandeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BlackAngel
 */
@Api(description = "API pour es opérations CRUD sur les produits.")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/commande-api/commandes")
public class CommandeRest {

    @Autowired
    @Qualifier("commandeItemConverter")
    private AbstractConverter<CommandeItem, CommandeItemVo> commandeItemConverter;

    @Autowired
    @Qualifier("commandeConverter")
    private AbstractConverter<Commande, CommandeVo> commandeConverter;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private CommandeItemService commandeItemService;

    @ApiOperation(value = "ajouter une nouvelle commande ")
    @PostMapping("/")
    public CommandeVo save(@RequestBody CommandeVo commandeVo) {

        Commande commande = new CommandeConverter().toItem(commandeVo);
        Commande cmd = commandeService.save(commande);
        return new CommandeConverter().toVo(cmd);
    }

    @GetMapping("/reference/{reference}/commande-items/")
    public List<CommandeItemVo> findByCommande(@PathVariable("reference") String reference) {
        Commande commande = new Commande();
        final List<CommandeItem> CommandeItems = commandeItemService.findByReference(reference);

        return commandeItemConverter.toVo(CommandeItems);
    }

    @GetMapping("/")
    public List<CommandeVo> findAll() {
        return new CommandeConverter().toVo(commandeService.findAll());
    }

    @ApiOperation(value = "Récupère une commande grâce à reference   à condition que celui-ci soit en stock!")
    @GetMapping("/reference/{reference}")
    public CommandeVo findByReference(@PathVariable("reference") String reference) {
        return new CommandeConverter().toVo(commandeService.findByReference(reference));
    }

    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

}
