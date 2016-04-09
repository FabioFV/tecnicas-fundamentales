package lab3;

import java.io.*;

/**
 * Created by Fabio Ferreras on 4/2/2016.
 */
public class Reader {

    Reader(File file)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = null;
            int count = 0;
            while ((linea = br.readLine()) != null)
            {
                String palabra = linea.toLowerCase();
                if(palabra.equals(new StringBuilder(palabra).reverse().toString()))
                    count++;
            }
            System.out.println(file.getName() + ": " + count + " palindromos.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}
