/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.MethodPayment;

/**
 *
 * @author user
 */
public class MethodPaymentDAO  extends DAO<MethodPayment>{
    public MethodPaymentDAO(){
        super(new MethodPayment());
    }
    public MethodPayment getOneById(MethodPayment methodPayment)throws HibernateException{
        return super.getOneById(methodPayment.getIdMethodPayment());
    
    }
}
