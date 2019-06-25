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
public class Pharmacy {
    private String idx;
    private String addr;
    private String name;
    private String Mapimg;
    private String tel1;
    private String close;
    private String open;
    
    public Pharmacy(String Idx, String Addr,String Name,String mapimg ,String Tel1,String Close,String Open)
    {
        this.idx=Idx;
        this.addr=Addr;
        this.name=Name;
        this.Mapimg=mapimg;
        this.tel1=Tel1;
        this.close=Close;
        this.open=Open;
        
    }

    Pharmacy(String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public  String getIdx(){
        return idx;
        
    }
    
      public String getAddr(){
        return addr;
        
    }
       public String getName(){
        return name;
        
    }
        public String getmapimg(){
        return Mapimg;
        
    }
        public String getTel1(){
        return tel1;
        
        
    }
         public String getClose(){
        return close;
        
        
    }
          public String getOpen(){
        return open;
        
        
    }
    
}
