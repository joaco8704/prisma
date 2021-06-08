package com.devopsaazure ;
import com.devopsaazure.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtPais( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais.class));
   }

   public SdtPais( int remoteHandle ,
                   ModelContext context )
   {
      super( context, "SdtPais");
      initialize( remoteHandle) ;
   }

   public SdtPais( int remoteHandle ,
                   StructSdtPais struct )
   {
      this(remoteHandle);
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

   public void Load( short AV1PaisId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV1PaisId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PaisId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Pais");
      metadata.set("BT", "Pais");
      metadata.set("PK", "[ \"PaisId\" ]");
      metadata.set("PKAssigned", "[ \"PaisId\" ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
               gxTv_SdtPais_Paisid = (short)(getnumericvalue(oReader.getValue())) ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisNombre") )
            {
               gxTv_SdtPais_Paisnombre = oReader.getValue() ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_Mode = oReader.getValue() ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisId_Z") )
            {
               gxTv_SdtPais_Paisid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaisNombre_Z") )
            {
               gxTv_SdtPais_Paisnombre_Z = oReader.getValue() ;
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
         sName = "Pais" ;
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
      oWriter.writeElement("PaisId", GXutil.trim( GXutil.str( gxTv_SdtPais_Paisid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "DevopsAazure") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DevopsAazure");
      }
      oWriter.writeElement("PaisNombre", GXutil.rtrim( gxTv_SdtPais_Paisnombre));
      if ( GXutil.strcmp(sNameSpace, "DevopsAazure") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DevopsAazure");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtPais_Mode));
         if ( GXutil.strcmp(sNameSpace, "DevopsAazure") != 0 )
         {
            oWriter.writeAttribute("xmlns", "DevopsAazure");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "DevopsAazure") != 0 )
         {
            oWriter.writeAttribute("xmlns", "DevopsAazure");
         }
         oWriter.writeElement("PaisId_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paisid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "DevopsAazure") != 0 )
         {
            oWriter.writeAttribute("xmlns", "DevopsAazure");
         }
         oWriter.writeElement("PaisNombre_Z", GXutil.rtrim( gxTv_SdtPais_Paisnombre_Z));
         if ( GXutil.strcmp(sNameSpace, "DevopsAazure") != 0 )
         {
            oWriter.writeAttribute("xmlns", "DevopsAazure");
         }
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
      AddObjectProperty("PaisId", gxTv_SdtPais_Paisid, false, includeNonInitialized);
      AddObjectProperty("PaisNombre", gxTv_SdtPais_Paisnombre, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaisId_Z", gxTv_SdtPais_Paisid_Z, false, includeNonInitialized);
         AddObjectProperty("PaisNombre_Z", gxTv_SdtPais_Paisnombre_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.devopsaazure.SdtPais sdt )
   {
      if ( sdt.IsDirty("PaisId") )
      {
         gxTv_SdtPais_Paisid = sdt.getgxTv_SdtPais_Paisid() ;
      }
      if ( sdt.IsDirty("PaisNombre") )
      {
         gxTv_SdtPais_Paisnombre = sdt.getgxTv_SdtPais_Paisnombre() ;
      }
   }

   public short getgxTv_SdtPais_Paisid( )
   {
      return gxTv_SdtPais_Paisid ;
   }

   public void setgxTv_SdtPais_Paisid( short value )
   {
      if ( gxTv_SdtPais_Paisid != value )
      {
         gxTv_SdtPais_Mode = "INS" ;
         this.setgxTv_SdtPais_Paisid_Z_SetNull( );
         this.setgxTv_SdtPais_Paisnombre_Z_SetNull( );
      }
      SetDirty("Paisid");
      gxTv_SdtPais_Paisid = value ;
   }

   public String getgxTv_SdtPais_Paisnombre( )
   {
      return gxTv_SdtPais_Paisnombre ;
   }

   public void setgxTv_SdtPais_Paisnombre( String value )
   {
      SetDirty("Paisnombre");
      gxTv_SdtPais_Paisnombre = value ;
   }

   public String getgxTv_SdtPais_Mode( )
   {
      return gxTv_SdtPais_Mode ;
   }

   public void setgxTv_SdtPais_Mode( String value )
   {
      SetDirty("Mode");
      gxTv_SdtPais_Mode = value ;
   }

   public void setgxTv_SdtPais_Mode_SetNull( )
   {
      gxTv_SdtPais_Mode = "" ;
   }

   public boolean getgxTv_SdtPais_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Initialized( )
   {
      return gxTv_SdtPais_Initialized ;
   }

   public void setgxTv_SdtPais_Initialized( short value )
   {
      SetDirty("Initialized");
      gxTv_SdtPais_Initialized = value ;
   }

   public void setgxTv_SdtPais_Initialized_SetNull( )
   {
      gxTv_SdtPais_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtPais_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Paisid_Z( )
   {
      return gxTv_SdtPais_Paisid_Z ;
   }

   public void setgxTv_SdtPais_Paisid_Z( short value )
   {
      SetDirty("Paisid_Z");
      gxTv_SdtPais_Paisid_Z = value ;
   }

   public void setgxTv_SdtPais_Paisid_Z_SetNull( )
   {
      gxTv_SdtPais_Paisid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtPais_Paisid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_Paisnombre_Z( )
   {
      return gxTv_SdtPais_Paisnombre_Z ;
   }

   public void setgxTv_SdtPais_Paisnombre_Z( String value )
   {
      SetDirty("Paisnombre_Z");
      gxTv_SdtPais_Paisnombre_Z = value ;
   }

   public void setgxTv_SdtPais_Paisnombre_Z_SetNull( )
   {
      gxTv_SdtPais_Paisnombre_Z = "" ;
   }

   public boolean getgxTv_SdtPais_Paisnombre_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.devopsaazure.pais_bc obj;
      obj = new com.devopsaazure.pais_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtPais_Paisnombre = "" ;
      gxTv_SdtPais_Mode = "" ;
      gxTv_SdtPais_Paisnombre_Z = "" ;
      sTagName = "" ;
   }

   public com.devopsaazure.SdtPais Clone( )
   {
      com.devopsaazure.SdtPais sdt;
      com.devopsaazure.pais_bc obj;
      sdt = (com.devopsaazure.SdtPais)(clone()) ;
      obj = (com.devopsaazure.pais_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.devopsaazure.StructSdtPais struct )
   {
      setgxTv_SdtPais_Paisid(struct.getPaisid());
      setgxTv_SdtPais_Paisnombre(struct.getPaisnombre());
      setgxTv_SdtPais_Mode(struct.getMode());
      setgxTv_SdtPais_Initialized(struct.getInitialized());
      setgxTv_SdtPais_Paisid_Z(struct.getPaisid_Z());
      setgxTv_SdtPais_Paisnombre_Z(struct.getPaisnombre_Z());
   }

   @SuppressWarnings("unchecked")
   public com.devopsaazure.StructSdtPais getStruct( )
   {
      com.devopsaazure.StructSdtPais struct = new com.devopsaazure.StructSdtPais ();
      struct.setPaisid(getgxTv_SdtPais_Paisid());
      struct.setPaisnombre(getgxTv_SdtPais_Paisnombre());
      struct.setMode(getgxTv_SdtPais_Mode());
      struct.setInitialized(getgxTv_SdtPais_Initialized());
      struct.setPaisid_Z(getgxTv_SdtPais_Paisid_Z());
      struct.setPaisnombre_Z(getgxTv_SdtPais_Paisnombre_Z());
      return struct ;
   }

   private short gxTv_SdtPais_Paisid ;
   private short gxTv_SdtPais_Initialized ;
   private short gxTv_SdtPais_Paisid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtPais_Paisnombre ;
   private String gxTv_SdtPais_Mode ;
   private String gxTv_SdtPais_Paisnombre_Z ;
   private String sTagName ;
   private boolean formatError ;
}

