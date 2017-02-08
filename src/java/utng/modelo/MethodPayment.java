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
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name="method_payment")
public class MethodPayment implements Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_method_payment")
    private Long idMethodPayment;
    @Column(length = 30)
    private String name;
    
    public MethodPayment(){
        this.idMethodPayment=0L;
    }

    public Long getIdMethodPayment() {
        return idMethodPayment;
    }

    public void setIdMethodPayment(Long idMethodPayment) {
        this.idMethodPayment = idMethodPayment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
