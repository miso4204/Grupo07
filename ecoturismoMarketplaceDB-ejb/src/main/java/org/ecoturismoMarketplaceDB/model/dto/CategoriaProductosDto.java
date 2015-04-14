package org.ecoturismoMarketplaceDB.model.dto;

import java.util.List;

import org.ecoturismoMarketplaceDB.model.Categoria;
import org.ecoturismoMarketplaceDB.model.Producto;


/**
 *
 * @author Juan David
 */

public class CategoriaProductosDto {

    private Categoria categoria;
    private List <Producto> prodList;
    
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Producto> getProdList() {
		return prodList;
	}
	public void setProdList(List<Producto> prodList) {
		this.prodList = prodList;
	}

}
