package serrano.mercedes.dam.mp09.uf01.pr2.seguridad.model.domain;

import java.time.LocalDate;

public class VisitaMedica {

	private int idVisita;
	private String nomPaciente;
	private String nomMetge;
	private LocalDate fecha;
	private String diagnostico;

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public String getNomPaciente() {
		return nomPaciente;
	}

	public void setNomPaciente(String nomPaciente) {
		this.nomPaciente = nomPaciente;
	}

	public String getNomMetge() {
		return nomMetge;
	}

	public void setNomMetge(String nomMetge) {
		this.nomMetge = nomMetge;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public boolean validarDatosInformados() {
		 return contieneEspacio(nomPaciente) && contieneEspacio(nomMetge) &&
	               nomPaciente != null && !nomPaciente.isEmpty() &&
	               nomMetge != null && !nomMetge.isEmpty() &&
	               fecha != null &&
	               diagnostico != null && !diagnostico.isEmpty();
	}

	private boolean contieneEspacio(String texto) {
        return texto != null && texto.contains(" ");
    }
	
	@Override
	public String toString() {
		return "VisitaMedica [idVisita=" + idVisita + ", nomPaciente=" + nomPaciente + ", nomMetge=" + nomMetge
				+ ", fecha=" + fecha + ", diagnostico=" + diagnostico + "]";
	}

	
	
	
}