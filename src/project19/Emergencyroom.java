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
public class Emergencyroom {  // 전체 db에따라 수정
    private String idx;
    private String name;
    private String tel1;
    private String serviceable;
    private String hospital;
    
    
    
    public Emergencyroom(String Idx, String Name,String Tel1,String Serviceable,String Hospital)
    {
        this.idx=Idx;
         this.name=Name;
        this.tel1=Tel1;
        this.serviceable=Serviceable;
         this. hospital= Hospital;
        
    }

    
    
    public  String getIdx(){
        return idx;
        
    }
     public String getName(){
        return name;
        
    }
      public String getTel1(){
        return tel1;
        
    }
       public String getServiceable(){
        return serviceable;
        
    }
        public String getHospital(){
        return hospital;
        
    }
            
    
}
