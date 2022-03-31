package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import java.util.List;
import java.util.Set;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ConsultaMapper {

    public List<Consulta> consultarConsultas(); 

}
