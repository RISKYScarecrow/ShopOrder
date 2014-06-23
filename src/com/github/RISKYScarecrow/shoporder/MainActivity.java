package com.github.RISKYScarecrow.shoporder;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	/*
	 * ArrayAdapter<Stock> listAdapter; List<String> myList = new
	 * ArrayList<String>();
	 */
	private ListView mainListView;
	private Stock[] stockItems;
	private ArrayAdapter<Stock> listAdapter;
	ArrayList<Stock> stockList;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		// Find the ListView resource.
		mainListView = (ListView) findViewById(R.id.list);

		// When item is tapped, toggle checked properties of CheckBox and
		// Planet.
		mainListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View item,
							int position, long id) {
						Stock stock = listAdapter.getItem(position);
						stock.toggleChecked();
						StockViewHolder viewHolder = (StockViewHolder) item
								.getTag();
						viewHolder.getCheckBox1().setChecked(stock.isChecked());
					}
				});

		// Create and populate stockItems.
		if (stockItems == null) {
			stockItems = new Stock[] { new Stock("Pants", "123456")};
		}
		stockList = new ArrayList<Stock>();
		stockList.addAll(Arrays.asList(stockItems));

		// Set our custom array adapter as the ListView's adapter.
		listAdapter = new StockArrayAdapter(this, stockList);
		mainListView.setAdapter(listAdapter);
	}

	public OnTouchListener gestureListener;

	public void sendMessage(View v) {
		EditText editText = (EditText) findViewById(R.id.editText1);
		String mess = editText.getText().toString();
		editText.setText("");
		stockList.add(new Stock(mess,"000000"));
		// final ArrayAdapter adapter = ((ArrayAdapter)getListAdapter());
		listAdapter.notifyDataSetChanged();
		// Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
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
/*
	static class ViewHolder {
		protected TextView text;
		protected ImageView icon;
		protected CheckBox checkbox;
		protected int position;
		private int color;
		private int imageid;

		public ViewHolder() {
			position = 0;
			color = 0xFFFFFFFF;
		}

		public int getColor() {
			return color;
		}

		public int getImageId() {
			return imageid;
		}

		public void setRunning(boolean running) {
			if (running) {
				color = 0xFFffffb6;
			} else {
				color = 0xFFFFFFFF;
			}
		}
	}
	*/
}
