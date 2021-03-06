package edu.eci.pdsw.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.DaoConsulta;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.ConsultaMapper;
import java.util.List;

public class MyBatisDAOConsulta implements DaoConsulta {


    @Inject
    ConsultaMapper consultaMapper;
    
    @Override
    public List<Consulta> loadAll() throws PersistenceException {
        try {
            return consultaMapper.consultarConsultas();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar consultas ", e);
        }
    }
}
