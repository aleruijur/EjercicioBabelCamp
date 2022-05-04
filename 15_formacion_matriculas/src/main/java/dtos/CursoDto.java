package dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CursoDto {
	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;
	private Date fechaInicio;
	
}
