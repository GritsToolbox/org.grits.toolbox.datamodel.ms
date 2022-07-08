package org.grits.toolbox.datamodel.ms.preference;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.grits.toolbox.core.datamodel.UnsupportedVersionException;
import org.grits.toolbox.core.preference.share.PreferenceEntity;
import org.grits.toolbox.core.preference.share.PreferenceReader;
import org.grits.toolbox.core.preference.share.PreferenceWriter;

import org.grits.toolbox.datamodel.ms.tablemodel.FillTypes;
import org.grits.toolbox.datamodel.ms.tablemodel.dmtranslate.DMPeak;
import org.grits.toolbox.datamodel.ms.tablemodel.dmtranslate.DMPrecursorPeak;
import org.grits.toolbox.datamodel.ms.tablemodel.dmtranslate.DMScan;
import org.grits.toolbox.display.control.table.datamodel.GRITSColumnHeader;
import org.grits.toolbox.display.control.table.preference.TableViewerPreference;

/**
 * Preferences appropriate for Mass Spec experiments.
 * 
 * @author D Brent Weatherly (dbrentw@uga.edu)
 *
 */
@XmlRootElement(name="massSpecViewerPreference")
public class MassSpecViewerPreference extends TableViewerPreference {
	private static final String PREFERENCE_NAME_ALL = "org.grits.toolbox.datamodel.ms.preference.MassSpecViewerPreference";
	/*
	 * Version history:
	 * 1.0 - Original release w/ versioning
	 * 1.1 - Committed 03/08/16. Re-versioned because parent class "TableViewerPreference" was modified
	 */
	private static final String CURRENT_VERSION = "1.1";
	protected int iMSLevel;
	protected FillTypes fillType = FillTypes.Scans;
	//log4J Logger
	private static final Logger logger = Logger.getLogger(MassSpecViewerPreference.class);

	// Show RAW peaks
	protected boolean bShowRaw = true;
	// Show picked peaks (precursors)
	protected boolean bShowPicked = false;
	// Show picked peak labels (m/z)
	protected boolean bShowPickedLabels = false;
	// Show annotated peaks (picked peaks that have been annotated)
	protected boolean bShowAnnotated = false;
	// Show annotated peak labels (text, image, etc)
	protected boolean bShowAnnotatedLabels = false;
	
	
	public MassSpecViewerPreference() {
		this( 0, FillTypes.Scans);
	}
	
	public MassSpecViewerPreference( int _iMSLevel, FillTypes fillType ) {
		super();
		this.iMSLevel = _iMSLevel;
		this.fillType = fillType;
	}

	/**
	 * @return true if user wants to see RAW peaks in the MS Spectra, false otherwise
	 */
	public boolean isShowRaw() {
		return bShowRaw;
	}
	/**
	 * @param bShowRaw
	 * 		Sets whether or not the user wants to see RAW peaks in the MS Spectra
	 */
	@XmlAttribute(name="showRaw")
	public void setShowRaw(boolean bShowRaw) {
		this.bShowRaw = bShowRaw;
	}

	/**
	 * @return true if the user wants to see annotated peaks in the MS Spectra, false otherwise
	 */
	public boolean isShowAnnotated() {
		return bShowAnnotated;
	}
	/**
	 * @param bShowAnnotated
	 * 		Sets whether or not the user wants to see annotated peaks in the MS Spectra
	 */
	@XmlAttribute(name="showAnnotated")
	public void setShowAnnotated(boolean bShowAnnotated) {
		this.bShowAnnotated = bShowAnnotated;
	}
	
	/**
	 * @return true if the user wants to see annotated peak labels in the MS Spectra, false otherwise
	 */
	public boolean isShowAnnotatedLabels() {
		return bShowAnnotatedLabels;
	}
	/**
	 * @param bShowAnnotatedLabels
	 * 		Sets whether or not the user wants to see annotated peak labels in the MS Spectra
	 */
	@XmlAttribute(name="showAnnotatedLabels")
	public void setShowAnnotatedLabels(boolean bShowAnnotatedLabels) {
		this.bShowAnnotatedLabels = bShowAnnotatedLabels;
	}
	
