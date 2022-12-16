package com.dnlg.projectsharingapi.security;

public class SecurityConstants {
        public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)"; // Your
        public static final int TOKEN_EXPIRATION = 86400000; // 86400000 milliseconds = 24 hours.
        public static final String BEARER = "Bearer "; // Authorization : "Bearer " + Token
        public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
        public static final String REGISTER_PATH = "/user/register"; // Public path that clients can use to register.
}
