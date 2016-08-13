package com.mpal.dao.automobile;

import com.mpal.dto.automobile.AutomobileTypesDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by System1 on 8/11/2016.
 */
public interface IAutomobileTypesDAO {
    List<AutomobileTypesDTO> getAllAutomobileTypes() throws SQLException;
}
