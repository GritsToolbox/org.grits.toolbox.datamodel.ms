package org.grits.toolbox.datamodel.ms.tablemodel.dmtranslate;

/**
 * Abstraction for the Scan class in the GRITS object model.
 * 
 * @author D Brent Weatherly (dbrentw@uga.edu)
 *
 */
public enum DMScan
{
	scan_scanNo("Scan #", "The MS scan number."),
	scan_pseudoScanNo("Matched Peak #", "A system-created scan number to represent the summary scan in GRITS."),
	scan_retentionTime("Retention Time", "The elution retention time for the analyte producing the scan."),
	scan_parentScan("Parent Scan #", "The parent scan number of the current scan (-1 if it has no parent)."),
	scan_scanStart("Low m/z", "The low m/z value of the MS scan range."),
	scan_scanEnd("High m/z", "The high m/z value of the MS scan range."),
	scan_msLevel("MS Level", "The MS level of the scan."),
	scan_polarity("Polarity", "Tells whether the MS was performed in postive mode or not."),
	scan_activationMethode("Activation Method", "The activation method of the MS scan (-1 if not known)."),
	scan_numsubscans("Num Sub-scans", "The activation method of the MS scan (-1 if not known)."),
	scan_numannotatedpeaks("Num Annotated Peaks", "If annotated by an external tool (e.g. glycan), then the number of peaks in the scan that were annotated.");
	
    private String sLabel;
    private String sDescription;

    public String getDescription() {
 		return sDescription;
 	}
    
    private DMScan( String sLabel, String sDescription ) {
        this.sLabel = sLabel;
        this.sDescription = sDescription;
    }

    public String getLabel() 
    {  
        return this.sLabel;  
    }		
    
    public static DMScan lookUp( String _sKey ) {
    	if ( scan_scanNo.name().equals(_sKey ) )
    		return scan_scanNo;
    	else if ( scan_pseudoScanNo.name().equals(_sKey ) )
    		return scan_pseudoScanNo;
    	else if ( scan_retentionTime.name().equals(_sKey) ) 
    		return scan_retentionTime;
    	else if ( scan_parentScan.name().equals(_sKey) ) 
    		return scan_parentScan;
    	else if ( scan_scanStart.name().equals(_sKey) ) 
    		return scan_scanStart;
    	else if ( scan_scanEnd.name().equals(_sKey) ) 
    		return scan_scanEnd;
    	else if ( scan_msLevel.name().equals(_sKey) ) 
    		return scan_msLevel;
    	else if ( scan_polarity.name().equals(_sKey) ) 
    		return scan_polarity;
    	else if ( scan_activationMethode.name().equals(_sKey) ) 
    		return scan_activationMethode;
    	else if ( scan_numsubscans.name().equals(_sKey) ) 
    		return scan_numsubscans;
    	else if ( scan_numannotatedpeaks.name().equals(_sKey) ) 
    		return scan_numannotatedpeaks;
    	
    	return null;
    } 
    
}
