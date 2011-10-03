/** 
 * File:    Type2Record.java
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
 * Sep 30, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class Type2Record extends Record
{
	public Type2Record()
	{
		super(2, "User Defined Descriptive Text");
	}
	
	public boolean validate(List<String> errors)
	{
		boolean is_valid = true;
		
		return is_valid;
	}

	/* (non-Javadoc)
	 * @see com.biometricom.nist.itl.biometrics.interchange.Record#getFieldList()
	 */
	@Override
	public List<Integer> getFieldList()
	{
		ArrayList<Integer> field_list = new ArrayList<Integer>();
		
		for (int i=1; i<3; i++)
		{
			if (isFieldAvailable(i))
			{
				field_list.add(new Integer(i));
			}
		}
		
		return field_list;
	}

}
