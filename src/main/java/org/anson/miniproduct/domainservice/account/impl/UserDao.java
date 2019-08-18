package org.anson.miniproduct.domainservice.account.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.anson.miniproduct.domainservice.base.BaseDao;
import org.anson.miniproduct.infrastructure.tool.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor = Exception.class)
@Slf4j
class UserDao extends BaseDao<UserPO, UserMapper> {

    public Boolean authentication(String userNo, String encryptedPsd){
        QueryWrapper<UserPO> qw = new QueryWrapper<>();
        qw.eq(UserPO.NO, userNo)
                .select(UserPO.PASSWORD, UserPO.REGISTEREDTIME, UserPO.ID);

        UserPO user = mapper.selectOne(qw);

        if (user == null) {
            return false;
        }

        // 计算密码
        log.debug("注册时间 : {}, 输入密码: {}", user.getRegisteredTime(), encryptedPsd);
        String secondEncryptedPsd = SecurityHelper.calcPsd(user.getRegisteredTime(), encryptedPsd);
        log.debug("secondEncryptedPsd : [{}]", secondEncryptedPsd);

        if (StrUtil.isNotBlank(secondEncryptedPsd) && secondEncryptedPsd.equals(user.getPassword())) {
            return true;
        }

        return false;
    }
    // 注入
    @Autowired
    @Override
    protected void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
