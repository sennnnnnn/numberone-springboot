package com.numberone.system.service;

import com.numberone.system.domain.ReceiveDocument;

import java.util.List;

public interface ReceiveDocumentService {

    ReceiveDocument selectReceiveById(Integer id);

    List<ReceiveDocument> selectDocumentList(ReceiveDocument Document);

    int insertReceive(ReceiveDocument Document);

    int updateReceive(ReceiveDocument Document);

    int updateReceiveByDocId(ReceiveDocument Document);

    int deleteReceiveByIds(String ids);

}
