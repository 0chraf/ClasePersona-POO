package t05.pkg001.pkg09;

import java.util.Scanner;

public class T0500109 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int caso;
        int casoFecha, edad;
        String nombre, apellido, fecha, fechaActual;

        caso = entrada.nextInt();
        entrada.nextLine();
        for (int i = 1; i <= caso; i++) {
            nombre = entrada.nextLine();
            apellido = entrada.nextLine();
            fecha = entrada.nextLine();
            try {
                Persona persona = new Persona(nombre, apellido, fecha);
                casoFecha = entrada.nextInt();
                entrada.nextLine();
                for (int j = 1; j <= casoFecha; j++) {
                    fechaActual = entrada.nextLine();
                    try {
                        edad = persona.getEdadEnFecha(fechaActual);
                        if (edad < 0) {
                            System.out.println(persona.getNombre() + " " + persona.getApellidos() + " aun no ha nacido a fecha " + fechaActual);
                        } else {
                            System.out.println(persona.getNombre() + " " + persona.getApellidos() + " tendra " + edad + " anyos en fecha " + fechaActual);
                        }
                    } catch (IllegalArgumentException exa) {
                        System.out.println("ERROR. Procesando siguiente fecha");
                    }
                }
            } catch (IllegalArgumentException exi) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }
    }
}

