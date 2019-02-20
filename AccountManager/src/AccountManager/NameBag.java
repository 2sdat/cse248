package AccountManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NameBag {
	private String boysNamesFile;
	private String girlsNamesFile;
	private String lastNamesFile;
	private String[] boysNames;
	private String[] girlsNames;
	private String[] lastNames;
	
	public NameBag(String boysNamesFile, String girlsNamesFile, String lastNamesFile) {
		this.boysNamesFile = boysNamesFile;
		this.girlsNamesFile = girlsNamesFile;
		this.lastNamesFile = lastNamesFile;
		loadNames();
	}

	private void loadNames() {
		boysNames = loadBoysNames();
		girlsNames = loadGirlsNames();
		lastNames = loadLastNames();
	}
	
	private String[] loadLastNames() {
		List<String> lastNames = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(lastNamesFile);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null) {
				lastNames.add(line);
				line = br.readLine();
			}
		} finally {
			fr.close();
		}
		
		return null;
	}

	private String[] loadGirlsNames() {
		return null;
	}

	private String[] loadBoysNames() {
		return null;
	}

}
