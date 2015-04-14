package org.ecoturismoMarketplaceProduct.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject; 
import javax.ws.rs.core.Response;

import org.ecoturismoMarketplaceDB.model.Categoria;
import org.ecoturismoMarketplaceDB.model.Producto;
import org.ecoturismoMarketplaceDB.model.dao.CategoriaDao;
import org.ecoturismoMarketplaceDB.model.dao.ProductoDao;
import org.ecoturismoMarketplaceDB.model.dao.UsuarioDao;
import org.ecoturismoMarketplaceDB.model.dto.CategoriaProductosDto;


@Stateless
//@LocalBean
public class WsProductBean {
	
	private static final Logger log = Logger.getLogger(WsProductBean.class.getName());

	@EJB
    private CategoriaDao categoriaDao;
	@Inject
	private UsuarioDao usuarioDao;
	@Inject 
	private ProductoDao productoDao;
	
	public void crearCategoria(Categoria c){
		categoriaDao.create(c);
	}
	
	public Response getCategorias() {
	    return Response.ok(categoriaDao.findAll()).build();
	}
	
	public Response getCategoriasAndProductos() {
		
		List<CategoriaProductosDto> cps = new ArrayList<CategoriaProductosDto>();
		List<Categoria> cats = categoriaDao.findAll();
		
		for(Categoria c : cats){
			
			Map<String, Object> qParams = new HashMap<String, Object>();
            qParams.put("idCategoria", c);
            List<Producto> prodList = productoDao.findWithNamedQuery("Producto.findByCategoria", qParams);
            
            if(prodList != null){
            	
            	if(prodList.size() > 4) {
            		prodList = prodList.subList(0, 3);
            	}
            	
            	CategoriaProductosDto cp = new CategoriaProductosDto();
            	cp.setCategoria(c);
            	cp.setProdList(prodList);
            	cps.add(cp);
            }
            
		}
			
	    return Response.ok(cps).build();
	}
	
}