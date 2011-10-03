/** 
 * File:    TraditionalEncodingOutputStream.java
 * Package: com.biometricom.nist.itl.biometrics.interchange.io
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
package com.biometricom.nist.itl.biometrics.interchange.io;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.biometricom.nist.itl.biometrics.interchange.*;

/** 
 * 
 *
 * 
 * Change History:
 * Date - Who : Details
 * --------------------------------------------------------------------
 * Sep 30, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class TraditionalEncodingOutputStream extends FilterOutputStream
{
	private final static byte FS = 28;
	private final static byte GS = 29;
	private final static byte RS = 30;
	private final static byte US = 31;
	
	private final static String COLON = ":";
	private final static String CHAR_ENC_A_PATTERN = "[a-z A-Z]";
	private final static String CHAR_ENC_N_PATTERN = "[0-9]";
	private final static String CHAR_ENC_S_PATTERN = "[\\p{Punct}]";
	private final static String CHAR_ENC_AN_PATTERN = "[a-z A-Z0-9]";
	private final static String CHAR_ENC_AS_PATTERN = "[a-z A-Z\\p{Punct}]";
	private final static String CHAR_ENC_NS_PATTERN = "[0-9\\p{Punct}]";
	private final static String CHAR_ENC_ANS_PATTERN = "[a-z A-Z0-9\\p{Punct}]";
	
	
	/**
	 * @param out
	 * @throws IOException
	 */
	public TraditionalEncodingOutputStream(OutputStream out) throws IOException
	{
		super(out);		
	}

	public void write(Transaction trans) throws IOException
	{
		// first we need to set all of the IDC values for the records
		trans.setIdcForAllRecords();
		
		write(trans.getType1Record());
		//write(trans.getType2Records());
	}
	
	
	
	private void write(Record rec) throws IOException
	{
		if (rec == null)
		{
			throw new IOException("Invalid file.  No Type 1 record found");
		}
		
		ByteArrayOutputStream byte_stream = new ByteArrayOutputStream();
		
		for (Integer field_no : rec.getFieldList())
		{
			if (field_no.intValue() != 1)
			{
				System.out.println("Writing field: " + field_no.intValue());
				writeField(rec.getField(field_no.intValue()), byte_stream);
			}
		}

		// write the header length info
		writeRecordHeader(rec, byte_stream.size());
		
		// write the rest of the record data to the output
		writeRecordData(byte_stream);
	}
	
	/**
	 * 
	 * @param byte_stream
	 */
	private void writeRecordData(ByteArrayOutputStream byte_stream) throws IOException
	{
		byte[] bytes = byte_stream.toByteArray();
		
		// writeField puts a GS at the end.  For the end of the record, we need to
		// replace the final GS with an FS
		if (bytes[bytes.length-1] == GS)
		{
			bytes[bytes.length-1] = FS;
		}
		out.write(bytes);
	}
	
	private void write(List<Record> list) throws IOException
	{
		for (Record rec : list)
		{
			
		}
	}
	
	private void writeRecordHeader(Record rec, int record_size) throws IOException
	{
		Field f = rec.getField(1);
		
		int record_length = record_size;
		record_length += getFieldId(f.getRecordType(), f.getNumber()).length();
		record_length += 1;			// for the colon
		record_length += 1;			// for the header field separator
		
		// since the length value itself is included in the length of the record, we need to
		// check to see if adding the length will push us over into the next set of digits
		if (record_length >= 98 && record_length < 100)
		{
			record_length++;	
		}
		else if (record_length >= 997 && record_length < 1000)
		{
			record_length++;	
		}
		else if (record_length >= 9996 && record_length < 10000)
		{
			record_length++;	
		}
		else if (record_length >= 99995 && record_length < 100000)
		{
			record_length++;	
		}
		else if (record_length >= 999994 && record_length < 1000000)
		{
			record_length++;	
		}
		else if (record_length >= 9999993 && record_length < 10000000)
		{
			record_length++;	
		}
		else if (record_length >= 99999992 && record_length < 100000000)
		{
			record_length++;	
		}
		else if (record_length >= 999999991 && record_length < 1000000000)
		{
			record_length++;	
		}
		
		// add in the length of the length string
		record_length += Integer.toString(record_length).length();
		
		f.setInformationField(new InformationField(Integer.toString(record_length)));
		writeField(f, super.out);
	}
	
	private void writeField(Field f, OutputStream os) throws IOException
	{
		String field_id = getFieldId(f.getRecordType(), f.getNumber());
		os.write(field_id.getBytes());
		os.write(COLON.getBytes());
		if (f.hasSubFields())
		{
			List<SubField> subfield_list = f.getAllSubFields();
			for (int sfi=0; sfi<subfield_list.size(); sfi++ )
			{
				SubField sf = subfield_list.get(sfi);
				List<InformationItem> ii_list = sf.getInformationItems();
				for (int iii=0; iii<ii_list.size(); iii++)
				{
					InformationItem ii = ii_list.get(iii);
					os.write(ii.getItem().getBytes());
					if (iii == ii_list.size()-1)
					{
						if (sfi != subfield_list.size()-1)
						{
							os.write(RS);
						}
					}
					else
					{
						os.write(US);
					}
				}
			}
		}
		else
		{
			String data = f.getInformationField().getFieldData();
			os.write(data.getBytes());
		}
		
		os.write(GS);
	}
	
	private String getFieldId(int record_type, int field_no)
	{
		return String.format("%d.%03d", record_type, field_no);
	}
}
