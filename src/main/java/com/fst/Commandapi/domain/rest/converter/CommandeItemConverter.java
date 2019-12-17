/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.rest.converter;

import com.fst.Commandapi.common.utile.NumberUtil;
import com.fst.Commandapi.domain.bean.Commande;
import com.fst.Commandapi.domain.bean.CommandeItem;
import com.fst.Commandapi.domain.rest.vo.CommandeItemVo;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author BlackAngel
 */
@Component

public class CommandeItemConverter extends AbstractConverter<CommandeItem, CommandeItemVo> {

    public CommandeItemConverter() {
    }

    @Override
    public CommandeItem toItem(CommandeItemVo vo) {
        if (vo == null) {
            return null;
        } else {
            CommandeItem c = new CommandeItem();
            c.setId(vo.getId());
            c.setPrix(NumberUtil.toBigDecimal(vo.getPrix()));
            c.setQte(NumberUtil.toBigDecimal(vo.getQte()));
            c.setReferencePProduit(vo.getReferencePProduit());
            return c;
        }
    }

    @Override
    public CommandeItemVo toVo(CommandeItem item) {
         if (item == null) {
            return null;
        } else {
            CommandeItemVo vo = new CommandeItemVo();
            vo.setId(item.getId());
            vo.setPrix(NumberUtil.toString(item.getPrix()));
            vo.setQte(NumberUtil.toString(item.getQte()));
            vo.setReferencePProduit(item.getReferencePProduit());
            return vo;
        }
    }

}
