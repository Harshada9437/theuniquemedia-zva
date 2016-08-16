package com.mpal.requestHandlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mpal.bo.request.automobile.AutomobilesBO;
import com.mpal.bo.request.automobile.UpdateAutomobileBO;
import com.mpal.dao.automobile.AutomobileDAO;
import com.mpal.dao.automobile.AutomobileTypesDAO;
import com.mpal.dto.automobile.AutomobileDTO;
import com.mpal.dto.automobile.AutomobileTypesDTO;
import com.mpal.rest.response.automobile.AutomobileResponse;
import com.mpal.exceptions.AutomobileServiceExceptions.AutomobileNotFoundException;
import com.mpal.rest.response.automobile.AutomobileTypeResponse;


/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobileRequestHandler {

    public List<AutomobileResponse> getAutomobileByTypeId(int automobileTypeId) throws SQLException,
            AutomobileNotFoundException{
        AutomobileDAO automobileDAO = new AutomobileDAO();
        List<AutomobileResponse> automobileList = new ArrayList<AutomobileResponse>();
        try {
            automobileList = getAutomobileResponseListFromDTOs(automobileDAO.getAutomobileByTypeId(automobileTypeId));
        } catch (SQLException s) {
            s.printStackTrace();
        } catch (AutomobileNotFoundException s) {
            s.printStackTrace();
        }
        return automobileList;
    }

    public List<AutomobileResponse> getAutomobilesList() {
        List<AutomobileResponse> automobileList = null;
        try {
            AutomobileDAO automobileDAO = new AutomobileDAO();
            automobileList = getAutomobileResponseListFromDTOs(automobileDAO.getAutomobilesList());
        } catch (SQLException s) {
            s.printStackTrace();
        } catch (IOException s) {
            s.printStackTrace();
        }
        return automobileList;
    }

    private AutomobileDTO buildAutomobilesDTOFromBO(AutomobilesBO requestBO) {
        AutomobileDTO automobileDTO = new AutomobileDTO();

        automobileDTO.setModel(requestBO.getModel());
        automobileDTO.setAutomobileTypeId(requestBO.getAutomobileTypeId());
        automobileDTO.setCompany(requestBO.getCompany());
        automobileDTO.setBuiltYear(requestBO.getBuiltYear());

        return automobileDTO;
    }

    private List<AutomobileResponse> getAutomobileResponseListFromDTOs(List<AutomobileDTO> atomobileDTOs) throws SQLException{
        List<AutomobileResponse> automobileResponseListResponse = new ArrayList<AutomobileResponse>();
        Iterator<AutomobileDTO> automobilesDTOIterator = atomobileDTOs.iterator();
        while(automobilesDTOIterator.hasNext()){
            AutomobileDTO automobileDTO = automobilesDTOIterator.next();
            AutomobileResponse automobileResponse = null;
            automobileResponse = new AutomobileResponse(
                    automobileDTO.getCompany(),
                    automobileDTO.getModel(),
                    automobileDTO.getBuiltYear(),
                    automobileDTO.getAutomobileTypeId(),
                    automobileDTO.getStatus());
            automobileResponseListResponse.add(automobileResponse);
        }
        return automobileResponseListResponse;
    }

    public boolean create(AutomobilesBO automobileBO) {

        Boolean isProcessed = Boolean.TRUE;
        String msg="notcreated";
        Integer automobileId=null;
        AutomobileDAO automobileDAO = new AutomobileDAO();
        try {
            automobileDAO.insertAutomobile(buildAutomobilesDTOFromBO(automobileBO));
        } catch (SQLException sq) {
            isProcessed = false;
        } catch (IOException sqlException) {
            isProcessed = false;
        }

        if (isProcessed=false) {

            System.out.println(msg);
            //EmailService.sendNewUserEmail(registrationRequestBO.getEmail(), userId);
        }

        return isProcessed;
    }

    public Boolean updateAutomobile(UpdateAutomobileBO updateRequestBO) {

        Boolean isProcessed = Boolean.FALSE;
        AutomobileDAO automobileDAO = new AutomobileDAO();
        try {
            isProcessed =automobileDAO.updateAutomobile(updateRequestBO);
        } catch (SQLException sq) {
            isProcessed = false;
        } catch (IOException sqlException) {
            isProcessed = false;
        }
        //System.out.println("isProcessed:::" + isProcessed);
        return isProcessed;
    }

    public List<AutomobileTypeResponse> getAutomobileTypes() {
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
