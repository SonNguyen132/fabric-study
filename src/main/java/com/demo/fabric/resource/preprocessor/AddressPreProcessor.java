package com.demo.fabric.resource.preprocessor;

import com.konylabs.middleware.common.DataPreProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;

import java.util.HashMap;

public class AddressPreProcessor implements DataPreProcessor2 {
    @Override
    public boolean execute(HashMap hashMap, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse, Result result) throws Exception {

        System.out.println("AddressPreProcessor START");

        // Validate field required
        validateRequired("id", dataControllerRequest.getParameter("id"));
        validateRequired("User_id", dataControllerRequest.getParameter("User_id"));
        validateRequired("addressLine1", dataControllerRequest.getParameter("addressLine1"));

        // Validate zipcode
        String zipCode = dataControllerRequest.getParameter("code");
        if (zipCode != null && zipCode.matches("\\d+")) {
            throw new Exception("Invalid zip code");
        }

        // validate lat, lon
        String latitude = dataControllerRequest.getParameter("latitude");
        if (latitude != null) {
            double latitudeDouble = Double.parseDouble(latitude);
            if (latitudeDouble > 90 || latitudeDouble < -90) {
                throw new Exception("Invalid latitude");
            }
        }
        String longitude = dataControllerRequest.getParameter("longitude");
        if (longitude != null) {
            double longitudeDouble = Double.parseDouble(longitude);
            if (longitudeDouble > 180 || longitudeDouble < -180) {
                throw new Exception("Invalid longitude");
            }
        }
        System.out.println("AddressPreProcessor END");

        return true;
    }

    private void validateRequired(String field, String value) throws Exception {

        if(value == null || value.isEmpty()) {
            throw new Exception(field + " is required");
        }
    }
}
