/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.MethodPaymentDAO;
import utng.datos.OrderHeaderDAO;
import utng.modelo.MethodPayment;
import utng.modelo.OrderHeader;

/**
 *
 * @author user
 */
@ManagedBean(name="orderHeaderBean") 
@SessionScoped
public class OrderHeaderBean implements Serializable{
    private List<OrderHeader> orderHeaders;
    private OrderHeader orderHeader;
    private List<MethodPayment> methodPayments;

    public OrderHeaderBean() {
        orderHeader= new OrderHeader();
        orderHeader.setMethodPayment(new MethodPayment());
    }

    public List<OrderHeader> getOrderHeaders() {
        return orderHeaders;
    }

    public void setOrderHeaders(List<OrderHeader> orderHeaders) {
        this.orderHeaders = orderHeaders;
    }

    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }

    public List<MethodPayment> getMethodPayments() {
        return methodPayments;
    }

    public void setMethodPayments(List<MethodPayment> methodPayments) {
        this.methodPayments = methodPayments;
    }
    public String listar(){
    OrderHeaderDAO dao=new OrderHeaderDAO();
    try{
        orderHeaders=dao.getAll();
            }catch(Exception e ){
        e.printStackTrace();
    }
    return  "Order Header";
}
public String eliminar(){
    OrderHeaderDAO dao=new OrderHeaderDAO();
    try{
        dao.delete(orderHeader);
        orderHeaders=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Eliminar";
}
 public String iniciar(){
        orderHeader=new OrderHeader();
        orderHeader.setMethodPayment(new MethodPayment());
        try{
            methodPayments=new MethodPaymentDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }return "Iniciar";
    }
    public String guardar(){
   OrderHeaderDAO dao=new OrderHeaderDAO();
    try{
        if(orderHeader.getIdOrderHeader()!=0){
            dao.update(orderHeader);
        }else{
            dao.insert(orderHeader);
        }
        orderHeaders=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
    public String cancelar(){
    return "Cancelar";
    }
public String editar(OrderHeader orderHeader){
    this.orderHeader=orderHeader;
    try{
        methodPayments=new MethodPaymentDAO().getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Editar";
}

 
    
    
}
