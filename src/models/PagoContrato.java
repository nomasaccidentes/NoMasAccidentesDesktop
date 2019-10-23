/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author AlexF
 */
public class PagoContrato {
    public String pagoContratoDescripcion;
    public String pagoContratoVcto;
    public int clienteId;

    public PagoContrato() {
    }


    public String getPagoContratoDescripcion() {
        return pagoContratoDescripcion;
    }

    public void setPagoContratoDescripcion(String pagoContratoDescripcion) {
        this.pagoContratoDescripcion = pagoContratoDescripcion;
    }

    public String getPagoContratoVcto() {
        return pagoContratoVcto;
    }

    public void setPagoContratoVcto(String pagoContratoVcto) {
        this.pagoContratoVcto = pagoContratoVcto;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "PagoContrato{" + ", pagoContratoDescripcion=" + pagoContratoDescripcion + ", pagoContratoVcto=" + pagoContratoVcto + ", clienteId=" + clienteId + '}';
    }
    
    
    
    
}
