package com.demo.fabric;

import com.dbp.core.fabric.extn.DBPServiceExecutorBuilder;
import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.JSONToResult;
import com.konylabs.middleware.dataobject.Result;
import org.json.JSONObject;

import java.util.*;

public class BankService implements JavaService2 {
    @Override
    public Object invoke(String s, Object[] objects, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse) throws Exception {
        Map<String, Object> inputParams = new HashMap<>();
        // Cach 2
//        inputParams = (Map<String, Object>) objects[1];
        //        inputParams.put("bankId", inputParams.get("bankId"));

        // Cach 3
        String bankId = dataControllerRequest.getParameter("Bank_id");

        if (bankId == null || bankId.isEmpty()) {
            Result result = new Result();
            result.addParam("Bank_id", bankId);
            return result;
        }

        inputParams.put("bankId", bankId);

        String serviceName = "SonDBService";
        String operationName = "dbxdb_CQ_get_bank_by_id";

        String resultStr = DBPServiceExecutorBuilder.builder()
                .withServiceId(serviceName)
                .withOperationId(operationName)
                .withRequestParameters(inputParams)
                .withRequestHeaders(dataControllerRequest.getHeaderMap())
                .withDataControllerRequest(dataControllerRequest)
                .build().getResponse();

        return JSONToResult.convert((new JSONObject(resultStr)).toString());
    }
}
