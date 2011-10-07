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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
				f.setInformationField(m_fbi_file_number);
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
	
	private String m_fbi_file_number = new String();
	private ArrayList<String>	m_send_copy_to = new ArrayList<String>();
	private String m_query_depth_of_detail = new String();
	private boolean	m_retention_code = false;
	private String m_attention_indicator = new String();
	private String m_originating_agency_case_number = new String();
	private ArrayList<ContributorCaseIdentifier>	m_contributor_case_identifier = new ArrayList<ContributorCaseIdentifier>();
	private String m_fbi_latent_case_number = new String();
	private String m_fbi_latent_case_extension = new String();
	private String m_fbi_number = new String();
	private String m_state_id_number = new String();
	private ArrayList<String> m_ssn = new ArrayList<String>();
	private String m_misc_id_number = new String();
	private String m_name = new String();
	private ArrayList<String>	m_aliases = new ArrayList<String>();
	private String	m_place_of_birth = new String();
	private String	m_country_of_citizenship = new String();
	private GregorianCalendar	m_date_of_birth = new GregorianCalendar();
	private int		m_age_range_hi = 0;
	private int		m_age_range_low = 0;
	private String	m_sex = new String();
	private String	m_race = new String();
	private ArrayList<String>	m_scars_marks_tattoos = new ArrayList<String>();
	private int		m_height = 0;
	private boolean	m_height_is_inches = true;
	private int		m_height_range_hi = 0;
	private int		m_height_range_low = 0;
	private int		m_weight = 0;
	private int		m_weight_range_hi = 0;
	private int		m_weight_range_low = 0;
	private String	m_eye_color = new String();
	private String	m_hair_color = new String();
	private String	m_ncic_fingerprint_class = new String();
	private ArrayList<FingerprintPattern>	m_fingerprint_pattern = new ArrayList<FingerprintPattern>();
	private boolean	m_is_palm_print_available = false;
	private boolean	m_is_photo_available = false;
	private String	m_reason_fingerprinted = new String();
	private GregorianCalendar	m_date_printed = new GregorianCalendar();
	private String	m_employer_address = new String();
	private String	m_occupation = new String();
	private String	m_person_fingerprinted_address = new String();
	private String	m_military_code = new String();
	private String	m_type_of_search_requested = new String();
	private String	m_geo_area_of_search = new String();
	private GregorianCalendar m_date_of_arrest = null;
	private String	m_date_of_arrest_suffix = new String();
	private ArrayList<ArrestSegmentLiteral>	m_arrest_info = new ArrayList<ArrestSegmentLiteral>();
	private boolean	m_is_civil_search_requested = false;
	private String	m_employee_id_number = new String();
	private ArrayList<CourtSegmentLiteral>	m_court_info = new ArrayList<CourtSegmentLiteral>();
	private int		m_offense_category = -1;
	private GregorianCalendar m_custody_or_supervisory_start_date = null;
	private String	m_custody_or_supervisory_status = null;
	private String	m_identifidation_comments = null;
	private	ArrayList<Integer>	m_finger_numbers_requested = new ArrayList<Integer>();
	private String	m_search_results_findings_code = new String();
	private ArrayList<String>	m_status_or_error_message = new ArrayList<String>();
	private String	m_case_title = new String();
	private ArrayList<Integer> m_image_type = new ArrayList<Integer>();
	private String	m_person_type_designator = new String();
	private ArrayList<Candidate>	m_candidate_list = new ArrayList<Candidate>();
	private String	m_repository_statistics_response = new String();
	private ArrayList<ImageCaptureEquipment>	m_capture_equipment = new ArrayList<ImageCaptureEquipment>();
	private int	m_image_record_type_desired = -1;
	private int	m_estimated_time_to_complete = 0;
	private boolean m_request_for_electronic_rap_sheet = false;
	private String m_action_to_be_taken = null;
	private ArrayList<String>	m_fingerprints_updated = new ArrayList<String>();
	private ArrayList<String>	m_controlling_agency_identifier = new ArrayList<String>();
	private ArrayList<Integer>	m_finger_position = new ArrayList<Integer>();
	private String m_electronic_rap_sheet = null;
	private int		m_priority = -1;
	private int		m_penetration_query_response = -1;
	private int		m_number_of_candidate_image_returned = 0;
	private String	m_response_explanation = null;
	private String	m_universal_control_number = null;
	private boolean	m_is_response = false;
	private boolean m_is_unsolved_latent_file = false;
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
	private int			m_photo_type =-1;
	private Integer		m_number_of_images_requested = null;
	private String		m_rap_back_verification_status = null;
	private Boolean		m_iris_images_requested = null;
	private String		m_disposition_maintenance_indicator = null;
	private Boolean		m_rap_back_elidgibility = null;
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
