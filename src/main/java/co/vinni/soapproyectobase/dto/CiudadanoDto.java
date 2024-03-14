package co.vinni.soapproyectobase.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CiudadanoDto implements Serializable{
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido")
    private String apellido;
    @NotBlank(message = "El tipo de documento")
    private String tipodocumento;
    @NotBlank(message = "El numero de documento")
    private long documento;
    @NotBlank(message = "La fecha de nacimiento")
    private Date fechanacimiento;
}
