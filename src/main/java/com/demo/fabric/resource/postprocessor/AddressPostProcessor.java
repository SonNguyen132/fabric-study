package com.demo.fabric.resource.postprocessor;

import com.konylabs.middleware.common.DataPostProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Result;

public class AddressPostProcessor implements DataPostProcessor2 {
    @Override
    public Object execute(Result result, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse) throws Exception {

        System.out.println("AddressPostProcessor START");

        // Data set records
        Dataset ds = result.getDatasetById("address");

        if (ds == null || ds.getAllRecords() == null || ds.getAllRecords().isEmpty()) {
            result.addParam("status", "NOT_FOUND");
            result.addParam("message", "No data found");
            return result;
        }
        result.addParam("status", "200");
        result.addParam("message", "SUCCESS");

        System.out.println("AddressPostProcessor END");

        return result;
    }
}