	/**
	 * @return true if the user wants to see picked peaks in the MS Spectra, false otherwise
	 */
	public boolean isShowPicked() {
		return bShowPicked;
	}
	/**
	 * @param bShowPicked
	 * 		Sets whether or not the user wants to see picked peaks in the MS Spectra
	 */
	@XmlAttribute(name="showPicked")
	public void setShowPicked(boolean bShowPicked) {
		this.bShowPicked = bShowPicked;
	}
	
	/**
	 * @return true if the user wants to see picked peak labels in the MS Spectra, false otherwise
	 */
	public boolean isShowPickedLabels() {
		return bShowPickedLabels;
	}
	/**
	 * @param bShowPickedLabels
	 * 		Sets whether or not the user wants to see picked peak labels in the MS Spectra
	 */
	@XmlAttribute(name="showPickedLabels")
	public void setShowPickedLabels(boolean bShowPickedLabels) {
		this.bShowPickedLabels = bShowPickedLabels;
	}
	
	/**
	 * @return the specified fill type for the GRITS Table
	 */
	public FillTypes getFillType() {
		return fillType;
	}
	/**
	 * @param fillType
	 * 		the desired fill type for the GRITS table
	 */
	@XmlAttribute(name="fillType")
	public void setFillType(FillTypes fillType) {
		this.fillType = fillType;
	}
	
	/**
	 * @param iMSLevel
	 * 		the MS Level for the GRITS Table
	 */
	public void setMSLevel(int iMSLevel) {
		this.iMSLevel = iMSLevel;
	}	
	/**
	 * @return the MS Level of the GRITS Table
	 */
	@XmlAttribute(name="msLevel")
	public int getMSLevel() {
		return iMSLevel;
	}
	
	/**
	 * Called to create the String ID of this Mass Spec GRITS table preference entry.
	 * @param _iMSLevel
	 * 		the MS Level of the GRITS Table
	 * @param _fillType
	 * 		the fill type of the GRITS Table
	 * @return an ID for the preference file for this GRITS Table
	 */
	protected static String getPreferenceID( int _iMSLevel, FillTypes _fillType ) {
		String sAdder = "";
		String sName = PREFERENCE_NAME_ALL;
		if ( _fillType == FillTypes.Scans ) {
			sAdder = ".Scans";
		}
		else if ( _fillType == FillTypes.PeakList ) {
			sAdder = ".Peaks";
		}
		else if ( _fillType == FillTypes.PeaksWithFeatures ) {
			sAdder = ".PeaksWithFeatures";
		}
		sName += sAdder;
		sName += ".MSLevel" + (_iMSLevel - 1);
		return sName;
	}
	
	/**
	 * @param _iMSLevel
	 * 		the MS Level of the GRITS Table
	 * @param _fillType
	 * 		the fill type of the GRITS Table
	 * @return the MassSpec PreferenceEntity for the GRITS Table with the specified MS level and fill type
	 * @throws UnsupportedVersionException
	 */
	public static PreferenceEntity getPreferenceEntity( int _iMSLevel, FillTypes _fillType  ) throws UnsupportedVersionException {
		PreferenceEntity preferenceEntity = PreferenceReader.getPreferenceByName(MassSpecViewerPreference.getPreferenceID(_iMSLevel, _fillType));
		return preferenceEntity;
	}
	
	/**
	 * @return the current version of the mass spec viewer preference
	 */
	protected String getCurrentVersion() {
		return MassSpecViewerPreference.CURRENT_VERSION; 
	}
	
	/* (non-Javadoc)
	 * @see org.grits.toolbox.display.control.table.preference.TableViewerPreference#writePreference()
	 */
	@Override
	public boolean writePreference() {
		PreferenceEntity preferenceEntity = new PreferenceEntity(MassSpecViewerPreference.getPreferenceID(getMSLevel(), getFillType()));
		preferenceEntity.setVersion(getCurrentVersion());
		preferenceEntity.setValue(marshalXML());
		return PreferenceWriter.savePreference(preferenceEntity);
	}
	
