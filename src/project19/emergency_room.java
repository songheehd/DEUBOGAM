
package project19;

    import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class emergency_room {
    private String m_emergency_room_name;
    private String m_emergency_room_tel1;
    private String m_emergency_room_serviceable;
    private String m_emergency_room_date;

    private ArrayList<String> m_arList = new ArrayList<>();

    public String getM_emergency_room_name() {
        return m_emergency_room_name;
    }

        public String getM_emergency_room_tel1() {
        return m_emergency_room_tel1;
    }

    public String getM_emergency_room_serviceable() {
        return m_emergency_room_serviceable;
    }


    public String getM_emergency_room_date() {
        return m_emergency_room_date;
    }


    public void setM_emergency_room_name(String m_emergency_room_name) {
        this.m_emergency_room_name = m_emergency_room_name;
    }


    public void setM_emergency_room_tel1(String m_emergency_room_tel1) {
        this.m_emergency_room_tel1 = m_emergency_room_tel1;
    }
        public void setM_emergency_room_serviceable(String m_emergency_room_serviceable) {
        this.m_emergency_room_serviceable = m_emergency_room_serviceable;
    }

        public void setM_emergency_room_date(String m_emergency_room_date) {
        this.m_emergency_room_date = m_emergency_room_date;
    }
        
    public ArrayList<String> getParsedataList(){
        try {
            parasing();
        } catch (Exception e) {

        }
        return m_arList;
    }
    
    public void parasing() throws ParserConfigurationException, SAXException, IOException
    { 
   emergency_room []rom = new emergency_room[30];
    for(int i =0; i<30; i++)
    rom[i]= new emergency_room();
    
    int j=0;
    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String emergency_room_addr = "http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEmrrmRltmUsefulSckbdInfoInqire?serviceKey=K9v339FQcToCtDg3b0ESgGBfomZgqP4YlIN7220KO9nY6Gj7EJPx3n3J%2FycN%2FjSzpO4cAgITklMGW5NF%2BIC1mA%3D%3D&&STAGE1=%EB%B6%80%EC%82%B0%EA%B4%91%EC%97%AD%EC%8B%9C&numOfRows=30";
        Document n4 = builder.parse(emergency_room_addr);
        
         NodeList list4 =n4.getElementsByTagName("items");  
            for (Node node = list4.item(0).getFirstChild(); node != null; node = node.getNextSibling())
            {   
             if (node.getNodeName().equals("item"))
               {
                  for (Node node2 = node.getFirstChild(); node2 != null; node2 = node2.getNextSibling()) 
                   {
                   if (node2.getNodeName().equals("dutyName")) 
                   {
                   rom[j].setM_emergency_room_name(node2.getTextContent());
                       System.out.println(rom[j].getM_emergency_room_name());
                   }
                   if (node2.getNodeName().equals("dutyTel3")) 
                   {
                      rom[j].setM_emergency_room_tel1((node2.getTextContent()));
                       System.out.println(rom[j].getM_emergency_room_tel1());
                   }

                   if (node2.getNodeName().equals("hvec")) 
                   {
                      rom[j].setM_emergency_room_serviceable((node2.getTextContent()));
                       System.out.println(rom[j].getM_emergency_room_serviceable());
                   }
                   
                   if (node2.getNodeName().equals("hvidate"))
                   {
                       rom[j].setM_emergency_room_date((node2.getTextContent()));
                       System.out.println(rom[j].getM_emergency_room_date());
                   }
               }
                     j++;
                       if(j==30)
                           break;
                   
             }
         }
      }
    }

