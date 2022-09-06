package com.example.demo.models;





public enum Accout_type {
	
  
     saving("saving_account"),
     current("current_account"),
     retirement("retirement_account");
	
	private String name;
	
	 
	
    public String getName()
    {
    	return name;
    }
    
    Accout_type(String name)
	{
		this.name=name;
	}
    
    
	




	
}

