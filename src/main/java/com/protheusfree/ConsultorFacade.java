/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.protheusfree;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danielsydow
 */
@Stateless
public class ConsultorFacade extends AbstractFacade<Consultor> {
    @PersistenceContext(unitName = "com_protheusfree_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultorFacade() {
        super(Consultor.class);
    }
    
}
