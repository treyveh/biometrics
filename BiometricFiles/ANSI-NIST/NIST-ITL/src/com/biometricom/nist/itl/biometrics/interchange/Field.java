// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 10/3/2011 10:01:11 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Field.java

package com.biometricom.nist.itl.biometrics.interchange;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.biometricom.nist.itl.biometrics.interchange:
//            SubField, InformationField

public class Field
{

    public Field()
    {
        m_record_type = 0;
        m_number = 0;
        m_description = new String();
        m_mnemonic = new String();
        m_subfields = new ArrayList();
        m_info = null;
    }

    public Field(int record_type)
    {
        m_record_type = 0;
        m_number = 0;
        m_description = new String();
        m_mnemonic = new String();
        m_subfields = new ArrayList();
        m_info = null;
        setRecordType(record_type);
    }

    public Field(int record_type, int number, String description, String mnemonic)
    {
        m_record_type = 0;
        m_number = 0;
        m_description = new String();
        m_mnemonic = new String();
        m_subfields = new ArrayList();
        m_info = null;
        m_record_type = record_type;
        m_number = number;
        m_description = description;
        m_mnemonic = mnemonic;
    }

    public void setRecordType(int record_type)
    {
        m_record_type = record_type;
    }

    public int getRecordType()
    {
        return m_record_type;
    }

    public void setNumber(int number)
    {
        m_number = number;
    }

    public int getNumber()
    {
        return m_number;
    }

    public void setDescription(String description)
    {
        m_description = description;
    }

    public String getDescription()
    {
        return m_description;
    }

    public void setMnemonic(String mnemonic)
    {
        m_mnemonic = mnemonic;
    }

    public String getMnemonic()
    {
        return m_mnemonic;
    }

    public void addSubField(SubField subfield)
    {
        m_subfields.add(subfield);
    }

    public void addSubField(int index, SubField subfield)
    {
        m_subfields.add(index, subfield);
    }

    public void updateSubField(int index, SubField subfield)
    {
        m_subfields.remove(index);
        m_subfields.add(index, subfield);
    }

    public void removeSubField(int index)
    {
        m_subfields.remove(index);
    }

    public List getAllSubFields()
    {
        return m_subfields;
    }

    public SubField getFieldData(int index)
    {
        return (SubField)m_subfields.get(index);
    }

    public void setInformationField(InformationField info)
    {
        m_info = info;
    }

    public void setInformationField(String info)
    {
        m_info = new InformationField(info);
    }

    public InformationField getInformationField()
    {
        return m_info;
    }

    public boolean hasSubFields()
    {
        return m_subfields.size() > 0;
    }

    private int m_record_type;
    private int m_number;
    private String m_description;
    private String m_mnemonic;
    private ArrayList m_subfields;
    private InformationField m_info;
}