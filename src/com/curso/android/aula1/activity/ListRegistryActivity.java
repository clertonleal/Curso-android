package com.curso.android.aula1.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.curso.android.aula1.R;
import com.curso.android.aula1.domain.Registry;

public class ListRegistryActivity extends Activity {
	
	private ListView listView;
	
	private ArrayAdapter<String> adapter;
	
	private List<Registry> registries;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_registry);
		listView = (ListView) findViewById(R.id.list_registry);
		registries = (ArrayList<Registry>)getIntent().getSerializableExtra("Registries");
		
		final List<String> names = new ArrayList<String>();
		
		for (Registry registry : registries) {
			names.add(registry.getName());
		}
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(onRegistryClickListener);
	}
	
	private final OnItemClickListener onRegistryClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			final Intent intent = new Intent(ListRegistryActivity.this, ReportActivity.class);
			intent.putExtra("Registry", registries.get(position));
			startActivity(intent);
		}
	};

}
