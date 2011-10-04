/** 
 * File:    Registry.java
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

import com.biometricom.nist.itl.biometrics.interchange.Transaction;
import com.biometricom.nist.itl.biometrics.interchange.TransactionDefinition;
import com.biometricom.nist.itl.biometrics.interchange.TransactionFactory;

/** 
 * 
 *
 * 
 * Change History:
 * Date - Who : Details
 * --------------------------------------------------------------------
 * Oct 3, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class Registry
{
	private Registry()
	{
		
	}
	
	public static void registerTransactions() throws Exception
	{
		TransactionFactory.registerTransaction(new TransactionDefinition("EBTS-DOD", "1.2", "CAR", Transaction.STD_VERSION_2000, "com.biometricom.ebts.dod.CriminalAnswerRequiredTransaction"));
	}
}
