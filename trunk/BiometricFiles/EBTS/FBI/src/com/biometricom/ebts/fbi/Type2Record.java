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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.biometricom.nist.itl.biometrics.interchange.Field;
import com.biometricom.nist.itl.biometrics.interchange.InformationField;
import com.biometricom.nist.itl.biometrics.interchange.SubField;

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
	public static String SEX_MALE = "M";
	public static String SEX_FEMALE = "F";
	public static String SEX_MALE_IMPERSONATOR = "G";
	public static String SEX_FEMALE_IMPERSONATOR = "N";
	public static String SEX_NO_GENDER_GIVEN_MALE_NAME = "Y";
	public static String SEX_NO_GENDER_GIVEN_FEMALE_NAME = "Z";
	public static String SEX_UNKNOWN_GENDER = "X";
	
	public static String RACE_ASIAN = "A";
	public static String RACE_BLACK = "B";
	public static String RACE_INDIAN = "I";
	public static String RACE_WHITE = "W";
	public static String RACE_UNKNOWN = "U";
	
	public static String EYE_COLOR_BLACK = "BLK";
	public static String EYE_COLOR_BLUE = "BLU";
	public static String EYE_COLOR_BROWN = "BRO";
	public static String EYE_COLOR_GRAY = "GRY";
	public static String EYE_COLOR_GREEN = "GRN";
	public static String EYE_COLOR_HAZEL = "HAZ";
	public static String EYE_COLOR_MAROON = "MAR";
	public static String EYE_COLOR_MULTICOLORED = "MUL";
	public static String EYE_COLOR_PINK = "PNK";
	public static String EYE_COLOR_UNKNOWN = "XXX";
	
	public static String HAIR_COLOR_BALD = "BAL";
	public static String HAIR_COLOR_BLACK = "BLK";
	public static String HAIR_COLOR_BLONDE = "BLN";
	public static String HAIR_COLOR_BLUE = "BLU";
	public static String HAIR_COLOR_BROWN = "BRO";
	public static String HAIR_COLOR_GRAY = "GRY";
	public static String HAIR_COLOR_GREEN = "GRN";
	public static String HAIR_COLOR_ORANGE = "ONG";
	public static String HAIR_COLOR_PINK = "PNK";
	public static String HAIR_COLOR_PURPLE = "PLE";
	public static String HAIR_COLOR_RED = "RED";
	public static String HAIR_COLOR_SANDY = "SDY";
	public static String HAIR_COLOR_UNKNOWN = "XXX";
	public static String HAIR_COLOR_WHITE = "WHI";
	
	public final static String MILITARY_CODE_ARMY = "A"; 
	public final static String MILITARY_CODE_AIR_FORCE = "F";
	public final static String MILITARY_CODE_NAVY = "N";
	public final static String MILITARY_CODE_MARINES = "M";
	public final static String MILITARY_CODE_COAST_GUARD = "G";

	
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
				f.setInformationField(m_fbi_file_number);
				return f;
		
			case 4: 
				f = new Field(getType(), field_no, "Query Depth Detail", "QDD");
				f.setInformationField(m_query_depth_of_detail);
				return f;

			case 5: 
				f = new Field(getType(), field_no, "Retention Code", "RET");
				f.setInformationField(( m_retention_code ? "Y" : "N"));
				return f;

			case 6: 
				f = new Field(getType(), field_no, "Attention Indicator", "ATN");
				f.setInformationField(m_attention_indicator);
				return f;
		
			case 7: 
				f = new Field(getType(), field_no, "Send Copy To", "SCO");
				for (String send_to : m_send_copy_to)
				{
					SubField sf = new SubField();
					sf.addInformationItem(send_to);
					f.addSubField(sf);
				}
				return f;

			case 9: 
				f = new Field(getType(), field_no, "Originating Agency Case Number", "OCA");
				f.setInformationField(m_originating_agency_case_number);
				return f;

			case 10: 
				f = new Field(getType(), field_no, "Contributor Case Identifier Number", "CIN");
				for (ContributorCaseIdentifier cci : m_contributor_case_identifier)
				{
					SubField sf = new SubField();
					sf.addInformationItem(cci.getPrefix());
					sf.addInformationItem(cci.getId());
					f.addSubField(sf);					
				}
				return f;
		
			case 11: 
				f = new Field(getType(), field_no, "Contributor Case Identifier Extension", "CIX");
				for (Integer cix : m_contributor_case_identifier_extension_list)
				{
					SubField sf = new SubField();
					sf.addInformationItem(cix.toString());
					f.addSubField(sf);
				}
				return f;
		
			case 12: 
				f = new Field(getType(), field_no, "FBI Latent Case Number", "LCN");
				f.setInformationField(m_fbi_latent_case_number);
				return f;

			case 13: 
				f = new Field(getType(), field_no, "Latent Case Number Extension", "LCX");
				f.setInformationField(m_fbi_latent_case_extension);
				return f;

			case 14: 
				f = new Field(getType(), field_no, "FBI Number", "FBI");
				for (String no : m_fbi_number_list)
				{
					SubField sf = new SubField();
					sf.addInformationItem(no);
					f.addSubField(sf);
				}
				
				return f;
		
			case 15: 
				f = new Field(getType(), field_no, "State Identification Number", "SID");
				f.setInformationField(m_state_id_number);
				return f;

			case 16: 
				f = new Field(getType(), field_no, "Social Security Number", "SOC");
				for (String ssn : m_ssn_list)
				{
					SubField sf = new SubField();
					sf.addInformationItem(ssn);
					f.addSubField(sf);
				}
				return f;

			case 17: 
				f = new Field(getType(), field_no, "Miscellaneous Identification Number", "MNU");
				for (String value : m_misc_id_number_list)
				{
					SubField sf = new SubField();
					sf.addInformationItem(value);
					f.addSubField(sf);
				}
				return f;

			case 18: 
				f = new Field(getType(), field_no, "Name", "NAM");
				f.setInformationField(m_name);
				return f;

			case 19: 
				f = new Field(getType(), field_no, "Aliases", "AKA");
				for (String value : m_alias_list)
				{
					SubField sf = new SubField();
					sf.addInformationItem(value);
					f.addSubField(sf);
				}
				return f;
		
			case 20: 
				f = new Field(getType(), field_no, "Place of Birth", "POB");
				f.setInformationField(m_place_of_birth);
				return f;

			case 21: 
				f = new Field(getType(), field_no, "Country of Citizenship", "CTZ");
				f.setInformationField(m_country_of_citizenship);
				return f;
		
			case 22: 
				f = new Field(getType(), field_no, "Date of Birth", "DOB");
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
				f.setInformationField(df.format(m_date_of_birth));
				return f;
		
			case 23: 
				f = new Field(getType(), field_no, "Age Range", "AGR");
				f.setInformationField(String.format("%1$02d%2$02d", m_age_range_low, m_age_range_hi));
				return f;
		
			case 24: 
				f = new Field(getType(), field_no, "Sex", "SEX");
				f.setInformationField(m_sex);
				return f;

			case 25: 
				f = new Field(getType(), field_no, "Race", "RAC");
				f.setInformationField(m_race);
				return f;

			case 26: 
				f = new Field(getType(), field_no, "Scars, Marks and Tattoos", "SMT");
				for (String value : m_scars_marks_tattoos)
				{
					SubField sf = new SubField();
					sf.addInformationItem(value);
					f.addSubField(sf);
				}
				return f;

			case 27: 
				f = new Field(getType(), field_no, "Height", "HGT");
				if (isHeightInches() == true)
				{
					f.setInformationField(String.format("N%02d", m_height_in));
				}
				else
				{
					f.setInformationField(String.format("%d%02d", m_height_ft, m_height_in));
				}
				return f;

			case 28: 
				f = new Field(getType(), field_no, "Height Range", "HTR");
				if (isHeightRangeInches())
				{
					f.setInformationField(String.format("N%02dN02d", m_height_range_low_in.intValue(), m_height_range_hi_in.intValue()));
				}
				else
				{
					f.setInformationField(String.format("%d%02d%d02d", m_height_range_low_ft.intValue(), m_height_range_low_in.intValue(), m_height_range_hi_ft, m_height_range_hi_in.intValue()));
				}
				return f;

			case 29: 
				f = new Field(getType(), field_no, "Weight", "WGT");
				f.setInformationField(String.format("%03d", m_weight));
				return f;

			case 30: 
				f = new Field(getType(), field_no, "Weight Range", "WTR");
				f.setInformationField(String.format("%03d%03d", m_weight_range_low, m_weight_range_hi));
				return f;

			case 31: 
				f = new Field(getType(), field_no, "Color Eyes", "EYE");
				f.setInformationField(m_eye_color);
				return f;
		
			case 32: 
				f = new Field(getType(), field_no, "Hair Color", "HAI");
				f.setInformationField(m_hair_color);
				return f;

			case 33: 
				f = new Field(getType(), field_no, "NCIC Fingerprint Classification", "FPC");
				f.setInformationField(m_ncic_fingerprint_class);
				return f;		

			case 34: 
				f = new Field(getType(), field_no, "Pattern Level Classifications", "PAT");
				for (FingerprintPattern fpat : m_fingerprint_pattern)
				{
					SubField sf = new SubField();
					sf.addInformationItem(String.format("%02d", fpat.getFingerNumber()));
					sf.addInformationItem(fpat.getFingerprintPatternCode());
					f.addSubField(sf);
				}
				return f;

			case 35: 
				f = new Field(getType(), field_no, "Palmprints Available Indicator", "PPA");
				f.setInformationField(m_is_palm_print_available == true ? "Y" : "N");
				return f;

			case 36: 
				f = new Field(getType(), field_no, "Photo Available Indicator", "PHT");
				f.setInformationField(m_is_photo_available == true ? "Y" : "N");
				return f;

			case 37: 
				f = new Field(getType(), field_no, "Reason Fingerprinted", "RFP");
				f.setInformationField(m_reason_fingerprinted);
				return f;

			case 38: 
				f = new Field(getType(), field_no, "Date Printed", "DPR");
				df = new SimpleDateFormat("yyyyMMdd");
				f.setInformationField(df.format(m_date_printed));
				return f;
		
			case 39: 
				f = new Field(getType(), field_no, "Employer Address", "EAD");
				f.setInformationField(m_employer_address);
				return f;
		
			case 40: 
				f = new Field(getType(), field_no, "Occupation", "OCP");
				f.setInformationField(m_occupation);
				return f;

			case 41: 
				f = new Field(getType(), field_no, "Residence of Person Fingerprinted", "RES");
				f.setInformationField(m_person_fingerprinted_address);
				return f;

			case 42: 
				f = new Field(getType(), field_no, "Military Code", "MIL");
				f.setInformationField(m_military_code);
				return f;

			case 43: 
				f = new Field(getType(), field_no, "Type of Search Required", "TSR");
				f.setInformationField(m_type_of_search_requested);
				return f;

			case 44: 
				f = new Field(getType(), field_no, "Geographic Area of Search", "GEO");
				for (String value : m_geo_area_of_search_list)
				{
					SubField sf = new SubField();
					sf.addInformationItem(value);
					f.addSubField(sf);
				}
				return f;
				
			case 45: 
				f = new Field(getType(), field_no, "Date of Arrest", "DOA");
				df = new SimpleDateFormat("yyyyMMdd");
				f.setInformationField(df.format(m_date_of_arrest));
				return f;
		
			case 46: 
				f = new Field(getType(), field_no, "Date of Arrest - Suffix", "DOS");
				f.setInformationField(m_date_of_arrest_suffix);
				return f;
		
			case 47: 
				f = new Field(getType(), field_no, "Arest Segment Literal", "ASL");
				for (ArrestSegmentLiteral asl : m_arrest_info)
				{
					SubField sf = new SubField();
					if (asl.getDateOfArrest() == null)
					{
						sf.addInformationItem("");
					}
					else
					{
						df = new SimpleDateFormat("yyyyMMdd");
						f.setInformationField(df.format(asl.getDateOfArrest()));
					}
					sf.addInformationItem(asl.getOffenseLiteral());
					
					f.addSubField(sf);
				}
				return f;
		
			case 48: 
				f = new Field(getType(), field_no, "Civil Search Requested Indicator", "CSR");
				f.setInformationField(m_is_civil_search_requested.booleanValue() == true ? "Y" : "F");
				return f;
		
			case 49: 
				f = new Field(getType(), field_no, "Employee Identification Number", "EID");
				f.setInformationField(m_employee_id_number);
				return f;
		
			case 51: 
				f = new Field(getType(), field_no, "Court Segment Literal", "CSL");
				for (CourtSegmentLiteral csl : m_court_info)
				{
					SubField sf = new SubField();
					if (csl.getDispositionDate() == null)
					{
						sf.addInformationItem("");
					}
					else
					{
						df = new SimpleDateFormat("yyyyMMdd");
						f.setInformationField(df.format(csl.getDispositionDate()));
					}
					sf.addInformationItem(csl.getOffenseLiteral());
					if (csl.getSentencingProvisions() == null)
					{
						sf.addInformationItem("");
					}
					else
					{
						sf.addInformationItem(csl.getSentencingProvisions());
					}
					f.addSubField(sf);
				}
				return f;
		
			case 53: 
				f = new Field(getType(), field_no, "Offense Category", "OFC");
				f.setInformationField(m_offense_category.toString());
				return f;

			case 54: 
				f = new Field(getType(), field_no, "Custody or Supervisory Status Start Date", "SSD");
				df = new SimpleDateFormat("yyyyMMdd");
				f.setInformationField(df.format(m_custody_or_supervisory_start_date));
				return f;

			case 55: 
				f = new Field(getType(), field_no, "Custody or Supervisory Status Literal", "SLE");
				f.setInformationField(m_custody_or_supervisory_status);
				return f;

			case 56: 
				f = new Field(getType(), field_no, "Identifiation Comments", "ICO");
				f.setInformationField(m_identification_comments);
				return f;

			case 57: 
				f = new Field(getType(), field_no, "Finger Number(s) Requested", "FNR");
				for (Integer fn : m_finger_numbers_requested)
				{
					SubField sf = new SubField();
					sf.addInformationItem(String.format("%02d", fn.intValue()));
					f.addSubField(sf);
				}
				return f;
		
			case 58: 
				f = new Field(getType(), field_no, "Image Record Type Desired", "ITD");
				f.setInformationField(m_image_record_type_desired.toString());
				return f;

			case 59: 
				f = new Field(getType(), field_no, "Search Results Findings", "SRF");
				f.setInformationField(m_search_results_findings_code);
				return f;

			case 60: 
				f = new Field(getType(), field_no, "Status/Error Message", "MSG");
				for (String msg : m_status_or_error_message)
				{
					SubField sf = new SubField();
					sf.addInformationItem(msg);
					f.addSubField(sf);
				}
				return f;

			case 61: 
				f = new Field(getType(), field_no, "Case Title", "CST");
				f.setInformationField(m_case_title);
				return f;
		
			case 62: 
				f = new Field(getType(), field_no, "Image Type", "IMT");
				for (Integer itype : m_image_type)
				{
					SubField sf = new SubField();
					sf.addInformationItem(Integer.toString(itype.intValue()));
					f.addSubField(sf);
				}
				return f;

			case 63: 
				f = new Field(getType(), field_no, "Person Type Designator", "PTD");
				f.setInformationField(m_person_type_designator);
				return f;

			case 64: 
				f = new Field(getType(), field_no, "Candidate List", "CAN");
				for (Candidate can : m_candidate_list)
				{
					SubField sf = new SubField();
					sf.addInformationItem(can.getUniversalControlNumber());
					sf.addInformationItem(can.getName());
					f.addSubField(sf);
				}
				return f;
		
			case 65: 
				f = new Field(getType(), field_no, "Repository Statistics Response", "RSR");
				f.setInformationField(m_repository_statistics_response);
				return f;

			case 67: 
				f = new Field(getType(), field_no, "Image Capture Equipment", "IMA");
				for (ImageCaptureEquipment icap : m_capture_equipment)
				{
					SubField sf = new SubField();
					sf.addInformationItem(icap.getMake());
					sf.addInformationItem(icap.getModel());
					sf.addInformationItem(icap.getSerialNumber());
					
					f.addSubField(sf);
				}
				return f;

			case 69: 
				f = new Field(getType(), field_no, "Estimated Time to Complete", "ETC");
				for (Integer ival : m_estimated_time_to_complete)
				{
					SubField sf = new SubField();
					sf.addInformationItem(ival.toString());
					f.addSubField(sf);					
				}
				return f;
		
			case 70: 
				f = new Field(getType(), field_no, "Request for Electronic Rap Sheet", "RAP");
				f.setInformationField(m_request_for_electronic_rap_sheet == true ? "Y" : "F");
				return f;

			case 71: 
				f = new Field(getType(), field_no, "Action to be Taken", "ACN");
				f.setInformationField(m_action_to_be_taken);
				return f;
		
			case 72: 
				f = new Field(getType(), field_no, "Fingerprint Image(s) Updated", "FIU");
				for (String value : m_fingerprints_updated)
				{
					SubField sf = new SubField();
					sf.addInformationItem(value);
					f.addSubField(sf);
				}
				return f;
		
			case 73: 
				f = new Field(getType(), field_no, "Controlling Agency Identifier", "CRI");
				for (String value : m_controlling_agency_identifier)
				{
					SubField sf = new SubField();
					sf.addInformationItem(value);
					f.addSubField(sf);
				}
				return f;
		
			case 74: 
				f = new Field(getType(), field_no, "Finger Position", "FGP");
				for (Integer value : m_finger_position)
				{
					SubField sf = new SubField();
					sf.addInformationItem(String.format("%02d", value.intValue()));
					f.addSubField(sf);
				}
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
	
	public void setFbiFileNumber(String value)
	{
		m_fbi_file_number = value;
	}
	
	public String getFbiFileNumber()
	{
		return m_fbi_file_number;
	}
	
	public void setQueryDepthOfDetail(String value)
	{
		m_query_depth_of_detail = value;
	}
	
	public String getQueryDepthOfDetail()
	{
		return m_query_depth_of_detail;
	}
	
	public void setAttentionIndicator(String value)
	{
		m_attention_indicator = value;
	}
	
	public String getAttentionIndicator()
	{
		return m_attention_indicator;
	}
	
	public void setOriginatingAgencyCaseNumber(String value)
	{
		m_originating_agency_case_number = value;
	}
	
	public String getOriginatingAgencyCaseNumber()
	{
		return m_originating_agency_case_number;
	}
	
	public void setFbiLatentCaseNumber(String value)
	{
		m_fbi_latent_case_number = value;
	}
	
	public String getFbiLatentCaseNumber()
	{
		return m_fbi_latent_case_number;
	}
	
	public void setFbiLatentCaseExtension(String value)
	{
		m_fbi_latent_case_extension = value;
	}
	
	public String getFbiLatentCaseExtension()
	{
		return m_fbi_latent_case_extension;
	}
	
	public void addFbiNumber(String value)
	{
		m_fbi_number_list.add(value);
	}
	
	public void setFbiNumberList(List<String> value)
	{
		m_fbi_number_list = new ArrayList<String>(value);
	}
	
	public List<String> getFbiNumber()
	{
		return m_fbi_number_list;
	}
	
	public void setStateIdNumber(String value)
	{
		m_state_id_number = value;
	}
	
	public String getStateIdNumber()
	{
		return m_state_id_number;
	}
	
	public void addMiscIdNumber(String value)
	{
		m_misc_id_number_list.add(value);
	}
	
	public void setMiscIdNumberList(List<String> value)
	{
		m_misc_id_number_list = new ArrayList<String>(value);
	}
	
	public List<String> getMiscIdNumberList()
	{
		return m_misc_id_number_list;
	}
	
	public void setName(String value)
	{
		m_name = value;
	}
	
	public String getName()
	{
		return m_name;
	}
	
	public void setPlaceOfBirth(String value)
	{
		m_place_of_birth = value;
	}
	
	public String getPlaceOfBirth()
	{
		return m_place_of_birth;
	}
	
	public void setCountryOfCitizenship(String value)
	{
		m_country_of_citizenship = value;
	}
	
	public String getCountryOfCitizenship()
	{
		return m_country_of_citizenship;
	}
	
	public void setSex(String value)
	{
		m_sex = value;
	}
	
	public String getSex()
	{
		return m_sex;
	}
	
	public void setRace(String value)
	{
		m_race = value;
	}
	
	public String getRace()
	{
		return m_race;
	}
	
	public void setEyeColor(String value)
	{
		m_eye_color = value;
	}
	
	public String getEyeColor()
	{
		return m_eye_color;
	}
	
	public void setHairColor(String value)
	{
		m_hair_color = value;
	}
	
	public String getHairColor()
	{
		return m_hair_color;
	}
	
	public void setNcicFingerprintClass(String value)
	{
		m_ncic_fingerprint_class = value;
	}
	
	public String getNcicFingerprintClass()
	{
		return m_ncic_fingerprint_class;
	}
	
	public void setReasonFingerprinted(String value)
	{
		m_reason_fingerprinted = value;
	}
	
	public String getReasonFingerprinted()
	{
		return m_reason_fingerprinted;
	}
	
	public void setEmployerAddress(String value)
	{
		m_employer_address = value;
	}
	
	public String getEmployerAddress()
	{
		return m_employer_address;
	}
	
	public void setOccupation(String value)
	{
		m_occupation = value;
	}
	
	public String getOccupation()
	{
		return m_occupation;
	}
	
	public void setPersonFingerprintedAddress(String value)
	{
		m_person_fingerprinted_address = value;
	}
	
	public String getPersonFingerprintedAddress()
	{
		return m_person_fingerprinted_address;
	}
	
	public void setMilitaryCode(String value)
	{
		m_military_code = value;
	}
	
	public String getMilitaryCode()
	{
		return m_military_code;
	}
	
	public void setTypeOfSearchRequested(String value)
	{
		m_type_of_search_requested = value;
	}
	
	public String getTypeOfSearchRequested()
	{
		return m_type_of_search_requested;
	}
	
	public void addGeographicAreaOfSearch(String value)
	{
		m_geo_area_of_search_list.add(value);
	}
	
	public void setGeographicAreaOfSearchList(List<String> value)
	{
		m_geo_area_of_search_list = new ArrayList<String>(value);
	}
	
	public List<String> getGeographicAreaOfSearch()
	{
		return m_geo_area_of_search_list;
	}
	
	public void setDateOfArrestSuffix(String value)
	{
		m_date_of_arrest_suffix = value;
	}
	
	public String getDateOfArrestSuffix()
	{
		return m_date_of_arrest_suffix;
	}
	
	public void setEmployeeIdNumber(String value)
	{
		m_employee_id_number = value;
	}
	
	public String getEmployeeIdNumber()
	{
		return m_employee_id_number;
	}
	
	public void setCustodyOrSupervisoryStatus(String value)
	{
		m_custody_or_supervisory_status = value;
	}
	
	public String getCustodyOrSupervisoryStatus()
	{
		return m_custody_or_supervisory_status;
	}
	
	public void setIdentificationComments(String value)
	{
		m_identification_comments = value;
	}
	
	public String getIdentificationComments()
	{
		return m_identification_comments;
	}
	
	public void setSearchResultsFindingsCode(String value)
	{
		m_search_results_findings_code = value;
	}
	
	public String getSearchResultsFindingsCode()
	{
		return m_search_results_findings_code;
	}
	
	public void setCaseTitle(String value)
	{
		m_case_title = value;
	}
	
	public String getCaseTitle()
	{
		return m_case_title;
	}
	
	public void setPersonTypeDesignator(String value)
	{
		m_person_type_designator = value;
	}
	
	public String getPersonTypeDesignator()
	{
		return m_person_type_designator;
	}
	
	public void setRepositoryStatisticsResponse(String value)
	{
		m_repository_statistics_response = value;
	}
	
	public String getRepositoryStatisticsResponse()
	{
		return m_repository_statistics_response;
	}
	
	public void setResponseExplanation(String value)
	{
		m_response_explanation = value;
	}
	
	public String getResponseExplanation()
	{
		return m_response_explanation;
	}
	
	public void setUniversalControlNumber(String value)
	{
		m_universal_control_number = value;
	}
	
	public String getUniversalControlNumber()
	{
		return m_universal_control_number;
	}
	
	public void setCivilRecordNumber(String value)
	{
		m_civil_record_number = value;
	}
	
	public String getCivilRecordNumber()
	{
		return m_civil_record_number;
	}
	
	public void setNoteField(String value)
	{
		m_note_field = value;
	}
	
	public String getNoteField()
	{
		return m_note_field;
	}
	
	public void setCourtCaseNumber(String value)
	{
		m_court_case_number = value;
	}
	
	public String getCourtCaseNumber()
	{
		return m_court_case_number;
	}
	
	public void setStateArrestNumber(String value)
	{
		m_state_arrest_number = value;
	}
	
	public String getStateArrestNumber()
	{
		return m_state_arrest_number;
	}
	
	public void setName1(String value)
	{
		m_name1 = value;
	}
	
	public String getName1()
	{
		return m_name1;
	}
	
	public void setName2(String value)
	{
		m_name2 = value;
	}
	
	public String getName2()
	{
		return m_name2;
	}
	
	public void setName3(String value)
	{
		m_name3 = value;
	}
	
	public String getName3()
	{
		return m_name3;
	}
	public void setName4(String value)
	{
		m_name4 = value;
	}
	
	public String getName4()
	{
		return m_name4;
	}

	public void setName5(String value)
	{
		m_name5 = value;
	}
	
	public String getName5()
	{
		return m_name5;
	}

	public void setCascadedSearchFlag(String value)
	{
		m_cascaded_search_flag = value;
	}
	
	public String getCascadedSearchFlag()
	{
		return m_cascaded_search_flag;
	}

	public void setSubmittedName(String value)
	{
		m_submitted_name = value;
	}
	
	public String getSubmittedName()
	{
		return m_submitted_name;
	}

	public void setRapBackVerificationStatus(String value)
	{
		m_rap_back_verification_status = value;
	}
	
	public String getRapBackVerificationStatus()
	{
		return m_rap_back_verification_status;
	}
	
	public void setDispositionMaintenanceIndicator(String value)
	{
		m_disposition_maintenance_indicator = value;
	}
	
	public String getDispositionMaintenanceIndicator()
	{
		return m_disposition_maintenance_indicator;
	}
	
	public void setDnaLocation(String value)
	{
		m_dna_location = value;
	}
	
	public String getDnaLocation()
	{
		return m_dna_location;
	}

	public void setIdentificationFirearmSales(String value)
	{
		m_identification_firearm_sales = value;
	}
	
	public String getIdentificationFirearmSales()
	{
		return m_identification_firearm_sales;
	}
	
	public void setContributorAssignedIdNumber(String value)
	{
		m_contributor_assigned_id_no = value;
	}
	
	public String getContributorAssignedIdNumber()
	{
		return m_contributor_assigned_id_no;
	}
	
	public void setSupplementaryIdInfo(String value)
	{
		m_supplementary_id_info = value;
	}
	
	public String getSupplementaryIdInfo()
	{
		return m_supplementary_id_info;
	}

	public void setHitTypeIndicator(String value)
	{
		m_hit_type_indc = value;
	}
	
	public String getHitTypeIndicator()
	{
		return m_hit_type_indc;
	}

	public void setGeographicCoordinateDatum(String value)
	{
		m_geo_coordinate_datum = value;
	}
	
	public String getGeographicCoordinateDatum()
	{
		return m_geo_coordinate_datum;
	}

	public void addSendCopyTo(String value)
	{
		m_send_copy_to.add(value);
	}
	
	public void setSendCopyToList(List<String> list)
	{
		m_send_copy_to = new ArrayList<String>(list);
	}
	
	public List<String> getSendCopyToList()
	{
		return m_send_copy_to;
	}

	public void addContributorCaseIdentifier(ContributorCaseIdentifier value)
	{
		m_contributor_case_identifier.add(value);
	}
	
	public void setContributorCaseIdentifierList(List<ContributorCaseIdentifier> list)
	{
		m_contributor_case_identifier = new ArrayList<ContributorCaseIdentifier>(list);
	}
	
	public List<ContributorCaseIdentifier> getContributorCaseIdentifierList()
	{
		return m_contributor_case_identifier;
	}

	public void addSocialSecurityNumber(String value)
	{
		m_ssn_list.add(value);
	}
	
	public void setSocialSecurityNumberList(List<String> list)
	{
		m_ssn_list = new ArrayList<String>(list);
	}
	
	public List<String> getSocialSecurityNumberList()
	{
		return m_ssn_list;
	}

	public void addAliases(String value)
	{
		m_alias_list.add(value);
	}
	
	public void setAliasesList(List<String> list)
	{
		m_alias_list = new ArrayList<String>(list);
	}
	
	public List<String> getAliasesList()
	{
		return m_alias_list;
	}

	public void addScarsMarksTattoos(String value)
	{
		m_scars_marks_tattoos.add(value);
	}
	
	public void setScarsMarksTattoosList(List<String> list)
	{
		m_scars_marks_tattoos = new ArrayList<String>(list);
	}
	
	public List<String> getScarsMarksTattoosList()
	{
		return m_scars_marks_tattoos;
	}

	public void addFingerprintPattern(FingerprintPattern value)
	{
		m_fingerprint_pattern.add(value);
	}
	
	public void setFingerprintPatternList(List<FingerprintPattern> list)
	{
		m_fingerprint_pattern = new ArrayList<FingerprintPattern>(list);
	}
	
	public List<FingerprintPattern> getFingerprintPatternList()
	{
		return m_fingerprint_pattern;
	}

	public void addArrestSegmentLiteral(ArrestSegmentLiteral value)
	{
		m_arrest_info.add(value);
	}
	
	public void setArrestSegmentLiteralList(List<ArrestSegmentLiteral> list)
	{
		m_arrest_info = new ArrayList<ArrestSegmentLiteral>(list);
	}
	
	public List<ArrestSegmentLiteral> getArrestSegmentLiteralList()
	{
		return m_arrest_info;
	}
	
	public void addCourtSegmentLiteral(CourtSegmentLiteral value)
	{
		m_court_info.add(value);
	}
	
	public void setCourtSegmentLiteralList(List<CourtSegmentLiteral> list)
	{
		m_court_info = new ArrayList<CourtSegmentLiteral>(list);
	}
	
	public List<CourtSegmentLiteral> getCourtSegmentLiteralList()
	{
		return m_court_info;
	}
	
	public void addFingerNumbersRequested(Integer value)
	{
		m_finger_numbers_requested.add(value);
	}
	
	public void setFingerNumbersRequestedList(List<Integer> list)
	{
		m_finger_numbers_requested = new ArrayList<Integer>(list);
	}
	
	public List<Integer> getFingerNumbersRequestedList()
	{
		return m_finger_numbers_requested;
	}

	public void addMessage(String value)
	{
		m_status_or_error_message.add(value);
	}
	
	public void setMessageList(List<String> list)
	{
		m_status_or_error_message = new ArrayList<String>(list);
	}
	
	public List<String> getMessageList()
	{
		return m_status_or_error_message;
	}

	public void addImageType(Integer value)
	{
		m_image_type.add(value);
	}
	
	public void setImageTypeList(List<Integer> list)
	{
		m_image_type = new ArrayList<Integer>(list);
	}
	
	public List<Integer> getImageTypeList()
	{
		return m_image_type;
	}

	public void addCandidate(Candidate value)
	{
		m_candidate_list.add(value);
	}
	
	public void setCandidateList(List<Candidate> list)
	{
		m_candidate_list = new ArrayList<Candidate>(list);
	}
	
	public List<Candidate> getCandidateList()
	{
		return m_candidate_list;
	}

	public void addImageCaptureEquipment(ImageCaptureEquipment value)
	{
		m_capture_equipment.add(value);
	}
	
	public void setImageCaptureEquipmentList(List<ImageCaptureEquipment> list)
	{
		m_capture_equipment = new ArrayList<ImageCaptureEquipment>(list);
	}
	
	public List<ImageCaptureEquipment> getImageCaptureEquipmentList()
	{
		return m_capture_equipment;
	}
	
	public void addFingerprintsUpdated(String value)
	{
		m_fingerprints_updated.add(value);
	}
	
	public void setFingerprintsUpdatedList(List<String> list)
	{
		m_fingerprints_updated = new ArrayList<String>(list);
	}
	
	public List<String> getFingerprintsUpdatedList()
	{
		return m_fingerprints_updated;
	}

	public void addControllingAgencyIdentifier(String value)
	{
		m_controlling_agency_identifier.add(value);
	}
	
	public void setControllingAgencyIdentifierList(List<String> list)
	{
		m_controlling_agency_identifier = new ArrayList<String>(list);
	}
	
	public List<String> getControllingAgencyIdentifierList()
	{
		return m_controlling_agency_identifier;
	}

	public void addFingerPosition(Integer value)
	{
		m_finger_position.add(value);
	}
	
	public void setFingerPositionList(List<Integer> list)
	{
		m_finger_position = new ArrayList<Integer>(list);
	}
	
	public List<Integer> getFingerPositionList()
	{
		return m_finger_position;
	}

	public void addAmputatedOrBandaged(AmputatedOrBandaged value)
	{
		m_amputated_or_bandaged.add(value);
	}
	
	public void setAmputatedOrBandagedList(List<AmputatedOrBandaged> list)
	{
		m_amputated_or_bandaged = new ArrayList<AmputatedOrBandaged>(list);
	}
	
	public List<AmputatedOrBandaged> getAmputatedOrBandagedList()
	{
		return m_amputated_or_bandaged;
	}

	public void addAfisSegmentControlNumber(Integer value)
	{
		m_afis_segment_control_number.add(value);
	}
	
	public void setAfisSegmentControlNumberList(List<Integer> list)
	{
		m_afis_segment_control_number = new ArrayList<Integer>(list);
	}
	
	public List<Integer> getAfisSegmentControlNumberList()
	{
		return m_afis_segment_control_number;
	}

	public void addMatchScore(Integer value)
	{
		m_match_score.add(value);
	}
	
	public void setMatchScoreList(List<Integer> list)
	{
		m_match_score = new ArrayList<Integer>(list);
	}
	
	public List<Integer> getMatchScoreList()
	{
		return m_match_score;
	}

	public void addRidgeCoreDeltaOneForSubpatternClassification(RidgeCoreDelta value)
	{
		m_ridge_core_delta_one_for_subpattern_classification.add(value);
	}
	
	public void setRidgeCoreDeltaOneForSubpatternClassificationList(List<RidgeCoreDelta> list)
	{
		m_ridge_core_delta_one_for_subpattern_classification = new ArrayList<RidgeCoreDelta>(list);
	}
	
	public List<RidgeCoreDelta> getRidgeCoreDeltaOneForSubpatternClassificationList()
	{
		return m_ridge_core_delta_one_for_subpattern_classification;
	}

	public void addRidgeCoreDeltaTwoForSubpatternClassification(RidgeCoreDelta value)
	{
		m_ridge_core_delta_two_for_subpattern_classification.add(value);
	}
	
	public void setRidgeCoreDeltaTwoForSubpatternClassificationList(List<RidgeCoreDelta> list)
	{
		m_ridge_core_delta_two_for_subpattern_classification = new ArrayList<RidgeCoreDelta>(list);
	}
	
	public List<RidgeCoreDelta> getRidgeCoreDeltaTwoForSubpatternClassificationList()
	{
		return m_ridge_core_delta_two_for_subpattern_classification;
	}

	public void addSpecialPopulationCognizantFileNumber(String value)
	{
		m_special_population_cognizant_file_number.add(value);
	}
	
	public void setSpecialPopulationCognizantFileNumberList(List<String> list)
	{
		m_special_population_cognizant_file_number = new ArrayList<String>(list);
	}
	
	public List<String> getSpecialPopulationCognizantFileNumberList()
	{
		return m_special_population_cognizant_file_number;
	}

	public void addNameOfDesignatedRepository(String value)
	{
		m_name_of_designated_repository.add(value);
	}
	
	public void setNameOfDesignatedRepositoryList(List<String> list)
	{
		m_name_of_designated_repository = new ArrayList<String>(list);
	}
	
	public List<String> getNameOfDesignatedRepositoryList()
	{
		return m_name_of_designated_repository;
	}

	public void addContributorCaseIdentiferExtension(Integer value)
	{
		m_contributor_case_identifier_extension_list.add(value);
	}
	
	public void setContributorCaseIdentiferExtensionList(List<Integer> list)
	{
		m_contributor_case_identifier_extension_list = new ArrayList<Integer>(list);
	}
	
	public List<Integer> getContributorCaseIdentiferExtensionList()
	{
		return m_contributor_case_identifier_extension_list;
	}

	public void addRapBackRecipient(String value)
	{
		m_rap_back_recipient.add(value);
	}
	
	public void setRapBackRecipientList(List<String> list)
	{
		m_rap_back_recipient = new ArrayList<String>(list);
	}
	
	public List<String> getRapBackRecipientList()
	{
		return m_rap_back_recipient;
	}
	
	public void setPalmPrintAvailable(boolean value)
	{
		m_is_palm_print_available = new Boolean(value);
	}
	
	public boolean isPalmPrintAvailable()
	{
		if (m_is_palm_print_available == null)
		{
			return false;
		}
		return m_is_palm_print_available.booleanValue();
	}

	public void setPhotoAvailable(boolean value)
	{
		m_is_photo_available = new Boolean(value);
	}
	
	public boolean isPhotoAvailable()
	{
		if (m_is_photo_available == null)
		{
			return false;
		}
		return m_is_photo_available.booleanValue();
	}

	public void setRetentionCode(boolean value)
	{
		m_retention_code = value;
	}
	
	public boolean getRetentionCode()
	{
		return m_retention_code;
	}

	public void setCivilSearchRequested(boolean value)
	{
		m_is_civil_search_requested = new Boolean(value);
	}
	
	public boolean isCivilSearchRequested()
	{
		if (m_is_civil_search_requested == null)
		{
			return false;
		}
		return m_is_civil_search_requested.booleanValue();
	}

	public void setRequestForElectronicRapSheet(boolean value)
	{
		m_request_for_electronic_rap_sheet = new Boolean(value);
	}
	
	public boolean isRequestForElectronicRapSheet()
	{
		if (m_request_for_electronic_rap_sheet == null)
		{
			return false;
		}
		return m_request_for_electronic_rap_sheet.booleanValue();
	}

	public void setResponse(boolean value)
	{
		m_is_response = value;
	}
	
	public boolean isResponse()
	{
		return m_is_response;
	}

	public void setUnsolvedLatentFile(boolean value)
	{
		m_is_unsolved_latent_file = new Boolean(value);
	}
	
	public boolean isUnsolvedLatentFile()
	{
		if (m_is_unsolved_latent_file == null)
		{
			return false;
		}
		return m_is_unsolved_latent_file.booleanValue();
	}

	public void setTreatAsAdult(boolean value)
	{
		m_treat_as_adult = new Boolean(value);
	}
	
	public boolean isTreatAsAdult()
	{
		if (m_treat_as_adult == null)
		{
			return false;
		}
		return m_treat_as_adult.booleanValue();
	}

	public void setRequestFeatures(boolean value)
	{
		m_request_features = new Boolean(value);
	}
	
	public boolean isRequestFeatures()
	{
		if (m_request_features == null)
		{
			return false;
		}
		return m_request_features.booleanValue();
	}

	public void setRequestPhoto(boolean value)
	{
		m_request_photo = new Boolean(value);
	}
	
	public boolean isRequestPhoto()
	{
		if (m_request_photo == null)
		{
			return false;
		}
		return m_request_photo.booleanValue();
	}
	
	public void setIrisImagesRequested(boolean value)
	{
		m_iris_images_requested = new Boolean(value);
	}
	
	public boolean isIrisImagesRequested()
	{
		if (m_iris_images_requested == null)
		{
			return false;
		}
		return m_iris_images_requested.booleanValue();
	}

	public void setRapBackEligibility(boolean value)
	{
		m_rap_back_eligibility = new Boolean(value);
	}
	
	public boolean isRapBackEligible()
	{
		if (m_rap_back_eligibility == null)
		{
			return false;
		}
		return m_rap_back_eligibility.booleanValue();
	}

	public void setDnaFlag(boolean value)
	{
		m_dna_flag = new Boolean(value);
	}
	
	public boolean isDnaFlag()
	{
		if (m_dna_flag == null)
		{
			return false;
		}
		return m_dna_flag.booleanValue();
	}

	public void setSealArrestFlag(boolean value)
	{
		m_seal_arrest_flag = new Boolean(value);
	}
	
	public boolean isSealArrestFlag()
	{
		if (m_seal_arrest_flag == null)
		{
			return false;
		}
		return m_seal_arrest_flag.booleanValue();
	}

	public void setAgeRange(int low, int high)
	{
		m_age_range_low = new Integer(low);
		m_age_range_hi  = new Integer(high);
	}
	
	public int getAgeRangeLow()
	{
		if (m_age_range_low == null)
		{
			return 0;
		}
		return m_age_range_low.intValue();
	}
	
	public int getAgeRangeHigh()
	{
		if (m_age_range_hi == null)
		{
			return 0;
		}
		return m_age_range_hi.intValue();
	}
	
	public void setDateOfBirth(GregorianCalendar cal)
	{
		m_date_of_birth = cal;
	}
	
	public GregorianCalendar getDateOfBirth()
	{
		return m_date_of_birth;
	}
	
	public void setHeight(int height_ft, int height_in)
	{
		m_height_ft = height_ft;
		m_height_in = height_in;
		m_is_height_inches = false;
	}

	public void setHeight(int height_in)
	{
		m_height_ft = 0;
		m_height_in = height_in;
		m_is_height_inches = true;
	}
	
	public int getHeightFeet()
	{
		return m_height_ft;
	}
	
	public int getHeightInches()
	{
		return m_height_in;
	}
	
	public boolean isHeightInches()
	{
		return m_is_height_inches;
	}
	
	public void setHeightRange(int low_ft, int low_in, int high_ft, int high_in)
	{
		m_height_range_low_ft = new Integer(low_ft);
		m_height_range_low_in = new Integer(low_in);
		m_height_range_hi_ft  = new Integer(high_ft);
		m_height_range_hi_in = new Integer(high_in);
		m_is_height_range_inches = false;
	}
	
	public void setHeightRange(int low_in, int high_in)
	{
		m_height_range_low_ft = null;
		m_height_range_low_in = new Integer(low_in);
		m_height_range_hi_ft  = null;
		m_height_range_hi_in = new Integer(high_in);
		m_is_height_range_inches = true;
	}

	public int getHeightRangeLowFt()
	{
		if (m_height_range_low_ft == null)
		{
			return 0;
		}
		return m_height_range_low_ft.intValue();
	}

	public int getHeightRangeLowIn()
	{
		if (m_height_range_low_in == null)
		{
			return 0;
		}
		return m_height_range_low_in.intValue();
	}

	public int getHeightRangeHighFt()
	{
		if (m_height_range_hi_ft == null)
		{
			return 0;
		}
		return m_height_range_hi_ft.intValue();
	}

	public int getHeightRangeHighIn()
	{
		if (m_height_range_hi_in == null)
		{
			return 0;
		}
		return m_height_range_hi_in.intValue();
	}

	public boolean isHeightRangeInches()
	{
		return m_is_height_range_inches;
	}
	
	public void setWeight(int weight)
	{
		m_weight = weight;
	}
	
	public int getWeight()
	{
		return m_weight;
	}
	
	public void setWeightRange(int low, int high)
	{
		m_weight_range_low = low;
		m_weight_range_hi  = high;
	}
	
	public int getWeightRangeLow()
	{
		if (m_weight_range_low == null)
		{
			return 0;
		}
		return m_weight_range_low.intValue();
	}

	public int getWeightRangeHigh()
	{
		if (m_weight_range_hi == null)
		{
			return 0;
		}
		return m_weight_range_hi.intValue();
	}

	public void setDatePrinted(GregorianCalendar cal)
	{
		m_date_printed = cal;
	}
	
	public Calendar getDatePrinted()
	{
		return m_date_printed;
	}
	
	public void setDateOfArrest(GregorianCalendar date_of_arrest)
	{
		m_date_of_arrest = date_of_arrest;
	}
	
	public Calendar getDateOfArrest()
	{
		return m_date_of_arrest;
	}
	
	public void setImageRecordTypeDesired(int value)
	{
		m_image_record_type_desired = new Integer(value);
	}
	
	public int getImageRecordTypeDesired()
	{
		if (m_image_record_type_desired == null)
		{
			return -1;
		}
		return m_image_record_type_desired.intValue();
	}
	
	public void setOffenseCategory(int value)
	{
		m_offense_category = new Integer(value);
	}
	
	public int getOffenseCategory()
	{
		if (m_offense_category == null)
		{
			return -1;
		}
		return m_offense_category.intValue();
	}
	
	public void setCustodyOrSupervisoryStartDate(GregorianCalendar cal)
	{
		m_custody_or_supervisory_start_date = cal;
	}
	
	public Calendar getCustodyOrSupervisoryStartDate()
	{
		return m_custody_or_supervisory_start_date;
	}
	
	public void setSubmittedDateOfBirth(GregorianCalendar cal)
	{
		m_submitted_date_of_birth = cal;
	}
	
	public Calendar getSubmittedDateOfBirth()
	{
		return m_submitted_date_of_birth;
	}
	
	public void setPhotoType(int value)
	{
		m_photo_type = new Integer(value);
	}
	
	public int getPhotoType()
	{
		if (m_photo_type == null)
		{
			return -1;
		}
		return m_photo_type.intValue();
	}

	public void addEstimatedTimeToComplete(int value)
	{
		m_estimated_time_to_complete.add(new Integer(value));
	}
	
	public void setEstimatedTimeToCompleteList(List<Integer> value)
	{
		m_estimated_time_to_complete = new ArrayList(value);
	}
	
	public List<Integer> getEstimatedTimeToCompleteList()
	{		
		return m_estimated_time_to_complete;
	}

	public void setNumberOfImagesRequested(int value)
	{
		m_number_of_images_requested = new Integer(value);
	}
	
	public int getNumberOfImagesRequested()
	{
		if (m_number_of_images_requested == null)
		{
			return -1;
		}
		return m_number_of_images_requested.intValue();
	}
	
	public void setActionToBeTaken(String value)
	{
		m_action_to_be_taken = value;
	}
	
	public String getActionToBeTaken()
	{
		return m_action_to_be_taken;
	}
	
	public void setElectronicRapSheet(String value)
	{
		m_electronic_rap_sheet = value;
	}
	
	public String getElectronicRapSheet()
	{
		return m_electronic_rap_sheet;
	}
	
	public void setPriority(int priority)
	{
		m_priority = priority;
	}
	
	public int getPriority()
	{
		return m_priority;
	}
	
	public void setPenetrationQueryResponse(int value)
	{
		m_penetration_query_response = value;
	}
	
	public int getPenetrationQueryResponse()
	{
		return m_penetration_query_response;
	}
	
	public void setNumberOfCandidateImagesReturned(int value)
	{
		m_number_of_candidate_image_returned = new Integer(value);
	}
	
	public int getNumberOfCandidateimagesReturned()
	{
		if (m_number_of_candidate_image_returned == null)
		{
			return -1;
		}
		return m_number_of_candidate_image_returned.intValue();
	}
	
	public void setRapBackExpirationDate(GregorianCalendar cal)
	{
		m_rap_back_expiration_date = cal;
	}
	
	public Calendar getRapBackExpirationDate()
	{
		return m_rap_back_expiration_date;
	}
	
	public void setDnaInCodisFlag(int value)
	{
		m_dna_in_codis_flag = new Integer(value);
	}
	
	public int getDnaInCodisFlag()
	{
		if (m_dna_in_codis_flag == null)
		{
			return -1;
		}
		return m_dna_in_codis_flag.intValue();
	}
	
	public void setGeographicCoordinateDateTimeStamp(GregorianCalendar cal)
	{
		m_geo_coordinate_date_time_stamp = cal;
	}
	
	public Calendar getGeographicCoordinateDateTimeStamp()
	{
		return m_geo_coordinate_date_time_stamp;
	}
	
	public void setGeographicCoordinateLocation(GeographicCoordinateLocation loc)
	{
		m_geo_coordinate_location = loc;
	}
	
	public GeographicCoordinateLocation getGeographicCoordinateLocation()
	{
		return m_geo_coordinate_location;
	}

	private String m_fbi_file_number = new String();
	private ArrayList<String>	m_send_copy_to = new ArrayList<String>();
	private String m_query_depth_of_detail = new String();
	private boolean	m_retention_code = false;
	private String m_attention_indicator = new String();
	private String m_originating_agency_case_number = new String();
	private ArrayList<ContributorCaseIdentifier>	m_contributor_case_identifier = new ArrayList<ContributorCaseIdentifier>();
	private ArrayList<Integer>	m_contributor_case_identifier_extension_list = new ArrayList<Integer>();
	private String m_fbi_latent_case_number = new String();
	private String m_fbi_latent_case_extension = new String();
	private ArrayList<String> m_fbi_number_list = new ArrayList<String>();
	private String m_state_id_number = new String();
	private ArrayList<String> m_ssn_list = new ArrayList<String>();
	private ArrayList<String> m_misc_id_number_list = new ArrayList<String>();
	private String m_name = new String();
	private ArrayList<String>	m_alias_list = new ArrayList<String>();
	private String	m_place_of_birth = new String();
	private String	m_country_of_citizenship = new String();
	private GregorianCalendar	m_date_of_birth = null;
	private Integer		m_age_range_hi = null;
	private Integer		m_age_range_low = null;
	private String	m_sex = new String();
	private String	m_race = new String();
	private ArrayList<String>	m_scars_marks_tattoos = new ArrayList<String>();
	private int		m_height_ft = 0;
	private int		m_height_in = 0;
	private boolean	m_is_height_inches = true;
	private Integer		m_height_range_hi_ft = null;
	private Integer		m_height_range_hi_in = null;
	private boolean		m_is_height_range_inches = false;
	private Integer		m_height_range_low_ft = null;
	private Integer		m_height_range_low_in = null;
	private int		m_weight = 0;
	private Integer		m_weight_range_hi = 0;
	private Integer		m_weight_range_low = 0;
	private String	m_eye_color = new String();
	private String	m_hair_color = new String();
	private String	m_ncic_fingerprint_class = new String();
	private ArrayList<FingerprintPattern>	m_fingerprint_pattern = new ArrayList<FingerprintPattern>();
	private Boolean	m_is_palm_print_available = null;
	private Boolean	m_is_photo_available = null;
	private String	m_reason_fingerprinted = new String();
	private GregorianCalendar	m_date_printed = null;
	private String	m_employer_address = new String();
	private String	m_occupation = new String();
	private String	m_person_fingerprinted_address = new String();
	private String	m_military_code = new String();
	private String	m_type_of_search_requested = new String();
	private ArrayList<String>	m_geo_area_of_search_list = new ArrayList<String>();
	private GregorianCalendar m_date_of_arrest = null;
	private String	m_date_of_arrest_suffix = new String();
	private ArrayList<ArrestSegmentLiteral>	m_arrest_info = new ArrayList<ArrestSegmentLiteral>();
	private Boolean	m_is_civil_search_requested = null;
	private String	m_employee_id_number = new String();
	private ArrayList<CourtSegmentLiteral>	m_court_info = new ArrayList<CourtSegmentLiteral>();
	private Integer		m_offense_category = null;
	private GregorianCalendar m_custody_or_supervisory_start_date = null;
	private String	m_custody_or_supervisory_status = null;
	private String	m_identification_comments = null;
	private	ArrayList<Integer>	m_finger_numbers_requested = new ArrayList<Integer>();
	private String	m_search_results_findings_code = new String();
	private ArrayList<String>	m_status_or_error_message = new ArrayList<String>();
	private String	m_case_title = new String();
	private ArrayList<Integer> m_image_type = new ArrayList<Integer>();
	private String	m_person_type_designator = new String();
	private ArrayList<Candidate>	m_candidate_list = new ArrayList<Candidate>();
	private String	m_repository_statistics_response = new String();
	private ArrayList<ImageCaptureEquipment>	m_capture_equipment = new ArrayList<ImageCaptureEquipment>();
	private Integer	m_image_record_type_desired = null;
	private ArrayList<Integer>	m_estimated_time_to_complete = new ArrayList<Integer>();
	private Boolean m_request_for_electronic_rap_sheet = null;
	private String m_action_to_be_taken = null;
	private ArrayList<String>	m_fingerprints_updated = new ArrayList<String>();
	private ArrayList<String>	m_controlling_agency_identifier = new ArrayList<String>();
	private ArrayList<Integer>	m_finger_position = new ArrayList<Integer>();
	private String m_electronic_rap_sheet = null;
	private int		m_priority = -1;
	private int		m_penetration_query_response = -1;
	private Integer		m_number_of_candidate_image_returned = null;
	private String	m_response_explanation = null;
	private String	m_universal_control_number = null;
	private boolean	m_is_response = false;
	private Boolean m_is_unsolved_latent_file = null;
	private ArrayList<AmputatedOrBandaged>	m_amputated_or_bandaged = new ArrayList<AmputatedOrBandaged>();
	private String	m_civil_record_number = null;
	private ArrayList<Integer>	m_afis_segment_control_number = new ArrayList<Integer>();
	private Boolean	m_treat_as_adult = null;
	private String	m_note_field = null;
	private ArrayList<Integer>	m_match_score = new ArrayList<Integer>();
	private ArrayList<RidgeCoreDelta>	m_ridge_core_delta_one_for_subpattern_classification = new ArrayList<RidgeCoreDelta>();
	private ArrayList<RidgeCoreDelta>	m_ridge_core_delta_two_for_subpattern_classification = new ArrayList<RidgeCoreDelta>();
	private ArrayList<String>	m_special_population_cognizant_file_number = new ArrayList<String>();
	private String		m_court_case_number = null;
	private Boolean		m_request_features = null;
	private Boolean		m_request_photo = null;
	private ArrayList<String>	m_name_of_designated_repository = null;	
	private String		m_state_arrest_number = null;
	private String		m_name1 = null;
	private String		m_name2 = null;
	private String		m_name3 = null;
	private String		m_name4 = null;
	private String		m_name5 = null;
	private String		m_cascaded_search_flag = null;
	private GregorianCalendar	m_submitted_date_of_birth = null;
	private String		m_submitted_name = null;
	private Integer			m_photo_type = null;
	private Integer		m_number_of_images_requested = null;
	private String		m_rap_back_verification_status = null;
	private Boolean		m_iris_images_requested = null;
	private String		m_disposition_maintenance_indicator = null;
	private Boolean		m_rap_back_eligibility = null;
	private GregorianCalendar m_rap_back_expiration_date = null;
	private Boolean		m_dna_flag = null;
	private String		m_dna_location = null;
	private Integer		m_dna_in_codis_flag = null;
	private Boolean		m_seal_arrest_flag = null;
	private ArrayList<String>	m_rap_back_recipient = new ArrayList<String>();
	private String		m_identification_firearm_sales = new String();
	private String		m_contributor_assigned_id_no = null;
	private String		m_supplementary_id_info = null;
	private String		m_hit_type_indc = null;
	private GregorianCalendar m_geo_coordinate_date_time_stamp = null;
	private GeographicCoordinateLocation 	m_geo_coordinate_location = null;
	private String		m_geo_coordinate_datum = null;
	
	public class GeographicCoordinateLocation
	{
		public GeographicCoordinateLocation()
		{
			
		}
		
		public GeographicCoordinateLocation(String lat_degree, String lat_minute, String lat_second, String lon_degree, String lon_minute, String lon_second)
		{
			setLatitude(lat_degree, lat_minute, lat_second);
			setLongitude(lon_degree, lon_minute, lon_second);
		}
		
		public void setLatitude(String lat_degree, String lat_minute, String lat_second)
		{
			m_lat_degree = lat_degree;
			m_lat_minute = lat_minute;
			m_lat_second = lat_second;
		}
		
		public void setLongitude(String lon_degree, String lon_minute, String lon_second)
		{
			m_lon_degree = lon_degree;
			m_lon_minute = lon_minute;
			m_lon_second = lon_second;
		}

		public String getLatitudeDegree()
		{
			return m_lat_degree;
		}
		
		public String getLatitudeMinute()
		{
			return m_lat_minute;
		}
		
		public String getLatitudeSecond()
		{
			return m_lat_second;
		}

		public String getLongitudeDegree()
		{
			return m_lon_degree;
		}
		
		public String getLontitudeMinute()
		{
			return m_lon_minute;
		}
		
		public String getLongitudeSecond()
		{
			return m_lon_second;
		}

		private String m_lat_degree = new String();
		private String m_lat_minute = new String();
		private String m_lat_second = new String();
		private String m_lon_degree = new String();
		private String m_lon_minute = new String();
		private String m_lon_second = new String();
	}
	
	public class RidgeCoreDelta
	{
		public RidgeCoreDelta()
		{
			
		}
		
		public RidgeCoreDelta(int finger_number, int ridge_count)
		{
			setRidgeCoreDelta(finger_number, ridge_count);
		}
		
		public void setRidgeCoreDelta(int finger_number, int ridge_count)
		{
			m_finger_number = finger_number;
			m_ridge_count = ridge_count;
		}
		
		public int getFingerNumber()
		{
			return m_finger_number;
		}
		
		public int getRidgeCount()
		{
			return m_ridge_count;
		}
		
		private int m_finger_number = 0;
		private int	m_ridge_count = 0;
	}
	
	public class AmputatedOrBandaged
	{
		public AmputatedOrBandaged()
		{
			
		}
		
		public AmputatedOrBandaged(int finger_code, String code)
		{
			setAmputatedOrBandaged(finger_code, code);
		}
		
		public void setAmputatedOrBandaged(int finger_code, String code)
		{
			m_finger_code = finger_code;
			m_code = code;
		}
		
		public int getFingerCode()
		{
			return m_finger_code;
		}
		
		public String getCode()
		{
			return m_code;
		}
		
		private int	m_finger_code = 0;
		private String m_code = new String();
	}
	
	public class ImageCaptureEquipment
	{
		public ImageCaptureEquipment()
		{
			
		}
		
		public void setCaptureEquipment(String make, String model, String serial_no)
		{
			m_make = make;
			m_model = model;
			m_serial_no = serial_no;
		}
		
		public String getMake()
		{
			return m_make;
		}
		
		public String getModel()
		{
			return m_model;
		}
		
		public String getSerialNumber()
		{
			return m_serial_no;
		}
		
		private String	m_make = new String();
		private String	m_model = new String();
		private String 	m_serial_no = new String();
	}
	
	public class Candidate
	{
		public Candidate()
		{
			
		}
		
		public Candidate(String control_number, String name)
		{
			setCandidate(control_number, name);
		}
		
		public void setCandidate(String control_number, String name)
		{
			m_universal_control_number = control_number;
			m_name = name;
		}
		
		public String getUniversalControlNumber()
		{
			return m_universal_control_number;
		}
		
		public String getName()
		{
			return m_name;
		}
		
		private String m_universal_control_number = new String();
		private String m_name = new String();
	}
	
	
	public class CourtSegmentLiteral
	{
		public CourtSegmentLiteral()
		{
			
		}
		
		public CourtSegmentLiteral(GregorianCalendar disposition_date, String offense_literal)
		{
			setCourtInfo(disposition_date, offense_literal);
		}
		
		public CourtSegmentLiteral(GregorianCalendar disposition_date, String offense_literal, String sentencing_provisions)
		{
			setCourtInfo(disposition_date, offense_literal, sentencing_provisions);
		}
		
		public void setCourtInfo(GregorianCalendar disposition_date, String offense_literal)
		{
			m_disposition_date = disposition_date;
			m_offense_literal = offense_literal;
		}
		
		public void setCourtInfo(GregorianCalendar disposition_date, String offense_literal, String sentencing_provisions)
		{
			m_disposition_date = disposition_date;
			m_offense_literal = offense_literal;
			m_sentencing_provisions = sentencing_provisions;
		}

		public Calendar getDispositionDate()
		{
			return m_disposition_date;
		}
		
		public String getOffenseLiteral()
		{
			return m_offense_literal;
		}
		
		public String getSentencingProvisions()
		{
			return m_sentencing_provisions;
		}
		
		private GregorianCalendar m_disposition_date = null;
		private String	m_offense_literal = new String();
		private String 	m_sentencing_provisions = null;
	}
	
	
	public class ArrestSegmentLiteral
	{
		public ArrestSegmentLiteral()
		{
			
		}
		
		public ArrestSegmentLiteral(GregorianCalendar date_of_arrest, String offense_literal)
		{
			setArrestInfo(date_of_arrest, offense_literal);
		}
		
		public void setArrestInfo(GregorianCalendar date_of_arrest, String offense_literal)
		{
			m_date_of_arrest = date_of_arrest;
			m_arrest_offense_literal = offense_literal;
		}
		
		public Calendar getDateOfArrest()
		{
			return m_date_of_arrest;
		}
			
		public String getOffenseLiteral()
		{
			return m_arrest_offense_literal;
		}
		
		private GregorianCalendar m_date_of_arrest = null;
		private String	m_arrest_offense_literal = new String();
	}
	
	
	public class ContributorCaseIdentifier
	{
		public ContributorCaseIdentifier()
		{
			
		}
		
		public ContributorCaseIdentifier(String prefix, String id)
		{
			setPrefix(prefix);
			setId(id);
		}
		
		public void setPrefix(String prefix)
		{
			m_prefix = prefix;
		}
		
		public String getPrefix()
		{
			return m_prefix;
		}
		
		public void setId(String id)
		{
			m_id = id;
		}
		
		public String getId()
		{
			return m_id;
		}
		private String m_prefix = new String();
		private String m_id = new String();	
	}
	
	
	
	
	
	
	
	
}
