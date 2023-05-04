package t05.pkg001.pkg09;

import java.util.Scanner;

public class T0500109 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int caso;

        String nombre, apellido, fecha;
        Persona personaAnterior = null;
        Persona persona = null;

        
        caso = entrada.nextInt();
        entrada.nextLine();
        for (int i = 1; i <= caso; i++) {
            nombre = entrada.nextLine();
            apellido = entrada.nextLine();
            fecha = entrada.nextLine();
            if (i == 1) {
                try {
                    personaAnterior = new Persona(nombre, apellido, fecha);
                } catch (IllegalArgumentException exi) {
                }
            } else {
                try {
                    persona = new Persona(nombre, apellido, fecha);
                    if (personaAnterior != null && persona.equals(personaAnterior)) {
                        System.out.println(persona.toString() + " y " + personaAnterior.toString() + " son la misma");
                    } else {
                        try {
                            System.out.println(persona.toString() + " y " + personaAnterior.toString() + " son distintas");
                        } catch (NullPointerException exi) {
                            System.out.println("ERROR. Procesando siguiente persona");
                        }
                    }
                } catch (IllegalArgumentException exi) {
                    System.out.println("ERROR. Procesando siguiente persona");
                }
                personaAnterior = persona;
            }
        }

    }
}
