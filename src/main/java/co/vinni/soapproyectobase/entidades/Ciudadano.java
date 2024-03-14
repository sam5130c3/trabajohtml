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
@Entity(name = "Ciudadano")
@Table(name = "CIUDADANO")
public class Ciudadano implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CIUDADANO")
    @SequenceGenerator(name = "SEQ_CIUDADANO", sequenceName = "SEQ_CIUDADANO", allocationSize = 1)
    @Column(name = "EQU_CODIGO", nullable = false)
    private long serial;

    @Column(name = "EQU_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EQU_APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "EQU_TIPODOCUMENTO", nullable = false)
    private String tipodocumento;

    @Column(name = "EQU_DOCUMENTO", nullable = false)
    private long documento;

    @Column(name = "EQU_FECHANACIMIENTO", nullable = false)
    private Date fechanacimiento;

}
