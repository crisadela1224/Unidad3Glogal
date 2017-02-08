/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Person;

/**
 *
 * @author user
 */
public class PersonDAO extends DAO<Person>{
    public PersonDAO(){
        super(new Person());
    }
    public Person getOneById(Person person)
            throws HibernateException{
        return super.getOneById(person.getIdPerson());
    }
}
