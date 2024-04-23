package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Padre")
@Table(name = "PADRE")
public class Padre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PADRE")
    @SequenceGenerator(name = "SEQ_PADRE", sequenceName = "SEQ_PADRE", allocationSize = 1)
    @Column(name = "EQU_CODIGOP", nullable = false)
    private long serialp;

    @Column(name = "EQU_NOMBREP", nullable = false)
    private String nombrep;

    @Column(name = "EQU_APELLIDOP", nullable = false)
    private String apellidop;

    @Column(name = "EQU_TIPODOCUMENTOP", nullable = false)
    private String tipodocumentop;

    @Column(name = "EQU_DOCUMENTOP", nullable = false)
    private long documentop;

    @Column(name = "EQU_FECHANACIMIENTOP", nullable = false)
    private Date fechanacimientop;
}
