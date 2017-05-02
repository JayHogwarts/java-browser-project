package mainProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class History {
	File config = new File("BrowserFiles/history.txt");
	String home = "";
	
	//Uses a BufferedReader to get the first line of text in the config file
	public String readHistory() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(config));
			String txt;
			if ((txt = reader.readLine()) != null) {
				this.home = txt;
			}
			reader.close();
		} catch (IOException e) {
			File config = new File("BrowserFiles/config.txt");
		}

		return home;
	}
	//Writes a new config file with the new home
	public void writeHistory(String h) {
		try {
			//The file is deleted to prevent multiple home URLs being stored in one config file
			config.delete();
			FileWriter writer = new FileWriter(config, true);
			writer.write(h);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.home = h;

	}
}