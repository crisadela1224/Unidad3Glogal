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
import utng.datos.RolDAO;
import utng.modelo.MethodPayment;
import utng.modelo.Rol;

/**
 *
 * @author user
 */

@ManagedBean
@SessionScoped
public class MethodPaymentBean implements Serializable{
    private List<MethodPayment> methodPayments;
    private MethodPayment methodPayment;

    public MethodPaymentBean() {
    }

    public List<MethodPayment> getMethodPayments() {
        return methodPayments;
    }

    public void setMethodPayments(List<MethodPayment> methodPayments) {
        this.methodPayments = methodPayments;
    }

    public MethodPayment getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(MethodPayment methodPayment) {
        this.methodPayment = methodPayment;
    }
    
     public String listar(){
        MethodPaymentDAO dao=new MethodPaymentDAO();
        try{
            methodPayments=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Method Paymet";
    }
    public String eliminar(){
         MethodPaymentDAO dao=new MethodPaymentDAO();
        try{
            dao.delete(methodPayment);
            methodPayments=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Eliminar";
    }
    public String iniciar(){
        methodPayment=new MethodPayment();
        return "Iniciar";
    }
    public String guardar(){
        MethodPaymentDAO dao=new MethodPaymentDAO();
    try{
        if(methodPayment.getIdMethodPayment()!=0){
            dao.update(methodPayment);
        }else{
            dao.insert(methodPayment);
        }
       methodPayments=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
    public String cancelar(){
    return "Cancelar";
    }
public String editar(MethodPayment methodPayment){
    this.methodPayment=methodPayment;
    return "Editar";
}
    
    
}
