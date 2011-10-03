/** 
 * File:    Transaction.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Collections;

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
public class Transaction
{
	public Transaction()
	{		
	}
	
	public Transaction(String tot)
	{
		m_type1_record.setTypeOfTransaction(tot);
	}
	
	public void setTypeOfTransaction(String tot)
	{
		m_type1_record.setTypeOfTransaction(tot);
	}
	
	public String getTypeOfTransaction()
	{
		return m_type1_record.getTypeOfTransaction();
	}
	
	public void addRecord(Type2Record rec) throws Exception
	{
		m_type2_records.add(rec);
	}
	
	public Type1Record getType1Record()
	{
		return m_type1_record;
	}
	
	public List<Type2Record> getType2Records()
	{
		return m_type2_records;
	}
	
	public void setIdcForAllRecords()
	{
		// as we create the IDC values for each record, we'll store them here so we can set it on
		// the type 1 record when we are done.
		ArrayList<Type1Record.RecordContent> record_content = new ArrayList<Type1Record.RecordContent>(); 
		int idc = 0;
		
		// no idc for type 1, so start with 2 and go through all the recs
		for (Record rec : m_type2_records)
		{
			rec.setIdc(idc);
			record_content.add(m_type1_record.new RecordContent(2, idc));
			idc++;
		}
		
		m_type1_record.setRecordContent(record_content);
	}
	
	
	public boolean validate(List<String> error_codes)
	{
		boolean is_valid = true;
		
		
		return is_valid;
	}
	
	private Type1Record 		m_type1_record = new Type1Record();
	private List<Type2Record>	m_type2_records = new ArrayList<Type2Record>();
}
