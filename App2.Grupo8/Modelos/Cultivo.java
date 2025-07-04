package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cultivo extends ElementoAgricola {
    private String variedad;
    private double superficie;
    private String codigoParcela;
    private List<Actividad> actividades;

    public Cultivo(String nombre, String variedad, double superficie, String codigoParcela, LocalDate fecha, String estado) {
        super(nombre, fecha, estado);
        this.variedad = variedad;
        this.superficie = superficie;
        this.codigoParcela = codigoParcela;
        this.actividades = new ArrayList<>();
    }

    public String getVariedad() {
        return variedad;
    }

    public double getSuperficie() {
        return superficie;
    }

    public String getCodigoParcela() {
        return codigoParcela;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setCodigoParcela(String codigoParcela) {
        this.codigoParcela = codigoParcela;
    }

    public void agregarActividad(Actividad a) {
        actividades.add(a);
    }

    @Override
    public String toCSV() {
        String actStr = actividades.stream()
            .map(Actividad::toString)
            .collect(Collectors.joining("\",\"", "[\"", "\"]"));
        return String.format("Cultivo,\"%s\",\"%s\",%.2f,\"%s\",\"%s\",\"%s\",%s",
                getNombre(), variedad, superficie, codigoParcela, getFecha().toString(), getEstado(), actStr);
    }

    @Override
    public String toString() {
        return getNombre() + " (" + variedad + ") - " + getEstado() + " en " + codigoParcela;
    }

    public static Cultivo desdeCSV(String linea) {
        String[] partes = linea.split(",");
        String nombre = partes[0];
        String variedad = partes[1];
        double superficie = Double.parseDouble(partes[2]);
        String codigoParcela = partes[3];
        LocalDate fecha = LocalDate.parse(partes[4]);
        String estado = partes[5];
        return new Cultivo(nombre, variedad, superficie, codigoParcela, fecha, estado);
    }
}
