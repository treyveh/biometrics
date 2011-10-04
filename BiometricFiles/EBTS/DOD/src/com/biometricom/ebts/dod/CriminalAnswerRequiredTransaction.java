/** 
 * File:    CriminalAnswerRequiredTransaction.java
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
public class CriminalAnswerRequiredTransaction extends Transaction
{

	/* (non-Javadoc)
	 * @see com.biometricom.nist.itl.biometrics.interchange.Transaction#getMaxRecordsForType(int)
	 */
	@Override
	public int getMaxRecordsForType(int type)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
