package com.github.RISKYScarecrow.shoporder;

import android.widget.CheckBox;
import android.widget.TextView;

public class StockViewHolder {
	private CheckBox checkbox1;
	private TextView textviewName;
	private TextView textviewPLU;
	
	public StockViewHolder() {}
	
	public StockViewHolder (TextView name,TextView plu, CheckBox cb1)
	{
		this.textviewName = name;
		this.textviewPLU = plu;
		this.checkbox1 = cb1;

	}
	
	
	//Set-ers
	public void setTextViewName(TextView tv)
	{
		this.textviewName = tv;
	}
	public void setCheckBox1(CheckBox cb)
	{
		this.checkbox1 = cb;
	}
	public void setTextViewPLU(TextView plu)
	{
		this.textviewPLU = plu;
	}
	
	//Get-ers
	public TextView getTextViewName()
	{
		return this.textviewName;
	}
	public TextView getTextViewPLU()
	{
		return this.textviewPLU;
	}	
	public CheckBox getCheckBox1()
	{
		return this.checkbox1;
	}

}
