package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	
	
	private String alienWord; 
	private List<String> translations;
	
	public WordEnhanced(String alienWord) {
		super();
		this.alienWord = alienWord;
		this.translations = new ArrayList<>();
	}

	
	
	public boolean equals(Object obj) {
		WordEnhanced altra = (WordEnhanced) obj;
	    
		if(alienWord.toLowerCase().compareTo(altra.alienWord.toLowerCase()) == 0)
			return true;
		else 
			return false;
	}
	
	public void setTranslation(String t) {
		this.translations.add(t);
	}
	
	public String getTranslation() {
		String trad = "";
		for (String s : this.translations) {
			trad += s+"\n";
		}
		return trad;
	}
	
	public String getAlienWord() {
		return this.alienWord;
	}


	@Override
	public String toString() {
	return "Inserita parola aliena" + alienWord + ", con traduzione" + this.translations;
	}

	
	
}
