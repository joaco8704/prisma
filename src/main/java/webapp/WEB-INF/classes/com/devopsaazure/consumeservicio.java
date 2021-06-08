package com.devopsaazure ;
import com.devopsaazure.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.devopsaazure.consumeservicio", "/com.devopsaazure.consumeservicio"})
public final  class consumeservicio extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new consumeservicio_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new consumeservicio_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Consume Servicio";
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

