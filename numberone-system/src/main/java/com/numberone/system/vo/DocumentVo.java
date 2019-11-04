package com.numberone.system.vo;

import com.numberone.system.domain.OfficialDocument;

public class DocumentVo extends OfficialDocument {
    /**
     * 接收人id
     */
    private Integer receiveId;

    /**
     * 附件
     */
    private String file;

    private Boolean flag;

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
