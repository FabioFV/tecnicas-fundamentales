package lab1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        menu();
    }

    private static void menu()
    {
        Scanner in = new Scanner(System.in);
        boolean active = true;

        while(active)
        {
            System.out.println("\n-------------- MENU PRINCIPAL --------------\n");
            System.out.println("1) Registrar un nuevo estudiante");
            System.out.println("2) Borrar un estudiante. [Por Matricula]");
            System.out.println("3) Registrar una calificacion para un estudiante.");
            System.out.println("4) Borrar una calificacion de un estudiante");
            System.out.println("5) Mostrar Lista de Estudiantes Registrados.");
            System.out.println("6) Mostrar Lista de Calificaciones.");
            System.out.println("7) Salir");

            int entrada = in.nextInt();
            switch(entrada)
            {
                case 1 :
                    registrarEstudiante();
                    break;
                case 2 :
                    borrarEstudiante();
                    break;
                case 3 :
                    registrarCalificacion();
                    break;
                case 4 :
                    borrarCalificacion();
                    break;
                case 5 :
                    listarEstudiantes();
                    break;
                case 6 :
                    listarCalificaciones();
                    break;
                case 7 :
                    System.out.println("Adios.");
                    active = false;
                    break;
                default :
                    System.out.println("Elige una de las opciones anteriores. Gracias.");
                    break;
            }
        }


    }

    private static void registrarEstudiante()
    {
        String matricula;
        String nombre;
        String apellido;

        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca la nueva matricula");
        matricula = in.next();

        if(Estudiante.buscar(matricula) == null)
        {
            System.out.println("Introduzca el nombre del estudiante");
            nombre = in.next();
            System.out.println("Introduzca el apellido del estudiante");
            apellido = in.next();

            Estudiante tempEstudiante = new Estudiante(matricula, nombre, apellido);

            System.out.println("Datos del estudiante:");
            System.out.println("Matricula: " + tempEstudiante.getMatricula());
            System.out.println("Nombre: " + tempEstudiante.getNombre() + " " + tempEstudiante.getApellido());

            System.out.println("\nDesea continuar...");
            System.out.println("1) No");
            System.out.println("2) Si");

            switch(in.nextInt())
            {
                case 2 :
                    Estudiante.guardar(tempEstudiante);
                    System.out.println("Estudiante registrado exitosamente.");
                    break;
                default :
                    System.out.println("El estudiante no ha sido registrado.");
                    break;
            }
        }
        else
        {
            System.out.println("La matricula introducida pertenece a un estudiante existente.");
        }


    }
    private static void listarCalificaciones(){
        System.out.print("\n-------------- Lista de Calificaciones --------------\n");
        Calificacion.listaCalificaciones();

    }
    private static void listarEstudiantes(){
        System.out.print("\n-------------- Lista de Estudiantes --------------\n");
        Estudiante.listaEstudiantes();
    }

    private static void borrarEstudiante()
    {
        String matricula;
        Scanner in = new Scanner(System.in);
        System.out.println("Introducir la matricula del estudiante que desea borrar");
        matricula = in.next();

        Estudiante temp = Estudiante.buscar(matricula);

        if(temp != null)
        {
            System.out.println("Datos del estudiante:");
            System.out.println("Matricula: " + temp.getMatricula());
            System.out.println("Nombre: " + temp.getNombre() + " " + temp.getApellido());

            System.out.println("\nRealmente desea borrar al estudiante: ");
            System.out.println("1) No");
            System.out.println("2) Si");

            switch(in.nextInt())
            {
                case 2 :
                    Estudiante.borrar(matricula);
                    Calificacion.borrar(matricula);
                    System.out.println("El estudiante: " + temp.getNombre() + " " + temp.getApellido() + " ha sido borrado exitosamente");
                    break;
                default :
                    System.out.println("El estudiante no ha sido borrado.");
                    break;
            }
        }
        else
        {
            System.out.println("El estudiante no existe. Favor introducir una matricula valida");
        }

    }

    private static void registrarCalificacion()
    {
        String matricula;
        String tarea;
        float nota;

        Scanner in = new Scanner(System.in);

        System.out.println("Introduzca la matricula del estudiante");
        matricula = in.next();

        Estudiante tempEstudiante = Estudiante.buscar(matricula);
        if(tempEstudiante == null)
        {
            System.out.println("El estudiante no existe. Favor comprobar la matricula");
        }
        else
        {
            System.out.println("Introduzca el nombre de la tarea");
            tarea = in.next();

            System.out.println("Introduzca la calificacion obtenida");
            nota = in.nextFloat();

            Calificacion tempCalificacion = new Calificacion(tempEstudiante, tarea, nota);

            System.out.println("Calificacion a introducir:");
            System.out.println("Matricula: " + matricula);
            System.out.println("Nombre: "  + tempEstudiante.getNombre() + " " + tempEstudiante.getApellido());
            System.out.println("Tarea: " + tempCalificacion.getTarea());
            System.out.println("Calificacion: " + tempCalificacion.getNota());
            System.out.println("\nDesea introducir la calificacion: ");
            System.out.println("1) No");
            System.out.println("2) Si");

            switch(in.nextInt())
            {
                case 2 :
                    Calificacion.guardar(tempCalificacion);
                    System.out.println("Calificación guardada.");
                    break;
                default :
                    System.out.println("La calificación no ha sido guardada.");
                    break;
            }

        }
    }
    private static void borrarCalificacion(){
        String matricula;
        Scanner in = new Scanner(System.in);
        System.out.println("Introducir la matricula del estudiante que desea borrar");
        matricula = in.next();
        System.out.println("Introducir el nombre de la tarea que desea borrar");
        String tarea = in.next();

        Estudiante temp = Estudiante.buscar(matricula);
        boolean state = false;

        if(temp != null)
        {
            System.out.println("Datos del estudiante:");
            System.out.println("Matricula: " + temp.getMatricula());
            System.out.println("Nombre: " + temp.getNombre() + " " + temp.getApellido());

            System.out.println("\nRealmente desea borrar la calificacion del estudiante: ");
            System.out.println("1) No");
            System.out.println("2) Si");

            switch(in.nextInt())
            {
                case 2 :
                    state = Calificacion.borrarCalifTarea(matricula, tarea);
                    if(state)
                        System.out.println("La calificacion de la tarea " + tarea + " del estudiante " + temp.getNombre() + " " + temp.getApellido() + ", ha sido borrado exitosamente");
                    else
                        System.out.println("No se encontro una calificacion correspondiente con los datos ingresados.");
                    break;
                default :
                    System.out.println("La calificacion no ha sido borrada.");
                    break;
            }
        }
        else
        {
            System.out.println("El estudiante y/o tarea no existe. Favor introducir una matricula valida y/o tarea valida");
        }


    }

}
