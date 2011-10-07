/** 
 * File:    FingerprintPattern.java
 * Package: com.biometricom.ebts.fbi
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
package com.biometricom.ebts.fbi;

/** 
 * 
 *
 * 
 * Change History:
 * Date - Who : Details
 * --------------------------------------------------------------------
 * Oct 6, 2011 - Pete Byhre : Created
 * 
 * 
 *
 */
public class FingerprintPattern
{
	public FingerprintPattern()
	{
		
	}
	
	public FingerprintPattern(int fingerprint_no, String pattern_code)
	{
		setFingerprintPattern(fingerprint_no, pattern_code);
	}
	
	public void setFingerprintPattern(int fingerprint_no, String pattern_code)
	{
		m_fingerprint_no = fingerprint_no;
		m_pattern_code = pattern_code;
	}
	
	public int getFingerNumber()
	{
		return m_fingerprint_no;
	}
	
	public String getFingerprintPatternCode()
	{
		return m_pattern_code;
	}
	
	private int		m_fingerprint_no = 0;
	private String	m_pattern_code = new String();
}
