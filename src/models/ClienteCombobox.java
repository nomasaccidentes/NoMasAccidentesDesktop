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
public class ClienteCombobox {
    public int cliente_id;
    public String cliente_nombre;

    public ClienteCombobox(int cliente_id, String cliente_nombre) {
        this.cliente_id = cliente_id;
        this.cliente_nombre = cliente_nombre;
    }



    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nombre() {
        return cliente_nombre;
    }

    public void setCliente_nombre(String cliente_nombre) {
        this.cliente_nombre = cliente_nombre;
    }

    @Override
    public String toString() {
        return cliente_nombre;
    }
    
    
}
