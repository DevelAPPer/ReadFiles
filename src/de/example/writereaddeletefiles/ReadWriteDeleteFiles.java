package de.example.writereaddeletefiles;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import android.content.Context;

public class ReadWriteDeleteFiles {
	
	private Context context;
	private FileOutputStream os = null;
	private Writer writer = null;

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

}
