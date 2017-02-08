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
import utng.datos.LoginDAO;
import utng.datos.PersonDAO;
import utng.modelo.Login;
import utng.modelo.Person;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class PersonBean implements Serializable{
    private List<Person> persons;
    private Person person;
    private List<Login>logins;
    
    public PersonBean(){
        person= new Person();
        person.setLogin(new Login());
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }
    public String listar(){
        PersonDAO dao= new PersonDAO();
        try{
            persons=dao.getAll();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Persons";
    }
    public String eliminar(){
        PersonDAO dao= new PersonDAO();
        try{
            dao.delete(person);
            persons=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Eliminar";
        
    }
    public String iniciar(){
        person= new Person();
        person.setLogin(new Login());
        try{
            logins= new LoginDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Iniciar";
    }
    public String guardar(){
        PersonDAO dao= new PersonDAO();
        try{
            if(person.getIdPerson()!=0){
                dao.update(person);
            }else{
                dao.insert(person);
            }
            persons=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Guardar";
    }
    public String cancelar(){
        return "Cancelar";
    }    
    public String editar(Person person){
        this.person=person;
        try{
            logins= new LoginDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Editar";
    }
}
