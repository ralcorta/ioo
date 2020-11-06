package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SociosController
{
    ArrayList <SocioProtector> listaDeSociosProtectores = new ArrayList<SocioProtector>();
    ArrayList <SocioParticipe> listaDeSociosParticipes = new ArrayList <SocioParticipe>();
    OperacionController controlador;

    public void registrarDocumentacion(String tipoDoc, Date fechaDeRecepcion, String estado, String usuario){

    }

    public boolean aprobarSocio(int cuit){

        return true;
    }

    public int cambiarEstadoDocumentacion(int cuit, String estado){

        return 0;
    }

    public void registrarAporte(float monto){

    }

    public void calcularComisionSocio(String tipoOperacion, int cuit){

    }

    public void calcularMoraSocio(int cuit) {

    }

    public void consultarRiesgo(int cuit) {

    }



}
