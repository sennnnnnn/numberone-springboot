package com.numberone.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;
/**
 * 附件表 attachment
 * 
 * @author numberone
 * @date 2019-11-02
 */
public class Attachment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 公文id */
	private Integer docId;
	/** 附件url */
	private String url;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setDocId(Integer docId) 
	{
		this.docId = docId;
	}

	public Integer getDocId() 
	{
		return docId;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("docId", getDocId())
            .append("url", getUrl())
            .toString();
    }
}
