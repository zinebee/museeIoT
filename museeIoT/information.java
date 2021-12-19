/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;

/**
 *
 * @author zineb
 */
public class information implements Serializable{
    double[] ctemp;
    String[] tit;
    public information(double[] ctemp){
      this.ctemp=ctemp;
    }
    public information(String[] tit){
      this.tit=tit;
    }
    public String[] gettit(){
       return this.tit;
    }
    public String toString(){
        String ch="";
       for(int u=0;u<tit.length;u++){
       ch+=tit[u]+"|";
       
       }
       return ch;
    }
}
