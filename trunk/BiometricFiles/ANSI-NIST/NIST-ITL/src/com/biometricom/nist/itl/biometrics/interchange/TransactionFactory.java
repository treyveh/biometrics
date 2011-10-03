/** 
 * File:    TransactionFactory.java
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
public class TransactionFactory
{
	private TransactionFactory()
	{		
	}
	
	public void registerTransaction(TransactionDefinition t)
	{
		if (m_transactions.contains(t) == false)
		{
			m_transactions.add(t);
		}
	}
	
	private static ArrayList<TransactionDefinition> m_transactions = new ArrayList<TransactionDefinition>();
}
