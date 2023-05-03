package t05.pkg001.pkg09;

import java.util.Scanner;

public class T0500109 {

   public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int caso;
        
        String nombre, apellido, fecha;

        caso = entrada.nextInt();
        entrada.nextLine();
        for (int i = 1; i <= caso; i++) {
            nombre = entrada.nextLine();
            apellido = entrada.nextLine();
            fecha = entrada.nextLine();
            try {
            Persona persona = new Persona(nombre, apellido, fecha);
            System.out.println(persona.getNombre()+" "+persona.getApellidos() +" tiene "+persona.getEdad()+ " anyos a dia de hoy");
            } catch (IllegalArgumentException exi){
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }
                
    }
}

