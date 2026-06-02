package com.demo.fabric.resource.address.impl;

import com.dbp.core.fabric.extn.DBPServiceExecutorBuilder;
import com.demo.fabric.resource.address.AddressResource;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.JSONToResult;
import com.konylabs.middleware.dataobject.Result;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AddressResourceImpl implements AddressResource {
    @Override
    public Result getAllAddress(DataControllerRequest request) throws Exception {
        Map<String, Object> inputParams = new HashMap<>();
        String serviceName = "SonDBService";
        String operationName = "dbxdb_address_get";
        String resultStr = DBPServiceExecutorBuilder.builder()
                .withServiceId(serviceName)
                .withOperationId(operationName)
                .withRequestParameters(inputParams)
                .withRequestHeaders(request.getHeaderMap())
                .withDataControllerRequest(request)
                .build().getResponse();

        return JSONToResult.convert((new JSONObject(resultStr)).toString());
    }

    @Override
    public Result createAddress(DataControllerRequest request, Object[] inputArray) throws Exception {
        Map<String, Object> inputParams = (Map<String, Object>) inputArray[1];

        String serviceName = "SonDBService";
        String operationName = "dbxdb_address_create";
        String resultStr = DBPServiceExecutorBuilder.builder()
                .withServiceId(serviceName)
                .withOperationId(operationName)
                .withRequestParameters(inputParams)
                .withRequestHeaders(request.getHeaderMap())
                .withDataControllerRequest(request)
                .build().getResponse();

        return JSONToResult.convert((new JSONObject(resultStr)).toString());
    }

    @Override
    public Result updateAddress(DataControllerRequest request) throws Exception {
        Map<String, Object> inputParams = new HashMap<>();

        inputParams.put("id", request.getParameter("id"));
        inputParams.put("Region_id", request.getParameter("Region_id"));
        inputParams.put("City", request.getParameter("City"));
        inputParams.put("addressLine1", request.getParameter("addressLine1"));
        inputParams.put("addressLine2", request.getParameter("addressLine2"));
        inputParams.put("zipCode", request.getParameter("zipCode"));
        inputParams.put("cityName", request.getParameter("cityName"));
        inputParams.put("User_id", request.getParameter("User_id"));
        inputParams.put("country", request.getParameter("country"));

        String serviceName = "SonDBService";
        String operationName = "dbxdb_address_update";
        String resultStr = DBPServiceExecutorBuilder.builder()
                .withServiceId(serviceName)
                .withOperationId(operationName)
                .withRequestParameters(inputParams)
                .withRequestHeaders(request.getHeaderMap())
                .withDataControllerRequest(request)
                .build().getResponse();

        return JSONToResult.convert((new JSONObject(resultStr)).toString());
    }

    @Override
    public Result deleteAddress(DataControllerRequest request) throws Exception {
        Map<String, Object> inputParams = new HashMap<>();

        inputParams.put("id", request.getParameter("id"));

        String serviceName = "SonDBService";
        String operationName = "dbxdb_address_delete";
        String resultStr = DBPServiceExecutorBuilder.builder()
                .withServiceId(serviceName)
                .withOperationId(operationName)
                .withRequestParameters(inputParams)
                .withRequestHeaders(request.getHeaderMap())
                .withDataControllerRequest(request)
                .build().getResponse();

        return JSONToResult.convert((new JSONObject(resultStr)).toString());
    }
}
