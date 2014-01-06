
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tapan
 */
public class SaveImage {
    private String imageurl;
    public SaveImage(String link)
    {
        imageurl=link;
    }
    public void getImage()
    {
        try {
          
            URL url=new URL(imageurl);
            InputStream is =url.openStream();
            OutputStream os=new FileOutputStream("img.jpg");
            byte[] b=new byte[2048];
            int length;
            while ((length=is.read(b))!=-1)
            {
                os.write(b,0,length);
            }
                    
            is.close();
            os.close();
            
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error while writing");
           
        }
    }
}
