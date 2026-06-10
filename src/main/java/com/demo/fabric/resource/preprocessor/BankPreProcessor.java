package com.demo.fabric.resource.preprocessor;

import com.konylabs.middleware.common.DataPreProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BankPreProcessor implements DataPreProcessor2 {
    @Override
    public boolean execute(HashMap hashMap, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse, Result result) throws Exception {

        // Cách 1 dùng session
//        String bank1Id = (String) dataControllerRequest.getSession().getAttribute("Bank_id");

        // Casch 2: Lay thang tu request
        String bankId = dataControllerRequest.getParameter("Bank_id");

        if (bankId == null || bankId.isEmpty()) {
            result.addParam("status", "NOT_FOUND");
            result.addParam("message", "No data found bank_id");
            return false;
        }

//        Record firstRecord = ds.getAllRecords().get(0);
//
//        String bankId = firstRecord != null && !firstRecord.isEmpty()
//                ? firstRecord.getParamValueByName("Bank_id")
//                : dataControllerRequest.getParameter("Bank_id");
//
//        Iterator<String> req = dataControllerRequest.getAttributeNames();
//        List<String> values = new ArrayList<>();
//        req.forEachRemaining(values::add);
//        System.out.println("ValueBankPreprocessor:: " + values);
//
//        if ((bankId == null || bankId.isEmpty())) {
//            result.addParam("status", "NOT_FOUND");
//            result.addParam("message", "No data found");
//            result.addParam("values", values.toString());
//            return false;
//        }

        hashMap.put("bankId", bankId);
        return true;
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
    private String convertToString(Iterator<String> iterator) {
        StringBuilder sb = new StringBuilder();

        while (iterator.hasNext()) {
            sb.append(iterator.next());

            if (iterator.hasNext()) {
                sb.append(",");
            }
        }

        return sb.toString();
    }
}
