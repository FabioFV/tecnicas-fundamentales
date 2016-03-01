package lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private static final String SEPARADOR = ",";
    private static final String FILENAME =  "Estudiantes.csv";
    private static final String HEADER = "Matricula,Nombre,Apellido";

    private static final int MATRICULA_INDEX = 0;
    private static final int NOMBRE_INDEX = 1;
    private static final int APELLIDO_INDEX = 2;

    private String mMatricula;
    private String mNombre;
    private String mApellido;


    public Estudiante(String matricula, String nombre, String apellido){
        mMatricula = matricula;
        mNombre = nombre;
        mApellido = apellido;
    }

    public String getMatricula() {
        return mMatricula;
    }

    public String getNombre() {
        return mNombre;
    }

    public String getApellido() {
        return mApellido;
    }

    @Override
    public String toString() {
        return mMatricula + SEPARADOR + mNombre + SEPARADOR + mApellido;
    }

    public static void guardar(Estudiante estudiante)
    {
        ArrayList<String> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante.toString());

        if(new File("Estudiantes.csv").exists())
            Writer.guardar(HEADER, FILENAME, true, estudiantes);
        else
            Writer.guardar(HEADER, FILENAME, false, estudiantes);

    }

    public static Estudiante buscar(String matricula)
    {
        String linea = "";
        Estudiante estudiante = null;
        BufferedReader fileReader = null;

        if(!new File("Estudiantes.csv").exists())
            return estudiante;

        try
        {
            fileReader = new BufferedReader(new FileReader("Estudiantes.csv"));

            fileReader.readLine(); //Obviar el header

            while ((linea = fileReader.readLine()) != null) {

                String[] data = linea.split(SEPARADOR);

                if (data.length > 0)
                {
                    if(data[MATRICULA_INDEX].equals(matricula))
                    {
                        estudiante = new Estudiante(matricula, data[NOMBRE_INDEX], data[APELLIDO_INDEX]);
                        break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }


        return estudiante;
    }

    public static void listaEstudiantes()
    {
        String linea = "";
        BufferedReader fileReader = null;

        if(!new File("Estudiantes.csv").exists())
        {
            System.out.print("No hay estudiantes registrados hasta el momento.");
            return;
        }

        try
        {
            fileReader = new BufferedReader(new FileReader("Estudiantes.csv"));

            // fileReader.readLine(); //Obviar el header

            int cnt = 0;
            while ((linea = fileReader.readLine()) != null)
            {

                String[] data = linea.split(SEPARADOR);

                if (cnt > 0 && data.length > 0)
                {
                    System.out.println(cnt + ") " + data[MATRICULA_INDEX] + "     " + data[NOMBRE_INDEX] + "     " + data[APELLIDO_INDEX]);

                }
                else
                {
                    System.out.println("   " + data[MATRICULA_INDEX] + "   " + data[NOMBRE_INDEX] + "   " + data[APELLIDO_INDEX]);

                }
                cnt++;
            }

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }


    public static Estudiante borrar(String matricula)
    {

        String linea = "";
        List<Estudiante> estudiantes = new ArrayList<>();
        Estudiante estudiante = null;
        BufferedReader fileReader = null;

        try
        {
            //LEER Y OBTENER EL ESTUDIANTE
            fileReader = new BufferedReader(new FileReader("Estudiantes.sv"));

            fileReader.readLine(); //Obviar el header

            while ((linea = fileReader.readLine()) != null)
            {

                String[] data = linea.split(SEPARADOR);

                if (data.length > 0)
                {
                    if(data[MATRICULA_INDEX].equals(matricula))
                        estudiante = new Estudiante(matricula, data[NOMBRE_INDEX], data[APELLIDO_INDEX]);
                    else
                        estudiantes.add(new Estudiante(data[MATRICULA_INDEX], data[NOMBRE_INDEX], data[APELLIDO_INDEX]));
                }
            }

            //GENERAR NUEVO CSV

            ArrayList<String> estudiantesStr = new ArrayList<>();

            for (int i = 0; i < estudiantes.size(); i++)
                estudiantesStr.add(estudiantes.get(i).toString());

            Writer.guardar(HEADER, FILENAME, false, estudiantesStr);

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

        return estudiante;
    }
}
