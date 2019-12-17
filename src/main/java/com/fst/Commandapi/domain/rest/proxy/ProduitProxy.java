
 
package com.fst.Commandapi.domain.rest.proxy;

import com.fst.Commandapi.domain.rest.vo.exchange.ProduitVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author BlackAngel
 */
@FeignClient(name = "microservice-produit-v4-api", url = "localhost:8091")
public interface ProduitProxy {

    @GetMapping("/produit-api/produits/reference/{reference}")
    public ProduitVo findByReference(@PathVariable("reference") String reference);
 
}
 