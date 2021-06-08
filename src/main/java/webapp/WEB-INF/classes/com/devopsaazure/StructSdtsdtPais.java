package com.devopsaazure ;
import com.genexus.*;

public final  class StructSdtsdtPais implements Cloneable, java.io.Serializable
{
   public StructSdtsdtPais( )
   {
      gxTv_SdtsdtPais_Paisnombre = "" ;
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
      return gxTv_SdtsdtPais_Paisid ;
   }

   public void setPaisid( short value )
   {
      gxTv_SdtsdtPais_Paisid = value ;
   }

   public String getPaisnombre( )
   {
      return gxTv_SdtsdtPais_Paisnombre ;
   }

   public void setPaisnombre( String value )
   {
      gxTv_SdtsdtPais_Paisnombre = value ;
   }

   protected short gxTv_SdtsdtPais_Paisid ;
   protected String gxTv_SdtsdtPais_Paisnombre ;
}

