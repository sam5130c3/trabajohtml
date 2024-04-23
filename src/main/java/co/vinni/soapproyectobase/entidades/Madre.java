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
@Entity(name = "Madre")
@Table(name = "MADRE")
public class Madre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MADRE")
    @SequenceGenerator(name = "SEQ_MADRE", sequenceName = "SEQ_MADRE", allocationSize = 1)
    @Column(name = "EQU_CODIGOM", nullable = false)
    private long serialm;

    @Column(name = "EQU_NOMBREM", nullable = false)
    private String nombrem;

    @Column(name = "EQU_APELLIDOM", nullable = false)
    private String apellidom;

    @Column(name = "EQU_TIPODOCUMENTOM", nullable = false)
    private String tipodocumentom;

    @Column(name = "EQU_DOCUMENTOM", nullable = false)
    private long documentom;

    @Column(name = "EQU_FECHANACIMIENTOM", nullable = false)
    private Date fechanacimientom;
}
