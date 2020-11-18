package Clases;

import java.util.Date;

public class Cheque {
    private String banco;
    private int numero;
    private Date fechaDeVencimiento;
    private String cuit;
    private float tasaDeDescuento;
    private float importe;
    Operacion operacion;

    public Cheque(String banco, int numero, Date fechaDeVencimiento, String cuit, float tasaDeDescuento, float importe) {
        this.banco = banco;
        this.numero = numero;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.cuit = cuit;
        this.tasaDeDescuento = tasaDeDescuento;
        this.importe = importe;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public float getTasaDeDescuento() {
        return tasaDeDescuento;
    }

    public void setTasaDeDescuento(float tasaDeDescuento) {
        this.tasaDeDescuento = tasaDeDescuento;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
