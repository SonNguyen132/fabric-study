package com.demo.fabric.resource.postprocessor;

import com.konylabs.middleware.common.DataPostProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Result;

public class AccountPostProcessor implements DataPostProcessor2 {
    @Override
    public Object execute(Result result, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse) throws Exception {

        System.out.println("AccountPostProcessor START");

        // Data set records
        Dataset ds = result.getDatasetById("records");

        // Lý do phải check nhu nay la vi do giua response ddc tra ve data set co id map
        // khong phai records, tuy nhien khi hien thi lai co records
        if (ds == null) {
            if (result.getAllRecords() != null || result.getAllRecords().isEmpty()) {
                ds = result.getAllDatasets().get(0);
            } else return result;
        }

        if (ds == null || ds.getAllRecords().isEmpty()) {
            result.addParam("status", "NOT_FOUND");
            result.addParam("message", "No data found");
            return result;
        }

        result.addParam("status", "SUCCESS");
        result.addParam("message", "Get data successfully");

        System.out.println("AccountPostProcessor END");

        return result;
    }
}
