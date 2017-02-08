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
import utng.datos.BookDAO;
import utng.modelo.Book;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class BookBean implements Serializable{
    private List<Book> books;
    private Book book;
    public BookBean(){
        
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
     public String listar(){
        BookDAO dao=new BookDAO();
        try{
            books=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Books";
    }
    public String eliminar(){
         BookDAO dao=new BookDAO();
        try{
            dao.delete(book);
            books=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Eliminar";
    }
    public String iniciar(){
        book=new Book();
        return "Iniciar";
    }
    public String guardar(){
    BookDAO dao=new BookDAO();
    try{
        if(book.getIdBook()!=0){
            dao.update(book);
        }else{
            dao.insert(book);
        }
        books=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
    public String cancelar(){
    return "Cancelar";
    }
public String editar(Book book){
    this.book=book;
    return "Editar";
}
   
    
}
