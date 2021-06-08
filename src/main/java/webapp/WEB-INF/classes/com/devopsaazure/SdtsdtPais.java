package com.devopsaazure ;
import com.devopsaazure.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtPais extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtsdtPais( )
   {
      this(  new ModelContext(SdtsdtPais.class));
   }

   public SdtsdtPais( ModelContext context )
   {
      super( context, "SdtsdtPais");
   }

   public SdtsdtPais( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtPais");
   }

   public SdtsdtPais( StructSdtsdtPais struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId") )
            {
               gxTv_SdtsdtPais_Paisid = (short)(getnumericvalue(oReader.getValue())) ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisNombre") )
            {
               gxTv_SdtsdtPais_Paisnombre = oReader.getValue() ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "sdtPais" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "DevopsAazure" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("PaisId", GXutil.trim( GXutil.str( gxTv_SdtsdtPais_Paisid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "DevopsAazure") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DevopsAazure");
      }
      oWriter.writeElement("PaisNombre", GXutil.rtrim( gxTv_SdtsdtPais_Paisnombre));
      if ( GXutil.strcmp(sNameSpace, "DevopsAazure") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DevopsAazure");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("PaisId", gxTv_SdtsdtPais_Paisid, false, false);
      AddObjectProperty("PaisNombre", gxTv_SdtsdtPais_Paisnombre, false, false);
   }

   public short getgxTv_SdtsdtPais_Paisid( )
   {
      return gxTv_SdtsdtPais_Paisid ;
   }

   public void setgxTv_SdtsdtPais_Paisid( short value )
   {
      gxTv_SdtsdtPais_Paisid = value ;
   }

   public String getgxTv_SdtsdtPais_Paisnombre( )
   {
      return gxTv_SdtsdtPais_Paisnombre ;
   }

   public void setgxTv_SdtsdtPais_Paisnombre( String value )
   {
      gxTv_SdtsdtPais_Paisnombre = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtPais_Paisnombre = "" ;
      sTagName = "" ;
   }

   public com.devopsaazure.SdtsdtPais Clone( )
   {
      return (com.devopsaazure.SdtsdtPais)(clone()) ;
   }

   public void setStruct( com.devopsaazure.StructSdtsdtPais struct )
   {
      setgxTv_SdtsdtPais_Paisid(struct.getPaisid());
      setgxTv_SdtsdtPais_Paisnombre(struct.getPaisnombre());
   }

   @SuppressWarnings("unchecked")
   public com.devopsaazure.StructSdtsdtPais getStruct( )
   {
      com.devopsaazure.StructSdtsdtPais struct = new com.devopsaazure.StructSdtsdtPais ();
      struct.setPaisid(getgxTv_SdtsdtPais_Paisid());
      struct.setPaisnombre(getgxTv_SdtsdtPais_Paisnombre());
      return struct ;
   }

   protected short gxTv_SdtsdtPais_Paisid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtsdtPais_Paisnombre ;
   protected String sTagName ;
   protected boolean formatError ;
}

