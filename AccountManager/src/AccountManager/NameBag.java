package AccountManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameBag {
	private InputStream boysNamesFile;
	private InputStream girlsNamesFile;
	private InputStream lastNamesFile;
	private Pattern namePattern;
	private ArrayList<String> boysNames;
	private ArrayList<String> girlsNames;
	private ArrayList<String> lastNames;
	
	public NameBag() throws IOException {
		namePattern = Pattern.compile("[A-z][a-z]+");
		loadNames();
	}
	
	private String loadTextFileToString(InputStream file) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(file));
		String curLine;
		while((curLine = br.readLine()) != null) {
			lines.add(curLine);
		}
		br.close();
		return lines.toString();
	}
	
	private ArrayList<String> loadNamesFromFile(InputStream file) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		Matcher nameMatcher = namePattern.matcher(loadTextFileToString(file));
		while(nameMatcher.find()) {
			list.add(nameMatcher.group(0));
		}
		return list;
	}
	
	private void loadNames() throws IOException {
		this.boysNamesFile = NameBag.class.getResourceAsStream("boys_names.txt");
		this.girlsNamesFile = NameBag.class.getResourceAsStream("girls_names.txt");
		this.lastNamesFile = NameBag.class.getResourceAsStream("last_names.txt");
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
	
	public boolean isMale(String name) {
		return boysNames.contains(name);
	}
}
