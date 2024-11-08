package com.central.oauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.context.LoginUserContextHolder;
import com.central.common.lock.DistributedLock;
import com.central.common.model.PageResult;
import com.central.common.service.impl.SuperServiceImpl;
import com.central.oauth.mapper.ClientMapper;
import com.central.oauth.model.Client;
import com.central.oauth.service.IClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author AlexZhang
 * <p>
 
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ClientServiceImpl extends SuperServiceImpl<ClientMapper, Client> implements IClientService {
    private final static String LOCK_KEY_CLIENTID = "clientId:";

    private final PasswordEncoder passwordEncoder;

    private final DistributedLock lock;

    @Override
    public void saveClient(Client client) throws Exception {
        client.setClientSecret(passwordEncoder.encode(client.getClientSecretStr()));
        String clientId = client.getClientId();
        if (client.getId() == null) {
            client.setCreatorId(LoginUserContextHolder.getUser().getId());
        }
        super.saveOrUpdateIdempotency(client, lock
                , LOCK_KEY_CLIENTID+clientId
                , new QueryWrapper<Client>().eq("client_id", clientId)
                , clientId + "已存在");
    }

    @Override
    public PageResult<Client> listClient(Map<String, Object> params, boolean isPage) {
        Page<Client> page;
        if (isPage) {
            page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        } else {
            page = new Page<>(1, -1);
        }
        List<Client> list = baseMapper.findList(page, params);
        page.setRecords(list);
        return PageResult.<Client>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public void delClient(long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public Client loadClientByClientId(String clientId) {
        QueryWrapper<Client> wrapper = Wrappers.query();
        wrapper.eq("client_id", clientId);
        return this.getOne(wrapper);
    }
}
