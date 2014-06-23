package com.github.RISKYScarecrow.shoporder;

import android.widget.CheckBox;
import android.widget.TextView;

public class StockViewHolder {
	private CheckBox checkbox1;
	private TextView textview;
	
	public StockViewHolder() {}
	
	public StockViewHolder (TextView tv, CheckBox cb1)
	{
		this.textview = tv;
		this.checkbox1 = cb1;

	}
	
	
	//Set-ers
	public void setTextView(TextView tv)
	{
		this.textview = tv;
	}
	
	public void setCheckBox1(CheckBox cb)
	{
		this.checkbox1 = cb;
	}
	
	
	//Get-ers
	public TextView getTextView()
	{
		return this.textview;
	}
	
	public CheckBox getCheckBox1()
	{
		return this.checkbox1;
	}

}
