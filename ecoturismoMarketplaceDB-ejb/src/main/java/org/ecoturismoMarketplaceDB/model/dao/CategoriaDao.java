package org.ecoturismoMarketplaceDB.model.dao;

import javax.ejb.Local;

import org.ecoturismoMarketplaceDB.model.Categoria;


/**
 *
 * @author Juan David
 */
@Local
public interface CategoriaDao extends JpaDao<Categoria, Integer> {

}