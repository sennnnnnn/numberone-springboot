package com.numberone.system.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 公文签收表 receive_document
 * 
 * @author numberone
 * @date 2019-11-02
 */
public class ReceiveDocument extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 公文id */
	private Integer docId;
	/** 接收人id */
	private Integer receiveId;

	/** 0未签收1已签收 */
	@Excel(name = "签收状态")
	private Integer receiveStatus;

	/** 签收时间 */
	@Excel(name = "签收时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date receiveTime;

	/** 签收意见 */
	@Excel(name = "签收意见")
	private String receiveObservation;

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
	public void setReceiveId(Integer receiveId) 
	{
		this.receiveId = receiveId;
	}

	public Integer getReceiveId() 
	{
		return receiveId;
	}
	public void setReceiveStatus(Integer receiveStatus) 
	{
		this.receiveStatus = receiveStatus;
	}

	public Integer getReceiveStatus() 
	{
		return receiveStatus;
	}
	public void setReceiveTime(Date receiveTime) 
	{
		this.receiveTime = receiveTime;
	}

	public Date getReceiveTime() 
	{
		return receiveTime;
	}
	public void setReceiveObservation(String receiveObservation) 
	{
		this.receiveObservation = receiveObservation;
	}

	public String getReceiveObservation() 
	{
		return receiveObservation;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("docId", getDocId())
            .append("receiveId", getReceiveId())
            .append("receiveStatus", getReceiveStatus())
            .append("receiveTime", getReceiveTime())
            .append("receiveObservation", getReceiveObservation())
            .toString();
    }
}
