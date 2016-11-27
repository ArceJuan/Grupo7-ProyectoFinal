package clases;

public class Caula {
    private int idaula;
    private String numero;
    private String piso;
    private String descripcion;
    private String caracteristicas;
    private String estado;
    private String tipo_aula;

    public Caula(int idaula, String numero, String piso, String descripcion, String caracteristicas, String estado, String tipo_aula) {
        this.idaula = idaula;
        this.numero = numero;
        this.piso = piso;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
        this.tipo_aula = tipo_aula;
    }

    public Caula() {
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_aula() {
        return tipo_aula;
    }

    public void setTipo_aula(String tipo_aula) {
        this.tipo_aula = tipo_aula;
    }

    
    
    
    
    
}
