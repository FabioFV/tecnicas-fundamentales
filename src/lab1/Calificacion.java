package lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Calificacion {

    private static final String SEPARADOR = ",";
    private static final String FILENAME =  "Calificacion.csv";
    private static final String HEADER = "Matricula,Tarea,Nota";

    private static final int MATRICULA_INDEX = 0;
    private static final int TAREA_INDEX = 1;
    private static final int NOTA_INDEX = 2;

    private String mTarea;
    private float  mNota;
    private Estudiante mEstudiante;
    private String mMatricula;

    public Calificacion(Estudiante estudiante, String tarea, float nota){
        mTarea = tarea;
        mNota = nota;
        mEstudiante = estudiante;
        mMatricula = mEstudiante.getMatricula();
    }

    public Calificacion(String matricula, String tarea, float nota){
        mTarea = tarea;
        mNota = nota;
        mMatricula = matricula;
        mEstudiante = null;
    }

    public String getTarea() {
        return mTarea;
    }

    public float getNota() {
        return mNota;
    }

    public String getMatricula() {
        return mMatricula;
    }

    @Override
    public String toString() {
        return mMatricula + SEPARADOR + mTarea + SEPARADOR + mNota;
    }

    public static void guardar(Calificacion calificacion)
    {
        ArrayList<String> calificaciones = new ArrayList<>();
        calificaciones.add(calificacion.toString());

        if(new File("Calificacion.csv").exists())
            Writer.guardar(HEADER, FILENAME, true, calificaciones);
        else
            Writer.guardar(HEADER, FILENAME, false, calificaciones);
    }

    public static void listaCalificaciones()
    {
        String linea = "";
        BufferedReader fileReader = null;

        if(!new File("Calificacion.csv").exists())
        {
            System.out.println("No hay calificaciones registradas hasta el momento.\n");
            return;
        }


        try
        {
            fileReader = new BufferedReader(new FileReader("Calificacion.csv"));

            int cnt = 0;
            while ((linea = fileReader.readLine()) != null)
            {
                String[] data = linea.split(SEPARADOR);

                if (cnt > 0 && data.length > 0)
                {
                    System.out.println(cnt + ") " + data[MATRICULA_INDEX] + "       " + data[TAREA_INDEX] + "     " +Float.valueOf(data[NOTA_INDEX]));
                }
                else
                {
                    System.out.println("   " + data[MATRICULA_INDEX] + "   " + data[TAREA_INDEX] + "   " + data[NOTA_INDEX]);
                }
                cnt++;
            }



        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public static void borrar(String matricula)
    {

        String linea = "";
        List<Calificacion> calificaciones = new ArrayList<>();
        BufferedReader fileReader = null;

        if(!new File("Calificacion.csv").exists())
            return;

        try
        {
            fileReader = new BufferedReader(new FileReader("Calificacion.csv"));

            fileReader.readLine(); //Obviar el header

            while ((linea = fileReader.readLine()) != null)
            {

                String[] data = linea.split(SEPARADOR);

                if (data.length > 0)
                {
                    if(!data[MATRICULA_INDEX].equals(matricula))
                        calificaciones.add(new Calificacion(matricula, data[TAREA_INDEX], Float.valueOf(data[NOTA_INDEX])));
                }
            }

            //GENERAR NUEVO CSV

            ArrayList<String> calificacionesStr = new ArrayList<>();

            for (int i = 0; i < calificaciones.size(); i++)
                calificacionesStr.add(calificaciones.get(i).toString());

            Writer.guardar(HEADER, FILENAME, false, calificacionesStr);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    public static boolean borrarCalifTarea(String matricula, String tarea)
    {
        boolean trueDel = false;
        String linea = "";
        List<Calificacion> calificaciones = new ArrayList<>();
        BufferedReader fileReader = null;

        if(!new File("Calificacion.csv").exists()){
            System.out.println("No Existe ninguna calificacion registrada en la base de datos.");
            return false;
        }

        try
        {
            fileReader = new BufferedReader(new FileReader("Calificacion.csv"));

            fileReader.readLine(); //Obviar el header

            while ((linea = fileReader.readLine()) != null)
            {

                String[] data = linea.split(SEPARADOR);

                if (data.length > 0)
                {
                    if(!(data[MATRICULA_INDEX].equals(matricula) && data[TAREA_INDEX].equals(tarea)))
                        calificaciones.add(new Calificacion(matricula, data[TAREA_INDEX], Float.valueOf(data[NOTA_INDEX])));
                    else trueDel = true;
                }
            }

            //GENERAR NUEVO CSV

            ArrayList<String> calificacionesStr = new ArrayList<>();

            for (int i = 0; i < calificaciones.size(); i++)
                calificacionesStr.add(calificaciones.get(i).toString());

            Writer.guardar(HEADER, FILENAME, false, calificacionesStr);

            fileReader.close();

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return trueDel;
    }


}


