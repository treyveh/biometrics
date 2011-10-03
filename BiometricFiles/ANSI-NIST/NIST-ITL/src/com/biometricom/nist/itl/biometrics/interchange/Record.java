/** 
 * File:    Record.java
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

import java.util.List;
import java.util.TreeMap;

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
public abstract class Record
{
	public Record()
	{	
	}
	
	public Record(int record_type, String description)
	{
		setRecordType(record_type, description);
	}
	
	public Record(int record_type, String description, int idc)
	{
		setRecordType(record_type, description, idc);
	}

	public void setRecordType(int record_type, String description)
	{
		m_record_type = record_type;
		m_description = description;
	}
	
	public void setRecordType(int record_type, String description, int idc)
	{
		m_record_type = record_type;
		m_description = description;
		m_idc = idc;
	}
	
	public void setIdc(int idc)
	{
		m_idc = idc;
	}
	
	public int getIdc()
	{
		return m_idc;
	}
	
	public boolean isFieldAvailable(int field_no)
	{
		if (field_no == 1 || field_no ==2)
		{
			return true;
		}
		return false;
	}
	
	public abstract List<Integer> getFieldList();
	
	public Field getField(int field_no)
	{
		Field f = null;
		
		switch (field_no)
		{
			case 1:
				f = new Field(m_record_type, field_no, "Record Header", "LEN");
				break;
				
			case 2:
				f = new Field(m_record_type, field_no, "Information Designation Character", "IDC");
				f.setInformationField(Integer.toString(m_idc));
				break;
				
		}
		
		return f;
	}
	
	public Field getField(String mnemonic)
	{
		if (mnemonic.equals("LEN"))
		{
			return getField(1);
		}
		else if (mnemonic.equals("IDC"))
		{
			return getField(2);
		}
		
		return null;
	}

	public abstract boolean validate(List<String> errors);
	
	private int							m_record_type = 0;
	private String						m_description = new String();
	private int							m_idc = -1;
	private TreeMap<Integer, Field> 	m_fields = new TreeMap<Integer, Field>();
}
