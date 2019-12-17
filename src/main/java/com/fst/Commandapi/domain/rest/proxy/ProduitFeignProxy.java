/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Commandapi.domain.rest.proxy;
import com.fst.Commandapi.domain.rest.vo.exchange.ProduitVo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
/**
 *
 * @author BlackAngel
 */

@FeignClient(name = "microservice-produit-v4-api", url = "localhost:8091")
public interface ProduitFeignProxy {

    @PostMapping("produit-api/produits/")
    public ProduitVo save(@RequestBody ProduitVo produitVo);

    @DeleteMapping("produit-api/produits/{id}")
    public void deleteById(@PathVariable Long id);

    @GetMapping("produit-api/produits/")
    public List<ProduitVo> findAll();

}
