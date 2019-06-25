
package project19;

import java.awt.*;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class cold  
{
    
    public String cold_parasing() throws ParserConfigurationException, SAXException, IOException 
    {
    
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
     Calendar cal = Calendar.getInstance();     //현재 년도, 월, 일
     int year = cal.get(cal.YEAR);
     int month = cal.get(cal.MONTH) + 1;
     int date = cal.get(cal.DATE);
     int common_cold=0;
     
     String r_date="";
     String s="0";
     if(date<10)
         r_date=s+date;
     else 
         r_date=date+"";
     
    String addr = "http://newsky2.kma.go.kr/iros/RetrieveWhoIndexService2/getInflWhoList?serviceKey=K9v339FQcToCtDg3b0ESgGBfomZgqP4YlIN7220KO9nY6Gj7EJPx3n3J%2FycN%2FjSzpO4cAgITklMGW5NF%2BIC1mA%3D%3D&areaNo=2600000000&time=";
    Document n5 = builder.parse(addr+year+month+r_date+"18");
    
    NodeList list5 = n5.getElementsByTagName("Body"); 
        for(int i=0; i<list5.getLength(); i++)
        {
	   for(Node node = list5.item(i).getFirstChild(); node!=null; node=node.getNextSibling())
           {
	     if(node.getNodeName().equals("IndexModel"))
             {
               for(Node node2 = node.getFirstChild(); node2!=null; node2=node2.getNextSibling())
                {
		    if (node2.getNodeName().equals("tomorrow"))
                    {   
                      //  System.out.println(node2.getTextContent());
                         common_cold=Integer.parseInt(node2.getTextContent());
                       
                         if(common_cold==0){   
                         return year+"년 "+month+"월 "+date+"일 "+"감기지수 낮음";
                                 
                         }
                         else if(common_cold==1){
                          return year+"년 "+month+"월 "+date+"일 "+"감기지수 보통";
                         }
                         else if(common_cold==2){
                             return year+"년 "+month+"월 "+date+"일 "+"감기지수 높음";
                         }
                         else if(common_cold==3){
                                return year+"년 "+month+"월 "+date+"일 "+"감기지수 매우높음";
                         }
                    }
                }
             }
           }
         }
        
                return "";
    }
}    

