package MetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

public class ParameterMetaDataDemo {
    public static void main(String[] args) throws Exception
    {
        // Obtain setup.
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");

        PreparedStatement ps = con.prepareStatement("INSERT Into employeedetails VALUES(?, ?, ?,?)");
        
        ParameterMetaData pmd = ps.getParameterMetaData();

        for (int i = 1; i <= pmd.getParameterCount(); i++) {
            System.out.println("Parameter number " + i);
              
          // System.out.println("  Class name is " + pmd.getParameterClassName(i));
            // Note: Mode relates to input, output or inout
            System.out.println("  Mode is " + pmd.getParameterMode(i));
           System.out.println("  Type is " + pmd.getParameterType(i));
            System.out.println("  Type name is " + pmd.getParameterTypeName(i));
            System.out.println("  Precision is " + pmd.getPrecision(i));
            System.out.println("  Scale is " + pmd.getScale(i));
            System.out.println("  Nullable? is " + pmd.isNullable(i));
            System.out.println("  Signed? is " + pmd.isSigned(i));
        }
    }
}

