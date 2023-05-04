package t05.pkg001.pkg09;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos) {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
    }

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return getFechaNacimiento('-');
    }

    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    public String getFechaNacimiento(char separador) {
        String fecha = null;
        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%02d%c%02d%c%d", fechaNacimiento.getDayOfMonth(), separador, fechaNacimiento.getMonthValue(), separador, fechaNacimiento.getYear());
            }
        }
        return fecha;
    }

    private LocalDate generarFecha(String fecha) {
        LocalDate resultado;
        int dia, mes, anyo;

        String regex = "([0][1-9]|[12][0-9]|3[01])(\\/|-)([0][1-9]|[1][0-2])\\2(\\d{4})";
        if (!fecha.matches(regex)) {
            throw new IllegalArgumentException();
        } else {
            try {
                dia = Integer.parseInt(fecha.substring(0, 2));
                mes = Integer.parseInt(fecha.substring(3, 5));
                anyo = Integer.parseInt(fecha.substring(6, 10));
                resultado = LocalDate.of(anyo, mes, dia);
            } catch (NumberFormatException | DateTimeException ex) {
                throw new IllegalArgumentException();
            }
        }
        return resultado;
    }

    public int getEdadEnFecha(String cadenaFecha) throws IllegalArgumentException {
        int edad = 0;
        LocalDate fecha;

        fecha = generarFecha(cadenaFecha);
        edad = fecha.getYear() - fechaNacimiento.getYear();
        if (fechaNacimiento.getMonthValue() > fecha.getMonthValue()
                || (fechaNacimiento.getMonthValue() == fecha.getMonthValue() && fechaNacimiento.getDayOfMonth() > fecha.getDayOfMonth())) {
            edad = edad - 1;
        }
        return edad;

    }

    public int getEdad() {
        int edad = 0;
        LocalDate fecha = LocalDate.now();

        if (fechaNacimiento.getYear() > fecha.getYear()
                || fechaNacimiento.getYear() == fecha.getYear() && (fechaNacimiento.getMonthValue() > fecha.getMonthValue())
                || fechaNacimiento.getYear() == fecha.getYear() && fechaNacimiento.getMonthValue() == fecha.getMonthValue() && (fechaNacimiento.getDayOfMonth() > fecha.getDayOfMonth())) {
            edad = -1;
        } else {
            edad = fecha.getYear() - fechaNacimiento.getYear();
            if (fechaNacimiento.getMonthValue() > fecha.getMonthValue()
                    || (fechaNacimiento.getMonthValue() == fecha.getMonthValue() && fechaNacimiento.getDayOfMonth() > fecha.getDayOfMonth())) {
                edad = edad - 1;
            }
        }

        return edad;
    }

    @Override
    public String toString() {

        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.apellidos);
        hash = 17 * hash + Objects.hashCode(this.fechaNacimiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

}
