package com.devopsaazure ;
import com.devopsaazure.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.devopsaazure.pais", "/com.devopsaazure.pais"})
public final  class pais extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new pais_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new pais_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais";
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

