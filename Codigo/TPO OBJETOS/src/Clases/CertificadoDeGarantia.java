package Clases;

import java.util.Date;

public class CertificadoDeGarantia
{
    private String idCertificadoGarantia;
    private Date fechaEmision;
    Operacion operacion;

    public String getIdCertificadoGarantia() {
        return idCertificadoGarantia;
    }

    public void setIdCertificadoGarantia(String idCertificadoGarantia) {
        this.idCertificadoGarantia = idCertificadoGarantia;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public CertificadoDeGarantia(String idCertificadoGarantia, Date fechaEmision) {
        this.idCertificadoGarantia = idCertificadoGarantia;
        this.fechaEmision = fechaEmision;
    }
}
