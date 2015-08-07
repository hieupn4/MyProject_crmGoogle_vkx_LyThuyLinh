/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conttroler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Administrator
 */
public class writeFile {
    public static void writefi(String url,String content) throws IOException
    {
        
        BufferedWriter output = null;
        try {
            File file = new File(url);
            output = new BufferedWriter(new FileWriter(file));
            output.write(content);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) output.close();
        }         
    }
    public static String readfi(String url)
    {
        return null;
    }
}
