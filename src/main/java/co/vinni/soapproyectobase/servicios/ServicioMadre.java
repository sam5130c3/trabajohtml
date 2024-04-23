package co.vinni.soapproyectobase.servicios;


import co.vinni.soapproyectobase.dto.MadreDto;
import co.vinni.soapproyectobase.repositorios.RepositorioMadre;
import co.vinni.soapproyectobase.entidades.Madre;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServicioMadre {
    private ModelMapper modelMapper;
    @Autowired
    private final RepositorioMadre repositorioMadre;

    public MadreDto registrar(MadreDto madreDto) {

        Madre elMadre = repositorioMadre.save(modelMapper.map(madreDto, Madre.class));
        return modelMapper.map(elMadre, MadreDto.class);
    }
    public List<MadreDto> obtenerMadre() {
        TypeToken<List<MadreDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioMadre.findAll(), typeToken.getType());

    }
    public MadreDto obtenerMadre(long serial) {
        Madre madre = repositorioMadre.findById(serial).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(madre, MadreDto.class);

    }
    public MadreDto actualizar(MadreDto madreDto) {
        repositorioMadre.save(modelMapper.map(madreDto, Madre.class));
        return madreDto;

    }
    public void eliminar(long serial) {

        repositorioMadre.deleteById(serial);


    }
}
