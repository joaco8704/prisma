package com.devopsaazure ;
import com.genexus.*;

public final  class StructSdtPais implements Cloneable, java.io.Serializable
{
   public StructSdtPais( )
   {
      gxTv_SdtPais_Paisnombre = "" ;
      gxTv_SdtPais_Mode = "" ;
      gxTv_SdtPais_Paisnombre_Z = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public short getPaisid( )
   {
      return gxTv_SdtPais_Paisid ;
   }

   public void setPaisid( short value )
   {
      gxTv_SdtPais_Paisid = value ;
   }

   public String getPaisnombre( )
   {
      return gxTv_SdtPais_Paisnombre ;
   }

   public void setPaisnombre( String value )
   {
      gxTv_SdtPais_Paisnombre = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_Initialized = value ;
   }

   public short getPaisid_Z( )
   {
      return gxTv_SdtPais_Paisid_Z ;
   }

   public void setPaisid_Z( short value )
   {
      gxTv_SdtPais_Paisid_Z = value ;
   }

   public String getPaisnombre_Z( )
   {
      return gxTv_SdtPais_Paisnombre_Z ;
   }

   public void setPaisnombre_Z( String value )
   {
      gxTv_SdtPais_Paisnombre_Z = value ;
   }

   protected short gxTv_SdtPais_Paisid ;
   protected short gxTv_SdtPais_Initialized ;
   protected short gxTv_SdtPais_Paisid_Z ;
   protected String gxTv_SdtPais_Paisnombre ;
   protected String gxTv_SdtPais_Mode ;
   protected String gxTv_SdtPais_Paisnombre_Z ;
}

