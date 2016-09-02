package com.mpal.requestHandlers;

import com.mpal.bo.request.automobile.AutomobilesBO;
import com.mpal.bo.request.automobile.UpdateAutomobileBO;
import com.mpal.dao.automobile.AutomobileDAO;
import com.mpal.dao.automobile.AutomobileTypesDAO;
import com.mpal.dto.automobile.AutomobileDTO;
import com.mpal.dto.automobile.AutomobileTypesDTO;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;
import com.mpal.rest.response.automobile.AutomobileResponse;
import com.mpal.rest.response.automobile.AutomobileTypeResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AutomobileRequestHandler {

    public List<AutomobileResponse> getAutomobileByTypeId(int automobileTypeId) throws SQLException{
        AutomobileDAO automobileDAO = new AutomobileDAO();
        List<AutomobileResponse> automobileList = new ArrayList<AutomobileResponse>();
        try {
            automobileList = getAutomobileResponseListFromDTOs(automobileDAO.getAutomobileByTypeId(automobileTypeId));
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return automobileList;
    }

    private AutomobileDTO buildAutomobilesDTOFromBO(AutomobilesBO requestBO) {
        AutomobileDTO automobileDTO = new AutomobileDTO();

        automobileDTO.setModel(requestBO.getModel());
        automobileDTO.setAutomobileTypeId(requestBO.getAutomobileTypeId());
        automobileDTO.setCompany(requestBO.getCompany());

        return automobileDTO;
    }

    private List<AutomobileResponse> getAutomobileResponseListFromDTOs(List<AutomobileDTO> atomobileDTOs) {
        List<AutomobileResponse> automobileResponseListResponse = new ArrayList<AutomobileResponse>();
        Iterator<AutomobileDTO> automobilesDTOIterator = atomobileDTOs.iterator();
        while (automobilesDTOIterator.hasNext()) {
            AutomobileDTO automobileDTO = automobilesDTOIterator.next();
            AutomobileResponse automobileResponse = null;
            automobileResponse = new AutomobileResponse(
                    automobileDTO.getId(),
                    automobileDTO.getCompany(),
                    automobileDTO.getModel(),
                    automobileDTO.getAutomobileTypeId(),
                    automobileDTO.getStatus());
            automobileResponseListResponse.add(automobileResponse);
        }
        return automobileResponseListResponse;
    }


    public String create(AutomobilesBO automobileBO) throws SQLException {
        String msg = "created";
        AutomobileDAO automobileDAO = new AutomobileDAO();
        try {
            if (automobileDAO.getValidationForModel(automobileBO.getModel()) == null && automobileDAO.getValidationForCompany(automobileBO.getModel()) == null) {
                automobileDAO.insertAutomobile(buildAutomobilesDTOFromBO(automobileBO));
            } else {
                msg = "model and company already exist";
            }

        } catch (SQLException sq) {
            msg = "Error While Inserting data";
        }

        return msg;
    }

    public Boolean updateAutomobile(UpdateAutomobileBO updateRequestBO) throws SQLException {
        Boolean isProcessed = Boolean.FALSE;
        AutomobileDAO automobileDAO = new AutomobileDAO();
        try {
            isProcessed = automobileDAO.updateAutomobile(updateRequestBO);
        } catch (SQLException sq) {
            isProcessed = false;
        }
        return isProcessed;
    }

    public List<AutomobileTypeResponse> getAutomobileTypes() throws SQLException{
        AutomobileTypesDAO automobileTypesDAO = new AutomobileTypesDAO();
        List<AutomobileTypeResponse> getAutomobileTypesResponses = new ArrayList<AutomobileTypeResponse>();
        try {
            List<AutomobileTypesDTO> automobileTypesDTOList = automobileTypesDAO
                    .getAllAutomobileTypes();

            for (com.mpal.dto.automobile.AutomobileTypesDTO automobileTypesDTO : automobileTypesDTOList) {
                AutomobileTypeResponse getAutomobileTypeResponse = new AutomobileTypeResponse();
                getAutomobileTypeResponse.setId(automobileTypesDTO.getId());
                getAutomobileTypeResponse.setType(automobileTypesDTO.getType());
                getAutomobileTypesResponses.add(getAutomobileTypeResponse);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

        return getAutomobileTypesResponses;
    }

}
