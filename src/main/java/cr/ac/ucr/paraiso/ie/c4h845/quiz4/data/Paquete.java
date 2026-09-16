package cr.ac.ucr.paraiso.ie.c4h845.quiz4.data;

public class Paquete {
    public enum Estado {
        REGISTRADO,
        EN_TRANSITO,
        ENTREGADO
    }
    
    private long id;
    private String codigoRastreo;
    private String descripcion;
    private double pesoKg;
    private Estado estado;

    public Paquete() {
    }

    public Paquete(long id, String codigoRastreo, String descripcion, double pesoKg, Estado estado) {
        this.id = id;
        this.codigoRastreo = codigoRastreo;
        this.descripcion = descripcion;
        this.pesoKg = pesoKg;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoRastreo() {
        return codigoRastreo;
    }

    public void setCodigoRastreo(String codigoRastreo) {
        this.codigoRastreo = codigoRastreo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "id=" + id +
                ", codigoRastreo='" + codigoRastreo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", pesoKg=" + pesoKg +
                ", estado=" + estado +
                '}';
    }
    
    
}
