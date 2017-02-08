/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Book;

/**
 *
 * @author user
 */
public class BookDAO extends DAO<Book>{
    public BookDAO(){
        super(new Book());
    }
    public Book getOneById(Book  book)throws HibernateException{
        return super.getOneById(book.getIdBook());
    }
}
