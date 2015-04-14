package org.ecoturismoMarketplaceDB.model.dao;

import javax.ejb.Stateless;

import org.ecoturismoMarketplaceDB.model.Ubicacion;


/**
 *
 * @author Juan David
 */
@Stateless
public class UbicacionJpaDao extends HibernateJpaDao<Ubicacion, Integer> implements UbicacionDao {
    

}