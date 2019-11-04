package com.numberone.system.mapper;

import com.numberone.system.domain.OfficialDocument;

import java.util.List;

/**
 * 公文 数据层
 *
 * @author numberone
 * @date 2019-11-02
 */
public interface OfficialDocumentMapper {
    /**
     * 查询公文信息
     *
     * @param id 公文ID
     * @return 公文信息
     */
    public OfficialDocument selectOfficialDocumentById(Integer id);

    /**
     * 查询公文列表
     *
     * @param officialDocument 公文信息
     * @return 公文集合
     */
    public List<OfficialDocument> selectOfficialDocumentList(OfficialDocument officialDocument);

    /**
     * 新增公文
     *
     * @param officialDocument 公文信息
     * @return 结果
     */
    public int insertOfficialDocument(OfficialDocument officialDocument);

    /**
     * 修改公文
     *
     * @param officialDocument 公文信息
     * @return 结果
     */
    public int updateOfficialDocument(OfficialDocument officialDocument);

    /**
     * 删除公文
     *
     * @param id 公文ID
     * @return 结果
     */
    public int deleteOfficialDocumentById(Integer id);

    /**
     * 批量删除公文
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOfficialDocumentByIds(String[] ids);

    /**
     * 发布公文
     *
     * @param id
     * @return
     */
    public int issueDocumentByIds(Integer id);

}