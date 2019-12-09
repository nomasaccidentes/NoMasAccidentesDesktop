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
public class Contrato {
    public String contrato_descripcion;
    public String contrato_fecha_inicio;
    public String contrato_fecha_fin;
    public int cant_capacitacion;
    public int cant_asesoria;
    public int contrato_activo;
    public int cliente_id;
    public int num_trabajadores;


    public String getContrato_descripcion() {
        return contrato_descripcion;
    }

    public void setContrato_descripcion(String contrato_descripcion) {
        this.contrato_descripcion = contrato_descripcion;
    }

    public String getContrato_fecha_inicio() {
        return contrato_fecha_inicio;
    }

    public void setContrato_fecha_inicio(String contrato_fecha_inicio) {
        this.contrato_fecha_inicio = contrato_fecha_inicio;
    }

    public String getContrato_fecha_fin() {
        return contrato_fecha_fin;
    }

    public void setContrato_fecha_fin(String contrato_fecha_fin) {
        this.contrato_fecha_fin = contrato_fecha_fin;
    }

    public int getCant_capacitacion() {
        return cant_capacitacion;
    }

    public void setCant_capacitacion(int cant_capacitacion) {
        this.cant_capacitacion = cant_capacitacion;
    }

    public int getCant_asesoria() {
        return cant_asesoria;
    }

    public void setCant_asesoria(int cant_asesoria) {
        this.cant_asesoria = cant_asesoria;
    }

    public int getContrato_activo() {
        return contrato_activo;
    }

    public void setContrato_activo(int contrato_activo) {
        this.contrato_activo = contrato_activo;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getNum_trabajadores() {
        return num_trabajadores;
    }

    public void setNum_trabajadores(int num_trabajadores) {
        this.num_trabajadores = num_trabajadores;
    }

    
    
    @Override
    public String toString() {
        return "Contrato{" + ", contrato_descripcion=" + contrato_descripcion + ", contrato_fecha_inicio=" + contrato_fecha_inicio + ", contrato_fecha_fin=" + contrato_fecha_fin + ", cant_capacitacion=" + cant_capacitacion + ", cant_asesoria=" + cant_asesoria + ", contrato_activo=" + contrato_activo + ", cliente_id=" + cliente_id + '}';
    }

    
    
    
    
    
}
