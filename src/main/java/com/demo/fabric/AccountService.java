package com.demo.fabric;

import com.demo.fabric.resource.account.impl.AccountResourceImpl;
import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;

public class AccountService implements JavaService2 {
//    private static final Logger logger = LogManager.getLogger(UserJavaService.class);

    public AccountService() {
    }

    @Override
    public Object invoke(String methodId, Object[] inputArray, DataControllerRequest request, DataControllerResponse response) throws Exception {

        AccountResourceImpl accountResource = new AccountResourceImpl();
        System.out.println("Start Account Service");

        Result result = new Result();
        try {
            switch (methodId) {
                case "accountInfo": return accountResource.getAllAccount(request);
                case "createAccount": return accountResource.createAccount(request);
                case "getAccountById": return accountResource.getAccountByAccountId(request);
                default: return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in UserJavaService"+ e);
            return result;
        }
    }
}
