/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.com;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.ent.RecursosProyecto;

/**
 *
 * @author Diego
 */
@Stateless
public class RecursosProyectoFacade extends AbstractFacade<RecursosProyecto> {
    @PersistenceContext(unitName = "SisComPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecursosProyectoFacade() {
        super(RecursosProyecto.class);
    }
    
}
