package com.mpal.requestHandlers;

import com.mpal.bo.request.automobileInfo.AutomobileInfoBO;
import com.mpal.bo.request.automobileInfo.UpdateAutomobileInfoBO;
import com.mpal.dao.automobile.AutomobileDAO;
import com.mpal.dao.automobileInfo.AutomobileInfoDAO;
import com.mpal.dto.automobileInfo.AutomobileInfoDTO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by System2 on 8/12/2016.
 */
public class AutomobileInfoRequestHandler {

    public boolean create_automobile_info(AutomobileInfoBO automobileinfoBO) {

        Boolean isProcessed = Boolean.TRUE;
        String msg="notcreated";
        Integer automobileId=null;

        AutomobileInfoDAO automobileinfoDAO = new AutomobileInfoDAO();
        try {
            automobileinfoDAO.insertAutomobileinfo(buildAutomobileInfoDTOFromBO(automobileinfoBO));
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

    private AutomobileInfoDTO buildAutomobileInfoDTOFromBO(AutomobileInfoBO requestBO) {

        AutomobileInfoDTO automobileinfoDTO = new AutomobileInfoDTO();

        automobileinfoDTO.setId(requestBO.getId());
        automobileinfoDTO.setName(requestBO.getName());
        automobileinfoDTO.setAutomobileInfoId(requestBO.getAutomobileInfoId());
        automobileinfoDTO.setAddress(requestBO.getAddress());
        automobileinfoDTO.setCity(requestBO.getCity());
        automobileinfoDTO.setState(requestBO.getState());
        automobileinfoDTO.setLat(requestBO.getLat());
        automobileinfoDTO.setLog(requestBO.getLog());
        automobileinfoDTO.setOpeningTime(requestBO.getOpeningTime());
        automobileinfoDTO.setClosingTime(requestBO.getClosingTime());
        automobileinfoDTO.setPhoneNo(requestBO.getPhoneNo());
        automobileinfoDTO.setMobileNo(requestBO.getMobileNo());
        automobileinfoDTO.setStatus(requestBO.getStatus());

        return automobileinfoDTO;
    }

    public boolean updateAutomobileInfo(UpdateAutomobileInfoBO updateautomobileInfoRequestBO) throws SQLException,
    IOException{

        Boolean isProcessed = Boolean.FALSE;
        AutomobileInfoDAO automobileInfoDAO = new AutomobileInfoDAO();
        try {
            isProcessed =automobileInfoDAO.updateAutomobileInfo(updateautomobileInfoRequestBO);
        } catch (SQLException sq) {
            isProcessed = false;
        } catch (IOException sqlException) {
            isProcessed = false;
        }
        //System.out.println("isProcessed:::" + isProcessed);
        return isProcessed;
    }

}