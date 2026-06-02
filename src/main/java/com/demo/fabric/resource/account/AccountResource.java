package com.demo.fabric.resource.account;

import com.dbp.core.api.Resource;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;

public interface AccountResource extends Resource {
    Result getAllAccount(DataControllerRequest request) throws Exception;
    Result getAccountByAccountId(DataControllerRequest request) throws Exception;
    Result createAccount(DataControllerRequest request) throws Exception;
}
