package project19;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import project19.Home19;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JavaTeam01 {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException 
    {
         cold very_cold = new cold(); 
         very_cold.cold_parasing();
         
       // String Busan[] = {"남구", "동구", "동래구", "부산진구", "북구", "서구", "영도구", "중구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"};
        //                    0       1       2         3        4       5       6      7         8           9       10       11       12       13        14       15       

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        
        
        
        
        
        /* 1번 병원정보
        //남구 210001 / 동구 210002 / 동래구 210003 / 부산진구 210004 / 북구 210005 / 서구 210006 / 영도구 210007/ 중구 210008 /
        // 해운대구 210009 / 사하구 210010 / 금정구 210011 / 강서구 210012 / 연제구 210013 / 수영구 210014 /사상구 210015 /기장군 210100
       
      
        String region[] ={"sgguCd=210001","sgguCd=210002","sgguCd=210003","sgguCd=210004","sgguCd=210005","sgguCd=210006","sgguCd=210007","sgguCd=210008","sgguCd=210009","sgguCd=210009","sgguCd=210010","sgguCd=210011","sgguCd=210012","sgguCd=210013","sgguCd=210014","sgguCd=210015","sgguCd=210100"};
        String zipCd_G="&zipCd=2010"; //종합병원
        String zipCd_H="&zipCd=2030"; //일반병원
        String hospital= "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList?serviceKey=K9v339FQcToCtDg3b0ESgGBfomZgqP4YlIN7220KO9nY6Gj7EJPx3n3J%2FycN%2FjSzpO4cAgITklMGW5NF%2BIC1mA%3D%3D&pageNo=1&startPage=1&numOfRows=30&pageSize=1&sidoCd=210000&";
        String addr_G=hospital+region[1]+zipCd_G; //종합병원정보 파싱주소
        String addr_H=hospital+region[1]+zipCd_H; //일반병원정보 파싱주소
        Document n1_G = builder.parse(addr_G);
        Document n1_H = builder.parse(addr_H);
         hospital []general =new hospital[29]; //종합병원
         int next1=0;
         for(int i=0; i<29; i++)
         {
             general[i]= new hospital();
         }
          NodeList list1 = n1_G.getElementsByTagName("items");  // 1번   
            for (Node node = list1.item(0).getFirstChild(); node != null; node = node.getNextSibling())
            {
                if (node.getNodeName().equals("item")) 
                {
                    for (Node node2 = node.getFirstChild(); node2 != null; node2 = node2.getNextSibling()) 
                    {
                            if (node2.getNodeName().equals("addr")) //병원 주소 
                            {
                            general[next1].setm_hospital_addr(node2.getTextContent());
                            System.out.println(general[next1].getm_hospital_addr());
                            }
                            if (node2.getNodeName().equals("telno")) // 병원 이름
                            {
                            general[next1].setm_hospital_name(node2.getTextContent());
                            System.out.println(general[next1].getm_hospital_name());
                            }
                            if (node2.getNodeName().equals("yadmNm")) //병원 전화번호
                            {
                            general[next1].setm_hospital_tel1(node2.getTextContent());
                            System.out.println(general[next1].getm_hospital_tel1());
                            next1++;
                            if(next1==29)
                            break;
                            }
                         
                    }
                }
             }
          */   
        /*
        emergency []parasing = new emergency[30];  //3번 응급병원 정보
        int next=0;
        boolean C_next=false;
        for(int i =0; i<30; i++)
        {
            parasing[i]= new emergency();
        }
        String num4 = "http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire?serviceKey=K9v339FQcToCtDg3b0ESgGBfomZgqP4YlIN7220KO9nY6Gj7EJPx3n3J%2FycN%2FjSzpO4cAgITklMGW5NF%2BIC1mA%3D%3D&pageNo=1&numOfRows=100&Q0=";
       //num5+ URLEncoder.encode("부산광역시","UTF-8") 응급병원정보
        Document n4 = builder.parse(num4 + URLEncoder.encode("부산광역시", "UTF-8"));
        NodeList list4 = n4.getElementsByTagName("items");  // 응급정보    
            for (Node node = list4.item(0).getFirstChild(); node != null; node = node.getNextSibling())
            {
          
                if (node.getNodeName().equals("item")) 
                {
                    for (Node node2 = node.getFirstChild(); node2 != null; node2 = node2.getNextSibling()) 
                    {
                            if (node2.getNodeName().equals("dutyAddr")) //병원 주소 
                            {
                               parasing[next].setM_emergency_addr(node2.getTextContent());
                             if(parasing[next].getM_emergency_addr()!=null)
                                 C_next=true;
                             else 
                                 C_next=false;
                            }
                             if (node2.getNodeName().equals("dutyName")) // 병원 이름
                            {
                              parasing[next].setM_emergency_name(node2.getTextContent());
                            }
                          
                            if (node2.getNodeName().equals("dutyTel1")) //병원 번호
                            {
                              parasing[next].setM_emergency_tel1(node2.getTextContent());
                              
                             } 
                            if (node2.getNodeName().equals("dutyTel3")) //병원 번호 2
                            {
                             parasing[next].setM_emergency_tel2(node2.getTextContent());
                             if(C_next==true) 
                             {
                                 next++;
                                 System.out.println("next =" + next);
                                 if(next==30)
                                 break;
                             }
                             }
                        }
                 }
            }
               for(int n=0; n<30; n++)
        {
        System.out.println(parasing[n].getM_emergency_addr());
        System.out.println(parasing[n].getM_emergency_name());
        System.out.println(parasing[n].getM_emergency_tel1());
        System.out.println(parasing[n].getM_emergency_tel2());
         }
         */  
 
 }
        //System.out.println(URLEncoder.encode("부산광역시","UTF-8"));
        //1.부산 병원정보http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList?serviceKey=K9v339FQcToCtDg3b0ESgGBfomZgqP4YlIN7220KO9nY6Gj7EJPx3n3J%2FycN%2FjSzpO4cAgITklMGW5NF%2BIC1mA%3D%3D&pageNo=1&startPage=1&numOfRows=10&pageSize=10&sidoCd=210000&zipCd=2010&clCd=11&dgsbjtCd=01
        //3.부산 응급병원정보 http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire?serviceKey=K9v339FQcToCtDg3b0ESgGBfomZgqP4YlIN7220KO9nY6Gj7EJPx3n3J%2FycN%2FjSzpO4cAgITklMGW5NF%2BIC1mA%3D%3D&pageNo=1&numOfRows=100&Q0=%EB%B6%80%EC%82%B0%EA%B4%91%EC%97%AD%EC%8B%9C
    }
