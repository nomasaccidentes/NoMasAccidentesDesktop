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
public class Cliente {
    public int cliente_id;
    public String cliente_nombre;
    public String cliente_direccion;
    public String cliente_rut;
    public int cliente_activo;
    public int rubro_id;
    public Rubro rubro;
    public String clienteCorreo;

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

    public String getCliente_direccion() {
        return cliente_direccion;
    }

    public void setCliente_direccion(String cliente_direccion) {
        this.cliente_direccion = cliente_direccion;
    }

    public String getCliente_rut() {
        return cliente_rut;
    }

    public void setCliente_rut(String cliente_rut) {
        this.cliente_rut = cliente_rut;
    }

    public int getCliente_activo() {
        return cliente_activo;
    }

    public void setCliente_activo(int cliente_activo) {
        this.cliente_activo = cliente_activo;
    }

    public int getRubro_id() {
        return rubro_id;
    }

    public void setRubro_id(int rubro_id) {
        this.rubro_id = rubro_id;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public String getClienteCorreo() {
        return clienteCorreo;
    }

    public void setClienteCorreo(String clienteCorreo) {
        this.clienteCorreo = clienteCorreo;
    }

  
    
    
    
}
