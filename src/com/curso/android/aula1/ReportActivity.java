package com.curso.android.aula1;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ReportActivity extends Activity {
	
	private TextView name;
	
	private TextView sex;
	
	private TextView preferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);
		bindViews();
		getReportData();
	}

	private void bindViews() {
		name = (TextView) findViewById(R.id.report_name);
		sex = (TextView) findViewById(R.id.report_sex);
		preferences = (TextView) findViewById(R.id.report_preferences);
	}

	private void getReportData() {
		final Bundle bundle = getIntent().getExtras();
		name.setText(" " + bundle.getCharSequence("Name"));
		sex.setText(" " + bundle.getCharSequence("Sex"));
		
		List<String> preferencesList = bundle.getStringArrayList("Preferences");
		String aux = " ";
		for (String string : preferencesList) {
			aux += string + ", ";
		}
		
		preferences.setText(aux);
	}

}
