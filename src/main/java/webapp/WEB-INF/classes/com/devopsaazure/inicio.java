package com.devopsaazure ;
import com.devopsaazure.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.devopsaazure.inicio", "/com.devopsaazure.inicio"})
public final  class inicio extends GXWebObjectStub
{
   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.devopsaazure.GXcfg.class);
      com.devopsaazure.inicio_impl pgm = new com.devopsaazure.inicio_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inicio_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inicio_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "inicio";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

}

