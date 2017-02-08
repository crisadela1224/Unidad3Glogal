/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Escritor;

/**
 *
 * @author user
 */
public class EscritorDAO extends DAO<Escritor>{
    public EscritorDAO(){
        super(new Escritor());
         
    }
public Escritor getOneById(Escritor escritor)
        throws HibernateException{
    return super.getOneById(escritor.getIdEscritor());
}
        }