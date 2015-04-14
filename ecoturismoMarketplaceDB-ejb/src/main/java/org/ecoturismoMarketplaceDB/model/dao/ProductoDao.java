package org.ecoturismoMarketplaceDB.model.dao;

import javax.ejb.Local;

import org.ecoturismoMarketplaceDB.model.Producto;

/**
 *
 * @author Juan David
 */
@Local
public interface ProductoDao extends JpaDao<Producto, Integer> {

}