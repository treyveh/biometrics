/** 
 * File:    Type2Record.java
 * Package: com.biometricom.ebts.dod
 *
 * Copyright (c) 2011 BiometriCom, Inc.
 * http://www.BiometriCom.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of BiometriCom, Inc.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with BiometriCom, Inc..
 *
 */
package com.biometricom.ebts.dod;

import com.biometricom.nist.itl.biometrics.interchange.Field;

/** 
 * 
 *
 * 
 * Change History:
 * Date - Who : Details
 * --------------------------------------------------------------------
 * Oct 5, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class Type2Record extends com.biometricom.ebts.fbi.Type2Record
{
	public Field getField(int field_no)
	{ 
		if (isFieldAvailable(field_no) == false)
		{
			return null;
		}
		
		Field f = null;
		
		switch (field_no)
		{
			case 303: 
				f = new Field(getType(), field_no, "DoD Number", "DOD_NO");
				
				return f;
				
			case 306: 
				f = new Field(getType(), field_no, "Geographic Coordinate Latitude/Longitude", "GEO_CORD");
				
				return f;
				
			case 307: 
				f = new Field(getType(), field_no, "Geographic Coordinate Datum", "DATUM_ID");
				
				return f;
				
			case 310: 
				f = new Field(getType(), field_no, "Biometric Subject Personnel Type", "PER_TYPE");
				
				return f;
				
			case 316: 
				f = new Field(getType(), field_no, "Request Mug Shot", "RMS");
				
				return f;
				
			case 317: 
				f = new Field(getType(), field_no, "Request Secondary Search", "RIS");
				
				return f;
				
			case 318: 
				f = new Field(getType(), field_no, "XML-based Rap Sheet", "XML");
				
				return f;
				
			case 321: 
				f = new Field(getType(), field_no, "Geographic Coordinate - Other", "CORD_OTHER");
				
				return f;
				
			case 322: 
				f = new Field(getType(), field_no, "Geographic Coordinate Universal Transverse Mercator", "CORD_UTM");
				
				return f;
				
			case 350: 
				f = new Field(getType(), field_no, "Alert", "ALERT");
				
				return f;
				
			case 351: 
				f = new Field(getType(), field_no, "Additional Response", "ARSP");
				
				return f;
				
			case 352: 
				f = new Field(getType(), field_no, "Transaction Lookup", "LOOKUP");
				
				return f;
				
			case 353: 
				f = new Field(getType(), field_no, "Subsequent Notification", "SN");
				
				return f;
				
			case 8000: 
				f = new Field(getType(), field_no, "Biometric Subject Name", "NAME");
				
				return f;
				
			case 8001: 
				f = new Field(getType(), field_no, "Biometric Subject Address", "SUBJ_ADDR");
				
				return f;
				
			case 8002: 
				f = new Field(getType(), field_no, "Biometric Subject Contact", "SUBJ_CNTCT");
				
				return f;
				
			case 8003: 
				f = new Field(getType(), field_no, "Biometric Subject Birth Date", "DOB");
				
				return f;
				
			case 8004: 
				f = new Field(getType(), field_no, "Biometric Subject Birth Place", "POB");
				
				return f;
				
			case 8005: 
				f = new Field(getType(), field_no, "Biometric Subject Death Date", "DOD");
				
				return f;
				
			case 8006: 
				f = new Field(getType(), field_no, "Biometric Subject Death Place", "POD");
				
				return f;
				
			case 8007: 
				f = new Field(getType(), field_no, "Biometric Subject Citizenship", "CTZ");
				
				return f;
				
			case 8008: 
				f = new Field(getType(), field_no, "Biometric Subject Ethnic / Racial Characteristic", "RACE");
				
				return f;
				
			case 8009: 
				f = new Field(getType(), field_no, "Biometric Subject Measurement - Height", "HGT");
				
				return f;
				
			case 8010: 
				f = new Field(getType(), field_no, "Biometric Subject Measurement - Weight", "WGT");
				
				return f;
				
			case 8011: 
				f = new Field(getType(), field_no, "Biometric Subject Eye Color Left", "LEYE");
				
				return f;
				
			case 8012: 
				f = new Field(getType(), field_no, "Biometric Subject Eye Color Right", "REYE");
				
				return f;
				
			case 8013: 
				f = new Field(getType(), field_no, "Biometric Subject Blood Type", "BLOOD");
				
				return f;
				
			case 8014: 
				f = new Field(getType(), field_no, "Biometric Subject Vital Status", "VITAL");
				
				return f;
				
			case 8015: 
				f = new Field(getType(), field_no, "Biometric Subject Other Physical Characteristic", "OTHER_PHYS");
				
				return f;
				
			case 8016: 
				f = new Field(getType(), field_no, "Biometric Subject Marital Status", "MAR_STAT");
				
				return f;
				
			case 8017: 
				f = new Field(getType(), field_no, "Biometric Subject Associated Individual", "IASSOC");
				
				return f;
				
			case 8018: 
				f = new Field(getType(), field_no, "Biometric Subject Group Membership", "GRPMBR");
				
				return f;
				
			case 8019: 
				f = new Field(getType(), field_no, "Collected Identification", "COL_IDENT");
				
				return f;
				
			case 8020: 
				f = new Field(getType(), field_no, "Collection Application Assigned Identification", "COL_APP_ASGN_IDENT");
				
				return f;
				
			case 8021: 
				f = new Field(getType(), field_no, "Biometric Subject Clearance", "CLEAR");
				
				return f;
				
			case 8022: 
				f = new Field(getType(), field_no, "Biometric Subject Claimed Compartments", "COMPART");
				
				return f;
				
			case 8023: 
				f = new Field(getType(), field_no, "Biometric Subject Comment", "SUBJ_COM");
				
				return f;
				
			case 8024: 
				f = new Field(getType(), field_no, "Biometric Subject US Person Indicator", "SUBJ_COM");
				
				return f;
				
			case 8025: 
				f = new Field(getType(), field_no, "Biometric Subject Derogatory Comment", "SUBJ_COM");
				
				return f;
				
			case 8100: 
				f = new Field(getType(), field_no, "Collection Location", "BLO");
				
				return f;
				
			case 8101: 
				f = new Field(getType(), field_no, "Contextual Data Collection Date", "COLL_DATE");
				
				return f;
				
			case 8102: 
				f = new Field(getType(), field_no, "Encounter Mission Type", "ENCTR_MSN");
				
				return f;
				
			case 8103: 
				f = new Field(getType(), field_no, "Collection Reason", "COL_RSN");
				
				return f;
				
			case 8104: 
				f = new Field(getType(), field_no, "Operational Personnel", "OPER");
				
				return f;
				
			case 8105: 
				f = new Field(getType(), field_no, "Conveyance", "CONVEY");
				
				return f;
				
			case 8106: 
				f = new Field(getType(), field_no, "Event", "EVENT");
				
				return f;
				
			case 8107: 
				f = new Field(getType(), field_no, "Biometric Subject Privacy Act Indicator", "PRI_ACT");
				
				return f;
				
			case 8108: 
				f = new Field(getType(), field_no, "Encounter Comment", "ENCTR_COM");
				
				return f;
				
			case 8109: 
				f = new Field(getType(), field_no, "DoD Candidate List", "DOD_CAND");
				
				return f;
				
			case 8110: 
				f = new Field(getType(), field_no, "Iris Omitted Reason", "IOMITTED");
				
				return f;
				
			case 8200: 
				f = new Field(getType(), field_no, "Submission Priority", "PRIORITY");
				
				return f;
				
			case 8202: 
				f = new Field(getType(), field_no, "Verification Identifier", "VID");
				
				return f;
				
			case 8203: 
				f = new Field(getType(), field_no, "Template Extraction Algorithm", "TEA");
				
				return f;
				
			case 8204: 
				f = new Field(getType(), field_no, "Limit of Candidates", "LIMIT_CAND");
				
				return f;
				
				
			default:
				return super.getField(field_no);
		
		}
	}
}
