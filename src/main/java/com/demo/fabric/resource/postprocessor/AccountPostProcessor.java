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
        System.out.println("Dataset" + ds);

        if (ds == null || ds.getAllRecords().isEmpty()) {
            result.addParam("status", "NOT_FOUND");
            result.addParam("message", "No data found");
//            result.addParam("dataset-empty", datasetInfo(result));
            return result;
        }

        result.addParam("status", "SUCCESS");
        result.addParam("message", "Get data successfully");
//        result.addParam("dataset-success", datasetInfo(result));


        System.out.println("AccountPostProcessor END");

        return result;
    }
//    private String datasetInfo(Result result) {
//        StringBuilder datasetInfo = new StringBuilder();
//
//        if (result.getAllDatasets() != null) {
//            for (Dataset ds : result.getAllDatasets()) {
//                datasetInfo.append(ds.getId());
//            }
//        }
//        return datasetInfo.toString();
//    }

}
