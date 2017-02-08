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
@Table(name="person")
public class Person implements Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id_person")
     private Long idPerson;
    @Column(name="nombre_person", length = 10)
    private String nombrePerson;
    @Column(length = 40)
    private String direction;
    @ManyToOne//(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_login")
    private Login login;

    public Person(Long idPerson, String nombrePerson, String direction, Login login) {
        super();
        this.idPerson = idPerson;
        this.nombrePerson = nombrePerson;
        this.direction = direction;
        this.login = login;
    }
        public Person(){
            this.idPerson=0L;
        }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getNombrePerson() {
        return nombrePerson;
    }

    public void setNombrePerson(String nombrePerson) {
        this.nombrePerson = nombrePerson;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
        
}
