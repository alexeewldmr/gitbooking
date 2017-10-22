package com.company.businesslogic.api;

    public class RemoveGuestRequest {

        private String name;

        public RemoveGuestRequest(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
