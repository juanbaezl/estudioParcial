/*
 * Copyright (C) 2016 hcadavid
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
package edu.eci.pdsw.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.DaoPaciente;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.ConsultaMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.PacienteMapper;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class MyBatisDAOPaciente implements DaoPaciente {


    @Inject
    PacienteMapper pacienteMapper;

    @Inject
    ConsultaMapper consultaMapper;
    
    @Override
    public Paciente load(int id, TipoIdentificacion tipoIdentificacion) throws PersistenceException {
        try {
            Paciente paciente = pacienteMapper.consultarPaciente(id,tipoIdentificacion);
            List<Consulta> consultas = consultaMapper.consultarConsultas();
            for (Consulta consulta : consultas){
                if(consulta.getIdPaciente()==id && consulta.getTipo_id()==paciente.getTipo_id())paciente.appendConsultas(consulta);;
            }
            return paciente;
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar paciente " + id + " "+ tipoIdentificacion, e);
        }
    }

    @Override
    public List<Paciente> loadAll() throws PersistenceException {
        try{
            List<Paciente> pacientes = pacienteMapper.getPacientes();
            for (Paciente paciente : pacientes){
                List<Consulta> consultas = consultaMapper.consultarConsultas();
                for (Consulta consulta : consultas){
                    if(consulta.getIdPaciente()==paciente.getId() && consulta.getTipo_id()==paciente.getTipo_id())paciente.appendConsultas(consulta);;
                }
            }        
            return pacientes;
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
        
    }

    @Override
    public void save(Paciente e) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Paciente e) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addConsulta(int id, TipoIdentificacion tipoId, Consulta c) throws PersistenceException {

    }


}
