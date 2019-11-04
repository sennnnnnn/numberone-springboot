package com.numberone.system.service;

import com.numberone.system.domain.Attachment;

import java.util.List;

public interface IAttachmentService {

    Attachment selectAttachmentById(Integer id);
    
    List<Attachment> selectAttachmentList(Attachment attachment);
    
    int insertAttachment(Attachment attachment);
    
    int updateAttachment(Attachment attachment);

    int updateAttachmentByDocId(Attachment attachment);

    int deleteAttachmentByIds(String ids);



}
