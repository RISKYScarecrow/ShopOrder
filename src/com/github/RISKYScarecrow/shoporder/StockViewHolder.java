package com.github.RISKYScarecrow.shoporder;

import android.widget.CheckBox;
import android.widget.TextView;

public class StockViewHolder {
	private CheckBox checkbox;
	private TextView textview;
	
	public StockViewHolder() {}
	
	public StockViewHolder (TextView tv, CheckBox cb)
	{
		this.textview = tv;
		this.checkbox = cb;
	}
	
	
	//Set-ers
	public void setTextView (TextView tv)
	{
		this.textview = tv;
	}
	
	public void setCheckBox (CheckBox cb)
	{
		this.checkbox = cb;
	}
	
	
	//Get-ers
	public TextView getTextView()
	{
		return this.textview;
	}
	
	public CheckBox getCheckBox()
	{
		return this.checkbox;
	}
}
