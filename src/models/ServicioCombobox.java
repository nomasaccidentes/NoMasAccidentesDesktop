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
public class ServicioCombobox {
    public int servicio_id;
    
    public String servicio_nombre;

    public ServicioCombobox(int servicio_id, String servicio_nombre) {
        this.servicio_id = servicio_id;
        this.servicio_nombre = servicio_nombre;
    }

    public ServicioCombobox() {
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getServicio_nombre() {
        return servicio_nombre;
    }

    public void setServicio_nombre(String servicio_nombre) {
        this.servicio_nombre = servicio_nombre;
    }

    @Override
    public String toString() {
        return servicio_nombre;
    }
    
    
}
