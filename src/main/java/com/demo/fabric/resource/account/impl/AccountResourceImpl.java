package com.demo.fabric.resource.account.impl;

import com.dbp.core.fabric.extn.DBPServiceExecutorBuilder;
import com.demo.fabric.resource.account.AccountResource;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.JSONToResult;
import com.konylabs.middleware.dataobject.Result;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AccountResourceImpl implements AccountResource {

    @Override
    public Result getAllAccount(DataControllerRequest request) throws Exception {
        Map<String, Object> inputParams = new HashMap<>();
        String serviceName = "SonDBService";
        String operationName = "dbxdb_accounts_get";
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
    public Result getAccountByAccountId(DataControllerRequest request) throws Exception {
        Map<String, Object> inputParams = new HashMap<>();
        inputParams.put("account_id", request.getParameter("account_id"));

        String serviceName = "SonDBService";
        String operationName = "dbxdb_CQ_get_account_by_account_id";
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
    public Result createAccount(DataControllerRequest request) throws Exception {
        Map<String, Object> inputParams = new HashMap<>();

// Nhóm tham số thứ nhất (Hiển thị ở danh sách text ẩn phía trên)
        inputParams.put("Account_id", request.getParameter("Account_id"));
        inputParams.put("AccountName", request.getParameter("AccountName"));
        inputParams.put("UserName", request.getParameter("UserName"));
        inputParams.put("ExternalBankidentity_id", request.getParameter("ExternalBankidentity_id"));
        inputParams.put("CurrencyCode", request.getParameter("CurrencyCode"));
        inputParams.put("AvailableBalance", request.getParameter("AvailableBalance"));
        inputParams.put("AccountHolder", request.getParameter("AccountHolder"));
        inputParams.put("Address", request.getParameter("Address"));
        inputParams.put("Scheme", request.getParameter("Scheme"));
        inputParams.put("Number", request.getParameter("Number"));
        inputParams.put("error", request.getParameter("error"));
        inputParams.put("Type_id", request.getParameter("Type_id"));
        inputParams.put("Product_id", request.getParameter("Product_id"));
        inputParams.put("Bank_id", request.getParameter("Bank_id"));
        inputParams.put("User_id", request.getParameter("User_id"));
        inputParams.put("Name", request.getParameter("Name"));
        inputParams.put("isBusinessAccount", request.getParameter("isBusinessAccount"));
        inputParams.put("Status_id", request.getParameter("Status_id"));
        inputParams.put("StatusDesc", request.getParameter("StatusDesc"));
        inputParams.put("companyLegalUnit", request.getParameter("companyLegalUnit"));
        inputParams.put("arrangementId", request.getParameter("arrangementId"));
        inputParams.put("jointAccountHolder1", request.getParameter("jointAccountHolder1"));
        inputParams.put("jointAccountHolder2", request.getParameter("jointAccountHolder2"));
        inputParams.put("bankAddress", request.getParameter("bankAddress"));
        inputParams.put("intermediaryBankName", request.getParameter("intermediaryBankName"));
        inputParams.put("intermediaryBankAddress", request.getParameter("intermediaryBankAddress"));
        inputParams.put("intermediaryBankSwiftCode", request.getParameter("intermediaryBankSwiftCode"));
        inputParams.put("phone", request.getParameter("phone"));
        inputParams.put("accountSubType", request.getParameter("accountSubType"));
        inputParams.put("description", request.getParameter("description"));
        inputParams.put("schemeName", request.getParameter("schemeName"));
        inputParams.put("identification", request.getParameter("identification"));
        inputParams.put("secondaryIdentification", request.getParameter("secondaryIdentification"));
        inputParams.put("servicerSchemeName", request.getParameter("servicerSchemeName"));
        inputParams.put("ownership", request.getParameter("ownership"));
        inputParams.put("MembershipName", request.getParameter("MembershipName"));
        inputParams.put("Membership_id", request.getParameter("Membership_id"));
        inputParams.put("Organization_id", request.getParameter("Organization_id"));
        inputParams.put("ActualUpdatedBY", request.getParameter("ActualUpdatedBY"));
        inputParams.put("UpdatedBy", request.getParameter("UpdatedBy"));
        inputParams.put("TaxId", request.getParameter("TaxId"));
        inputParams.put("adminProductId", request.getParameter("adminProductId"));
        inputParams.put("IBAN", request.getParameter("IBAN"));
        inputParams.put("dataCreditLineCurrency", request.getParameter("dataCreditLineCurrency"));
        inputParams.put("dataCreditLineAmount", request.getParameter("dataCreditLineAmount"));
        inputParams.put("dataCreditLineType", request.getParameter("dataCreditLineType"));
        inputParams.put("dataCreditLineIncluded", request.getParameter("dataCreditLineIncluded"));
        inputParams.put("dataDateTime", request.getParameter("dataDateTime"));
        inputParams.put("dataType", request.getParameter("dataType"));
        inputParams.put("dataCreditDebitIndicator", request.getParameter("dataCreditDebitIndicator"));
        inputParams.put("servicerIdentification", request.getParameter("servicerIdentification"));


        String serviceName = "SonDBService";
        String operationName = "dbxdb_accounts_create";
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
