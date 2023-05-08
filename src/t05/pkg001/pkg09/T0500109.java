package t05.pkg001.pkg09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class T0500109 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ArrayList<Persona> alumnos = new ArrayList<>();
        int caso, cantidad, edad, edadpersona;
        String nombre, apellido, fecha, fechaReferencia;
        Persona persona = null;

        caso = entrada.nextInt();
        entrada.nextLine();
        for (int i = 1; i <= caso; i++) {
            nombre = entrada.nextLine();
            apellido = entrada.nextLine();
            fecha = entrada.nextLine();
            try {
                persona = new Persona(nombre, apellido, fecha);
                alumnos.add(persona);
            } catch (IllegalArgumentException ex) {

                System.out.println("ERROR procesando alumno " + nombre + ". Procesando siguiente alumno");
            }
        }

        cantidad = entrada.nextInt();

        for (int i = 1; i <= cantidad; i++) {
            entrada.nextLine();
            fechaReferencia = entrada.nextLine();
            edad = entrada.nextInt();
            

            System.out.println("CASO " + i);
            System.out.println("----------");
            Iterator<Persona> iterator = alumnos.iterator();
            while (iterator.hasNext()) {
                Persona alumno = iterator.next();
                edadpersona = alumno.getEdadEnFecha(fechaReferencia);
                if (edadpersona > 0 && edadpersona < edad) {
                    System.out.println(alumno.toString());
                }
            }

        }
        alumnos.clear();

    }
}
