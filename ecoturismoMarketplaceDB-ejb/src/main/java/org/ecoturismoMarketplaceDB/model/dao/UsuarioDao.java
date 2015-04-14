package org.ecoturismoMarketplaceDB.model.dao;
import javax.ejb.Local;
import org.ecoturismoMarketplaceDB.model.Usuario;

/**
 *
 * @author Juan David
 */
@Local
public interface UsuarioDao extends JpaDao<Usuario, Integer> {

}