package com.numberone.system.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;
import java.util.Date;

/**
 * 公文表 official_document
 * 
 * @author numberone
 * @date 2019-11-02
 */
public class OfficialDocument extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	

	@Excel(name = "序号")
	private Integer id;

	@Excel(name = "公文编号")
	private String code;

	@Excel(name = "公文标题")
	private String title;
	/** 0普通1加急 */
	@Excel(name = "公文等级",readConverterExp = "0普通,1加急")
	private String level;
	/** 0保密1绝密 */
	@Excel(name = "公文密级",readConverterExp = "0保密,1绝密")
	private String secretLevel;
	/** 内容 */
	@Excel(name = "公文内容")
	private String content;
	/** 0未发布1已发布 */
	@Excel(name = "公文状态", readConverterExp = "0未发布,1已发布")
	private String status;

	@Excel(name = "发布日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date publishTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setLevel(String level)
	{
		this.level = level;
	}

	public String getLevel()
	{
		return level;
	}
	public void setSecretLevel(String secretLevel)
	{
		this.secretLevel = secretLevel;
	}

	public String getSecretLevel()
	{
		return secretLevel;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getStatus()
	{
		return status;
	}

	public void setPublishTime(Date publishTime) 
	{
		this.publishTime = publishTime;
	}

	public Date getPublishTime() 
	{
		return publishTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("title", getTitle())
            .append("level", getLevel())
            .append("secretLevel", getSecretLevel())
            .append("content", getContent())
            .append("status", getStatus())
			.append("createBy", getCreateBy())
			.append("createTime", getCreateTime())
			.append("updateBy", getUpdateBy())
			.append("updateTime", getUpdateTime())
            .append("publishTime", getPublishTime())
            .toString();
    }
}
