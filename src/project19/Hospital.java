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
public class Hospital {  // 전체 db에따라 수정
    private String idx;
    private String lavel;
    private String addr;
    private String name;
    private String tel1;
    public Hospital(String Idx, String Lavel,String Addr,String Name ,String Tel1)
    {
        this.idx=Idx;
        this.lavel=Lavel;
        this.addr=Addr;
        this.name=Name;
        this.tel1=Tel1;
        
    }

    
    
    public  String getIdx(){
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
        public String getTel1(){
        return tel1;
        
    }
            
    
}
