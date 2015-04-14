package org.ecoturismoMarketplaceDB.model.dao;

import javax.ejb.Stateless;

import org.ecoturismoMarketplaceDB.model.Categoria;


/**
 *
 * @author Juan David
 */
@Stateless
public class CategoriaJpaDao extends HibernateJpaDao<Categoria, Integer> implements CategoriaDao {
    

}