/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import java.io.Serializable;

/**
 *
 * @author zineb
 */
public class directeur implements Serializable{
    int Id;
    String login;
    String password;
    public directeur(int id,String login,String password){
      this.Id=id;
      this.login=login;
      this.password=password;
    }
    public directeur(String login,String password){
      this.login=login;
      this.password=password;
    
    }
    public String getLogin(){
      return this.login;
    }
    public String getPassword(){
      return this.password;
    }
    public String toString(){
     return "Directeur[ login= "+this.login+",password= "+this.password+"]";
    }
}
