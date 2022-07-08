package org.grits.toolbox.datamodel.ms.tablemodel.dmtranslate;

/**
 * Abstraction for the precursor-specific elements of the Peak class in the GRITS object model.
 * 
 * @author D Brent Weatherly (dbrentw@uga.edu)
 *
 */
public enum DMPrecursorPeak 
{
	precursor_peak_id("Precursor Id", "The auto-assigned ID of the MS precursor peak."),
	precursor_peak_mz("Precursor m/z", "The m/z of the MS precursor peak."),
	precursor_peak_intensity("Precursor Intensity", "The raw intensity of the MS precursor peak."),
	precursor_peak_relative_intensity("Relative Intensity", "The relative intensity of the current precursor peak to the most abundant peak in the peak list."),
	precursor_peak_charge("Precursor Charge", "The assigned charge of the MS precursor peak (-1 means unassigned).");
	
    private String sLabel;
    private String sDescription;
    
    private DMPrecursorPeak( String sLabel, String sDescription ) {
        this.sLabel = sLabel;
        this.sDescription = sDescription;
    }

    public String getLabel() 
    {  
        return this.sLabel;  
    }	

    public String getDescription() {
 		return sDescription;
 	}
    
    public static DMPrecursorPeak lookUp( String _sKey ) {
    	if ( precursor_peak_id.name().equals(_sKey ) )
    		return precursor_peak_id;
    	else if ( precursor_peak_mz.name().equals(_sKey) ) 
    		return precursor_peak_mz;
    	else if ( precursor_peak_charge.name().equals(_sKey) ) 
    		return precursor_peak_charge;
    	else if ( precursor_peak_intensity.name().equals(_sKey) ) 
    		return precursor_peak_intensity;
    	else if ( precursor_peak_relative_intensity.name().equals(_sKey) ) 
    		return precursor_peak_relative_intensity;
    	
    	return null;
    } 
    
}
