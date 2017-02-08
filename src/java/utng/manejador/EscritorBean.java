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
import javax.faces.context.FacesContext;
import utng.datos.BookDAO;
import utng.datos.EscritorDAO;
import utng.datos.UsuarioDAO;
import utng.modelo.Book;
import utng.modelo.Escritor;

/**
 *
 * @author user
 */
@ManagedBean(name="escritorBean") 
@SessionScoped
public class EscritorBean  implements Serializable{
    private List<Escritor> escritores;
    private Escritor escritor;
    private List<Book> books;
    
    public EscritorBean(){
        escritor= new Escritor();
        escritor.setBook(new Book());
    }

    public List<Escritor> getEscritores() {
        return escritores;
    }

    public void setEscritores(List<Escritor> escritores) {
        this.escritores = escritores;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public String listar(){
    EscritorDAO dao=new EscritorDAO();
    try{
        escritores=dao.getAll();
            }catch(Exception e ){
        e.printStackTrace();
    }
    return  "Escritores";
}
public String eliminar(){
   EscritorDAO dao=new EscritorDAO();
    try{
        dao.delete(escritor);
        escritores=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Eliminar";
}
 public String iniciar(){
        escritor=new Escritor();
        escritor.setBook(new Book());
        try{
            books=new BookDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }return "Iniciar";
    }
    public String guardar(){
   EscritorDAO dao=new EscritorDAO();
    try{
        if(escritor.getIdEscritor()!=0){
            dao.update(escritor);
        }else{
            dao.insert(escritor);
        }
        escritores=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
    public String cancelar(){
    return "Cancelar";
    }
public String editar(Escritor escritor){
    this.escritor=escritor;
    try{
        books=new BookDAO().getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Editar";
}

}
