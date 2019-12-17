/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.rest.converter;

import com.fst.Commandapi.common.utile.NumberUtil;
import com.fst.Commandapi.domain.bean.Commande;
import com.fst.Commandapi.domain.rest.vo.CommandeVo;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author BlackAngel
 */
@Component

public class CommandeConverter extends AbstractConverter<Commande, CommandeVo> {

    @Override
    public Commande toItem(CommandeVo vo) {
        if (vo == null) {
            return null;
        } else {
            Commande c = new Commande();
            c.setId(vo.getId());
            c.setReference(vo.getReference());
            c.setTotal(NumberUtil.toBigDecimal(vo.getTotal()));
            c.setCommandeItems(new CommandeItemConverter().toItem(vo.getCommandeItemVos()));
            return c;
        }

    }

    @Override
    public CommandeVo toVo(Commande item) {
        if (item == null) {
            return null;
        } else {
            CommandeVo vo = new CommandeVo();
            vo.setId(item.getId());
            vo.setReference(item.getReference());
            vo.setTotal(NumberUtil.toString(item.getTotal()));
            vo.setCommandeItemVos(new CommandeItemConverter().toVo(item.getCommandeItems()));
            return vo;
        }
    }

}
