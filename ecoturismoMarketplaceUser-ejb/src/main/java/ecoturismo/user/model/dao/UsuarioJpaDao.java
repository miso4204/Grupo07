package ecoturismo.user.model.dao;

import javax.ejb.Stateless;

import ecoturismo.user.model.Usuario;

/**
 *
 * @author Juan David
 */
@Stateless
public class UsuarioJpaDao extends HibernateJpaDao<Usuario, Integer> implements UsuarioDao {
    

}