/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Login;

/**
 *
 * @author user
 */
public class LoginDAO extends DAO<Login>{
    
    public LoginDAO(){
        super(new Login());
    }
    public Login getOneById(Login login)
    throws HibernateException{
        return super.getOneById(login.getIdLogin());
    }
}
