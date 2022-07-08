package org.grits.toolbox.datamodel.ms.tablemodel;


public enum FillTypes {
	Scans("Sub-scans List"),
	PeakList("Peak List"),
	Selection("Subset List"),
	PeaksWithFeatures("Annotated Peak List");
	
	private String sLabel;

	private FillTypes( String sLabel )
	{
		this.sLabel = sLabel;
	}

	public String getLabel() 
	{  
		return this.sLabel;  
	}	
	
	  public static FillTypes lookUp( String _sKey ) {
	    	if ( Scans.getLabel().equals(_sKey ) )
	    		return Scans;
	    	if ( PeakList.getLabel().equals(_sKey ) )
	    		return PeakList;	    	
	    	if ( PeaksWithFeatures.getLabel().equals(_sKey ) )
	    		return PeaksWithFeatures;
	    	if ( Selection.getLabel().equals(_sKey ) )
	    		return Selection;
	    	return null;
	    } 
	
}
