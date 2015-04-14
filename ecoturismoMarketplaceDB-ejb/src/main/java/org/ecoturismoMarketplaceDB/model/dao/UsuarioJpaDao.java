package org.ecoturismoMarketplaceDB.model.dao;

import javax.ejb.Stateless;

import org.ecoturismoMarketplaceDB.model.Usuario;

/**
 *
 * @author Juan David
 */
@Stateless
public class UsuarioJpaDao extends HibernateJpaDao<Usuario, Integer> implements UsuarioDao {
    

}