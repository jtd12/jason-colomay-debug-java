package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// implémentation de ISymptomReader pour lire les symptomes dans un fichier texte

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/*
	* Constructeur ReadSymptomDataFromFile
	* @param path qui décrit le chemin de sortie du fichier
	*/

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/*
	* Lit la liste des symptomes dans un fichier
	@ param description à l'aide d'une liste contenant les symptomes
	@ return une liste de chaine de caractères représentant les symptomes
	*/

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
