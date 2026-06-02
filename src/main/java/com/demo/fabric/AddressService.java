package com.demo.fabric;

import com.demo.fabric.resource.address.impl.AddressResourceImpl;
import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;

public class AddressService implements JavaService2 {
    @Override
    public Object invoke(String methodId, Object[] inputParams, DataControllerRequest dataControllerRequest, DataControllerResponse dataControllerResponse) throws Exception {

        AddressResourceImpl addressResource = new AddressResourceImpl();

        Result result = new Result();

        try {
            switch (methodId) {
                case "getAllAddress": return addressResource.getAllAddress(dataControllerRequest);
                case "createAddress": return addressResource.createAddress(dataControllerRequest, inputParams);
                case "updateAddress": return addressResource.updateAddress(dataControllerRequest);
                case "deleteAddress": return addressResource.deleteAddress(dataControllerRequest);
                default: return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
