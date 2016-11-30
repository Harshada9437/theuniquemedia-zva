package com.zva.api.services;

import com.zva.bo.request.ticket.TicketRequestBO;
import com.zva.bo.request.ticket.UpdateTicketRequestBO;
import com.zva.dao.ticket.TicketDAO;
import com.zva.dto.ticket.TicketDTO;
import com.zva.requestHandlers.TicketRequestHandler;
import com.zva.rest.request.ticket.TicketRequest;
import com.zva.rest.request.ticket.UpdateTicketRequest;
import com.zva.rest.response.FailureResponse;
import com.zva.rest.response.ticket.*;
import com.zva.rest.response.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/ticket")
public class TicketService {
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTicket(TicketRequest ticketRequest) {
         /* if (auth != null && RequestValidation.isRequestValid(auth)) {*/
        TicketRequestBO ticketRequestBO = new TicketRequestBO();
        TicketRequestHandler ticketRequestHandler = new TicketRequestHandler();
        CreateTicketResponse createTicketResponse = new CreateTicketResponse();
        int id = 0;
        try {
            ticketRequestBO.setRequestId(ticketRequest.getRequestId());
            ticketRequestBO.setVendorId(ticketRequest.getVendorId());
            ticketRequestBO.setStatus(ticketRequest.getStatus());
            id = ticketRequestHandler.createTicket(ticketRequestBO);

            if (id > 0) {
                /*TicketDTO ticketDTO = TicketDAO.getTicketById(id);
                TicketDAO ticketDAO = new TicketDAO();
                ticketDAO.insertTicketLog(ticketDTO);*/
                return ResponseGenerator.generateSuccessResponse(createTicketResponse, String.valueOf(id));
            } else {
                FailureResponse failureResponse = new FailureResponse();
                return ResponseGenerator.generateFailureResponse(failureResponse, "Ticket creation failed");
            }
        } catch (SQLException e) {
            FailureResponse failureResponse = new FailureResponse();
            return ResponseGenerator.generateFailureResponse(failureResponse, "Ticket creation failed");
        }
          /* } else {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateBatch(UpdateTicketRequest updateTicketRequest/*, @HeaderParam("Auth") String auth*/) throws Exception {
       /* if (auth != null && RequestValidation.isRequestValid(auth)) {*/
        UpdateTicketRequestBO updateTicketRequestBO = new UpdateTicketRequestBO();
        updateTicketRequestBO.setId(updateTicketRequest.getId());
        updateTicketRequestBO.setStatus(updateTicketRequest.getStatus());
        updateTicketRequestBO.setUpdatedBy(updateTicketRequest.getUpdatedBy());

        TicketRequestHandler ticketRequestHandler = new TicketRequestHandler();
        UpdateTicketResponse updateTicketResponse = new UpdateTicketResponse();

            if (ticketRequestHandler.updateTicket(updateTicketRequestBO)) {
                return ResponseGenerator.generateSuccessResponse(updateTicketResponse, "Ticket updated successfully");

            } else {
                return ResponseGenerator.generateFailureResponse(updateTicketResponse, "Unable to update the ticket.");

            }
      /*  }else
        {
            return ResponseGenerator.generateResponse(RequestValidation.getUnautheticatedResponse());
        }*/
    }
}

