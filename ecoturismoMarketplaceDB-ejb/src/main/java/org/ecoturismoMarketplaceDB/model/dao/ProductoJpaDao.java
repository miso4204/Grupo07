package org.ecoturismoMarketplaceDB.model.dao;

import javax.ejb.Stateless;

import org.ecoturismoMarketplaceDB.model.Producto;


/**
*
* @author Juan David
*/
@Stateless
public class ProductoJpaDao extends HibernateJpaDao<Producto, Integer> implements ProductoDao {

}
   

