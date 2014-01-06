
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tapan
 */
public class XMLParser {
    
    private String title,description,imagelink;
    public void parseXml()
    {
        try 
        {
            URL url =new URL("http://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss");
            URLConnection conn = url.openConnection();
            
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc=dBuilder.parse(conn.getInputStream());
            
            doc.getDocumentElement().normalize();
        
            
            NodeList nList=doc.getElementsByTagName("item");
            Node nNode=nList.item(0);
          

                    if(nNode.getNodeType()==Node.ELEMENT_NODE)
                    {
                        Element eElement=(Element) nNode;
                        title=eElement.getElementsByTagName("title").item(0).getTextContent();
                        description=eElement.getElementsByTagName("description").item(0).getTextContent();
                        String temp=eElement.getElementsByTagName("enclosure").item(0).getAttributes().getNamedItem("url")+"";
                        imagelink=temp.replace("url=\"", "").replace("\"", "").trim();
                    }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    
    public String getTitle()
    {
        return title;
    }
    public String getDescription()
    {
        return description;
    }
    public String getImageLink()
    {
        return imagelink;
    }
    
}
