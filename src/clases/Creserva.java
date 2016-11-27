
package clases;

public class Creserva {
    private int idreserva;
    private int idaula;
    private int idsolicitante;
    private int idtrabajador;

    public Creserva() {
    }

    public Creserva(int idreserva, int idaula, int idsolicitante, int idtrabajador) {
        this.idreserva = idreserva;
        this.idaula = idaula;
        this.idsolicitante = idsolicitante;
        this.idtrabajador = idtrabajador;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    public int getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(int idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }


    
    
    
}
