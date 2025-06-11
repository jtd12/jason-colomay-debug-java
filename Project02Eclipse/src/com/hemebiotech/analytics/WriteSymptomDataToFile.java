package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteSymptomDataFromFile implements IsymptomWriter
{
private String path;

public WriteSymptomDataFromFile (String filepath)
{
this.path=filepath;
}

@override
public List<String> WriteSymptoms(Map<String,Integer> symptoms)
{
	ArrayList<String> result=new ArrayList<String>();
	
	for(Map.Entry<String,Integer> entry : symptoms.entrySet())
	{
	result.add(entry.getKey() +" : " +entry.getValue());
	}

	if(path!=null)
	{
	try
	{
	BufferedWriter writer=new BufferedWriter(new FileWriter(path));
	for(String line: result)
	{
	writer.write(result);
	writer.close();
	}
	}
	catch(IOException e)
	{
	e.printStackTrace();
	}
     }
    return result;
   }
}