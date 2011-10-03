/** 
 * File:    InformationItem.java
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
 * Sep 29, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class InformationItem
{
	public InformationItem()
	{
		
	}
	
	public InformationItem(String item)
	{
		setItem(item);
	}
	
	public void setItem(String item)
	{
		m_item = item;
	}
	
	public String getItem()
	{
		return m_item;
	}
	
	private String		m_item;
}
