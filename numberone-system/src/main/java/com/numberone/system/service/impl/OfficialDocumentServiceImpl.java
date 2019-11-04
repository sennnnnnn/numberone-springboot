package com.numberone.system.service.impl;

import com.numberone.common.support.Convert;
import com.numberone.system.domain.OfficialDocument;
import com.numberone.system.mapper.OfficialDocumentMapper;
import com.numberone.system.service.IOfficialDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficialDocumentServiceImpl implements IOfficialDocumentService {

    @Autowired
    private OfficialDocumentMapper officialDocumentMapper;


    @Override
    public OfficialDocument selectDocumentById(Integer id) {
        return officialDocumentMapper.selectOfficialDocumentById(id);
    }

    @Override
    public List<OfficialDocument> selectDocumentList(OfficialDocument document) {
        return officialDocumentMapper.selectOfficialDocumentList(document);
    }

    @Override
    public int insertDocument(OfficialDocument document) {
        return officialDocumentMapper.insertOfficialDocument(document);
    }

    /**
     * 修改公文对象
     *
     * @param document
     * @return
     */
    @Override
    public int updateDocument(OfficialDocument document) {
        return officialDocumentMapper.updateOfficialDocument(document);
    }

    /**
     * 删除公文对象
     *
     * @param ids 需要删除的数据ID
     * @return
     */
    @Override
    public int deleteDocumentByIds(String ids) {
        return officialDocumentMapper.deleteOfficialDocumentByIds(Convert.toStrArray(ids));
    }

    @Override
    public int issueDocumentByIds(Integer id) {
        return officialDocumentMapper.issueDocumentByIds(id);
    }
}
