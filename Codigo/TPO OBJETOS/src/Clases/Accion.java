package Clases;

public class Accion {
    private int idAccion;
    private String tipo;
    SocioProtector socioProtector;
    SocioParticipe socioParticipe;

    public Accion(int idAccion, String tipo) {
        this.idAccion = idAccion;
        this.tipo = tipo;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
