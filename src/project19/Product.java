/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project19;

/**
 *
 * @author admin
 */
public class Product {
    
   private int idx;
    private String lavel;
    private String addr;
    private String name;
    private int tel1;
    
    public  Product(int Idx, String Lavel,String Addr,String Name ,int Tel1)
    {
        this.idx=Idx;
        this.lavel=Lavel;
        this.addr=Addr;
        this.name=Name;
        this.tel1=Tel1;
        
    }

    
    
    public int getIdx(){
        return idx;
        
    }
     public String getLavel(){
        return lavel;
        
    }
      public String getAddr(){
        return addr;
        
    }
       public String getName(){
        return name;
        
    }
        public int getTel1(){
        return tel1;
        
    }
            

}