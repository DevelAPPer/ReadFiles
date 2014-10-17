package de.example.writereaddeletefiles;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private EditText eingabe;
	private Button savebutton;
	private Context context;
	private ReadWriteDeleteFiles rwfd = null;
	private boolean savegeklickt = false;
	private Button readbutton;
	private TextView anzeige;
	private String ausgabe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = MainActivity.this;
		eingabe = (EditText)findViewById(R.id.editText1);
		savebutton = (Button)findViewById(R.id.button1);
		savebutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (eingabe.length()>0) {
					rwfd = new ReadWriteDeleteFiles(context);
					rwfd.writefile(eingabe.getText().toString());
					Toast.makeText(getApplicationContext(), "Inhalt wurde abgespeichert",
							Toast.LENGTH_SHORT).show();
					savegeklickt = true;
				} else {
					Toast.makeText(getApplicationContext(), "Bitte tragen Sie etwas in das Feld ein!",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		readbutton = (Button)findViewById(R.id.button2);
		anzeige = (TextView)findViewById(R.id.textView2);
		readbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (savegeklickt == true) {
					ausgabe = rwfd.readfile();
					anzeige.setText(ausgabe);
					savegeklickt = false;
				} else {
					Toast.makeText(getApplicationContext(), "Bitte zuerst abspeichern",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
