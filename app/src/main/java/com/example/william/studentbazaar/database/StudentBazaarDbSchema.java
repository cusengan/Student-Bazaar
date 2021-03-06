package com.example.william.studentbazaar.database;

public class StudentBazaarDbSchema {

    public static final class ClubTable {
        public static final String NAME = "club"; //name of table

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name"; //name of clubs
            public static final String DESCRIPTION = "description";
        }
    }

    public static final class UserTable {
        public static final String NAME ="user";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String FIRSTNAME = "firstName";
            public static final String LASTNAME = "lastName";
            public static final String STUDENTID = "studentId";
            public static final String PHONENUMBER = "phoneNumber";
            public static final String EMAIL = "email";
            public static final String PASSWORD ="password";
        }
    }

    public static final class ItemTable {
        public static final String NAME = "item";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String OWNERID = "ownerId";
            public static final String NAME = "name"; //name of item
            public static final String DESCRIPTION = "description";
            public static final String ONSALE = "onSale";
        }
    }

    public static final class InClubTable {
        public static final String NAME = "inClub";
        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String CLUBID = "clubId";
            public static final String STUDENTID = "studentId";
        }
    }

    public static final class EventTable {
        public static final String NAME = "event";
        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String OWNERID = "ownerId";
            public static final String NAME = "name";
            public static final String DESCRIPTION = "description";
            public static final String ONDISPLAY = "display";
        }
    }

}
