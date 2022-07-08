package org.grits.toolbox.datamodel.ms.tablemodel.dmtranslate;

/**
 * Abstraction for the Peak class in the GRITS object model.
 * 
 * @author D Brent Weatherly (dbrentw@uga.edu)
 *
 */
public enum DMPeak 
{
	peak_id("Peak Id", "The auto-assigned ID of the MS peak."),
	peak_mz("Peak m/z", "The m/z of the MS peak."),
	peak_intensity("Peak Intensity", "The raw intensity of the MS peak."),
	peak_charge("Peak Charge", "The assigned charge of the MS peak (-1 means unassigned)."),
	peak_is_precursor("Peak Is Precursor", "Tells whether the peak was selected for fragmentation."),
	peak_relative_intensity("Relative Intensity", "The relative intensity of the current peak to the most abundant peak in the peak list.");
	
    private String sLabel;    
    private String sDescription;
    
    private DMPeak( String sLabel, String sDescription ) {
        this.sLabel = sLabel;
        this.sDescription = sDescription;
    }

    public String getDescription() {
 		return sDescription;
 	}
    
    public String getLabel() 
    {  
        return this.sLabel;  
    }	
        
    public static DMPeak lookUp( String _sKey ) {
    	if ( peak_id.name().equals(_sKey ) )
    		return peak_id;
    	else if ( peak_intensity.name().equals(_sKey) ) 
    		return peak_intensity;
    	else if ( peak_charge.name().equals(_sKey) ) 
    		return peak_charge;
    	else if ( peak_mz.name().equals(_sKey) ) 
    		return peak_mz;
    	else if ( peak_is_precursor.name().equals(_sKey) ) 
    		return peak_is_precursor;
    	else if ( peak_relative_intensity.name().equals(_sKey) ) 
    		return peak_relative_intensity;
    	
    	return null;
    } 
    
}
