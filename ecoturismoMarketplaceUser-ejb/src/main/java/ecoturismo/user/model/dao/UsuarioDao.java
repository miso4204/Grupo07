package ecoturismo.user.model.dao;

import javax.ejb.Local;

import ecoturismo.user.model.Usuario;

/**
 *
 * @author Juan David
 */
@Local
public interface UsuarioDao extends JpaDao<Usuario, Integer> {

}