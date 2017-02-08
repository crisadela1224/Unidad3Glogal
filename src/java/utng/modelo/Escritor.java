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
@Table(name="escritor")
public class Escritor  implements Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id_escritor")
     private Long idEscritor;
    @Column(name="nombre_escritor", length = 30)
    private String nombreEscritor;
    @Column(length = 40)
    private String edad;
    @Column(length = 40)
    private String direccion;
    @ManyToOne//(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_book")
    private Book book;

    public Escritor(Long idEscritor, String nombreEscritor, String edad, String direccion, Book book) {
        this.idEscritor = idEscritor;
        this.nombreEscritor = nombreEscritor;
        this.edad = edad;
        this.direccion = direccion;
        this.book = book;
    }
    public Escritor(){
        this.idEscritor=0L;
    }

    public Long getIdEscritor() {
        return idEscritor;
    }

    public void setIdEscritor(Long idEscritor) {
        this.idEscritor = idEscritor;
    }

    public String getNombreEscritor() {
        return nombreEscritor;
    }

    public void setNombreEscritor(String nombreEscritor) {
        this.nombreEscritor = nombreEscritor;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    
}
