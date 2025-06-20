package com.hemebiotech.analytics;

import java.util.List;

/*
* Interface représentant un lecteur de Symptomes
* Une implémentation doit fournir une méthode pour lire les symptomes
*/

public interface ISymptomReader {

	/*
	* Lit et retourne la liste des symptomes
	*/

	List<String> getSymptoms();
}

