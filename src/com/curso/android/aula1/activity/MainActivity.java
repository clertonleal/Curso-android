package com.curso.android.aula1.activity;

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
import android.widget.Toast;

import com.curso.android.aula1.R;
import com.curso.android.aula1.domain.Registry;

public class MainActivity extends Activity {
	
	private EditText editName;
	
	private RadioButton radioMan;
	
	private RadioButton radioWoman;
	
	private CheckBox checkMusic;
	
	private CheckBox checkRun;
	
	private CheckBox checkStudy;
	
	private Button buttonInsertRegistry;
	
	private Button buttonListRegistries;
	
	private final ArrayList<Registry> registries = new ArrayList<Registry>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aula1);
		bindViews();
		buttonInsertRegistry.setOnClickListener(onInsertRegistry);
		buttonListRegistries.setOnClickListener(onListRegistries);
	}

	private void bindViews() {
		editName = (EditText) findViewById(R.id.edit_name);
		radioMan = (RadioButton) findViewById(R.id.radio_man);
		radioWoman = (RadioButton) findViewById(R.id.radio_woman);
		checkMusic = (CheckBox) findViewById(R.id.checkbox_music);
		checkRun = (CheckBox) findViewById(R.id.checkbox_run);
		checkStudy = (CheckBox) findViewById(R.id.checkbox_study);
		buttonInsertRegistry = (Button) findViewById(R.id.buttonInsert);
		buttonListRegistries = (Button) findViewById(R.id.buttonList);
	}
	
	private final OnClickListener onInsertRegistry = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			final Registry registry = new Registry();
			
			registry.setName(editName.getText().toString());
			
			if( radioMan.isChecked() ){
				registry.setSex("Man");
			} else if( radioWoman.isChecked() ){
				registry.setSex("Woman");
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
			
			registry.setPreferences(preferences);
			registries.add(registry);
			Toast.makeText(MainActivity.this, "Registro inserido", Toast.LENGTH_LONG).show();
			cleanFields();
			
		}

		private void cleanFields() {
			editName.setText("");
			radioMan.setChecked(true);
			checkMusic.setChecked(false);
			checkRun.setChecked(false);
			checkStudy.setChecked(false);
		}
	};
	
	private final OnClickListener onListRegistries = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			final Intent intent = new Intent(MainActivity.this, ListRegistryActivity.class);
			intent.putExtra("Registries", registries);
			startActivity(intent);
		}
	};

}
