import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.biometricom.nist.itl.biometrics.interchange.Transaction;
import com.biometricom.nist.itl.biometrics.interchange.Type1Record;
import com.biometricom.nist.itl.biometrics.interchange.Type2Record;
import com.biometricom.nist.itl.biometrics.interchange.Type1Record.Domain;
import com.biometricom.nist.itl.biometrics.interchange.io.TraditionalEncodingOutputStream;

/** 
 * File:    Test.java
 * Package: 
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

/** 
 * 
 *
 * 
 * Change History:
 * Date - Who : Details
 * --------------------------------------------------------------------
 * Oct 2, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class Test
{
	private final static String OUTPUT_DIR = "C:/dev/test/output/";
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		
		try
		{
			Transaction trans = new Transaction("TEST");
			Type1Record type1 = trans.getType1Record();
			type1.setVersion("0500");
			type1.setDestinationAgencyIdentifier("BAR");
			type1.setOriginatingAgencyIdentifier("FU");
			type1.setTransactionControlNumber("TCN123");
			type1.setDomain(type1.new Domain("EBTS", "1.2"));
			GregorianCalendar gmt = new GregorianCalendar();
			
			//gmt.setTimeZone(TimeZone.getDefault());
			System.out.println("TZO=" + gmt.get(Calendar.ZONE_OFFSET));
			gmt.add(Calendar.MILLISECOND, gmt.get(Calendar.ZONE_OFFSET)*-1);
			type1.setGmt(gmt);
			trans.addRecord(new Type2Record());
			
			TraditionalEncodingOutputStream out = new TraditionalEncodingOutputStream(new FileOutputStream(new File(OUTPUT_DIR, "Test1.dat")));
			out.write(trans);
			out.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		

	}

}
