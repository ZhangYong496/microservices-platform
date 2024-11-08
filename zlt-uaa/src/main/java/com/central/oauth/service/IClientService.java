package com.central.oauth.service;

import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.oauth.model.Client;

import java.util.Map;

/**
 * @author AlexZhang
 * <p>
 
 */
public interface IClientService extends ISuperService<Client> {
    void saveClient(Client clientDto) throws Exception;

    /**
     * 查询应用列表
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClient(Map<String, Object> params, boolean isPage);

    void delClient(long id);

    Client loadClientByClientId(String clientId);
}
