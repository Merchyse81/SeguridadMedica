package serrano.mercedes.dam.mp09.uf01.pr2.app;

import serrano.mercedes.dam.mp09.uf01.pr2.seguridad.controller.VisitaMedicaController;

public class Main {

	public static void main(String[] args) {
		VisitaMedicaController visitaMedicaController = new VisitaMedicaController();
		visitaMedicaController.aplicaSeguridadMD5();
		visitaMedicaController.aplicaSeguridadSHA256();
		visitaMedicaController.aplicaSeguridadAES();

	}

}
