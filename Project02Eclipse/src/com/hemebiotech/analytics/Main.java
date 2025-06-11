package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main
{
	public static void main(String args[])
	{
	
	ISymptomReader symptomReader=new SymptomReaderFromFile("data/symptoms.txt");

	ISymptomWriter symptomWriter=new SymptomWriterFromFile("data/symptoms.txt");
	
	AnalyticsCounter analytics=new AnalyticsCounter(symptomReader,symptomWriter);
	
	List<String> symptoms=symptomReader.getSymptoms();
	
	Map<String,Integer> listSymptoms=new HashMap<>();
	
	analytics.countSymptoms(symptoms);

	analytics.sortSymptoms(symptoms);

	analytics.writeSymptoms(listSymptoms);
	}
}