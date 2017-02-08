/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author user
 */

@Entity
@Table(name="order_header")
public class OrderHeader implements Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id_order_header")
     private Long idOrderHeader;
    @Column(name="id_customer", length = 10)
    private String idCustomer;
    @Column(length = 40)
    private String date;
    @ManyToOne//(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_method_payment")
    private MethodPayment methodPayment;

    public OrderHeader(Long idOrderHeader, String idCustomer, String date, MethodPayment methodPayment) {
        super();
        this.idOrderHeader = idOrderHeader;
        this.idCustomer = idCustomer;
        this.date = date;
        this.methodPayment = methodPayment;
    }
    public OrderHeader(){
        this.idOrderHeader=0L;
    }

    public Long getIdOrderHeader() {
        return idOrderHeader;
    }

    public void setIdOrderHeader(Long idOrderHeader) {
        this.idOrderHeader = idOrderHeader;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MethodPayment getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(MethodPayment methodPayment) {
        this.methodPayment = methodPayment;
    }

    
}
