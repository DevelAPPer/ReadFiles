package de.example.writereaddeletefiles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import android.content.Context;

public class ReadWriteDeleteFiles {
	
	private Context context;
	private FileOutputStream os = null;
	private Writer writer = null;
	private FileInputStream is = null;
	private InputStreamReader isr = null;
	private BufferedReader br = null;
	private String ausgabe;

	public ReadWriteDeleteFiles(Context context) {
		this.context = context;
	}
	public void writefile(String zuschreibendedaten) {
		try {
			//FileOutputStream setzt den File Namen fest und die Zugriffsrechte 
			//Mode Private: Zugriff nur innerhalb dieser Anwendung erlaubt
			//Mode Append: Daten an bestehender Datei anhängen
			os = context.getApplicationContext().openFileOutput("eingabe",
					Context.MODE_PRIVATE|Context.MODE_APPEND);
			writer = new OutputStreamWriter(os);
			writer.write(zuschreibendedaten);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String readfile() {
		try {
			//FileInputStream: Datei Zugriff
			is = context.getApplicationContext().openFileInput("eingabe");
			//InputStreamReader: Unterstützung von Unicode (mehreren Sprachen)
			isr = new InputStreamReader(is);
			//BufferedReader zum zeilenweise aus
			br = new BufferedReader(isr);
			ausgabe = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ausgabe;
	}
}
