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
public class Usuario {
    
    public final int ADMIN = 1;
    public final int CLIENTE = 3;
    public final int PROFESIONAL = 2;
    
    
    
    public int usuario_id;
    public String usuario_username;
    public String usuario_clave;

    public Cliente cliente;
    public Profesional profesional;
    public Rol rol;
    public int usuario_activo;
    
    public int cliente_id;
    
    public int profesional_id;
    
    public int rol_id;

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_username() {
        return usuario_username;
    }

    public void setUsuario_username(String usuario_username) {
        this.usuario_username = usuario_username;
    }

    public String getUsuario_clave() {
        return usuario_clave;
    }

    public void setUsuario_clave(String usuario_clave) {
        this.usuario_clave = usuario_clave;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getUsuario_activo() {
        return usuario_activo;
    }

    public void setUsuario_activo(int usuario_activo) {
        this.usuario_activo = usuario_activo;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getProfesional_id() {
        return profesional_id;
    }

    public void setProfesional_id(int profesional_id) {
        this.profesional_id = profesional_id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

  
    
    
}
