package ecoturismoMarketplace.loginModule.ws;

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

import org.ecoturismoMarketplaceDB.model.Usuario;
import org.ecoturismoMarketplaceDB.model.dao.UsuarioDao;

import ecoturismoMarketplace.loginModule.exception.InvalidRequestException;
import ecoturismoMarketplace.loginModule.exception.NoAccessException;


@Stateless
@LocalBean
public class WsLoginBean {
	
	private static final Logger log = Logger.getLogger(WsLoginBean.class.getName());

	@EJB
    private UsuarioDao usuarioDao;
	
	public void crearUsuario(Usuario u){
		usuarioDao.create(u);
	}
	
    public String login(String user, String pass) throws NoAccessException {

        if (user != null && pass != null && !user.isEmpty() && !pass.isEmpty()) {
            Map<String, Object> qParams = new HashMap<String, Object>();
            qParams.put("username", user);
            qParams.put("password", pass);
            List<Usuario> userList = usuarioDao.findWithNamedQuery("Usuario.findByUserPass", qParams);

            if (!userList.isEmpty() && userList.size() > 0) {
                Usuario u = userList.get(0);

                String token = UUID.randomUUID().toString().toUpperCase();

                u.setToken(token);
                
                usuarioDao.update(u);

                log.log(Level.INFO, "El usuario [{0}] inició sesion", u.getNombre());
                
                return token;
                
            } else {
            	log.log(Level.INFO, "El usuario no puede acceder");
                throw new NoAccessException();
            }
        } else {
        	log.log(Level.INFO, "El usuario no puede acceder");
            throw new NoAccessException();
        }
    }
   
    
    public void logout(String token) throws InvalidRequestException {
    	
    	Map<String, Object> qParams = new HashMap<String, Object>();
        qParams.put("token", token);
        List<Usuario> userList = usuarioDao.findWithNamedQuery("Usuario.findByToken", qParams);
        
        if(!userList.isEmpty()){
        
        Usuario u = userList.get(0);

        	if (u != null) {

        		u.setToken(null);
        		usuarioDao.update(u);
        		
        		log.log(Level.INFO, "El usuario [{0}] cerró sesion", u.getUsername());
        	
        	} else {
                throw new InvalidRequestException("Usuario Inexistente");
            }
        	
        } else {
            throw new InvalidRequestException("Usuario Inexistente");
        }
    }
    
    public void registrarUsuario(String nombre,String apellidos,String correo,String direccion,String user, String pass) throws InvalidRequestException{
    	
    	if(nombre != null && apellidos != null && correo != null && direccion != null && user != null && pass != null
    	   && !nombre.isEmpty() && !apellidos.isEmpty() && !correo.isEmpty() && !direccion.isEmpty() && !user.isEmpty() && !pass.isEmpty()){
    	
    		Usuario u = new Usuario();
    	
    		u.setNombre(nombre);
    		u.setApellidos(apellidos);
    		u.setCorreo(correo);
    		u.setDireccion(direccion);
    		u.setPassword(pass);
    		u.setUsername(user);
    	
    		usuarioDao.create(u);
    		
    	} else {
    		
    		throw new InvalidRequestException("No se puede registrar el usuario nuevo");
    		
    	}
    	
    	
    }
    
}