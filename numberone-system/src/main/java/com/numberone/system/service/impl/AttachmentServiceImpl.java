package com.numberone.system.service.impl;

import com.numberone.common.support.Convert;
import com.numberone.system.domain.Attachment;
import com.numberone.system.mapper.AttachmentMapper;
import com.numberone.system.service.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements IAttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public Attachment selectAttachmentById(Integer id) {
        return attachmentMapper.selectAttachmentById(id);
    }

    @Override
    public List<Attachment> selectAttachmentList(Attachment attachment) {
        return attachmentMapper.selectAttachmentList(attachment);
    }

    @Override
    public int insertAttachment(Attachment attachment) {
        return attachmentMapper.insertAttachment(attachment);
    }

    @Override
    public int updateAttachment(Attachment attachment) {
        return attachmentMapper.updateAttachment(attachment);
    }

    @Override
    public int updateAttachmentByDocId(Attachment attachment) {
        return attachmentMapper.updateAttachmentByDocId(attachment);
    }

    @Override
    public int deleteAttachmentByIds(String ids) {
        return attachmentMapper.deleteAttachmentByIds(Convert.toStrArray(ids));
    }
}
