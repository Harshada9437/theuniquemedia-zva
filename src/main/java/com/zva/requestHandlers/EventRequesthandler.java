package com.zva.requestHandlers;


import com.zva.dao.event.EventDAO;
import com.zva.dto.event.EventDTO;
import com.zva.dto.event.EventSubTypeDTO;
import com.zva.rest.response.event.EventResponse;
import com.zva.rest.response.event.EventSubTypeResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventRequesthandler {

    public List<EventResponse> getEventList( ) throws SQLException {
        EventDAO eventDAO = new EventDAO();
        return getEventResponseListFromDTOs(eventDAO.getEvents());
    }

    private List<EventResponse> getEventResponseListFromDTOs(List<EventDTO> eventDTOs) {
        List<EventResponse> eventResponseList = new ArrayList<EventResponse>();
        Iterator<EventDTO> eventDTOIterator = eventDTOs.iterator();
        while (eventDTOIterator.hasNext()) {
            EventDTO eventDTO = eventDTOIterator.next();
            EventResponse eventResponse = new EventResponse(
                    eventDTO.getId(),
                    eventDTO.getType(),
                    eventDTO.getStatus());
            eventResponseList.add(eventResponse);
        }
        return eventResponseList;
    }

    public List<EventSubTypeResponse> getEventSubTypes(int eventId) throws SQLException {
        EventDAO eventDAO = new EventDAO();
        return getAutomobileResponseListFromDTOs(eventDAO.getEventSubTypes(eventId));
    }

    private List<EventSubTypeResponse> getAutomobileResponseListFromDTOs(List<EventSubTypeDTO> eventSubTypeDTOs) {
        List<EventSubTypeResponse> eventSubTypeResponseeList = new ArrayList<EventSubTypeResponse>();
        Iterator<EventSubTypeDTO> eventSubTypeDTOIterator = eventSubTypeDTOs.iterator();
        while (eventSubTypeDTOIterator.hasNext()) {
            EventSubTypeDTO automobileDTO = eventSubTypeDTOIterator.next();
            EventSubTypeResponse eventSubTypeResponse = new EventSubTypeResponse(
                    automobileDTO.getId(),
                    automobileDTO.getEventTypeId(),
                    automobileDTO.getSubType(),
                    automobileDTO.getStatus());
            eventSubTypeResponseeList.add(eventSubTypeResponse);
        }
        return eventSubTypeResponseeList;
    }

}
