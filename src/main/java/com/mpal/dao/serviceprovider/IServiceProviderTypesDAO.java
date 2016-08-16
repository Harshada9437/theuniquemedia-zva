package com.mpal.dao.serviceprovider;

import com.mpal.dto.serviceprovider.ServiceProviderTypesDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by System1 on 8/16/2016.
 */
public interface IServiceProviderTypesDAO {
    List<ServiceProviderTypesDTO> getAllServiceTypes() throws SQLException;
}
