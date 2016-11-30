package com.zva.util;

import com.sun.jersey.core.util.Base64;

import java.sql.SQLException;

/**
 * Created by System1 on 10/6/2016.
 */
public class RequestValidation {
     /*   public static Boolean isRequestValid(String autherization) throws Exception {
            Base64 decoder = new Base64();
            byte[] decodedBytes = decoder.decode(autherization);
            String decodedString = new String(decodedBytes);
            String[] stringParts = decodedString.split(":");
            String password = MD5Encode.Encode(stringParts[1]);
            Boolean isValidRequest = Boolean.FALSE;
            try {
                Boolean verify = new UsersDAO().getValidUserBySessionIdPasswordUsername(stringParts[0],password,stringParts[2]);
                if(verify){
                    isValidRequest = Boolean.TRUE;
                }
            }catch (SQLException e){
                e.printStackTrace();
                return Boolean.FALSE;
            }

            return isValidRequest;
        }

        public static RequestAuthenticationResponse getUnautheticatedResponse(){
            RequestAuthenticationResponse requestAuthenticationResponse = new RequestAuthenticationResponse();
            requestAuthenticationResponse.setMessageType("UNAUTHORIZED");
            requestAuthenticationResponse.setMessage("UNAUTHORIZED ACCESS");
            return requestAuthenticationResponse;
        }*/
}
