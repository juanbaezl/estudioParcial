/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.entities;

import java.sql.Date;

/**
 *
 * @author hcadavid
 */
public class Consulta {
    //el identificador es asignado por la base de datos,
    //por eso no se incluye en el constructor.
    private int id;
    private Date fecha_y_hora;
    private String resumen;
    private int idPaciente;
    private TipoIdentificacion tipo_id;

    
    
    public Date getFecha_y_hora() {
        return fecha_y_hora;
    }

    public void setFecha_y_hora(Date fecha_y_hora) {
        this.fecha_y_hora = fecha_y_hora;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TipoIdentificacion getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(TipoIdentificacion tipo_id) {
        this.tipo_id = tipo_id;
    }

    public Consulta(int id, Date fecha_y_Hora, String resumen, int idPaciente, TipoIdentificacion tipo_id) {
        this.id=id;
        this.fecha_y_hora = fecha_y_Hora;
        this.resumen = resumen;
        this.idPaciente=idPaciente;
        this.tipo_id=tipo_id;
    }    
    
    public Consulta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public String toString() {
        return "Consulta { id: "+id+", fechayHora: "+fecha_y_hora+", resumen: "+resumen+" }";
    }
    
    
}
