package com.curso.android.aula1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Aula1Activity extends Activity {
	
	private EditText editName;
	
	private RadioButton radioMan;
	
	private RadioButton radioWoman;
	
	private CheckBox checkMusic;
	
	private CheckBox checkRun;
	
	private CheckBox checkStudy;
	
	private Button buttonGenerateReport;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aula1);
		bindViews();
		buttonGenerateReport.setOnClickListener(onGenerateReport);
	}

	private void bindViews() {
		editName = (EditText) findViewById(R.id.edit_name);
		radioMan = (RadioButton) findViewById(R.id.radio_man);
		radioWoman = (RadioButton) findViewById(R.id.radio_woman);
		checkMusic = (CheckBox) findViewById(R.id.checkbox_music);
		checkRun = (CheckBox) findViewById(R.id.checkbox_run);
		checkStudy = (CheckBox) findViewById(R.id.checkbox_study);
		buttonGenerateReport = (Button) findViewById(R.id.button);
	}
	
	private final OnClickListener onGenerateReport = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			final Intent intent = new Intent(Aula1Activity.this, ReportActivity.class);
			final Bundle bundle = new Bundle();
			bundle.putCharSequence("Name", editName.getText());
			
			if( radioMan.isChecked() ){
				bundle.putCharSequence("Sex", "Man");
			} else if( radioWoman.isChecked() ){
				bundle.putCharSequence("Sex", "Woman");
			}
			
			final ArrayList<String> preferences = new ArrayList<String>();
			if( checkMusic.isChecked() ){
				preferences.add("Music");
			}
			if( checkRun.isChecked() ){
				preferences.add("Run");
			}
			if( checkStudy.isChecked() ){
				preferences.add("Study");
			}
			
			bundle.putStringArrayList("Preferences", preferences);
			intent.putExtras(bundle);
			startActivity(intent);
		}
	};

}
