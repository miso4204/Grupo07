package ecoturismoMarketplace.product.ws;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ecoturismoMarketplaceProduct.ws.WsProductBean;


@Path("/")
//@Stateless
//@LocalBean
public class ProductWs {
	
	private static final Logger log = Logger.getLogger(ProductWs.class.getName());
	
	@Inject
	private WsProductBean wsProductBean;
	
	@GET
    @Path("/getCategorias")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategorias() {
        return wsProductBean.getCategorias();  //Response.ok(CategoriaDao.findAll()).build();
    }
	
	@GET
    @Path("/getCategoriasAndProductos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoriasAndProductos() {
        return wsProductBean.getCategoriasAndProductos();  
    }
    
}