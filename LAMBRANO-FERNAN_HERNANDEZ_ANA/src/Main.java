import java.sql.Connection;

import com.backend.integrador.dao.H2Connection;

public class Main {
    public static void main(String[] args) {
        
        try {
           Connection a = H2Connection.getConnection();
           System.out.println("OK----");
        } catch (Exception e) {
            System.out.println(" ");
        }
    }
    
    
}