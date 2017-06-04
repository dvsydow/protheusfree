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
public class Consultor1Facade extends AbstractFacade<Consultor1> {
    @PersistenceContext(unitName = "com_protheusfree_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Consultor1Facade() {
        super(Consultor1.class);
    }
    
}
