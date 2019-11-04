package com.numberone.system.service;

import com.numberone.system.domain.OfficialDocument;
import sun.rmi.server.InactiveGroupException;

import java.util.List;

/**
 * 公文管理 服务层
 */
public interface IOfficialDocumentService
{

    /**
     * 查询公文信息
     *
     * @param DocumentId 公文ID
     * @return 公文信息
     */
     OfficialDocument selectDocumentById(Integer DocumentId);

    /**
     * 查询公文列表
     *
     * @param Document 公文信息
     * @return 公文集合
     */
     List<OfficialDocument> selectDocumentList(OfficialDocument Document);

    /**
     * 新增公文
     *
     * @param Document 公文信息
     * @return 结果
     */
     int insertDocument(OfficialDocument Document);

    /**
     * 修改公文
     *
     * @param Document 公文信息
     * @return 结果
     */
     int updateDocument(OfficialDocument Document);

    /**
     * 删除公文信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteDocumentByIds(String ids);

    /**
     * 发布公文信息
     *
     * @param id
     * @return 结果
     */
     int issueDocumentByIds(Integer id);
}
