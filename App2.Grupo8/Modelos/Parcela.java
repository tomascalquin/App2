package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Parcela {
    private String codigo;
    private String ubicacion;
    private double tamano;
    private List<Cultivo> cultivos;

    public Parcela(String codigo, String ubicacion, double tamano) {
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.tamano = tamano;
        this.cultivos = new ArrayList<>();
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getTamano() {
        return tamano;
    }

    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    public void agregarCultivo(Cultivo cultivo) {
        cultivos.add(cultivo);
    }

    public void eliminarCultivo(Cultivo cultivo) {
        cultivos.remove(cultivo);
    }

    @Override
    public String toString() {
        return codigo + " - " + ubicacion + " (" + tamano + " ha)";
    }
}
