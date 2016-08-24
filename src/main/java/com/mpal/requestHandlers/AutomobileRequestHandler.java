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

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobileRequestHandler {

    public List<AutomobileResponse> getAutomobileByTypeId(int automobile_type_id) throws SQLException,
            AutomobileNotFoundException{
        AutomobileDAO automobileDAO = new AutomobileDAO();
        List<AutomobileResponse> automobileList = new ArrayList<AutomobileResponse>();
        try {
            automobileList = getAutomobileResponseListFromDTOs(automobileDAO.getAutomobileByTypeId(automobile_type_id));
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

        return automobileDTO;
    }

    private List<AutomobileResponse> getAutomobileResponseListFromDTOs(List<AutomobileDTO> atomobileDTOs) throws SQLException{
        List<AutomobileResponse> automobileResponseListResponse = new ArrayList<AutomobileResponse>();
        Iterator<AutomobileDTO> automobilesDTOIterator = atomobileDTOs.iterator();
        while(automobilesDTOIterator.hasNext()){
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


    public String create(AutomobilesBO automobileBO) {


        String msg="created";
        AutomobileDAO automobileDAO = new AutomobileDAO();
        try {
            if (automobileDAO.getValidationForModel(automobileBO.getModel()) == null && automobileDAO.getValidationForCompany(automobileBO.getModel()) == null)

                automobileDAO.insertAutomobile(buildAutomobilesDTOFromBO(automobileBO));

            else
                msg="model and company already exist";

        } catch (SQLException sq) {
           msg="Error While Inserting data";
        } catch (IOException sqlException) {
            msg="Error While Inserting data";
        }

       /* if ("created".equals(msg) && automobileId != null) {

            System.out.println("******");
            //EmailService.sendNewUserEmail(registrationRequestBO.getEmail(), userId);
        }*/

        return msg;
    }


    /*
    public boolean create(AutomobilesBO automobileBO) {

        Boolean isProcessed = Boolean.TRUE;
        AutomobileDAO automobileDAO = new AutomobileDAO();
        try {
            if (automobileDAO.getValidationForModel(automobileBO.getModel()) == null)
                if(automobileDAO.getValidationForCompany(automobileBO.getModel()) == null)

                automobileDAO.insertAutomobile(buildAutomobilesDTOFromBO(automobileBO));

                else
                isProcessed = false;
            else
                isProcessed = false;

        } catch (SQLException sq) {
            isProcessed = false;
        } catch (IOException sqlException) {
            isProcessed = false;
        }

        if (isProcessed=false) {

            System.out.println("******");
            //EmailService.sendNewUserEmail(registrationRequestBO.getEmail(), userId);
        }

        return isProcessed;
    }
*/
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
