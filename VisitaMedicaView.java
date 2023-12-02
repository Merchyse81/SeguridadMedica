package serrano.mercedes.dam.mp09.uf01.pr2.seguridad.view.console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import serrano.mercedes.dam.mp09.uf01.pr2.seguridad.model.domain.VisitaMedica;

public class VisitaMedicaView {
	
	//En cada método he añadido errores, el id solo puede ser número, el nombre el paciente y el médico tiene q ir 
	//con apellido y separado, la fecha tiene formato YYYY-MM-DD sino da error, y el diagnostico no puede ser 
	//solo una palabra
	
	public VisitaMedica getVisitaMedica()
	{
		VisitaMedica visitaMedica = new VisitaMedica();
		Scanner scanner = new Scanner(System.in);
		
		boolean datosCorrectos = false;

	    while (!datosCorrectos) {
	        showMissatge("Nº Visita: ", false);
	        if (scanner.hasNextInt()) {
	            visitaMedica.setIdVisita(scanner.nextInt());
	            scanner.nextLine(); // Limpiar el buffer después de nextInt()
	            datosCorrectos = true;
	        } else {
	            showMissatge("Error: Por favor ingresa un número válido.", true);
	            scanner.nextLine(); // Limpiar el buffer si se ingresó algo que no es un número
	        }
	    }
		
	    datosCorrectos = false;

	    while (!datosCorrectos) {
	        showMissatge("Nombre del paciente: ", false);
	        String nombreCompletoPaciente = scanner.nextLine().trim();

	        if (nombreCompletoPaciente.contains(" ") && nombreCompletoPaciente.split(" ").length >= 2) {
	            visitaMedica.setNomPaciente(nombreCompletoPaciente.split(" ")[0]);
	            visitaMedica.setNomPaciente(nombreCompletoPaciente.split(" ")[1]);
	            datosCorrectos = true;
	        } else {
	            showMissatge("Error: Por favor ingresa nombre y apellido del paciente.", true);
	        }
	    }
		
	    datosCorrectos = false;

	    while (!datosCorrectos) {
	        showMissatge("Nombre del médico: ", false);
	        String nombreCompletoMedico = scanner.nextLine().trim();

	        if (nombreCompletoMedico.contains(" ") && nombreCompletoMedico.split(" ").length >= 2) {
	            visitaMedica.setNomMetge(nombreCompletoMedico.split(" ")[0]);
	            visitaMedica.setNomMetge(nombreCompletoMedico.split(" ")[1]);
	            datosCorrectos = true;
	        } else {
	            showMissatge("Error: Por favor ingresa nombre y apellido del médico.", true);
	        }
	    }
		
	    datosCorrectos = false;

	    while (!datosCorrectos) {
	        showMissatge("Fecha visita (Formato yyyy-mm-dd): ", false);
	        String fechaString = scanner.nextLine().trim();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        try {
	            LocalDate fecha = LocalDate.parse(fechaString, formatter);
	            visitaMedica.setFecha(fecha);
	            datosCorrectos = true;
	        } catch (DateTimeParseException ex) {
	            showMissatge("Error al introducir la fecha. Asegúrate de ingresarla en el formato correcto (yyyy-mm-dd).", true);
	        }
	    }
	       
        
	    datosCorrectos = false;

	    while (!datosCorrectos) {
	        showMissatge("Diagnóstico: ", false);
	        String diagnostico = scanner.nextLine().trim();

	        if (!diagnostico.isEmpty() && diagnostico.contains(" ")) {
	            visitaMedica.setDiagnostico(diagnostico);
	            datosCorrectos = true;
	        } else {
	            showMissatge("Error: Por favor ingresa un diagnóstico válido (una o varias palabras).", true);
	        }
	    }

	
		
		return visitaMedica;
	}

	
	public void showMissatge(String missatge, boolean esError) {
		if(esError) {
			System.err.println(missatge);
		}else {
			System.out.println(missatge);
		}
	}

	public void showVisitaMedica(VisitaMedica visitaMedica) 
	{
		System.out.println(visitaMedica.toString());
		
	}

}
