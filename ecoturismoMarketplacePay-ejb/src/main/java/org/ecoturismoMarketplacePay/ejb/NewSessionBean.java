/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ecoturismoMarketplacePay.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

import org.omg.CORBA.UserException;

import ecoturismo.user.model.Usuario;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {
	
	UserException es;
	Usuario u;

    public void businessMethod() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
