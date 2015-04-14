package ecoturismoMarketplace.login.ws;

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

import org.ecoturismoMarketplaceDB.model.Usuario;

import ecoturismoMarketplace.loginModule.exception.InvalidRequestException;
import ecoturismoMarketplace.loginModule.exception.NoAccessException;
import ecoturismoMarketplace.loginModule.ws.WsLoginBean;


@Path("/")
//@Stateless
//@LocalBean
public class LoginWs {
	
	private static final Logger log = Logger.getLogger(LoginWs.class.getName());
	
	@Inject
	private WsLoginBean wsBean;
	
	//**********************Servicios para manejo de sesion del usuario***********************
	
	
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("user") String user, @FormParam("pass") String pass) {
        try {
            String ud = wsBean.login(user, pass);
            log.log(Level.INFO, "Usuario [{0}] inicio sesion correctamente", user);
            System.out.println(Response.ok(ud).build());
            return Response.ok(ud).build();
        } catch (NoAccessException ex) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    @POST
    @Path("/logout/{token}")
    public Response logout(@PathParam("token") String token) {
        try {
            wsBean.logout(token);
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
            String token = wsBean.registrarUsuario(nombre,apellidos,correo,direccion,user, pass);
            log.log(Level.INFO, "Registrando usuario [{0}]", user);
            return Response.ok(token).build();
        } catch (InvalidRequestException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }
    
  //*************************** Servicios de prueba ***************************
	
  	@GET
      @Path("/user1")
      @Produces("text/html")
      public String user1() {
      	
           Usuario employee = new Usuario();
           employee.setNombre("JuanD");
           employee.setApellidos("PovedaT");
           employee.setUsername("jdpt");
           employee.setPassword("A123");
           employee.setDireccion("xxyyzz");
           employee.setCorreo("aa@bb.cc");
           employee.setTelefono("7444444");
          
           wsBean.crearUsuario(employee);
      	
      return "<h2>Creado Usuario 1! "+"</h2>";
      }
      
      @GET
      @Path("/user2")
      @Produces("text/html")
      public String user2() {
      	
           Usuario employee = new Usuario();
           employee.setNombre("Juan");
           employee.setApellidos("Poveda");
           employee.setUsername("jdp");
           employee.setPassword("A456");
           employee.setDireccion("xxwwyyzz");
           employee.setCorreo("aa@bb.cwwc");
           employee.setTelefono("7422224");
          
           wsBean.crearUsuario(employee);
      	
      return "<h2>Creado Usuario 2! "+"</h2>";
      }
  	  
      @GET
      @Path("/fakeLogin")
      @Produces("text/html")
      public String fakeLogin() {
      	
      	try {
              String ud = wsBean.login("jdpt", "A123");
              log.log(Level.INFO, "Usuario [{0}] inicio sesion correctamente", "jdpt");
              System.out.println(Response.ok(ud).build());
              return "<h2>Fake Login Exitoso... token: "+ ud +"</h2>";
          } catch (NoAccessException ex) {
          	return "<h2>Fake Login Fallo... "+"</h2>";
          }
      	
      }
      
      @GET
      @Path("/fakeLogout/{token}")
      public Response fakeLogout(@PathParam("token") String token) {
          try {
              wsBean.logout(token);
              return Response.ok().build();
          } catch (InvalidRequestException ex) {
              return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
          }
      }
      
   
}