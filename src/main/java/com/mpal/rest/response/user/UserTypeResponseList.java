package com.mpal.rest.response.user;

import java.util.List;

/**
 * Created by System1 on 8/13/2016.
 */
public class UserTypeResponseList {

        List<UserResponseList> getTypeResponseList;
        private String message;
        private String messageType;

        public List<UserResponseList> getGetTypeResponseList() {
            return getTypeResponseList;
        }

        public void setGetTypeResponseList(List<UserResponseList> getTypeResponseList) {
            this.getTypeResponseList = getTypeResponseList;
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
                    "getTypeResponseList=" + getTypeResponseList +
                    ", message='" + message + '\'' +
                    ", messageType='" + messageType + '\'' +
                    '}';
        }
}
