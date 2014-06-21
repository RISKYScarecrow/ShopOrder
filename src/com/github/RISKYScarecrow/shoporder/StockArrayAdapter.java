package com.github.RISKYScarecrow.shoporder;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class StockArrayAdapter extends ArrayAdapter<Stock> 
{
    private LayoutInflater inflater;  
      
    public StockArrayAdapter( Context context, List<Stock> planetList ) {  
      super( context, R.layout.simplerow, R.id.rowTextView, planetList );  
      // Cache the LayoutInflate to avoid asking for a new one each time.  
      inflater = LayoutInflater.from(context) ;  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
      // Planet to display  
      Stock stock = (Stock) this.getItem(position);   
  
      // The child views in each row.  
      CheckBox checkBox ;   
      TextView textView ;   
        
      // Create a new row view  
      if ( convertView == null ) {  
        convertView = inflater.inflate(R.layout.simplerow, null);  
          
        // Find the child views.  
        textView = (TextView) convertView.findViewById( R.id.rowTextView );  
        checkBox = (CheckBox) convertView.findViewById( R.id.CheckBox01 );  
          
        // Optimization: Tag the row with it's child views, so we don't have to   
        // call findViewById() later when we reuse the row.  
        convertView.setTag( new StockViewHolder(textView,checkBox) );  
  
        // If CheckBox is toggled, update the planet it is tagged with.  
        checkBox.setOnClickListener( new View.OnClickListener() {  
          public void onClick(View v) {  
            CheckBox cb = (CheckBox) v ;  
            Stock stock= (Stock) cb.getTag();  
            stock.setChecked( cb.isChecked() );  
          }  
        });          
      }  
      // Reuse existing row view  
      else {  
        // Because we use a ViewHolder, we avoid having to call findViewById().  
        StockViewHolder viewHolder = (StockViewHolder) convertView.getTag();  
        checkBox = viewHolder.getCheckBox() ;  
        textView = viewHolder.getTextView() ;  
      }  
  
      // Tag the CheckBox with the Planet it is displaying, so that we can  
      // access the planet in onClick() when the CheckBox is toggled.  
      checkBox.setTag(stock);   
        
      // Display planet data  
      checkBox.setChecked(stock.isChecked());  
      textView.setText(stock.getName());        
        
      return convertView;  
    }  
      
  }  