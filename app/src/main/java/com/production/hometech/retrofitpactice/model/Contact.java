package com.production.hometech.retrofitpactice.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Arpit on 27-Mar-17.
 */

public class Contact {

    @SerializedName("contacts")
    private List<ContactsBean> contacts;

    public List<ContactsBean> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactsBean> contacts) {
        this.contacts = contacts;
    }

    public static class ContactsBean {
        /**
         * id : c200
         * name : Ravi Tamada
         * email : ravi@gmail.com
         * address : xx-xx-xxxx,x - street, x - country
         * gender : male
         * phone : {"mobile":"+91 0000000000","home":"00 000000","office":"00 000000"}
         */

        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("email")
        private String email;
        @SerializedName("address")
        private String address;
        @SerializedName("gender")
        private String gender;
        @SerializedName("phone")
        private PhoneBean phone;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public PhoneBean getPhone() {
            return phone;
        }

        public void setPhone(PhoneBean phone) {
            this.phone = phone;
        }

        public static class PhoneBean {
            /**
             * mobile : +91 0000000000
             * home : 00 000000
             * office : 00 000000
             */

            @SerializedName("mobile")
            private String mobile;
            @SerializedName("home")
            private String home;
            @SerializedName("office")
            private String office;

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getHome() {
                return home;
            }

            public void setHome(String home) {
                this.home = home;
            }

            public String getOffice() {
                return office;
            }

            public void setOffice(String office) {
                this.office = office;
            }
        }
    }
}
