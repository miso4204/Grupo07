package ecoturismo.user.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ecoturismo.user.exception.InvalidRequestException;
import ecoturismo.user.exception.NoAccessException;
import ecoturismo.user.model.Usuario;
import ecoturismo.user.model.dao.UsuarioDao;
import ecoturismo.user.ws.dto.UsuarioDto;

@Stateless
public class WsBean {
	
	private static final Logger log = Logger.getLogger(WsBean.class.getName());

    @EJB
    private UsuarioDao usuarioDao;
    
    public UsuarioDto login(String user, String pass) throws NoAccessException {

        if (user != null && pass != null && !user.isEmpty() && !pass.isEmpty()) {
            Map<String, Object> qParams = new HashMap<String, Object>();
            qParams.put("username", user);
            qParams.put("password", pass);
            List<Usuario> userList = usuarioDao.findWithNamedQuery("Usuario.findByUserPass", qParams);

            if (!userList.isEmpty() && userList.size() > 0) {
                Usuario u = userList.get(0);

                UsuarioDto ud = new UsuarioDto();
                
                ud.setId(u.getId());
                ud.setNombre(u.getNombre());
                ud.setApellido(u.getApellidos());

                return ud;
                
            } else {
                throw new NoAccessException();
            }
        } else {
            throw new NoAccessException();
        }
    }
    
    public void logout(Integer usuario) throws InvalidRequestException {
        Usuario u = usuarioDao.find(usuario);

        if (u != null) {

                log.log(Level.INFO, "El usuario [{0}] cerró sesion", u.getUsername());
            
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
