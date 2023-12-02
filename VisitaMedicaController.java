package serrano.mercedes.dam.mp09.uf01.pr2.seguridad.controller;

import serrano.mercedes.dam.mp09.uf01.pr2.seguridad.model.domain.VisitaMedica;
import serrano.mercedes.dam.mp09.uf01.pr2.seguridad.model.security.MD5Security;
import serrano.mercedes.dam.mp09.uf01.pr2.seguridad.model.security.SHA256Security;
import serrano.mercedes.dam.mp09.uf01.pr2.seguridad.model.security.AESSecurity;
import serrano.mercedes.dam.mp09.uf01.pr2.seguridad.view.console.VisitaMedicaView;
public class VisitaMedicaController {
	
	VisitaMedicaView visitaMedicaView = new VisitaMedicaView();
	
	public void aplicaSeguridadMD5()
	{
		try {
	        visitaMedicaView.showMissatge("MD5 ---------", false);
	        VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
	        
	        if (visitaMedica == null) {
	            visitaMedicaView.showMissatge("Error al obtener los datos de la visita.", true);
	            return; 
	        }
	        
	        MD5Security Security = new MD5Security();
	        String nomPacienteEnc = Security.encripta(visitaMedica.getNomPaciente());
	        String diagnosticoEnc = Security.encripta(visitaMedica.getDiagnostico());
	        
	        VisitaMedica visitaMedicaEnc = new VisitaMedica();
	        visitaMedicaEnc.setNomPaciente(nomPacienteEnc);
	        visitaMedicaEnc.setDiagnostico(diagnosticoEnc);
	        
	        visitaMedicaView.showVisitaMedica(visitaMedicaEnc);
	    } catch (Exception ex) {
	        visitaMedicaView.showMissatge("Error: " + ex.getMessage(), true);
	    }
	}
	
	public void aplicaSeguridadSHA256()
	{
		try {
			visitaMedicaView.showMissatge("SHA256 ---------", false);
			VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
			SHA256Security Security = new SHA256Security();
			String nomPacienteEnc = Security.encripta(visitaMedica.getNomPaciente());
			String diagnosticoEnc = Security.encripta(visitaMedica.getDiagnostico());
			
			VisitaMedica visitaMedicaEnc = new VisitaMedica();
			visitaMedicaEnc.setNomPaciente(nomPacienteEnc);
			visitaMedicaEnc.setDiagnostico(diagnosticoEnc);
			
			visitaMedicaView.showVisitaMedica(visitaMedicaEnc);
		}catch(Exception ex) {
			visitaMedicaView.showMissatge(ex.getMessage(), true);
		}
	}
	
	public void aplicaSeguridadAES()
	{
		try {
			visitaMedicaView.showMissatge("AES ---------", false);
			VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
			AESSecurity Security = new AESSecurity();
			String nomPacienteEnc = Security.encripta(visitaMedica.getNomPaciente());
			String diagnosticoEnc = Security.encripta(visitaMedica.getDiagnostico());
			
			VisitaMedica visitaMedicaEnc = new VisitaMedica();
			visitaMedicaEnc.setNomPaciente(nomPacienteEnc);
			visitaMedicaEnc.setDiagnostico(diagnosticoEnc);
			
			visitaMedicaView.showVisitaMedica(visitaMedicaEnc);
			
			visitaMedicaView.showMissatge("AES ------------ Desencripta", false);

			String nomPacienteDesenc = Security.desencripta(visitaMedicaEnc.getNomPaciente());
			String diagnosticoDesenc = Security.desencripta(visitaMedicaEnc.getDiagnostico());

			VisitaMedica visitaMedicaDesenc = new VisitaMedica();
			visitaMedicaDesenc.setNomPaciente(nomPacienteDesenc);
			visitaMedicaDesenc.setDiagnostico(diagnosticoDesenc);
			visitaMedicaView.showVisitaMedica(visitaMedicaDesenc);
			
		}catch(Exception ex) {
			visitaMedicaView.showMissatge(ex.getMessage(), true);
		}
	}

}
