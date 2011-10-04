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

import java.lang.reflect.Constructor;
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
	
	public static Transaction create(String name, String version, String tot) throws Exception
	{
		TransactionDefinition def = getTransactionDefinition(name, version, tot);
		if (def != null)
		{
			Class cls = Class.forName(def.getClassName());
			Class partypes[] = new Class[1];
            partypes[0] = TransactionDefinition.class;
            Constructor ct  = cls.getConstructor(partypes);
            Object arglist[] = new Object[1];
            arglist[0] = def;
            
            return (Transaction)ct.newInstance(arglist);
		}
		return null;
	}
	
	public static TransactionDefinition getTransactionDefinition(String name, String version, String tot)
	{
		int index = m_transactions.indexOf(new TransactionDefinition(name, version, tot));
		if (index >= 0)
		{
			return m_transactions.get(index);
		}
		return null;
	}
	
	public static void registerTransaction(TransactionDefinition t)
	{
		if (m_transactions.contains(t) == false)
		{
			m_transactions.add(t);
		}
	}
	
	public static void unregisterTransaction(TransactionDefinition t)
	{
		m_transactions.remove(t);
	}
	
	private static ArrayList<TransactionDefinition> m_transactions = new ArrayList<TransactionDefinition>();
}
