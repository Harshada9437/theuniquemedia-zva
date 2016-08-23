package com.mpal.rest.response.user;

import java.util.List;

/**
 * Created by System1 on 8/13/2016.
 */
public class UserTypeResponseList {

        List<UserResponseList> userResponseList;
        private String message;
        private String messageType;

        public List<UserResponseList> getUserResponseList() {
            return userResponseList;
        }

        public void setUserResponseList(List<UserResponseList> userResponseList) {
            this.userResponseList = userResponseList;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        @Override
        public String toString() {
            return "UserTypesResponse{" +
                    "userResponseList=" + userResponseList +
                    ", message='" + message + '\'' +
                    ", messageType='" + messageType + '\'' +
                    '}';
        }
}