	/** 
	 * Creates Mass Spec column header objects (if the key is recognized). 
	 * If the key isn't recognized, it won't be added to the table!
	 * @see org.grits.toolbox.display.control.table.preference.TableViewerPreference#getColumnHeader(java.lang.String)
	 */
	@Override
	public GRITSColumnHeader getColumnHeader(String _sKey) {
		if ( _sKey.equals(DMScan.scan_scanNo.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_scanNo.getLabel(), DMScan.scan_scanNo.name() );
		}
		if ( _sKey.equals(DMScan.scan_pseudoScanNo.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_pseudoScanNo.getLabel(), DMScan.scan_pseudoScanNo.name() );
		}
		if ( _sKey.equals(DMScan.scan_parentScan.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_parentScan.getLabel(), DMScan.scan_parentScan.name() );
		}		
		if ( _sKey.equals(DMScan.scan_retentionTime.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_retentionTime.getLabel(), DMScan.scan_retentionTime.name());
		}
		if ( _sKey.equals(DMScan.scan_scanStart.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_scanStart.getLabel(), DMScan.scan_scanStart.name() );
		}
		if ( _sKey.equals(DMScan.scan_scanEnd.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_scanEnd.getLabel(), DMScan.scan_scanEnd.name() );
		}
		if ( _sKey.equals(DMScan.scan_msLevel.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_msLevel.getLabel(), DMScan.scan_msLevel.name() );
		}
		if ( _sKey.equals(DMScan.scan_polarity.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_polarity.getLabel(), DMScan.scan_polarity.name() );
		}
		if ( _sKey.equals(DMScan.scan_activationMethode.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_activationMethode.getLabel(), DMScan.scan_activationMethode.name() );
		}
		if ( _sKey.equals(DMScan.scan_numsubscans.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_numsubscans.getLabel(), DMScan.scan_numsubscans.name() );
		}
		if ( _sKey.equals(DMScan.scan_numannotatedpeaks.name() ) ) {
			return new GRITSColumnHeader( DMScan.scan_numannotatedpeaks.getLabel(), DMScan.scan_numannotatedpeaks.name() );
		}
		if ( _sKey.equals(DMPeak.peak_id.name() ) ) {
			return new GRITSColumnHeader( DMPeak.peak_id.getLabel(), DMPeak.peak_id.name() );
		}
		if ( _sKey.equals(DMPeak.peak_mz.name() ) ) {
			return new GRITSColumnHeader( DMPeak.peak_mz.getLabel(), DMPeak.peak_mz.name() );
		}
		if ( _sKey.equals(DMPeak.peak_intensity.name() ) ) {
			return new GRITSColumnHeader( DMPeak.peak_intensity.getLabel(), DMPeak.peak_intensity.name() );
		}
		if ( _sKey.equals(DMPeak.peak_relative_intensity.name() ) ) {
			return new GRITSColumnHeader( DMPeak.peak_relative_intensity.getLabel(), DMPeak.peak_relative_intensity.name() );
		}
		if ( _sKey.equals(DMPeak.peak_charge.name() ) ) {
			return new GRITSColumnHeader( DMPeak.peak_charge.getLabel(), DMPeak.peak_charge.name() );
		}
		if ( _sKey.equals(DMPrecursorPeak.precursor_peak_mz.name() ) ) {
			return new GRITSColumnHeader( DMPrecursorPeak.precursor_peak_mz.getLabel(), DMPrecursorPeak.precursor_peak_mz.name() );
		}
		if ( _sKey.equals(DMPrecursorPeak.precursor_peak_intensity.name() ) ) {
			return new GRITSColumnHeader( DMPrecursorPeak.precursor_peak_intensity.getLabel(), DMPrecursorPeak.precursor_peak_intensity.name() ); 
		}
		if ( _sKey.equals(DMPrecursorPeak.precursor_peak_relative_intensity.name() ) ) {
			return new GRITSColumnHeader( DMPrecursorPeak.precursor_peak_relative_intensity.getLabel(), DMPrecursorPeak.precursor_peak_relative_intensity.name() ); 
		}
		if ( _sKey.equals(DMPrecursorPeak.precursor_peak_charge.name() ) ) {
			return new GRITSColumnHeader( DMPrecursorPeak.precursor_peak_charge.getLabel(), DMPrecursorPeak.precursor_peak_charge.name() );
		}
		return null;
	}
	
	
	
}