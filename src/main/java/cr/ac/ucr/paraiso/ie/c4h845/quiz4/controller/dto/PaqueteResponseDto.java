package cr.ac.ucr.paraiso.ie.c4h845.quiz4.controller.dto;

public class PaqueteResponseDto {
    private long id;
    private String codigoRastreo;
    private String descripcion;
    private double pesoKg;
    private String estado;

    public PaqueteResponseDto() {
    }

    public PaqueteResponseDto(long id, String codigoRastreo, String descripcion, double pesoKg, String estado) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
