package com.numberone.web.controller.offic;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.numberone.common.annotation.Log;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.enums.BusinessType;
import com.numberone.common.page.TableDataInfo;
import com.numberone.framework.util.ShiroUtils;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.Attachment;
import com.numberone.system.domain.OfficialDocument;
import com.numberone.system.domain.ReceiveDocument;
import com.numberone.system.domain.SysUser;
import com.numberone.system.service.IAttachmentService;
import com.numberone.system.service.IOfficialDocumentService;
import com.numberone.system.service.ISysUserService;
import com.numberone.system.service.ReceiveDocumentService;
import com.numberone.system.vo.DocumentVo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 公告 信息操作处理
 *
 * @author numberone
 */
@Controller
@RequestMapping("/official/document")
public class OfficDocumentController extends BaseController {
    private String prefix = "official";

    @Autowired
    private IOfficialDocumentService documentService;

    @Autowired
    private ReceiveDocumentService receiveService;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("official:document:view")
    @GetMapping()
    public String document() {
        return prefix + "/document";
    }

    /**
     * 查询公文列表
     */
    @RequiresPermissions("official:document:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OfficialDocument document) {
        startPage();
        List<OfficialDocument> list = documentService.selectDocumentList(document);
        return getDataTable(list);
    }

    @GetMapping("/lookers/{docId}")
    public String lookers(@PathVariable("docId") Integer docId, ModelMap mmap) {
        mmap.put("docId",docId);
        return prefix + "/lookers";
    }


    /**
     * 查询签收人数列表
     */
    @RequiresPermissions("official:document:lookers")
    @PostMapping("/lookers/list")
    @ResponseBody
    public TableDataInfo lookersList(ReceiveDocument receive) {
        startPage();
        List<ReceiveDocument> list = receiveService.selectDocumentList(receive);
        return getDataTable(list);
    }

    /**
     * 新增公文
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SysUser user = new SysUser();
        mmap.put("users", userService.selectUserList(user));
        return prefix + "/add";
    }

    /**
     * 新增保存公文
     */
    @RequiresPermissions("official:document:add")
    @Log(title = "公文管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(DocumentVo document) {

        document.setCreateBy(ShiroUtils.getLoginName());
        documentService.insertDocument(document);

        //附件
        if (document.getFile() != null) {
            Attachment attachment = new Attachment();
            attachment.setDocId(document.getId());
            attachment.setUrl(document.getFile());
            attachmentService.insertAttachment(attachment);
        }

        //接收人
        ReceiveDocument receive = new ReceiveDocument();
        receive.setDocId(document.getId());
        receive.setReceiveId(document.getReceiveId());
        receive.setCreateBy(ShiroUtils.getLoginName());
        receive.setCreateTime(new Date());
        return toAjax(receiveService.insertReceive(receive));

    }

    /**
     * 修改公文
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        SysUser user = new SysUser();
        OfficialDocument official = documentService.selectDocumentById(id);

        ReceiveDocument receive = new ReceiveDocument();
        receive.setDocId(id);
        List<ReceiveDocument> receiveList = receiveService.selectDocumentList(receive);
        List<SysUser> users = userService.selectUserList(user);
        if (receiveList.size() > 0) {
            receiveList.stream().filter(i -> i.getReceiveId() != null).forEach(i -> {
                users.stream().forEach(u -> {
                    if (i.getReceiveId().toString().equals(u.getUserId().toString())) {
                        u.setFlag(true);
                    }
                });
            });
        }
        Attachment attachment = new Attachment();
        attachment.setDocId(id);
        List<Attachment> list = attachmentService.selectAttachmentList(attachment);
        if (list.size() > 0) {
            JSONObject jsonObject = JSON.parseObject(list.get(0).getUrl());
            mmap.put("fileName", jsonObject.getString("fileName"));
            mmap.put("fileUrl", jsonObject.getString("url"));
        }
        mmap.put("users", users);
        mmap.put("document", official);
        return prefix + "/edit";
    }


    /**
     * 详情公文
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, ModelMap mmap) {
        SysUser user = new SysUser();
        OfficialDocument official = documentService.selectDocumentById(id);

        ReceiveDocument receive = new ReceiveDocument();
        receive.setDocId(id);
        List<ReceiveDocument> receiveList = receiveService.selectDocumentList(receive);
        List<SysUser> users = userService.selectUserList(user);
        if (receiveList.size() > 0) {
            receiveList.stream().filter(i -> i.getReceiveId() != null).forEach(i -> {
                users.stream().forEach(u -> {
                    if (i.getReceiveId().toString().equals(u.getUserId().toString())) {
                        u.setFlag(true);
                    }
                });
            });
        }
        Attachment attachment = new Attachment();
        attachment.setDocId(id);
        List<Attachment> list = attachmentService.selectAttachmentList(attachment);
        if (list.size() > 0) {
            JSONObject jsonObject = JSON.parseObject(list.get(0).getUrl());
            mmap.put("fileName", jsonObject.getString("fileName"));
            mmap.put("fileUrl", jsonObject.getString("url"));
        }
        mmap.put("users", users);
        mmap.put("document", official);
        return prefix + "/detail";
    }


    /**
     * 修改保存公文
     */
    @RequiresPermissions("official:document:edit")
    @Log(title = "公文管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(DocumentVo document) {
        if (document.getReceiveId() != null) {
            //编辑接收人
            ReceiveDocument receive = new ReceiveDocument();
            receive.setDocId(document.getId());
            List<ReceiveDocument> list = receiveService.selectDocumentList(receive);
            receive.setReceiveId(document.getReceiveId());
            if (list.size() > 0) {
                receiveService.updateReceiveByDocId(receive);
            } else {
                receiveService.insertReceive(receive);
            }
        }
        if (document.getFile() != null) {
            //编辑附件
            Attachment attachment = new Attachment();
            attachment.setDocId(document.getId());
            List<Attachment> list = attachmentService.selectAttachmentList(attachment);
            attachment.setUrl(document.getFile());
            if (list.size() > 0) {
                attachmentService.updateAttachmentByDocId(attachment);
            } else {
                attachmentService.insertAttachment(attachment);
            }
        }

        document.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(documentService.updateDocument(document));
    }

    /**
     * 删除公文
     */
    @RequiresPermissions("official:document:remove")
    @Log(title = "公文管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(documentService.deleteDocumentByIds(ids));
    }

    /**
     * 发布公文
     */
    @RequiresPermissions("official:document:issue")
    @Log(title = "公文管理", businessType = BusinessType.UPDATE)
    @GetMapping("/issue/{id}")
    @ResponseBody
    public AjaxResult issue(@PathVariable("id") Integer id) {
        return toAjax(documentService.issueDocumentByIds(id));
    }



}
