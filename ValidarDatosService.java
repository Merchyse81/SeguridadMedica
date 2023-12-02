package serrano.mercedes.dam.mp09.uf01.pr2.seguridad.model.service;

import java.time.LocalDate;

import serrano.mercedes.dam.mp09.uf01.pr2.seguridad.model.domain.VisitaMedica;

public class ValidarDatosService {

	public boolean validarVisitaMedica(VisitaMedica visitaMedica)
	{
		LocalDate fechaActual = LocalDate.now();
		
		return visitaMedica != null &&
			   validarString(visitaMedica.getNomPaciente()) &&
	           validarString(visitaMedica.getNomMetge()) &&
	           validarFecha(visitaMedica.getFecha(), fechaActual) &&
	           validarString(visitaMedica.getDiagnostico());
	    }

	    private boolean validarString(String texto) {
	        return texto != null && !texto.isEmpty();
	    }

	    private boolean validarFecha(LocalDate fecha, LocalDate fechaActual) {
	        return fecha != null && !fecha.isAfter(fechaActual); 
	    }
	
}
