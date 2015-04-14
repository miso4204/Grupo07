package org.ecoturismoMarketplaceDB.model.dao;

import javax.ejb.Local;

import org.ecoturismoMarketplaceDB.model.Ubicacion;

/**
 *
 * @author Juan David
 */
@Local
public interface UbicacionDao extends JpaDao<Ubicacion, Integer> {

}