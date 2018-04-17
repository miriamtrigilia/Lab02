package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    private AlienDictionary diz = new AlienDictionary();
    
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String p = txtWord.getText();
    	
    	// controllo parola non inserita
    	if(txtWord.getText().length()==0) {
    		txtResult.setText("Inserire parola/e\n");
    	}
    	
    if(p.contains(" ")) {
    	String array[] = p.split(" ");
    	diz.addWord(array[0], array[1]);
	if(!array[0].matches("[a-zA-Z]*") || !array[1].matches("[a-zA-Z]*")) {
		txtResult.setText("E' stata inserita una parola con un carattere non valido\n");
		return;
	}
	WordEnhanced w = new WordEnhanced(array[0]);
    	w.setTranslation(array[1]);
	txtWord.clear();
	txtResult.appendText("\n"+w);
    	}
    	else {
    		// controllo caratteri
    		if(!p.matches("[a-zA-Z]*")) {
    			txtResult.setText("E' stata inserita una parola con un carattere non valido\n");
    			return;
    		}
    		
    		String g=diz.translateWord(p);
    		txtWord.clear();
    		txtResult.appendText("\n"+g);
    		
    	}

    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    		txtResult.setText("Welcome to Alien Dictionary v2018.\n");

    }
    
}
