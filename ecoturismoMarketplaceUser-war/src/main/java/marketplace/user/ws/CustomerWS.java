package marketplace.user.ws;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ecoturismo.user.exception.InvalidRequestException;
import ecoturismo.user.exception.NoAccessException;
import ecoturismo.user.model.Usuario;
import ecoturismo.user.model.dao.UsuarioDao;
import ecoturismo.user.ws.WsBean;
import ecoturismo.user.ws.dto.UsuarioDto;

@Path("/customers")
//@Stateless
//@LocalBean
public class CustomerWS {
	
	private static final Logger log = Logger.getLogger(CustomerWS.class.getName());
	
	@Inject
    private UsuarioDao usuarioDao;
	@Inject
	private WsBean wsBean;
    @GET
    @Path("/test")
    @Produces("text/html")
    public String getHtml() {
    	
         Usuario employee = new Usuario();
         employee.setNombre("Juan");
         employee.setApellidos("Poveda");
         employee.setUsername("jdpt");
         employee.setPassword("A123");
         employee.setDireccion("xxyyzz");
         employee.setCorreo("aa@bb.cc");
        
         usuarioDao.create(employee);
    	
    return "<h2>Hello "+"</h2>";
    }
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("user") String user, @FormParam("pass") String pass) {
        try {
            UsuarioDto ud = wsBean.login(user, pass);
            log.log(Level.INFO, "Usuario [{0}] inicio sesion correctamente", user);
            System.out.println(Response.ok(ud).build());
            return Response.ok(ud).build();
        } catch (NoAccessException ex) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    @POST
    @Path("/logout/{usuario}")
    public Response terminaTrabajo(@PathParam("usuario") Integer usuario) {
        try {
            wsBean.logout(usuario);
            return Response.ok().build();
        } catch (InvalidRequestException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }
    
    @POST
    @Path("/registrar")
    public Response registrarUsuario(@FormParam("nombre") String nombre, 
    		@FormParam("apellidos") String apellidos, @FormParam("correo") String correo, 
    		@FormParam("direccion") String direccion, @FormParam("user") String user,
    		@FormParam("pass") String pass) {
        try {
            wsBean.registrarUsuario(nombre,apellidos,correo,direccion,user, pass);
            log.log(Level.INFO, "Registrando usuario [{0}]", user);
            return Response.ok().build();
        } catch (InvalidRequestException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }
    
}