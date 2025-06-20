
package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* création d'une classe AnalyticsCounter qui analyse l'ensemble des symptômes */

public class AnalyticsCounter {
	private static int headacheCount = 0;	//intitialisation à 0 de la variable headache qui compte ce type de symptomes
	private static int rashCount = 0;	//intitialisation à 0 de la variable rash qui compte ce type de symptomes	
	private static int pupilCount = 0;	//intitialisation à 0 de la variable pupil qui compte ce type de symptomes
	private ISymptomWriter writer;
	private ISymptomReader reader;

	/*
	* Constructeur AnalyticsCounter
	* @param reader qui décrit la lecture des symptomes 
	* @param writer qui décrit l'écriture des symptomes
	*/

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer)
	{
		this.reader=reader;
		this.writer=writer;
			
	}

	/*
	* méthode qui récupère la liste des entrées dans un fichier 
	* @param décrit la lecture des symptomes et l'écriture des symptômes		
	*/

	public List<String> getSymptoms()
	{
		  List<String> symptoms = reader.getSymptoms();

	        // Compter les occurrences
	        Map<String, Integer> symptomCounts = new TreeMap<>();
	        for (String symptom : symptoms) {
	            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
	        }

	        // Utilise l�instance de ISymptomWriter pour �crire dans un fichier
	        return writer.writeSymptoms(symptomCounts);
	}
	
	/*
	*  méthode qui compte les occurences de chaque symptome
	*/

	public Map<String,Integer> countSymptoms(List<String> symptoms)
	{
	     Map<String, Integer> symptomCounts = new TreeMap<>(); 

	        for (String symptom : symptoms) {
	            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
	        }

	        return symptomCounts;
	}
	

	/* 
	* méthode qui trie la liste de symptomes et d'occurences par ordre alphabétique
	* @param liste de tous les symptomes sous forme de chaines de caractères
	*/

	public Map<String,Integer> sortSymptoms(List<String> symptoms)
	{
		  Map<String, Integer> sortedMap = new TreeMap<>();// Tri alphab�tique

	        for (String symptom : symptoms) {
	            sortedMap.put(symptom, sortedMap.getOrDefault(symptom, 0) + 1);
	        }

	        return sortedMap;
	 }
	
	
	/*
	* méthode qui écrit le résultat dans le fichier de sortie
	@param liste de tous les symptomes sous forme de chaines de caractères
	*/

	public void writeSymptoms(Map<String,Integer> symptoms)
	{
		writer.writeSymptoms(symptoms);
	}
	
	public void analyzeSpecificSymptoms() {
	    List<String> symptoms = reader.getSymptoms(); // Utilise l�interface pour lire les donn�es

	    //factorisation de la fonction main() qui g�re la logique plac�e dans la fonction analyzeSpecificSymptoms()
	    for (String line : symptoms) { //on evalue combien de fois on retrouve les mots dans le fichier
	        if (line.equals("headache")) {
	            headacheCount++;
	        } else if (line.equals("rash")) {
	            rashCount++;
	        } else if (line.contains("pupils")) {
	            pupilCount++;
	        }
	    }
	    
	    System.out.println("headache: " + headacheCount); //on affiche combien de fois on retrouve chacun des mots du fichier dans la console
	    System.out.println("Pupils: " + pupilCount);
	    System.out.println("rash: " + rashCount);

	
	    //on �crit les mots dans le fichier et on voit combien de fois ils apparaissent dans le fichier 
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.out"))) {
	        bw.write("headache: " + headacheCount + "\n");
	        bw.write("rash: " + rashCount + "\n");
	        bw.write("dilated pupils: " + pupilCount + "\n");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}


