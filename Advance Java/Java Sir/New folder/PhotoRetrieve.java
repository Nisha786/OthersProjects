 import java.sql.*;
 import java.io.*;
 class PhotoRetrieve
 {
     public static void main(String args[])throws Exception
     {
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");

       Statement st=con.createStatement(1005,1008);
       ResultSet rs=st.executeQuery("select * from emp");
       rs.absolute(2);
    //   if(rs.next())
      // {
         InputStream in=rs.getBinaryStream("ephoto");

     	 FileOutputStream fos=new FileOutputStream("newpict.jpg");

	     int bytesRead=0;
  	     byte [] buffer=new byte[4096];

    	 while((bytesRead=in.read(buffer))!=-1)
	     {
	        fos.write(buffer,0,bytesRead);
         }

		System.out.println("photo is stored in newpict.gif");

          fos.close();
	      in.close();
	      rs.close();
	      st.close();
	      con.close();
	  // }//if
       }//main
     }//class