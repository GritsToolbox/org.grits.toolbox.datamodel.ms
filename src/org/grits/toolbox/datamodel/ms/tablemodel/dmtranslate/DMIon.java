package org.grits.toolbox.datamodel.ms.tablemodel.dmtranslate;

/**
 * Abstraction for the Ion class in the GRITS object model.
 * 
 * @author D Brent Weatherly (dbrentw@uga.edu)
 *
 */
public enum DMIon {
	
	ion_charge("Ion Charge", "The assigned charge of the ion (-1 means unassigned).");
	
    private String sLabel;
    private String sDescription;

    private DMIon( String sLabel, String sDescription ) {
        this.sLabel = sLabel;
        this.sDescription = sDescription;
    }

    public String getLabel() {  
        return this.sLabel;  
    }	

    public String getDescription() {
		return sDescription;
	}
    
    public static DMIon lookUp( String _sKey ) {
    	if ( ion_charge.name().equals(_sKey ) )
    		return ion_charge;
    	
    	return null;
    } 
    
}
