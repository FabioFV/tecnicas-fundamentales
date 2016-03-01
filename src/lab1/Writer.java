package lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Programming on 2/17/2016.
 */
public class Writer {

    private static final String NUEVA_LINEA =  "\n";

    public static void guardar(String header, String filename, Boolean exists, ArrayList<String> lines)
    {
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter(filename, exists);
            if(!exists)
            {
                fileWriter.append(header);
                fileWriter.append(NUEVA_LINEA);
            }

            for (int i = 0; i < lines.size(); i++) {
                fileWriter.append(lines.get(i));
                fileWriter.append(NUEVA_LINEA);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            try
            {
                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException e)
            {
                System.out.println(e.toString());
            }
        }
    }

}
