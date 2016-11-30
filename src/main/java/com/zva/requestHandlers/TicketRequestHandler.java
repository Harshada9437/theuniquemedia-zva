package com.zva.requestHandlers;

import com.zva.bo.request.ticket.TicketRequestBO;
import com.zva.bo.request.ticket.UpdateTicketRequestBO;
import com.zva.dao.ticket.TicketDAO;
import com.zva.dto.ticket.*;
import java.sql.SQLException;



public class TicketRequestHandler {

    public int createTicket(TicketRequestBO ticketRequestBO) throws SQLException {
        TicketDAO ticketDAO = new TicketDAO();
        int id = ticketDAO.createTicket(buildTicketDTOFromBO(ticketRequestBO));

        return id;
    }

    private TicketDTO buildTicketDTOFromBO(TicketRequestBO ticketRequestBO) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setRequestId(ticketRequestBO.getRequestId());
        ticketDTO.setVendorId(ticketRequestBO.getVendorId());
        ticketDTO.setStatus(ticketRequestBO.getStatus());
        return ticketDTO;
    }

    public boolean updateTicket(UpdateTicketRequestBO updateTicketRequestBO) {
        Boolean isProcessed = Boolean.FALSE;
        TicketDAO ticketDAO = new TicketDAO();
        try {
            isProcessed = ticketDAO.updateTicket(buildUpdateTicketDTOfromBO(updateTicketRequestBO));
        } catch (SQLException sq) {
            isProcessed = false;
        }
        return isProcessed;
    }

    private TicketDTO buildUpdateTicketDTOfromBO(UpdateTicketRequestBO updateTicketRequestBO) {
        TicketDTO ticketDTO= new TicketDTO();
        ticketDTO.setId(updateTicketRequestBO.getId());
        ticketDTO.setStatus(updateTicketRequestBO.getStatus());
        ticketDTO.setUpdatedBy(updateTicketRequestBO.getUpdatedBy());
        return ticketDTO;
    }
}