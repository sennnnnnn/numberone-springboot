package com.numberone.system.service.impl;

import com.numberone.common.support.Convert;
import com.numberone.system.domain.ReceiveDocument;
import com.numberone.system.mapper.ReceiveDocumentMapper;
import com.numberone.system.service.ReceiveDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiveDocumentServiceImpl implements ReceiveDocumentService {

    @Autowired
    private ReceiveDocumentMapper receiveMapper;

    @Override
    public ReceiveDocument selectReceiveById(Integer id) {
        return receiveMapper.selectReceiveDocumentById(id);
    }

    @Override
    public List<ReceiveDocument> selectDocumentList(ReceiveDocument receive) {
        return receiveMapper.selectReceiveDocumentList(receive);
    }

    @Override
    public int insertReceive(ReceiveDocument receive) {
        return receiveMapper.insertReceiveDocument(receive);
    }

    @Override
    public int updateReceive(ReceiveDocument receive) {
        return receiveMapper.updateReceiveDocument(receive);
    }

    @Override
    public int updateReceiveByDocId(ReceiveDocument receive) {
        return receiveMapper.updateReceiveDocumentByDocId(receive);
    }

    @Override
    public int deleteReceiveByIds(String ids) {
        return receiveMapper.deleteReceiveDocumentByIds(Convert.toStrArray(ids));
    }
}
