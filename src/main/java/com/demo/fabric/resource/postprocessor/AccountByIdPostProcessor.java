package com.demo.fabric.resource.postprocessor;

import com.konylabs.middleware.common.DataPostProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;

public class AccountByIdPostProcessor implements DataPostProcessor2 {
    @Override
    public Object execute(Result result, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse) throws Exception {
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
        result.addParam("dataset-success", datasetInfo(result));

        Record firstRecord = ds.getAllRecords().get(0);
        String bankId = firstRecord != null ? firstRecord.getParamValueByName("Bank_id") : null;

        // Casch 1: dung session
        dataControllerRequest.getSession().setAttribute("Bank_id", bankId);

        System.out.println("AccountPostProcessor END");

        return result;
    }
    private String datasetInfo(Result result) {
        StringBuilder datasetInfo = new StringBuilder();

        if (result.getAllDatasets() != null) {
            for (Dataset ds : result.getAllDatasets()) {
                datasetInfo.append(ds.getId());
            }
        }
        return datasetInfo.toString();
    }
}
