package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

		public static void main(String args[]) throws Exception {
			/*
		* Instanciation de l'objet ISymptomReader qui lit les symptômes dans un fichier texte
		*/

		ISymptomReader symptomReader=new ReadSymptomDataFromFile("data/symptoms.txt");
		
		
		/*
		* Instanciation de l'objet ISymptomWriter qui écrit les symptômes dans un fichier texte
		*/

		ISymptomWriter symptomWriter=new WriteSymptomDataToFile("data/symptoms.txt");
		
		/*
		* Instanciation de l'objet AnalyticsCounter 
		@param décrit la lecture des symptomes et l'ecriture des symptomes
		*/ 
		
		AnalyticsCounter counter = new AnalyticsCounter(symptomReader, symptomWriter);
		
		counter.analyzeSpecificSymptoms();

		/*
		* appel de la méthode getSymptoms() qui lit une liste d'entrée dans un fichier liée aux differents symptômes
		*/
		
		List<String> symptoms=symptomReader.getSymptoms();

		/*
		* description d'une map contenant les symptomes et leurs fréquences
		*/

		Map<String,Integer> listSymptoms=new HashMap<>();
		
		/*
		* Appel de la méthode countSymptoms() qui compte les occurences de chaque symptome
		* @param liste de tous les symptomes sous forme de chaines de caractères
		*/

		counter.countSymptoms(symptoms);
		
		/*
		* appel de la méthode sortSymptoms() qui trie la liste des symptomes et d'occurences par ordre alphabétique
		* @param liste de tous les symptomes sous forme de chaines de caractères
		*/

		counter.sortSymptoms(symptoms);

		/*
		* appel de la méthode writeSymptoms qui écrit le résultat dans le fichier de sortie
		* @param la description d'une map contenant les symptomes et leurs fréquences
		*/
		
		counter.writeSymptoms(listSymptoms);
		
		}
	  
}
