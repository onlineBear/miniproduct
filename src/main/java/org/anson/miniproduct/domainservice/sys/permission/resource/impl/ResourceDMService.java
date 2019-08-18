package org.anson.miniproduct.domainservice.sys.permission.resource.impl;

import org.anson.miniproduct.domainservice.sys.permission.resource.IResourceDMService;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;


@Component
@Transactional(rollbackFor = Exception.class)
class ResourceDMService implements IResourceDMService {
    @Override
    public String addResource(@Valid AddResourceCMD cmd) throws Exception {
        ResourcePO po = addResourceCMDConvert.toResourcePO(cmd);
        String id = this.dao.insert(po);
        return id;
    }

    // 注入
    @Autowired
    private ResourceDao dao;
    @Autowired
    private AddResourceCMDConvert addResourceCMDConvert;
}
