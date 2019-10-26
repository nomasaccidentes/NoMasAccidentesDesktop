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
public class EstadoSolicitudCombobox {
    public int ESTADO_SOLICITUD_ID;
    public String ESTADO_SOLICITUD_NOMBRE;

    public EstadoSolicitudCombobox(int ESTADO_SOLICITUD_ID, String ESTADO_SOLICITUD_NOMBRE) {
        this.ESTADO_SOLICITUD_ID = ESTADO_SOLICITUD_ID;
        this.ESTADO_SOLICITUD_NOMBRE = ESTADO_SOLICITUD_NOMBRE;
    }

    public EstadoSolicitudCombobox() {
    }
    
    
    

    public int getESTADO_SOLICITUD_ID() {
        return ESTADO_SOLICITUD_ID;
    }

    public void setESTADO_SOLICITUD_ID(int ESTADO_SOLICITUD_ID) {
        this.ESTADO_SOLICITUD_ID = ESTADO_SOLICITUD_ID;
    }

    public String getESTADO_SOLICITUD_NOMBRE() {
        return ESTADO_SOLICITUD_NOMBRE;
    }

    public void setESTADO_SOLICITUD_NOMBRE(String ESTADO_SOLICITUD_NOMBRE) {
        this.ESTADO_SOLICITUD_NOMBRE = ESTADO_SOLICITUD_NOMBRE;
    }

    @Override
    public String toString() {
        return ESTADO_SOLICITUD_NOMBRE;
    }
 

  
    
    
}
