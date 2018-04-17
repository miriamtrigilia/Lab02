package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<WordEnhanced> wordList = new ArrayList<WordEnhanced>(); 
 	
	public void addWord(String alienWord, String translation) {
		WordEnhanced tmp = new WordEnhanced(alienWord);
		tmp.setTranslation(translation);
		boolean trovata = false;
		
		for(WordEnhanced w : wordList) {
				if(w.equals(tmp)) {
					w.setTranslation(translation);
					trovata = true;
				}
			}
		
		if(trovata == false) 
			wordList.add(tmp);
		
		
	}
	
	public String wildcard(String alienWord) {
		int cont = 0;
		int uguali = 0;
		String giusta = "";
		for(Character c : alienWord.toCharArray()) {
			if(c.equals('?')) {
				cont++;
			}
		}
		if(cont!=1) {
			System.out.println("E' ammesso un solo carattere '?'");
			return null;
		} else {
			
			for(WordEnhanced w : this.wordList) {
				char[] parola = w.getAlienWord().toCharArray();
				for(Character c2 : parola) {
					for(Character c1 : alienWord.toCharArray()) {
						if(c1.equals(c2)) {
							uguali++;
						}
					}
					if(alienWord.length() == (uguali-1))
						return w.getAlienWord();
					else return null;
				}
				
			}
			
			
				
		}
		
		return null;
		
		
			
	}
	
	public String translateWord(String alienWord) {
		String trad = "Non esiste nessuna traduzione di "+alienWord;
		//if(alienWord.contains('?'))
			
		for(WordEnhanced w : wordList) {
			if(w.getAlienWord().toLowerCase().compareTo(alienWord.toLowerCase()) == 0) {
				trad= w.getTranslation();
			}
			
		}
	return trad;
		
		
	}
	
	

}
