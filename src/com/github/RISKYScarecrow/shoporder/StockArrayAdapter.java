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
      super( context, R.layout.simplerow, R.id.StockName, planetList );  
      // Cache the LayoutInflate to avoid asking for a new one each time.  
      inflater = LayoutInflater.from(context) ;  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
      // Planet to display  
      Stock stock = (Stock) this.getItem(position);   
  
      // The child views in each row.  
      CheckBox checkBox1;   
      TextView textViewName;
      TextView textViewPLU;
        
      // Create a new row view  
      if ( convertView == null ) {  
        convertView = inflater.inflate(R.layout.simplerow, null);  
          
        // Find the child views.  
        textViewName = (TextView) convertView.findViewById(R.id.StockName);
        textViewPLU = (TextView) convertView.findViewById(R.id.StockPLU);
        checkBox1 = (CheckBox) convertView.findViewById(R.id.CheckBox01); 
        
          
        // Optimization: Tag the row with it's child views, so we don't have to   
        // call findViewById() later when we reuse the row.  
        convertView.setTag(new StockViewHolder(textViewName, textViewPLU, checkBox1));  
  
        // If CheckBox is toggled, update the planet it is tagged with.  
        checkBox1.setOnClickListener( new View.OnClickListener() {  
          public void onClick(View v) {  
            CheckBox cb = (CheckBox) v ;  
            Stock stock= (Stock) cb.getTag();  
            stock.setChecked(cb.isChecked());  
          }  
        });          
      }  
      // Reuse existing row view  
      else {  
        // Because we use a ViewHolder, we avoid having to call findViewById().  
        StockViewHolder viewHolder = (StockViewHolder) convertView.getTag();  
        checkBox1 = viewHolder.getCheckBox1();  

        textViewName  = viewHolder.getTextViewName();
        textViewPLU   = viewHolder.getTextViewPLU();
      }  
  
      // Tag the CheckBox with the Planet it is displaying, so that we can  
      // access the planet in onClick() when the CheckBox is toggled.  
      checkBox1.setTag(stock);   
        
      // Display planet data  
      checkBox1.setChecked(stock.isChecked());  
      textViewName.setText(stock.getName());        
      textViewPLU .setText(stock.getPLU());        
        
      return convertView;  
    }  
      
  }  