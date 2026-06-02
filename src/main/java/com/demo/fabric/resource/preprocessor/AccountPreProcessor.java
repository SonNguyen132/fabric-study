package com.demo.fabric.resource.preprocessor;

import com.konylabs.middleware.common.DataPreProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;

import java.util.HashMap;

public class AccountPreProcessor implements DataPreProcessor2 {
    @Override
    public boolean execute(HashMap hashMap, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse, Result result) throws Exception {

        System.out.println("AccountPreProcessor START");
        // Validate id
        String accountId = dataControllerRequest.getParameter("account_id");
        if (accountId == null || accountId.isEmpty()) {
            throw new Exception("Account ID is empty");
        }
        System.out.println("AccountPreProcessor END");
        return true;
    }
}
