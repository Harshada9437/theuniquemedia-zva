package com.mpal.requestHandlers;

import com.mpal.bo.request.customer.CreateCustomerRequestBO;
import com.mpal.bo.request.customer.UpdateCustomerRequestBO;
import com.mpal.dao.customer.CustomerRequestDAO;
import com.mpal.dto.customer.CustomerRequestDTO;
import com.mpal.dto.customer.RequestDTO;
import com.mpal.rest.response.customer.GetRequestResponse;
import com.mpal.rest.response.customer.RequestResponse;
import com.mpal.rest.response.customer.RequestResponseList;
import com.mpal.util.DateUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CustomerRequestHandler {

    public String createCustomerRequest(CreateCustomerRequestBO createCustomerRequestBO) {
        CustomerRequestDAO customerRequestDAO = new CustomerRequestDAO();
        CustomerRequestDTO customerRequestDTO = buildCreateCustomerRequestDTOFromBO(createCustomerRequestBO);
        Boolean isCreated = customerRequestDAO.createCustomerRequest(customerRequestDTO);
        if (isCreated) {
            return customerRequestDTO.getToken();
        }
        return null;
    }

    private CustomerRequestDTO buildCreateCustomerRequestDTOFromBO(CreateCustomerRequestBO createCustomerRequestBO) {
        CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
        customerRequestDTO.setAutomobileDetailsId(createCustomerRequestBO.getAutomobileDetailsId());
        customerRequestDTO.setMechanicId(createCustomerRequestBO.getMechanicId());
        customerRequestDTO.setCustomerId(createCustomerRequestBO.getCustomerId());
        customerRequestDTO.setServiceId(createCustomerRequestBO.getServiceId());
        customerRequestDTO.setToken(generateToken(createCustomerRequestBO));
        return customerRequestDTO;
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

    public Boolean updateCustomerRequest(UpdateCustomerRequestBO updaterCustomerRequestBO, String token) {

        Boolean isProcessed = Boolean.FALSE;
        CustomerRequestDAO customerRequestDAO = new CustomerRequestDAO();
        try {
            isProcessed = customerRequestDAO.updateCustomerRequest(updaterCustomerRequestBO,token);
        } catch (SQLException sq) {
            isProcessed = false;
        } catch (IOException sqlException) {
            isProcessed = false;
        }

        return isProcessed;
    }


    private List<RequestResponseList> getRequestResponseListFromDTOs(List<CustomerRequestDTO> customerRequestDTO) throws SQLException{
        List<RequestResponseList> requestResponseListResponse = new ArrayList<RequestResponseList>();
        Iterator<CustomerRequestDTO> createCustomerRequestDTOIterator = customerRequestDTO.iterator();
        while(createCustomerRequestDTOIterator.hasNext()){
            CustomerRequestDTO createCustomerRequestDTO = createCustomerRequestDTOIterator.next();
            RequestResponseList requestResponseList = new RequestResponseList(createCustomerRequestDTO.getId(),
                    createCustomerRequestDTO.getCustomerId(),
                    createCustomerRequestDTO.getMechanicId(),
                    createCustomerRequestDTO.getAutomobileDetailsId(),
                    createCustomerRequestDTO.getServiceId(),
                    createCustomerRequestDTO.getCreatedDtm(),
                    createCustomerRequestDTO.getUpdatedDtm(),
                    createCustomerRequestDTO.getUpdatedBy(),
                    createCustomerRequestDTO.getToken(),
                    createCustomerRequestDTO.getStatus());
                    requestResponseListResponse.add(requestResponseList);
        }
        return requestResponseListResponse;
    }

    public List<RequestResponseList> getRequestListByCustomer(int customer_id) {
            List<RequestResponseList> customerList = new ArrayList<RequestResponseList>();
            try {
                CustomerRequestDAO customerRequestDAO = new CustomerRequestDAO();
                customerList = getRequestResponseListFromDTOs(customerRequestDAO.getRequestListByCustomer(customer_id));
            } catch (SQLException s) {
                s.printStackTrace();
            } catch (IOException s) {
                s.printStackTrace();
            }
            return customerList;
        }

    public GetRequestResponse getRequestByToken(String token) throws SQLException
    {
        CustomerRequestDAO customerRequestDAO = new CustomerRequestDAO();
            GetRequestResponse requestResponse = buildRequestResponseFromDTO(customerRequestDAO
                    .getRequestByToken(token));
            return requestResponse;
        }

    private GetRequestResponse buildRequestResponseFromDTO(CustomerRequestDTO usersDTO) {
        GetRequestResponse requestResponse = new GetRequestResponse();
        requestResponse.setId(usersDTO.getId());
        requestResponse.setCustomerId(usersDTO.getCustomerId());
        requestResponse.setMechanicId(usersDTO.getMechanicId());
        requestResponse.setAutomobileDetailsId(usersDTO.getServiceId());
        requestResponse.setServiceId(usersDTO.getServiceId());
        requestResponse.setCreatedDtm(usersDTO.getCreatedDtm());
        requestResponse.setUpdatedDtm(usersDTO.getUpdatedDtm());
        requestResponse.setUpdatedBy(usersDTO.getUpdatedBy());
        requestResponse.setToken(usersDTO.getToken());
        requestResponse.setStatus(usersDTO.getStatus());
        return requestResponse;
    }

    public List<RequestResponseList> getRequestListByMechanic(int mechanic_id) throws SQLException {
        CustomerRequestDAO customerRequestDAO = new CustomerRequestDAO();
        List<RequestResponseList> requestResponse=new ArrayList<RequestResponseList>();
        try {
            requestResponse = getRequestResponseListFromDTOs(customerRequestDAO
                    .getRequestByMechanic(mechanic_id));
        }catch (SQLException s) {
            s.printStackTrace();
        }
        return requestResponse;
    }

    public List<RequestResponseList> getRequestListByToken(String token) throws SQLException{
        CustomerRequestDAO customerRequestDAO = new CustomerRequestDAO();
        List<RequestResponseList> requestResponse=new ArrayList<RequestResponseList>();
        try {
            requestResponse = getRequestResponseListFromDTOs(customerRequestDAO
                    .getRequestListByToken(token));
        }catch (SQLException s) {
            s.printStackTrace();
        }
        return requestResponse;
    }

    public List<RequestResponse> getRequestList() throws SQLException{
        CustomerRequestDAO customerRequestDAO = new CustomerRequestDAO();
        List<RequestResponse> requestResponse=new ArrayList<RequestResponse>();
        try {
            requestResponse = getRequestResponseFromDTOs(customerRequestDAO
                    .getRequestList());
        }catch (SQLException s) {
            s.printStackTrace();
        }
        return requestResponse;
    }

    private List<RequestResponse> getRequestResponseFromDTOs(List<RequestDTO> requestDTOs) throws SQLException{
        List<RequestResponse> requestResponseList = new ArrayList<RequestResponse>();
        Iterator<RequestDTO> requestDTOIterator = requestDTOs.iterator();
        while(requestDTOIterator.hasNext()){
            RequestDTO requestDTO = requestDTOIterator.next();
            RequestResponse requestResponse = new RequestResponse(
                    requestDTO.getMechName(),
                    requestDTO.getMechNo(),
                    requestDTO.getMechEmail(),
                    requestDTO.getCustomerName(),
                    requestDTO.getCustomerNo(),
                    requestDTO.getCustomerEmail(),
                    requestDTO.getServiceId(),
                    requestDTO.getServiceName(),
                    requestDTO.getMake(),
                    requestDTO.getModel(),
                    requestDTO.getId(),
                    requestDTO.getCreatedDtm(),
                    requestDTO.getUpdatedDtm(),
                    requestDTO.getUpdatedBy(),
                    requestDTO.getToken(),
                    requestDTO.getStatus());
            requestResponseList.add(requestResponse);
        }
        return requestResponseList;
    }

}

