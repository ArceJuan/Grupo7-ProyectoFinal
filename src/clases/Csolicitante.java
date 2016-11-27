
package clases;

public class Csolicitante extends Cpersona{
    private String codigo_solicitante;

    public Csolicitante() {
    }

    public Csolicitante(String codigo_solicitante) {
        this.codigo_solicitante = codigo_solicitante;
    }

    public String getCodigo_solicitante() {
        return codigo_solicitante;
    }

    public void setCodigo_solicitante(String codigo_solicitante) {
        this.codigo_solicitante = codigo_solicitante;
    }
    
}
