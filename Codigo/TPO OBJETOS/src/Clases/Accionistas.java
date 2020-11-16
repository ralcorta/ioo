package Clases;

import java.util.ArrayList;

public class Accionistas
{
    private String cuit;
    private int porcentajeDeParticipacion;
    private String razonSocial;
    ArrayList <SocioProtector> listaDeSociosProtectores = new ArrayList <SocioProtector>();
    ArrayList <SocioParticipe> listaDeSociosParticipes = new ArrayList <SocioParticipe>();

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public int getPorcentajeDeParticipacion() {
        return porcentajeDeParticipacion;
    }

    public void setPorcentajeDeParticipacion(int porcentajeDeParticipacion) {
        this.porcentajeDeParticipacion = porcentajeDeParticipacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Accionistas(String cuit, int porcentajeDeParticipacion, String razonSocial) {
        this.cuit = cuit;
        this.porcentajeDeParticipacion = porcentajeDeParticipacion;
        this.razonSocial = razonSocial;
    }
}
