package com.github.RISKYScarecrow.shoporder;

public class Stock {  
    private String name;
    private String plu;
    private boolean checked = false ;  
    
    public Stock() {}  
    
    public Stock(String name, String plu) 
    {  
      this.name = name;
      this.plu = plu;
    }  
    
    public Stock(String name, String plu, boolean checked ) 
    {  
      this.name = name; 
      this.plu = plu;
      this.checked = checked;  
    }  
    
    
    //Get-ers
    public String getName() 
    {  
      return name;  
    }    
    public boolean isChecked() 
    {  
      return checked;  
    }  
    public String getPLU()
    {
    	return plu;
    }
    
    
    //Set-ers
    public void setName(String name) 
    {  
      this.name = name;  
    }  
    public void setChecked(boolean checked) 
    {  
      this.checked = checked;  
    }  
    public void setPLU(String plu)
    {
    	this.plu = plu;
    }
    
    //State Changers
    public void toggleChecked() 
    {  
      checked = !checked;  
    }  
  }  