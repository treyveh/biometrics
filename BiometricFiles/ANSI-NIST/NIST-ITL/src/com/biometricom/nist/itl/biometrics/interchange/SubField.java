/** 
 * File:    SubField.java
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
import java.util.List;

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
public class SubField
{
	public SubField()
	{
		
	}
	
	public void addInformationItem(String item)
	{
		m_info_items.add(new InformationItem(item));
	}
	
	public List<InformationItem> getInformationItems()
	{
		return m_info_items;
	}
	
	private ArrayList<InformationItem>	m_info_items = new ArrayList<InformationItem>();
}
