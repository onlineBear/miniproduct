package org.anson.miniproduct.domainservice.sys.permission.resource.impl;

import org.anson.miniproduct.domainservice.sys.permission.resource.IResourceDMService;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.UpdResourceCMD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@Component
@Transactional(rollbackFor = Exception.class)
class ResourceDMService implements IResourceDMService {
    @Override
    public String addResource(@Valid AddResourceCMD cmd) throws Exception {
        ResourcePO po = addResourceCMDConverter.toResourcePO(cmd);
        String id = this.dao.insert(po);
        return id;
    }

    @Override
    public void updateResource(@Valid UpdResourceCMD cmd) throws Exception {
        ResourcePO po = updResourceCMDConverter.toResourcePO(cmd);
        this.dao.updateById(po);
    }

    @Override
    public void deleteResource(@Valid @NotBlank String id) throws Exception {
        // 删除资源
        this.dao.deleteById(id);

        // 删除相应的角色资源
    }

    // 注入
    @Autowired
    private ResourceDao dao;
    @Autowired
    private AddResourceCMDConverter addResourceCMDConverter;
    @Autowired
    private UpdResourceCMDConverter updResourceCMDConverter;
}
