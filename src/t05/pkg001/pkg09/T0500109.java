package t05.pkg001.pkg09;
import java.util.Scanner;

public class T0500109 {

    public static void main(String[] args) {
        
       Scanner entrada = new Scanner(System.in);
        int numConFecha;
        int numSinFecha;
        boolean fechaCorrecto = true;
        String nombre, apellido, fecha;
        String fechaPersona;
        numConFecha = entrada.nextInt();
        numSinFecha = entrada.nextInt();
        entrada.nextLine();

        for (int i = 1; i <= numConFecha; i++) {

            try {
                nombre = entrada.nextLine();
                apellido = entrada.nextLine();
                fecha = entrada.nextLine();
                Persona persona1 = new Persona(nombre, apellido, fecha);
                fechaPersona = persona1.getFechaNacimiento();

                System.out.println("Procesado: " + persona1.getNombre() + " " + persona1.getApellidos() +
                ", nacido el " + fechaPersona.substring(0, 2) + " del " 
                + fechaPersona.substring(3, 5) + " de " + fechaPersona.substring(6, fechaPersona.length()));
            } catch (IllegalArgumentException exi) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }
        fechaPersona = "";
       
        for (int i = 1; i <= numSinFecha; i++) {
            nombre = entrada.nextLine();
            apellido = entrada.nextLine();
            try {
                Persona persona1 = new Persona(nombre, apellido);
                fechaPersona = persona1.getFechaNacimiento();
                System.out.println("Procesado: " + persona1.getNombre() + " " + persona1.getApellidos() + ", nacido el " + fechaPersona);

               
                if (i == numSinFecha) {
                    while (fechaCorrecto) {
                        try {
                            fecha = entrada.nextLine();
                            persona1.setFechaNacimiento(fecha);
                            fechaCorrecto = false;
                            fechaPersona = persona1.getFechaNacimiento();
                            System.out.println("Procesado: " + persona1.getNombre() + " " + persona1.getApellidos() + ", nacido el "+ fechaPersona.substring(0, 2) + " del " 
                + fechaPersona.substring(3, 5) + " de " + fechaPersona.substring(6, fechaPersona.length()));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Fecha Incorrecta");
                        }

                    }
                }
            } catch (IllegalArgumentException exi) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }
    }
}
