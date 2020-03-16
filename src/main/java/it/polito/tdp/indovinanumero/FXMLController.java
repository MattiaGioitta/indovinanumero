package it.polito.tdp.indovinanumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	private final int NMAX=100;
	private final int TMAX=8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco=false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnNuova;

    @FXML
    private TextField txtRimast;

    @FXML
    private HBox layoutTentativo;

    @FXML
    private TextField txtTentativi;

    @FXML
    private Button btnProva;

    @FXML
    void doNuova(ActionEvent event) {
    	//gestione nell'inizio di una nuova
    	//partita- Logica del gioco
    	this.segreto=(int)(Math.random()*NMAX)+1;
    	this.tentativiFatti=0;
    	this.inGioco=true;
    	//gestione interfaccia
    	layoutTentativo.setDisable(false);
    	txtRisultato.clear();
    	txtRimast.setText(Integer.toString(TMAX));
    	

    }

    @FXML
    void doTentativo(ActionEvent event) {
    	String ts=txtTentativi.getText();
    	int tentativo;
    	try {
    	tentativo=Integer.parseInt(ts);
    	}catch(NumberFormatException e) {
    		txtRisultato.appendText("Devi inserire un numero");
    		return;
    	}
    	this.tentativiFatti++;
    	if(tentativo==this.segreto) {
    		txtRisultato.appendText("Hai vinto in tentativi"+this.tentativiFatti);
    		layoutTentativo.setDisable(true);
    		this.inGioco=false;
    		return;
    	}
    	if(tentativiFatti==TMAX) {
    		//esauriti tentativi
    		txtRisultato.appendText("Hai perso, n. segreto: "+this.segreto);
    		layoutTentativo.setDisable(true);
    		this.inGioco=false;
    		return;
    	}
    	//Informare l'utente se e' troppo alto 
    	if(tentativo<this.segreto)
    		txtRisultato.appendText("Tentativo troppo basso");
    	else
    		txtRisultato.appendText("Tentativo troppo alto");
        txtRimast.setText(Integer.toString(TMAX-this.tentativiFatti));
        
    		
    	

    }

    @FXML
    void initialize() {
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRimast != null : "fx:id=\"txtRimast\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
