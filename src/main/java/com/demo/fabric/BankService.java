package com.demo.fabric;

import com.dbp.core.fabric.extn.DBPServiceExecutorBuilder;
import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.JSONToResult;
import org.json.JSONObject;

import java.util.*;

public class BankService implements JavaService2 {
    @Override
    public Object invoke(String s, Object[] objects, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse) throws Exception {
        Map<String, Object> inputParams = new HashMap<>();
        inputParams = (Map<String, Object>) objects[1];

        inputParams.put("bankId", inputParams.get("bankId"));

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
