/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author AlexF
 */
public class PagoContratoDetalle {
    public int pagoContratoDetalleId;
    public String pagoContratoDetalleDes;
    public int pagoContratoId;

    public int getPagoContratoDetalleId() {
        return pagoContratoDetalleId;
    }

    public void setPagoContratoDetalleId(int pagoContratoDetalleId) {
        this.pagoContratoDetalleId = pagoContratoDetalleId;
    }

    public String getPagoContratoDetalleDes() {
        return pagoContratoDetalleDes;
    }

    public void setPagoContratoDetalleDes(String pagoContratoDetalleDes) {
        this.pagoContratoDetalleDes = pagoContratoDetalleDes;
    }

    public int getPagoContratoId() {
        return pagoContratoId;
    }

    public void setPagoContratoId(int pagoContratoId) {
        this.pagoContratoId = pagoContratoId;
    }
    
    
}
