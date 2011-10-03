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
import java.util.HashMap;
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
public abstract class Transaction
{
	public final static int STD_VERSION_2000 = 0;
	public final static int STD_VERSION_2007 = 1;
	public final static int STD_VERSION_2011 = 2;
	
	public final static int[] VALID_REC_TYPES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 98, 99};
	
	public Transaction()
	{		
	}
	
	public Transaction(TransactionDefinition def) 
	{
		setTransactionDefinition(def);
	}
	
	public void setTransactionDefinition(TransactionDefinition def)
	{
		m_def = def;
		
		try
		{
			Type1Record rec = null;
			
			List<Record> rec_list = getRecords(1);
			if (rec_list == null || rec_list.size() == 0)
			{
				rec = new Type1Record();
				addRecord(rec);				
			}
			else
			{
				rec = (Type1Record)rec_list.get(1);
			}
			rec.setTypeOfTransaction(def.getTypeOfTransaction());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
	public TransactionDefinition getTransactionDefinition()
	{
		return m_def;
	}
	
	/*public void addRecord(Type2Record rec) throws Exception
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
	}*/
	
	public void addRecord(Record rec) throws Exception
	{
		Integer key = new Integer(rec.getType());
		List<Record> rec_list = m_records.get(key);
		if (rec_list == null)
		{
			rec_list = new ArrayList<Record>();
		}
		else
		{
			// quick check to see if we're trying to add beyond the limit of the rec type
			int max_recs = getMaxRecordsForType(rec.getType());
			if (rec_list.size() >= max_recs)
			{
				throw new Exception("Transaction of type [" + m_def.getTypeOfTransaction() + "] can only have " + max_recs + " of type " + rec.getType() + " records.");
			}
		}
		if (rec_list.contains(rec) == false)
		{
			rec_list.add(rec);
			m_records.put(key, rec_list);			
		}
	}
	
	
	public abstract int getMaxRecordsForType(int type);
	
	
	public List<Record> getRecords(int type)
	{
		return m_records.get(new Integer(type));
	}
	
	public void setIdcForAllRecords()
	{
		// as we create the IDC values for each record, we'll store them here so we can set it on
		// the type 1 record when we are done.
		ArrayList<Type1Record.RecordContent> record_content = new ArrayList<Type1Record.RecordContent>(); 
		int idc = 0;
		
		//get the type 1 record as we will need to update the record content
		List<Record> rec_list = getRecords(1);
		Type1Record type1_rec = (Type1Record)rec_list.get(0);
		
		// no idc for type 1, so start with 2 and go through all the recs
		for (int i=1; i<VALID_REC_TYPES.length; i++)
		{
			rec_list = getRecords(VALID_REC_TYPES[i]);
			if (rec_list != null)
			{
				for (Record rec : rec_list)
				{
					rec.setIdc(idc);
					record_content.add(type1_rec.new RecordContent(rec.getType(), idc));
					idc++;
				}
			}
			
			
		}
		
		type1_rec.setRecordContent(record_content);
	}
	
	
	public boolean validate(List<String> error_codes)
	{
		boolean is_valid = true;
		
		
		return is_valid;
	}
	
	public boolean equals(Object t)
	{
		try
		{
			if (t instanceof Transaction)
			{
				Transaction trans = (Transaction)t;
				if (trans.getTransactionDefinition().getName().equals(m_def.getName()) && 
						trans.getTransactionDefinition().getVersion().equals(m_def.getVersion()) && 
						trans.getTransactionDefinition().getTypeOfTransaction().equals(m_def.getTypeOfTransaction()))
				{
					return true;
				}
			}
		}
		catch (Exception ex)
		{
			// fall through to false
		}
		return false;
	}
	
	private TransactionDefinition	m_def = null;
	//private String				m_name = new String();
	//private String				m_version = new String();
	//private String				m_tot = new String();
	//private int					m_std_version = 0;
	
	//private Type1Record 		m_type1_record = new Type1Record();
	//private List<Type2Record>	m_type2_records = new ArrayList<Type2Record>();
	private HashMap<Integer, List<Record>>	m_records = new HashMap<Integer, List<Record>>();
}
