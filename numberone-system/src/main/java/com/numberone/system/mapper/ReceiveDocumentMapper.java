package com.numberone.system.mapper;

import com.numberone.system.domain.ReceiveDocument;
import java.util.List;	

/**
 * 公文签收 数据层
 * 
 * @author numberone
 * @date 2019-11-02
 */
public interface ReceiveDocumentMapper 
{
	/**
     * 查询公文签收信息
     * 
     * @param id 公文签收ID
     * @return 公文签收信息
     */
	public ReceiveDocument selectReceiveDocumentById(Integer id);
	
	/**
     * 查询公文签收列表
     * 
     * @param receiveDocument 公文签收信息
     * @return 公文签收集合
     */
	public List<ReceiveDocument> selectReceiveDocumentList(ReceiveDocument receiveDocument);
	
	/**
     * 新增公文签收
     * 
     * @param receiveDocument 公文签收信息
     * @return 结果
     */
	public int insertReceiveDocument(ReceiveDocument receiveDocument);
	
	/**
     * 修改公文签收
     * 
     * @param receiveDocument 公文签收信息
     * @return 结果
     */
	public int updateReceiveDocument(ReceiveDocument receiveDocument);

	public int updateReceiveDocumentByDocId(ReceiveDocument receiveDocument);

	/**
     * 删除公文签收
     * 
     * @param id 公文签收ID
     * @return 结果
     */
	public int deleteReceiveDocumentById(Integer id);
	
	/**
     * 批量删除公文签收
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteReceiveDocumentByIds(String[] ids);
	
}