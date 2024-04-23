package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.PadreDto;
import co.vinni.soapproyectobase.entidades.Padre;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RepositorioPadre;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioPadre implements Serializable {
    private ModelMapper modelMapper;

    private final RepositorioPadre repositorioPadre;

    public PadreDto registrar(PadreDto padreDto) {

        Padre elPadre = repositorioPadre.save(modelMapper.map(padreDto, Padre.class));
        return modelMapper.map(elPadre, PadreDto.class);
    }
    public List<PadreDto> obtenerPadre() {
        TypeToken<List<PadreDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioPadre.findAll(), typeToken.getType());

    }
    public PadreDto obtenerPadre(long serial) {
        Padre padre = repositorioPadre.findById(serial).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(padre, PadreDto.class);

    }
    public PadreDto actualizar(PadreDto padreDto) {
        repositorioPadre.save(modelMapper.map(padreDto, Padre.class));
        return padreDto;

    }
    public void eliminar(long serial) {

        repositorioPadre.deleteById(serial);


    }
}
