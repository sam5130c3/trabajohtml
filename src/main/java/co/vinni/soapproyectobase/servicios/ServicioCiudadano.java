package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.CiudadanoDto;
import co.vinni.soapproyectobase.entidades.Ciudadano;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RespositorioCiudadano;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioCiudadano implements Serializable {


    private ModelMapper modelMapper;

    private final RespositorioCiudadano repoCiudadano;

    public CiudadanoDto registrar(CiudadanoDto ciudadanoDto) {

        Ciudadano elCiudadano = repoCiudadano.save(modelMapper.map(ciudadanoDto, Ciudadano.class));
        return modelMapper.map(elCiudadano, CiudadanoDto.class);
    }
    public List<CiudadanoDto> obtenerCiudadano() {
        TypeToken<List<CiudadanoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoCiudadano.findAll(), typeToken.getType());

    }
    public CiudadanoDto obtenerCiudadano(long serial) {
        Ciudadano ciudadano = repoCiudadano.findById(serial).orElseThrow(
            ResourceNotFoundException::new);

        return modelMapper.map(ciudadano, CiudadanoDto.class);

    }
    public CiudadanoDto actualizar(CiudadanoDto ciudadanoDto) {
        repoCiudadano.save(modelMapper.map(ciudadanoDto, Ciudadano.class));
        return ciudadanoDto;

    }
    public void eliminar(long serial) {

        repoCiudadano.deleteById(serial);


    }
}
