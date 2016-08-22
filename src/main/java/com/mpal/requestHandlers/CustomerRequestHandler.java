package com.mpal.requestHandlers;

import com.mpal.bo.request.customer.CreateCustomerRequestBO;
import com.mpal.dao.customer.CustomerRequestDAO;
import com.mpal.dto.customer.CreateCustomerRequestDTO;
import com.mpal.util.DateUtil;

import java.util.Date;


public class CustomerRequestHandler {

    public String createCustomerRequest(CreateCustomerRequestBO createCustomerRequestBO) {
        CustomerRequestDAO customerRequestDAO = new CustomerRequestDAO();
        CreateCustomerRequestDTO createCustomerRequestDTO = buildCreateCustomerRequestDTOFromBO(createCustomerRequestBO);
        Boolean isCreated = customerRequestDAO.createCustomerRequest(createCustomerRequestDTO);
        if (isCreated) {
            return createCustomerRequestDTO.getToken();
        }
        return null;
    }

    private CreateCustomerRequestDTO buildCreateCustomerRequestDTOFromBO(CreateCustomerRequestBO createCustomerRequestBO) {
        CreateCustomerRequestDTO createCustomerRequestDTO = new CreateCustomerRequestDTO();
        createCustomerRequestDTO.setAutomobileDetailsId(createCustomerRequestBO.getAutomobileDetailsId());
        createCustomerRequestDTO.setMechanicId(createCustomerRequestBO.getMechanicId());
        createCustomerRequestDTO.setCustomerId(createCustomerRequestBO.getCustomerId());
        createCustomerRequestDTO.setServiceId(createCustomerRequestBO.getServiceId());
        createCustomerRequestDTO.setToken(generateToken(createCustomerRequestBO));
        return createCustomerRequestDTO;
    }

    private String generateToken(CreateCustomerRequestBO createCustomerRequestBO) {
        String serverTime = DateUtil.getCurrentServerTime();
        String date[] = serverTime.split(" ");
        String dateParts[] = date[0].split("-");
        String token = dateParts[0] + "" + dateParts[1] + "" + dateParts[2] +
                "C" + createCustomerRequestBO.getCustomerId() + "M" + createCustomerRequestBO.getMechanicId() + "X" +
                Integer.parseInt(date[1].split(":")[2]) * 113 * 113;
        return token;
    }
}
