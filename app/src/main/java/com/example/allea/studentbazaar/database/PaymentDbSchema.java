package com.example.allea.studentbazaar.database;

public class PaymentDbSchema {
    public static final class PaymentTable{
        public static final String NAME = "payments"; //name of table

        public static final class Cols{
           public static final String UUID = "uuid";
           public static final String NAME = "name"; //card names
           public static final String NUMBER = "number"; //card numbers
           public static final String EXPIRY = "expiry"; //expiry dates
           public static final String SECURITY = "security"; //security codes

        }

    }
}
