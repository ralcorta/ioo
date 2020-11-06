package Clases;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class Operacion {
    private int idOperacion;
    private String tipoDeOperacion;
    private String subtipoOperacion;
    private String estado;
    private Date fechaCambioEstado;
    private String estadoAnterior;
    private String usuarioModificador;
    private String garantia;
    private Currency importe;
    private Date fechaCreacionOperacion;
    private Date fechaVencimiento;
    private int cuotasPagadas;
    private int cantidadTotalCuotas;
    private float importeUtilizado;
    LineaDeCredito linea;
    Comision comision;
    CertificadoDeGarantia certificadoGarantia;
    ArrayList <Cheque> cheques = new ArrayList<Cheque>();
    ArrayList <Prestamo> prestamos = new ArrayList<Prestamo>();
    ArrayList <CuentaCorriente> cuentasCorrientes = new ArrayList<CuentaCorriente>();

    public Operacion(int idOperacion, String tipoDeOperacion, String subtipoOperacion, String estado, Date fechaCambioEstado, String estadoAnterior, String usuarioModificador, String garantia, Currency importe, Date fechaCreacionOperacion, Date fechaVencimiento, int cuotasPagadas, int cantidadTotalCuotas, float importeUtilizado) {
        this.idOperacion = idOperacion;
        this.tipoDeOperacion = tipoDeOperacion;
        this.subtipoOperacion = subtipoOperacion;
        this.estado = estado;
        this.fechaCambioEstado = fechaCambioEstado;
        this.estadoAnterior = estadoAnterior;
        this.usuarioModificador = usuarioModificador;
        this.garantia = garantia;
        this.importe = importe;
        this.fechaCreacionOperacion = fechaCreacionOperacion;
        this.fechaVencimiento = fechaVencimiento;
        this.cuotasPagadas = cuotasPagadas;
        this.cantidadTotalCuotas = cantidadTotalCuotas;
        this.importeUtilizado = importeUtilizado;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getTipoDeOperacion() {
        return tipoDeOperacion;
    }

    public void setTipoDeOperacion(String tipoDeOperacion) {
        this.tipoDeOperacion = tipoDeOperacion;
    }

    public String getSubtipoOperacion() {
        return subtipoOperacion;
    }

    public void setSubtipoOperacion(String subtipoOperacion) {
        this.subtipoOperacion = subtipoOperacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCambioEstado() {
        return fechaCambioEstado;
    }

    public void setFechaCambioEstado(Date fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public Currency getImporte() {
        return importe;
    }

    public void setImporte(Currency importe) {
        this.importe = importe;
    }

    public Date getFechaCreacionOperacion() {
        return fechaCreacionOperacion;
    }

    public void setFechaCreacionOperacion(Date fechaCreacionOperacion) {
        this.fechaCreacionOperacion = fechaCreacionOperacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCuotasPagadas() {
        return cuotasPagadas;
    }

    public void setCuotasPagadas(int cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
    }

    public int getCantidadTotalCuotas() {
        return cantidadTotalCuotas;
    }

    public void setCantidadTotalCuotas(int cantidadTotalCuotas) {
        this.cantidadTotalCuotas = cantidadTotalCuotas;
    }

    public float getImporteUtilizado() {
        return importeUtilizado;
    }

    public void setImporteUtilizado(float importeUtilizado) {
        this.importeUtilizado = importeUtilizado;
    }

    public void generarComision(int idComision, String estado, Date fechaCambioEstado, String estadoAnterior){
        Comision comision = new Comision(idComision, estado, fechaCambioEstado, estadoAnterior);
        this.comision = comision;
    }

    public void emitirCertificadoGarantia(int idCertificadoGarantia, Date fechaEmision){
        CertificadoDeGarantia certificadoDeGarantia = new CertificadoDeGarantia(idCertificadoGarantia, fechaEmision);
        this.certificadoGarantia = certificadoDeGarantia;
    }

    public void crearCheque(String banco, int numero, Date fechaDeVencimiento, String cuit, float tasaDeDescuento){
        Cheque cheque = new Cheque(banco, numero, fechaDeVencimiento, cuit, tasaDeDescuento);
        cheques.add(cheque);
    }

    public void crearPrestamo(String banco, float tasa, Date fechaDeAcreditacion, int cantidadDeCuotas, String sistema){
        Prestamo prestamo = new Prestamo(banco, tasa, fechaDeAcreditacion, cantidadDeCuotas, sistema);
        prestamos.add(prestamo);
    }

    public void crearCuentaCorriente(String nombreEmpresa, Date fechaDeVencimiento){
        CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreEmpresa, fechaDeVencimiento);
        cuentasCorrientes.add(cuentaCorriente);
    }
}
