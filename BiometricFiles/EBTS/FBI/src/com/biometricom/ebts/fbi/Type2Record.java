/** 
 * File:    Type2Record.java
 * Package: com.biometricom.ebts.fbi
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
package com.biometricom.ebts.fbi;

import com.biometricom.nist.itl.biometrics.interchange.Field;
import com.biometricom.nist.itl.biometrics.interchange.InformationField;

/** 
 * 
 *
 * 
 * Change History:
 * Date - Who : Details
 * --------------------------------------------------------------------
 * Oct 4, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class Type2Record extends com.biometricom.nist.itl.biometrics.interchange.Type2Record
{
	public Type2Record()
	{
		super();
	}
	
	public Field getField(int field_no)
	{ 
		if (isFieldAvailable(field_no) == false)
		{
			return null;
		}
		
		Field f = null;
		
		switch (field_no)
		{
			case 3: 
				f = new Field(getType(), field_no, "FBI File Number", "FFN");
				
				return f;
		
			case 4: 
				f = new Field(getType(), field_no, "Query Depth Detail", "QDD");
				
				return f;

			case 5: 
				f = new Field(getType(), field_no, "Retention Code", "RET");
				
				return f;

			case 6: 
				f = new Field(getType(), field_no, "Attention Indicator", "ATN");
				
				return f;
		
			case 7: 
				f = new Field(getType(), field_no, "Send Copy To", "SCO");
				
				return f;

			case 9: 
				f = new Field(getType(), field_no, "Originating Agency Case Number", "OCA");
				
				return f;

			case 10: 
				f = new Field(getType(), field_no, "Contributor Case Identifier Number", "CIN");
				
				return f;
		
			case 11: 
				f = new Field(getType(), field_no, "Contributor Case Identifier Extension", "CIX");
				
				return f;
		
			case 12: 
				f = new Field(getType(), field_no, "FBI Latent Case Number", "LCN");
				
				return f;

			case 13: 
				f = new Field(getType(), field_no, "Latent Case Number Extension", "LCX");
				
				return f;

			case 14: 
				f = new Field(getType(), field_no, "FBI Number", "FBI");
				
				return f;
		
			case 15: 
				f = new Field(getType(), field_no, "State Identification Number", "SID");
				
				return f;

			case 16: 
				f = new Field(getType(), field_no, "Social Security Number", "SOC");
				
				return f;

			case 17: 
				f = new Field(getType(), field_no, "Miscellaneous Identification Number", "MNU");
				
				return f;

			case 18: 
				f = new Field(getType(), field_no, "Name", "NAM");
				
				return f;

			case 19: 
				f = new Field(getType(), field_no, "Aliases", "AKA");
				
				return f;
		
			case 20: 
				f = new Field(getType(), field_no, "Place of Birth", "POB");
				
				return f;

			case 21: 
				f = new Field(getType(), field_no, "Country of Citizenship", "CTZ");
				
				return f;
		
			case 22: 
				f = new Field(getType(), field_no, "Date of Birth", "DOB");
				
				return f;
		
			case 23: 
				f = new Field(getType(), field_no, "Age Range", "AGR");
				
				return f;
		
			case 24: 
				f = new Field(getType(), field_no, "Sex", "SEX");
				
				return f;

			case 25: 
				f = new Field(getType(), field_no, "Race", "RAC");
				
				return f;

			case 26: 
				f = new Field(getType(), field_no, "Scars, Marks and Tattoos", "SMT");
				
				return f;

			case 27: 
				f = new Field(getType(), field_no, "Height", "HGT");
				
				return f;

			case 28: 
				f = new Field(getType(), field_no, "Height Range", "HTR");
				
				return f;

			case 29: 
				f = new Field(getType(), field_no, "Weight", "WGT");
				
				return f;

			case 30: 
				f = new Field(getType(), field_no, "Weight Range", "WTR");
				
				return f;

			case 31: 
				f = new Field(getType(), field_no, "Color Eyes", "EYE");
				
				return f;
		
			case 32: 
				f = new Field(getType(), field_no, "Hair Color", "HAI");
				
				return f;

			case 33: 
				f = new Field(getType(), field_no, "NCIC Fingerprint Classification", "FPC");
				
				return f;		

			case 34: 
				f = new Field(getType(), field_no, "Pattern Level Classifications", "PAT");
				
				return f;

			case 35: 
				f = new Field(getType(), field_no, "Palmprints Available Indicator", "PPA");
				
				return f;

			case 36: 
				f = new Field(getType(), field_no, "Photo Available Indicator", "PHT");
				
				return f;

			case 37: 
				f = new Field(getType(), field_no, "Reason Fingerprinted", "RFP");
				
				return f;

			case 38: 
				f = new Field(getType(), field_no, "Date Printed", "DPR");
				
				return f;
		
			case 39: 
				f = new Field(getType(), field_no, "Employer Address", "EAD");
				
				return f;
		
			case 40: 
				f = new Field(getType(), field_no, "Occupation", "OCP");
				
				return f;

			case 41: 
				f = new Field(getType(), field_no, "Residence of Person Fingerprinted", "RES");
				
				return f;

			case 42: 
				f = new Field(getType(), field_no, "Military Code", "MIL");
				
				return f;

			case 43: 
				f = new Field(getType(), field_no, "Type of Search Required", "TSR");
				
				return f;

			case 44: 
				f = new Field(getType(), field_no, "Geographic Area of Search", "GEO");
				
				return f;
			case 45: 
				f = new Field(getType(), field_no, "Date of Arrest", "DOA");
				
				return f;
		
			case 46: 
				f = new Field(getType(), field_no, "Date of Arrest - Suffix", "DOS");
				
				return f;
		
			case 47: 
				f = new Field(getType(), field_no, "Arest Segment Literal", "ASL");
				
				return f;
		
			case 48: 
				f = new Field(getType(), field_no, "Civil Search Requested Indicator", "CSR");
				
				return f;
		
			case 49: 
				f = new Field(getType(), field_no, "Employee Identification Number", "EID");
				
				return f;
		
			case 51: 
				f = new Field(getType(), field_no, "Court Segment Literal", "CSL");
				
				return f;
		
			case 53: 
				f = new Field(getType(), field_no, "Offense Category", "OFC");
				
				return f;

			case 54: 
				f = new Field(getType(), field_no, "Custody or Supervisory Status Start Date", "SSD");
				
				return f;

			case 55: 
				f = new Field(getType(), field_no, "Custody or Supervisory Literal", "SLE");
				
				return f;

			case 56: 
				f = new Field(getType(), field_no, "Identifiation Comments", "ICO");
				
				return f;

			case 57: 
				f = new Field(getType(), field_no, "Finger Number(s) Requested", "FNR");
				
				return f;
		
			case 58: 
				f = new Field(getType(), field_no, "Image Record Type Desired", "ITD");
				
				return f;

			case 59: 
				f = new Field(getType(), field_no, "Search Results Findings", "SRF");
				
				return f;

			case 60: 
				f = new Field(getType(), field_no, "Status/Error Message", "MSG");
				
				return f;

			case 61: 
				f = new Field(getType(), field_no, "Case Title", "CST");
				
				return f;
		
			case 62: 
				f = new Field(getType(), field_no, "Image Type", "IMT");
				
				return f;

			case 63: 
				f = new Field(getType(), field_no, "Person Type Designator", "PTD");
				
				return f;

			case 64: 
				f = new Field(getType(), field_no, "Candidate List", "CAN");
				
				return f;
		
			case 65: 
				f = new Field(getType(), field_no, "Repository Statistics Response", "RSR");
				
				return f;

			case 67: 
				f = new Field(getType(), field_no, "Image Capture Equipment", "IMA");
				
				return f;

			case 69: 
				f = new Field(getType(), field_no, "Estimated Time to Complete", "ETC");
				
				return f;
		
			case 70: 
				f = new Field(getType(), field_no, "Request for Electronic Rap Sheet", "RAP");
				
				return f;

			case 71: 
				f = new Field(getType(), field_no, "Action to be Taken", "ACN");
				
				return f;
		
			case 72: 
				f = new Field(getType(), field_no, "Fingerprint Image(s) Updated", "FIU");
				
				return f;
		
			case 73: 
				f = new Field(getType(), field_no, "Controlling Agency Identifier", "CRI");
				
				return f;
		
			case 74: 
				f = new Field(getType(), field_no, "Finger Position", "FGP");
				
				return f;
		
			case 75: 
				f = new Field(getType(), field_no, "Electronic Rap Sheet", "ERS");
				
				return f;
		
			case 76: 
				f = new Field(getType(), field_no, "Priority", "PRI");
				
				return f;

			case 77: 
				f = new Field(getType(), field_no, "Cancel Friction Ridge Search", "CFS");
				
				return f;
		
			case 78: 
				f = new Field(getType(), field_no, "Penetration Query Response", "PEN");
				
				return f;

			case 79: 
				f = new Field(getType(), field_no, "Number of Candidates / Images Returned", "NCR");
				
				return f;

			case 80: 
				f = new Field(getType(), field_no, "Response Explanation", "EXP");
				
				return f;
		
			case 81: 
				f = new Field(getType(), field_no, "Universal Control Number", "UCN");
				
				return f;

			case 82: 
				f = new Field(getType(), field_no, "Response Code", "REC");
				
				return f;

			case 83: 
				f = new Field(getType(), field_no, "Unsolved Latent File", "ULF");
				
				return f;

			case 84: 
				f = new Field(getType(), field_no, "Amputated or Bandaged", "AMP");
				
				return f;
		
			case 85: 
				f = new Field(getType(), field_no, "Civil Record Number", "CRN");
				
				return f;
		
			case 86: 
				f = new Field(getType(), field_no, "AFIS Segment Control Number", "SCNA");
				
				return f;

			case 87: 
				f = new Field(getType(), field_no, "Treat as Adult", "TAA");
				
				return f;

			case 88: 
				f = new Field(getType(), field_no, "Note Field", "NOT");
				
				return f;

			case 89: 
				f = new Field(getType(), field_no, "Match Score", "MSC");
				
				return f;

			case 91: 
				f = new Field(getType(), field_no, "Ridge Core Deta One for Subpattern Classification", "RCD1");
				
				return f;

			case 92: 
				f = new Field(getType(), field_no, "Ridge Core Deta Two for Subpattern Classification", "RCD2");
				
				return f;

			case 94: 
				f = new Field(getType(), field_no, "Court Case Number", "CCN");
				
				return f;
		
			case 95: 
				f = new Field(getType(), field_no, "Request Features Record", "RFR");
				
				return f;

			case 96: 
				f = new Field(getType(), field_no, "Request Photos Record", "RPR");
				
				return f;

			case 98: 
				f = new Field(getType(), field_no, "Name of Designated Repository", "NDR");
				
				return f;

			case 99: 
				f = new Field(getType(), field_no, "State Arrest Number", "SAN");
				
				return f;

			case 2001: 
				f = new Field(getType(), field_no, "Name-One", "NAM1");
				
				return f;

			case 2002: 
				f = new Field(getType(), field_no, "Name-Two", "NAM2");
				
				return f;

			case 2003: 
				f = new Field(getType(), field_no, "Name-Three", "NAM3");
				
				return f;

			case 2004: 
				f = new Field(getType(), field_no, "Name-Four", "NAM4");
				
				return f;

			case 2005: 
				f = new Field(getType(), field_no, "Name-Five", "NAM5");
				
				return f;

			case 2006: 
				f = new Field(getType(), field_no, "Cascaded Search Flag", "CSF");
				
				return f;
		
			case 2007: 
				f = new Field(getType(), field_no, "Submitted Date of Birth", "SDOB");
				
				return f;

			case 2008: 
				f = new Field(getType(), field_no, "Submitted Name", "SNAM");
				
				return f;

			case 2009: 
				f = new Field(getType(), field_no, "Photo Type", "PTY");
				
				return f;

			case 2010: 
				f = new Field(getType(), field_no, "Number of Images Requested", "NIR");
				
				return f;

			case 2012: 
				f = new Field(getType(), field_no, "Iris Images Requested", "IIR");
				
				return f;

			case 2013: 
				f = new Field(getType(), field_no, "Disposition Maintenance Indicator", "DMI");
				
				return f;
		
			case 2016: 
				f = new Field(getType(), field_no, "DNA Flag", "DNAF");
				
				return f;
		
			case 2017: 
				f = new Field(getType(), field_no, "DNA Location", "DORI");
				
				return f;
		
			case 2018: 
				f = new Field(getType(), field_no, "DNA in CODIS Flag", "DNAC");
				
				return f;
		
			case 2019: 
				f = new Field(getType(), field_no, "Seal Arrest Flag", "SEAL");
				
				return f;

			case 2021: 
				f = new Field(getType(), field_no, "Identification Firearms Sales", "IFS");
				
				return f;

			case 2022: 
				f = new Field(getType(), field_no, "Contributor Assigned Identification Number", "CIDN");
				
				return f;
		
			case 2023: 
				f = new Field(getType(), field_no, "Supplementary Identity Information", "SII");
				
				return f;

			case 2024: 
				f = new Field(getType(), field_no, "Hit Type Indicator", "HTI");
				
				return f;

			case 2025: 
				f = new Field(getType(), field_no, "Geographic Coordinate Date Time Stamp", "GEO_TIME");
				
				return f;
		
			case 2026: 
				f = new Field(getType(), field_no, "Geographic Coordinate Locator", "GEO_CORD");
				
				return f;
		
			case 2027: 
				f = new Field(getType(), field_no, "Geographic Coordinate Datum", "DATUM_ID");
				
				return f;
		
			default:
				return super.getField(field_no);
		}
	}
}
