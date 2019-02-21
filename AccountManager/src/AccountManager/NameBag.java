package AccountManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameBag {
	private String boysNamesFile;
	private String girlsNamesFile;
	private String lastNamesFile;
	private Pattern namePattern;
	private ArrayList<String> boysNames;
	private ArrayList<String> girlsNames;
	private ArrayList<String> lastNames;
	
	public NameBag(String boysNamesFile, String girlsNamesFile, String lastNamesFile) throws IOException {
		this.boysNamesFile = boysNamesFile;
		this.girlsNamesFile = girlsNamesFile;
		this.lastNamesFile = lastNamesFile;
		namePattern = Pattern.compile("[A-z][a-z]+");
		loadNames();
	}
	
	private String loadTextFileToString(String pathToFile) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(pathToFile));
		String curLine;
		while((curLine = br.readLine()) != null) {
			lines.add(curLine);
		}
		br.close();
		return lines.toString();
	}
	
	private ArrayList<String> loadNamesFromFile(String pathToFile) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		Matcher nameMatcher = namePattern.matcher(loadTextFileToString(pathToFile));
		while(nameMatcher.find()) {
			list.add(nameMatcher.group(0));
		}
		return list;
	}
	
	private void loadNames() throws IOException {
		lastNames = loadNamesFromFile(lastNamesFile);
		girlsNames = loadNamesFromFile(girlsNamesFile);
		boysNames = loadNamesFromFile(boysNamesFile);
	}

	public String getBoysName() {
		Random rand = new Random();
		return boysNames.get(rand.nextInt(boysNames.size()));
	}

	public String getGirlsName() {
		Random rand = new Random();
		return girlsNames.get(rand.nextInt(girlsNames.size()));
	}

	public String getLastName() {
		Random rand = new Random();
		return lastNames.get(rand.nextInt(lastNames.size()));
	}
}
