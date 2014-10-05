package de.example.writereaddeletefiles;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private EditText eingabe;
	private Button savebutton;
	private Context context;
	private ReadWriteDeleteFiles rwfd = null;

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
				rwfd = new ReadWriteDeleteFiles(context);
				rwfd.writefile(eingabe.getText().toString());
				Toast.makeText(getApplicationContext(), "Inhalt wurde abgespeichert",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
