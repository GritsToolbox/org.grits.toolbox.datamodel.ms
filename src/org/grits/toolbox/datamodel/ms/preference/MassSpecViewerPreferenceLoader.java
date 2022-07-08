package org.grits.toolbox.datamodel.ms.preference;

import org.apache.log4j.Logger;
import org.grits.toolbox.core.datamodel.UnsupportedVersionException;
import org.grits.toolbox.core.preference.share.PreferenceEntity;

import org.grits.toolbox.datamodel.ms.tablemodel.FillTypes;
import org.grits.toolbox.display.control.table.preference.TableViewerPreference;

public class MassSpecViewerPreferenceLoader {
	private static final Logger logger = Logger.getLogger(MassSpecViewerPreferenceLoader.class);

	public static MassSpecViewerPreference getTableViewerPreference(int _iMSLevel, FillTypes fillType )  {
		MassSpecViewerPreference preferences = null;
		try {
			PreferenceEntity preferenceEntity = MassSpecViewerPreference.getPreferenceEntity(_iMSLevel, fillType); 
			if( preferenceEntity == null ) { // previous version
				preferences = MassSpecViewerPreferencePreVersion.getTableViewerPreferencesPreVersioning(_iMSLevel, fillType);
				
				if( preferences != null ) {
					MassSpecViewerPreferencePreVersion.removeElements(_iMSLevel, fillType);
				}
				if( preferences.getColumnSettings() != null ) {
					preferences.writePreference();
				}
			} else {
				preferences = (MassSpecViewerPreference) TableViewerPreference.getTableViewerPreference(preferenceEntity, MassSpecViewerPreference.class);
			}
		} catch (UnsupportedVersionException ex) {
			logger.error(ex.getMessage(), ex);
			
		} catch( Exception ex ) {
			logger.error(ex.getMessage(), ex);
		}		
		if( preferences == null ) { // well, either no preferences yet or some error. initialize to defaults and return
			preferences = new MassSpecViewerPreference();
			preferences.setFillType(fillType);
			preferences.setMSLevel(_iMSLevel);
			preferences.setColumnSettings("");
		}
		return preferences;
	}
	
}
