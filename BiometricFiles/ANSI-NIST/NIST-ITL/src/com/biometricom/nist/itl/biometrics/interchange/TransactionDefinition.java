/** 
 * File:    TransactionDefinition.java
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
public class TransactionDefinition
{
	TransactionDefinition()
	{
		
	}
	
	public TransactionDefinition(String name, String version, String tot, int std_version) 
	{
		m_name = name;
		m_version = version;		
				
		// need to add the type 1 rec before setting tot on rec1
		setTypeOfTransaction(tot);
		
		m_std_version = std_version;
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
	
	public void setTypeOfTransaction(String tot)
	{
		m_tot = tot;
	}
	
	public String getTypeOfTransaction()
	{
		return m_tot;
	}
	
	public void setStandardVersion(int version) throws Exception
	{
		if (version >= Transaction.STD_VERSION_2000 && version <= Transaction.STD_VERSION_2011)
		{
			m_std_version = version;
		}
		else
		{
			throw new Exception("Invalid ANSI-NIST-ITL standard version [" + version + "]");
		}
	}
	
	public int getStandardVersion()
	{
		return m_std_version;
	}
	private String				m_name = new String();
	private String				m_version = new String();
	private String				m_tot = new String();
	private int					m_std_version = 0;

}
