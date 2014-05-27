package com.github.RISKYScarecrow.shoporder;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	//ListView listView;
	ArrayAdapter<String> ListAdapter;

	List<String> myList = new ArrayList<String>();

	public void sendMessage(View v) {
		EditText editText = (EditText) findViewById(R.id.editText1);
		String mess = editText.getText().toString();
		editText.setText("");
		myList.add(mess);
		//final ArrayAdapter adapter = ((ArrayAdapter)getListAdapter());
		ListAdapter.notifyDataSetChanged();
		Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		ListAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, myList);
		ListView lv = (ListView) findViewById(R.id.list);
		lv.setAdapter(ListAdapter);

		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(),
						"Click ListItem Number " + position, Toast.LENGTH_SHORT)
						.show();
			}
		});
		
		
		
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		EditText editText = (EditText) findViewById(R.id.editText1);
		editText.setFocusableInTouchMode(true);
		editText.setFocusable(true);
		editText.requestFocus();
		editText.setCursorVisible(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
