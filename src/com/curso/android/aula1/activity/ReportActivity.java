package com.curso.android.aula1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.curso.android.aula1.R;
import com.curso.android.aula1.domain.Registry;

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
		final Registry registry = (Registry) getIntent().getSerializableExtra("Registry");
		name.setText(" " + registry.getName());
		sex.setText(" " + registry.getSex());
		
		String aux = " ";
		for (String string : registry.getPreferences()) {
			aux += string + ", ";
		}
		
		preferences.setText(aux);
	}

}
