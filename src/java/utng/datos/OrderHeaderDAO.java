/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.OrderHeader;

/**
 *
 * @author user
 */
public class OrderHeaderDAO extends DAO<OrderHeader>{
    public OrderHeaderDAO(){
        super(new OrderHeader());
    }
    public OrderHeader getOneById(OrderHeader orderHeader)throws HibernateException{
        return super.getOneById(orderHeader.getIdOrderHeader());
    }
}
