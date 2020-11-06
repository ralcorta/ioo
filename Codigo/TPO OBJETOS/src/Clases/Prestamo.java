package Clases;
import java.util.Date;

public class Prestamo {
    private String banco;
    private float tasa;
    private Date fechaDeAcreditacion;
    private int cantidadDeCuotas;
    private String sistema;
    Operacion operacion;

    public Prestamo(String banco, float tasa, Date fechaDeAcreditacion, int cantidadDeCuotas, String sistema) {
        this.banco = banco;
        this.tasa = tasa;
        this.fechaDeAcreditacion = fechaDeAcreditacion;
        this.cantidadDeCuotas = cantidadDeCuotas;
        this.sistema = sistema;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public Date getFechaDeAcreditacion() {
        return fechaDeAcreditacion;
    }

    public void setFechaDeAcreditacion(Date fechaDeAcreditacion) {
        this.fechaDeAcreditacion = fechaDeAcreditacion;
    }

    public int getCantidadDeCuotas() {
        return cantidadDeCuotas;
    }

    public void setCantidadDeCuotas(int cantidadDeCuotas) {
        this.cantidadDeCuotas = cantidadDeCuotas;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }
}
