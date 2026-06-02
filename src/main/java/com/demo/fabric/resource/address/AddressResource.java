package com.demo.fabric.resource.address;

import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;

public interface AddressResource {
    Result getAllAddress(DataControllerRequest request) throws Exception;
    Result createAddress(DataControllerRequest request, Object[] inputParams) throws Exception;
    Result updateAddress(DataControllerRequest request) throws Exception;
    Result deleteAddress(DataControllerRequest request) throws Exception;
}
