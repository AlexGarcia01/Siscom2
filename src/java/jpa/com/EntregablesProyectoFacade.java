/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.com;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.ent.EntregablesProyecto;

/**
 *
 * @author Diego
 */
@Stateless
public class EntregablesProyectoFacade extends AbstractFacade<EntregablesProyecto> {
    @PersistenceContext(unitName = "SisComPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntregablesProyectoFacade() {
        super(EntregablesProyecto.class);
    }
    
}
