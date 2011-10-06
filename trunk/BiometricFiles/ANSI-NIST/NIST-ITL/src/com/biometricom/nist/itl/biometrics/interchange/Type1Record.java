/** 
 * File:    Type1Record.java
 * Package: com.biometricom.nist.itl.biometrics.interchange
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
package com.biometricom.nist.itl.biometrics.interchange;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/** 
 * 
 *
 * 
 * Change History:
 * Date - Who : Details
 * --------------------------------------------------------------------
 * Sep 29, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class Type1Record extends Record
{	
	public Type1Record()
	{
		super(1, "Transaction Information Record");
	}
	
	public Type1Record(String type_of_transaction)
	{
		setTypeOfTransaction(type_of_transaction);
	}
	
	public boolean validate(List<String> errors)
	{
		boolean is_valid = true;
		
		if (m_version.matches("[0-9]{4}") == false)
		{
			errors.add("Record Type 1, Version (VER), must be a 4 digit string.  Current value is [" + m_version + "].");
		}
		
		if (m_type_of_transaction.matches("[a-zA-Z]{1,16}") == false)
		{
			errors.add("Record Type 1, Type of Transaction (TOT), must be an alpha string between 1 and 16 characters.Current value is [" + m_type_of_transaction + "].");
		}
		
		
		return is_valid;
	}
	
	public void setTypeOfTransaction(String type_of_transaction)
	{
		m_type_of_transaction = type_of_transaction;
	}
	
	public String getTypeOfTransaction()
	{
		return m_type_of_transaction;
	}
	
	public void setVersion(String version)
	{
		m_version = version;
	}
	
	public String getVersion()
	{
		return m_version;
	}
	
	public void setDateOfTransaction(Calendar date_of_transaction)
	{
		m_date_of_transaction = date_of_transaction;
	}
	
	public Calendar getDateOfTransaction()
	{
		return m_date_of_transaction;
	}
	
	/**
	 * This sets the priority of the transaction.  This is an optional field  
	 * @param priority  If this value is 0, the field will not be included in the record.  If it is
	 *                  a value between 1 and 9, it will be included in the transaction.
	 */
	public void setPriority(int priority)
	{
		if (priority < 0 || priority > 9)
		{
			throw new IllegalArgumentException("Priority must be an integer between 0..9");
		}
		m_priority = priority;
	}
	
	public int getPriority()
	{
		return m_priority;
	}
	
	public void setDestinationAgencyIdentifier(String dai)
	{
		m_destination_agency_identifier = dai;
	}
	
	public String getDestinationAgencyIdentifier()
	{
		return m_destination_agency_identifier;
	}
	
	public void setOriginatingAgencyIdentifier(String ori)
	{
		m_originating_agency_identifier = ori;
	}
	
	public String getOriginatingAgencyIdentifier()
	{
		return m_originating_agency_identifier;
	}
	
	public void setTransactionControlNumber(String tcn)
	{
		m_transaction_control_number = tcn;
	}
	
	public String getTransactionControlNumber()
	{
		return m_transaction_control_number;
	}
	
	public void setTransactionControlReference(String tcr)
	{
		m_transaction_control_reference = tcr;
	}
	
	public String getTransactionControlReference()
	{
		return m_transaction_control_reference;
	}
	
	public void setNativeScanningResolution(double pixels_per_mm)
	{
		m_native_scanning_resolution = pixels_per_mm;
	}
	
	public double getNativeScanningResolution()
	{
		return m_native_scanning_resolution;
	}
	
	public void setNominalResolution(double pixels_per_mm)
	{
		m_nominal_resolution = pixels_per_mm;
	}
	
	public double getNominalResolution()
	{
		return m_nominal_resolution;
	}
	
	public void setDomain(Domain domain)
	{
		m_domain = domain;
	}
	
	public Domain getDomain()
	{
		return m_domain;
	}
	
	public void setCharacterEncoding(List<CharacterEncoding> encoding)
	{
		m_character_encoding = new ArrayList<CharacterEncoding>(encoding);
	}
	
	public List<CharacterEncoding> getCharacterEncoding()
	{
		return m_character_encoding;
	}
	
	public List<ApplicationProfileSpecification> getApplicationProfileSpecifications()
	{
		return m_application_profile_specs;
	}
	
	public void addApplicationProfileSpecification(ApplicationProfileSpecification spec)
	{
		m_application_profile_specs.add(spec);
	}
	
	public void removeApplicationProfileSpecification(ApplicationProfileSpecification spec)
	{
		m_application_profile_specs.remove(spec);
	}
	
	public void removeApplicationProfileSpecification(int index)
	{
		m_application_profile_specs.remove(index);
	}
	
	public void setDestinationAgencyName(String name)
	{
		m_destination_agency_name = name;
	}
	
	public String getDestinationAgencyName()
	{
		return m_destination_agency_name;
	}
	
	public void setOriginatingAgencyName(String name)
	{
		m_originating_agency_name = name;
	}
	
	public String getOriginatingAgencyName()
	{
		return m_originating_agency_name;
	}
	
	public void setGmt(Calendar gmt)
	{
		m_gmt = gmt;
	}
	
	public Calendar getGmt()
	{
		return m_gmt;
	}
	
	public void setRecordContent(List<RecordContent> record_content)
	{
		m_record_content = new ArrayList<RecordContent>(record_content);
	}
	
	public List<RecordContent> getRecordContent()
	{
		return m_record_content;
	}
	
	public List<Integer> getFieldList()
	{
		ArrayList<Integer> field_list = new ArrayList<Integer>();
		
		for (int i=1; i<18; i++)
		{
			if (isFieldAvailable(i))
			{
				field_list.add(new Integer(i));
			}
		}
		
		return field_list;
	}
	
	public boolean isFieldAvailable(int field_no)
	{
		switch (field_no)
		{
			// all manditory fields must be available.  They may not be valid, but that is a different check
			case 2: 
			case 3:	
			case 4: 
			case 5:
			case 7:
			case 8:
			case 9:
			case 11:
			case 12:
				return true;
			
			case 6:
				if (m_priority > 0)
				{
					return true;
				}
				return false;
			
						
			case 10: 
				if (m_transaction_control_reference.length() == 0)
				{
					return false;
				}				
				return true;
				
			case 13:
				if (m_domain == null)
				{
					return false;
				}
				if (m_domain.getDomainName() == null || m_domain.getDomainName().length() == 0)
				{
					return false;
				}
				return true;
				
			case 14:
				if (m_gmt == null)
				{
					return false;
				}
				return true;
				
			case 15:
				if (m_character_encoding.size() == 0)
				{
					return false;
				}
				return true;
				
			case 16:
				if (m_application_profile_specs.size() == 0)
				{
					return false;
				}
				return true;
				
			case 17:
				if (m_destination_agency_name.length() == 0 && m_originating_agency_name.length() == 0)
				{
					return false;
				}
				return true;
								
				
			default:
				return super.isFieldAvailable(field_no);
		}
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
			case 2: 
				f = new Field(getType(), field_no, "Version Numbder", "VER");
				f.setInformationField(new InformationField(m_version));
				return f;
				
			case 3:				
				return getTransactionContentField();
				
			case 4: 
				f = new Field(getType(), field_no, "Type of Transaction", "TOT");
				f.setInformationField(new InformationField(m_type_of_transaction));
				return f;
				
			case 5: 
				f = new Field(getType(), field_no, "Date", "DAT");
				String date = String.format("%1$tY%1$tm%1$td", m_date_of_transaction);
				f.setInformationField(new InformationField(date));
				return f;

			case 6:				
				f = new Field(getType(), field_no, "Priority", "PRY");
				f.setInformationField(Integer.toString(m_priority));
				return f;
				
			case 7: 
				f = new Field(getType(), field_no, "Destination Agency Identifier", "DAI");
				f.setInformationField(new InformationField(m_destination_agency_identifier));
				return f;
				
			case 8: 
				f = new Field(getType(), field_no, "Originating Agency Identifier", "ORI");
				f.setInformationField(new InformationField(m_originating_agency_identifier));
				return f;
				
			case 9: 
				f = new Field(getType(), field_no, "Transaction Control Number", "TCN");
				f.setInformationField(new InformationField(m_transaction_control_number));
				return f;
				
			case 10: 
				f = new Field(getType(), field_no, "Transaction Control Reference", "TCR");
				f.setInformationField(new InformationField(m_transaction_control_reference));
				return f;
				
			case 11: 
				f = new Field(getType(), field_no, "Native Scanning Resolution", "NSR");
				String nsr = String.format("%05.2f", m_native_scanning_resolution);
				f.setInformationField(new InformationField(nsr));
				return f;

			case 12: 
				f = new Field(getType(), field_no, "Nominal Resolution", "NTR");
				String ntr = String.format("%05.2f", m_nominal_resolution);
				f.setInformationField(new InformationField(ntr));
				return f;
				
			case 13: 
				f = new Field(getType(), field_no, "Domain", "DOM");
				SubField dom = new SubField();
				dom.addInformationItem(m_domain.getDomainName());
				if (m_domain.getDomainVersion() != null && m_domain.getDomainVersion().length() > 0)
				{
					dom.addInformationItem(m_domain.getDomainVersion());
				}
				f.addSubField(dom);				
				return f;
				
			case 14: 
				f = new Field(getType(), field_no, "Grenwich Mean Time", "GMT");
				String gmt = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tSZ", m_gmt);
				f.setInformationField(new InformationField(gmt));
				return f;
				
			case 15: 
				f = new Field(getType(), field_no, "Character Encoding", "DCS");
				
				for (CharacterEncoding enc : m_character_encoding)
				{
					SubField dcs = new SubField();
					dcs.addInformationItem(Integer.toString(enc.getCharacterEncodingType()));
					dcs.addInformationItem(enc.getName());
					String version = enc.getVersion();
					if (version != null && version.length() > 0 )
					{
						dcs.addInformationItem(version);
					}
					f.addSubField(dcs);	
				}
				return f;
				
			case 16: 
				f = new Field(getType(), field_no, "Application Profile Specifications", "APS");
				
				for (ApplicationProfileSpecification aps : m_application_profile_specs)
				{
					SubField sfaps = new SubField();
					sfaps.addInformationItem(aps.getOrganization());
					sfaps.addInformationItem(aps.getProfileName());
					sfaps.addInformationItem(aps.getVersion());
					
					f.addSubField(sfaps);	
				}
				return f;
			
			case 17: 
				f = new Field(getType(), field_no, "Agency Names", "ANM");
				
				SubField anm = new SubField();
				anm.addInformationItem(m_destination_agency_name);
				anm.addInformationItem(m_originating_agency_name);
									
				f.addSubField(anm);					
				return f;
				
			default:
				return super.getField(field_no);
		}		
	}
	
	private Field getTransactionContentField()
	{
		Field f = new Field(getType(), 3, "Transaction Content", "CNT");
		SubField frc = new SubField();
		frc.addInformationItem("1");
		frc.addInformationItem(Integer.toString(m_record_content.size()));
		
		f.addSubField(frc);
		
		for (RecordContent rc : m_record_content)
		{
			SubField crc = new SubField();
			crc.addInformationItem(Integer.toString(rc.getRecordType()));
			crc.addInformationItem(Integer.toString(rc.getIdc()));
			
			f.addSubField(crc);
		}
		return f;
	}
	
	private String				m_version = new String();
	private String				m_type_of_transaction = new String();
	private Calendar			m_date_of_transaction = new GregorianCalendar();
	private	int					m_priority = 0;
	private String				m_transaction_control_number = new String();
	private String				m_transaction_control_reference = new String();
	private double				m_native_scanning_resolution = 0.0;
	private double				m_nominal_resolution = 0.0;
	private String				m_destination_agency_identifier = new String();
	private String				m_destination_agency_name = new String();
	private String				m_originating_agency_identifier = new String();
	private String				m_originating_agency_name = new String();
	private ArrayList<CharacterEncoding>				m_character_encoding = new ArrayList<CharacterEncoding>();
	private ArrayList<RecordContent>					m_record_content = new ArrayList<RecordContent>();
	private ArrayList<ApplicationProfileSpecification>	m_application_profile_specs = new ArrayList<ApplicationProfileSpecification>();
	private Calendar			m_gmt = null;
	private Domain				m_domain = null;
	
	public class RecordContent
	{
	    public RecordContent()
	    {	        
	        m_record_type = 0;
	        m_idc = -1;
	    }

	    public RecordContent(int record_type, int idc)
	    {	        
	        m_record_type = 0;
	        m_idc = -1;
	        setRecordContent(record_type, idc);
	    }

	    public void setRecordContent(int record_type, int idc)
	    {
	        m_record_type = record_type;
	        m_idc = idc;
	    }

	    public int getRecordType()
	    {
	        return m_record_type;
	    }

	    public int getIdc()
	    {
	        return m_idc;
	    }

	    private int m_record_type;
	    private int m_idc;
	}
	
	public class Domain
	{
	    public Domain()
	    {
	        m_domain_name = null;
	        m_domain_version = null;
	    }

	    public Domain(String domain)
	    {
	        m_domain_name = null;
	        m_domain_version = null;
	        setDomain(domain);
	    }

	    public Domain(String domain, String version)
	    {
	        m_domain_name = null;
	        m_domain_version = null;
	        setDomain(domain, version);
	    }


	    public void setDomain(String domain)
	    {
	        m_domain_name = domain;
	    }

	    public void setDomain(String domain, String version)
	    {
	        m_domain_name = domain;
	        m_domain_version = version;
	    }

	    public String getDomainName()
	    {
	        return m_domain_name;
	    }

	    public String getDomainVersion()
	    {
	        return m_domain_version;
	    }

	    private String m_domain_name;
	    private String m_domain_version;

	}
	
	public class CharacterEncoding
	{
	    public static final int CHAR_ENCODE_ASCII = 0;
	    public static final int CHAR_ENCODE_UTF16 = 2;
	    public static final int CHAR_ENCODE_UTF8 = 3;
	    public static final int CHAR_ENCODE_UTF32 = 4;
	    public static final String CHAR_ENCODE_NAME_ASCII = "ASCII";
	    public static final String CHAR_ENCODE_NAME_UTF16 = "UTF-16";
	    public static final String CHAR_ENCODE_NAME_UTF8 = "UTF-8";
	    public static final String CHAR_ENCODE_NAME_UTF32 = "UTF-32";

	    public CharacterEncoding()
	    {
	        m_character_encoding = 0;
	        m_name = "ASCII";
	        m_version = null;
	    }

	    public CharacterEncoding(int encoding)
	    {
	        m_character_encoding = 0;
	        m_name = "ASCII";
	        m_version = null;
	        setCharacterEncoding(encoding);
	    }

	    public void setCharacterEncoding(int encoding)
	    {
	        setCharacterEncodingType(encoding);
	    }

	    public void setCharacterEncoding(int encoding, String version)
	    {
	        setCharacterEncodingType(encoding);
	        setVersion(version);
	    }

	    public void setCharacterEncodingType(int encoding)
	    {
	        if(encoding == 1 || encoding > 4 && encoding < 128 || encoding > 999 || encoding < 0)
	        {
	            throw new IllegalArgumentException((new StringBuilder("Invalid character encoding: ")).append(encoding).toString());
	        }
	        
	        m_character_encoding = encoding;
	        
	        switch(encoding)
	        {
	        case 0: // '\0'
	            setName("ASCII");
	            break;

	        case 2: // '\002'
	            setName("UTF-16");
	            break;

	        case 3: // '\003'
	            setName("UTF-8");
	            break;

	        case 4: // '\004'
	            setName("UTF-32");
	            break;
	        }
	    }

	    public int getCharacterEncodingType()
	    {
	        return m_character_encoding;
	    }

	    public void setName(String name)
	    {
	        m_name = name;
	    }

	    public String getName()
	    {
	        return m_name;
	    }

	    public void setVersion(String version)
	    {
	        m_version = version;
	    }

	    public String getVersion()
	    {
	        return m_version;
	    }

	    private int m_character_encoding;
	    private String m_name;
	    private String m_version;

	}
	
	public class ApplicationProfileSpecification
	{
	    public ApplicationProfileSpecification()
	    {
	        m_organization = null;
	        m_profile_name = null;
	        m_version = null;
	    }

	    public ApplicationProfileSpecification(String organization, String profile_name, String version)
	    {
	        m_organization = null;
	        m_profile_name = null;
	        m_version = null;
	        setProfileSpecification(organization, profile_name, version);
	    }

	    public void setProfileSpecification(String organization, String profile_name, String version)
	    {
	        m_organization = organization;
	        m_profile_name = profile_name;
	        m_version = version;
	    }

	    public void setOrganization(String organization)
	    {
	        m_organization = organization;
	    }

	    public String getOrganization()
	    {
	        return m_organization;
	    }

	    public void setProfileName(String profile_name)
	    {
	        m_profile_name = profile_name;
	    }

	    public String getProfileName()
	    {
	        return m_profile_name;
	    }

	    public void setVersion(String version)
	    {
	        m_version = version;
	    }

	    public String getVersion()
	    {
	        return m_version;
	    }

	    public boolean equals(Object obj)
	    {
	        try
	        {
		        if(obj instanceof ApplicationProfileSpecification)
		        {
		            ApplicationProfileSpecification tmp = (ApplicationProfileSpecification)obj;
		            if(tmp.m_organization.equals(m_organization) && tmp.m_profile_name.equals(m_profile_name) && tmp.m_version.equals(m_version))
		            {
		            	return true;
		            }
		        }
		    }
	        catch (Exception ex)
	        {
	        	
	        }
		        
	        return false;
	    }

	    private String m_organization;
	    private String m_profile_name;
	    private String m_version;
	   
	}
}