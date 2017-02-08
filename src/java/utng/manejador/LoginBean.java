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
import utng.modelo.Login;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
    private List<Login> logins;
    private Login login;
    
    public LoginBean(){
        
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    public String listar(){
        LoginDAO dao= new LoginDAO();
        try{
            
            logins=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Logins";
    }
    public String eliminar(){
        LoginDAO dao= new LoginDAO();
        try{
            dao.delete(login);
            logins=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Eliminar";
    }
    public String iniciar(){
        login= new Login();
        return "Iniciar";
    }
    public String guardar(){
        LoginDAO dao= new LoginDAO();
        try{
            if(login.getIdLogin()!=0){
                dao.update(login);
            }else{
                dao.insert(login);
            }
            logins=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Guardar";
    }
    public String cancelar(){
        return "Cancelar";
    }
    public String editar(Login login){
        this.login=login;
        return "Editar";
    }
    
}
