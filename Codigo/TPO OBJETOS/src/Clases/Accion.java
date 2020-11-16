package Clases;

public class Accion {
    private String idAccion;
    private String tipo;
    SocioProtector socioProtector;
    SocioParticipe socioParticipe;

    public Accion(String idAccion, String tipo) {
        this.idAccion = idAccion;
        this.tipo = tipo;
    }

    public String getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(String idAccion) {
        this.idAccion = idAccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
