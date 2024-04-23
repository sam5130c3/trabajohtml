package co.vinni.soapproyectobase.repositorios;


import co.vinni.soapproyectobase.entidades.Padre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioPadre extends JpaRepository<Padre, Long>, JpaSpecificationExecutor<Padre> {
}
