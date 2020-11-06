package Clases;

import java.util.Date;

public class CertificadoDeGarantia
{
    private int idCertificadoGarantia;
    private Date fechaEmision;
    Operacion operacion;

    public int getIdCertificadoGarantia() {
        return idCertificadoGarantia;
    }

    public void setIdCertificadoGarantia(int idCertificadoGarantia) {
        this.idCertificadoGarantia = idCertificadoGarantia;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public CertificadoDeGarantia(int idCertificadoGarantia, Date fechaEmision) {
        this.idCertificadoGarantia = idCertificadoGarantia;
        this.fechaEmision = fechaEmision;
    }
}
