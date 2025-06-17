package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/*
* Interface représentant l'écriture des symptomes
* Une implémentation doit fournir une méthode pour écrire les symptomes
*/

public interface ISymptomWriter
{
	/*
	* écrit et retourne la liste des symptomes et prend 2 paramètres:
	*  description d'une map contenant les symptomes et leurs fréquences
	*/

	List<String> writeSymptoms(Map<String,Integer> symptoms);
}