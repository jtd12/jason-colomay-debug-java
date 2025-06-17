package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// implémentation de ISymptomWriter pour écrire les symptomes dans un fichier texte

public class WriteSymptomDataToFile implements ISymptomWriter
{
	private String path;
	
	/*
	* Constructeur WriteSymptomDataToFile 
	* @param path qui décrit le chemin de sortie du fichier
	*/

	public WriteSymptomDataToFile (String filepath)
	{
	this.path=filepath;
	}
	
	/*
	* Ecrit la liste des symptomes dans un fichier
	* @param description d'une map contenant les symptomes et leurs fréquences
	* @return une liste de chaines de caractères repéresentant les symptomes
	*/

	@Override
	public List<String> writeSymptoms(Map<String,Integer> symptoms)
	{	
	ArrayList<String> result=new ArrayList<String>();
	
	// ajout de chaque symptome dans la liste à écrire
	for(Map.Entry<String,Integer> entry : symptoms.entrySet()){
	   result.add(entry.getKey() +" : " +entry.getValue());
	}

	// écrire la liste dans le fichier
	if(path!=null){
	try (BufferedWriter writer=new BufferedWriter(new FileWriter(path))){
		
		for(String line: result)
		{
		writer.write(line);
		writer.newLine(); // saut de ligne après chaque symptomes
		writer.close();
		}
	}catch(IOException e){
		e.printStackTrace();
		}
     }
    return result;
   }
}