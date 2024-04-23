package co.vinni.soapproyectobase.repositorios;


import co.vinni.soapproyectobase.entidades.Madre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioMadre extends JpaRepository<Madre, Long>, JpaSpecificationExecutor<Madre> {
}
