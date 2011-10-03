/** 
 * File:    InformationField.java
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
public class InformationField
{
	public InformationField()
	{
		
	}
	
	public InformationField(String data)
	{
		setFieldData(data);
	}
	
	public void setFieldData(String data)
	{
		m_data = data;
	}
	
	public String getFieldData()
	{
		return m_data;
	}
	
	private String m_data = new String();
}
