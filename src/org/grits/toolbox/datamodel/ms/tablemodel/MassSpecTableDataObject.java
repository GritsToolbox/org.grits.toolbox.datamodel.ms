package org.grits.toolbox.datamodel.ms.tablemodel;

import java.util.ArrayList;

import org.grits.toolbox.datamodel.ms.preference.MassSpecViewerPreferenceLoader;
import org.grits.toolbox.display.control.table.datamodel.GRITSTableDataObject;

public class MassSpecTableDataObject extends GRITSTableDataObject {    
    protected ArrayList<Integer> alScanNoCol;
    protected ArrayList<Integer> alParentScanNoCol;
    protected Integer iMSLevel = null;
    protected FillTypes fillType = FillTypes.Scans;	
    protected ArrayList<Integer> alPeakIdCol;
    protected ArrayList<Integer> alMzCol;
    protected ArrayList<Integer> alPeakIntensityCol;
    protected ArrayList<Integer> alPeakIsPrecursorCol;
    protected ArrayList<Integer> alPrecursorIntensityCol;
     
    public MassSpecTableDataObject( int _iMSLevel, FillTypes fillType ) {
    	super();
        this.alScanNoCol = new ArrayList<Integer>();
        this.alParentScanNoCol = new ArrayList<>();
        this.iMSLevel = _iMSLevel;
        this.alPeakIdCol = new ArrayList<Integer>();
        this.alPeakIntensityCol = new ArrayList<Integer>();
        this.alPeakIsPrecursorCol = new ArrayList<Integer>();
        this.alPrecursorIntensityCol = new ArrayList<>();
        this.fillType = fillType;
        this.alMzCol = new ArrayList<Integer>();
 	}
           
    public void addMzCol( int iMzCol ) {
    	this.alMzCol.add(iMzCol);
    }
    
    public ArrayList<Integer> getMzCols() {
    	return this.alMzCol;
    }
	
    public void addPeakIdCol( int iPeakIdCol ) {
    	this.alPeakIdCol.add(iPeakIdCol);
    }
    
    public ArrayList<Integer> getPeakIdCols() {
    	return this.alPeakIdCol;
    }

    public void addPeakIntensityCol( int iPeakIntIdCol ) {
    	this.alPeakIntensityCol.add(iPeakIntIdCol);
    }
    
    public ArrayList<Integer> getPeakIntensityCols() {
    	return this.alPeakIntensityCol;
    }
    
    public ArrayList<Integer> getPrecursorIntensityCols() {
		return alPrecursorIntensityCol;
	}

    public void addPeakIsPrecursorCol( int iPeakIsPrecursor ) {
    	this.alPeakIsPrecursorCol.add(iPeakIsPrecursor);
    }
    
    public void addPrecursorIntensityCol (int precursorIntensity) {
    	this.alPrecursorIntensityCol.add(precursorIntensity);
    }
    
    public ArrayList<Integer> getPeakIsPrecursorCols() {
    	return this.alPeakIsPrecursorCol;
    }
    
    public FillTypes getFillType() {
    	return fillType;
    }
    
    public Integer getMSLevel() {
		return iMSLevel;
	}

    /*
    public void setMSLevel(Integer iMSLevel) {
		this.iMSLevel = iMSLevel;
	}
    */
    
    @Override
    public void initializePreferences() {
    	setTablePreferences(MassSpecViewerPreferenceLoader.getTableViewerPreference(getMSLevel(), getFillType()));
    }
        
    public void addScanNoCol( int iScanNoCol ) {
    	this.alScanNoCol.add(iScanNoCol);
    }
    
    public ArrayList<Integer> getScanNoCols() {
    	return this.alScanNoCol;
    }

    public void addParentNoCol( int iScanNoCol ) {
    	this.alParentScanNoCol.add(iScanNoCol);
    }
    
    public ArrayList<Integer> getParentNoCol() {
    	return this.alParentScanNoCol;
    }
    
}
