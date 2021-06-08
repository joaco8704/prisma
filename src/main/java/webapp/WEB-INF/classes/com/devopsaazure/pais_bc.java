package com.devopsaazure ;
import com.devopsaazure.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pais_bc extends GXWebPanel implements IGxSilentTrn
{
   public pais_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pais_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pais_bc.class ));
   }

   public pais_bc( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow011( ) ;
      standaloneNotModal( ) ;
      initializeNonKey011( ) ;
      standaloneModal( ) ;
      addRow011( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z1PaisId = A1PaisId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_010( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls011( ) ;
         }
         else
         {
            checkExtendedTable011( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors011( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm011( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         Z2PaisNombre = A2PaisNombre ;
      }
      if ( GX_JID == -1 )
      {
         Z1PaisId = A1PaisId ;
         Z2PaisNombre = A2PaisNombre ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load011( )
   {
      /* Using cursor BC00014 */
      pr_default.execute(2, new Object[] {Short.valueOf(A1PaisId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A2PaisNombre = BC00014_A2PaisNombre[0] ;
         zm011( -1) ;
      }
      pr_default.close(2);
      onLoadActions011( ) ;
   }

   public void onLoadActions011( )
   {
   }

   public void checkExtendedTable011( )
   {
      nIsDirty_1 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors011( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey011( )
   {
      /* Using cursor BC00015 */
      pr_default.execute(3, new Object[] {Short.valueOf(A1PaisId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound1 = (short)(1) ;
      }
      else
      {
         RcdFound1 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00016 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1PaisId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm011( 1) ;
         RcdFound1 = (short)(1) ;
         A1PaisId = BC00016_A1PaisId[0] ;
         A2PaisNombre = BC00016_A2PaisNombre[0] ;
         Z1PaisId = A1PaisId ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load011( ) ;
         if ( AnyError == 1 )
         {
            RcdFound1 = (short)(0) ;
            initializeNonKey011( ) ;
         }
         Gx_mode = sMode1 ;
      }
      else
      {
         RcdFound1 = (short)(0) ;
         initializeNonKey011( ) ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode1 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey011( ) ;
      if ( RcdFound1 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_010( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency011( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00017 */
         pr_default.execute(5, new Object[] {Short.valueOf(A1PaisId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z2PaisNombre, BC00017_A2PaisNombre[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Pais"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert011( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         zm011( 0) ;
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00018 */
                  pr_default.execute(6, new Object[] {A2PaisNombre});
                  /* Retrieving last key number assigned */
                  /* Using cursor BC00019 */
                  pr_default.execute(7);
                  A1PaisId = BC00019_A1PaisId[0] ;
                  pr_default.close(7);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load011( ) ;
         }
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void update011( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000110 */
                  pr_default.execute(8, new Object[] {A2PaisNombre, Short.valueOf(A1PaisId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
                  if ( (pr_default.getStatus(8) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate011( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void deferredUpdate011( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls011( ) ;
         afterConfirm011( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete011( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000111 */
               pr_default.execute(9, new Object[] {Short.valueOf(A1PaisId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode1 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel011( ) ;
      Gx_mode = sMode1 ;
   }

   public void onDeleteControls011( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel011( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete011( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart011( )
   {
      /* Using cursor BC000112 */
      pr_default.execute(10, new Object[] {Short.valueOf(A1PaisId)});
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1PaisId = BC000112_A1PaisId[0] ;
         A2PaisNombre = BC000112_A2PaisNombre[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext011( )
   {
      /* Scan next routine */
      pr_default.readNext(10);
      RcdFound1 = (short)(0) ;
      scanKeyLoad011( ) ;
   }

   public void scanKeyLoad011( )
   {
      sMode1 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1PaisId = BC000112_A1PaisId[0] ;
         A2PaisNombre = BC000112_A2PaisNombre[0] ;
      }
      Gx_mode = sMode1 ;
   }

   public void scanKeyEnd011( )
   {
      pr_default.close(10);
   }

   public void afterConfirm011( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert011( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate011( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete011( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete011( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate011( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes011( )
   {
   }

   public void send_integrity_lvl_hashes011( )
   {
   }

   public void addRow011( )
   {
      VarsToRow1( bcPais) ;
   }

   public void readRow011( )
   {
      RowToVars1( bcPais, 1) ;
   }

   public void initializeNonKey011( )
   {
      A2PaisNombre = "" ;
      Z2PaisNombre = "" ;
   }

   public void initAll011( )
   {
      A1PaisId = (short)(0) ;
      initializeNonKey011( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow1( com.devopsaazure.SdtPais obj1 )
   {
      obj1.setgxTv_SdtPais_Mode( Gx_mode );
      obj1.setgxTv_SdtPais_Paisnombre( A2PaisNombre );
      obj1.setgxTv_SdtPais_Paisid( A1PaisId );
      obj1.setgxTv_SdtPais_Paisid_Z( Z1PaisId );
      obj1.setgxTv_SdtPais_Paisnombre_Z( Z2PaisNombre );
      obj1.setgxTv_SdtPais_Mode( Gx_mode );
   }

   public void KeyVarsToRow1( com.devopsaazure.SdtPais obj1 )
   {
      obj1.setgxTv_SdtPais_Paisid( A1PaisId );
   }

   public void RowToVars1( com.devopsaazure.SdtPais obj1 ,
                           int forceLoad )
   {
      Gx_mode = obj1.getgxTv_SdtPais_Mode() ;
      A2PaisNombre = obj1.getgxTv_SdtPais_Paisnombre() ;
      A1PaisId = obj1.getgxTv_SdtPais_Paisid() ;
      Z1PaisId = obj1.getgxTv_SdtPais_Paisid_Z() ;
      Z2PaisNombre = obj1.getgxTv_SdtPais_Paisnombre_Z() ;
      Gx_mode = obj1.getgxTv_SdtPais_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A1PaisId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey011( ) ;
      scanKeyStart011( ) ;
      if ( RcdFound1 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z1PaisId = A1PaisId ;
      }
      zm011( -1) ;
      onLoadActions011( ) ;
      addRow011( ) ;
      scanKeyEnd011( ) ;
      if ( RcdFound1 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars1( bcPais, 0) ;
      scanKeyStart011( ) ;
      if ( RcdFound1 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z1PaisId = A1PaisId ;
      }
      zm011( -1) ;
      onLoadActions011( ) ;
      addRow011( ) ;
      scanKeyEnd011( ) ;
      if ( RcdFound1 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey011( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert011( ) ;
      }
      else
      {
         if ( RcdFound1 == 1 )
         {
            if ( A1PaisId != Z1PaisId )
            {
               A1PaisId = Z1PaisId ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update011( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A1PaisId != Z1PaisId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert011( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert011( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars1( bcPais, 1) ;
      saveImpl( ) ;
      VarsToRow1( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars1( bcPais, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert011( ) ;
      afterTrn( ) ;
      VarsToRow1( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.devopsaazure.SdtPais auxBC = new com.devopsaazure.SdtPais( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A1PaisId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcPais);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars1( bcPais, 1) ;
      updateImpl( ) ;
      VarsToRow1( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars1( bcPais, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert011( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow1( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars1( bcPais, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey011( ) ;
      if ( RcdFound1 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A1PaisId != Z1PaisId )
         {
            A1PaisId = Z1PaisId ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A1PaisId != Z1PaisId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "pais_bc");
      VarsToRow1( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcPais.getgxTv_SdtPais_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcPais.setgxTv_SdtPais_Mode( Gx_mode );
   }

   public void SetSDT( com.devopsaazure.SdtPais sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcPais )
      {
         bcPais = sdt ;
         if ( GXutil.strcmp(bcPais.getgxTv_SdtPais_Mode(), "") == 0 )
         {
            bcPais.setgxTv_SdtPais_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow1( bcPais) ;
         }
         else
         {
            RowToVars1( bcPais, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcPais.getgxTv_SdtPais_Mode(), "") == 0 )
         {
            bcPais.setgxTv_SdtPais_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars1( bcPais, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtPais getPais_BC( )
   {
      return bcPais ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z2PaisNombre = "" ;
      A2PaisNombre = "" ;
      BC00014_A1PaisId = new short[1] ;
      BC00014_A2PaisNombre = new String[] {""} ;
      BC00015_A1PaisId = new short[1] ;
      BC00016_A1PaisId = new short[1] ;
      BC00016_A2PaisNombre = new String[] {""} ;
      sMode1 = "" ;
      BC00017_A1PaisId = new short[1] ;
      BC00017_A2PaisNombre = new String[] {""} ;
      BC00019_A1PaisId = new short[1] ;
      BC000112_A1PaisId = new short[1] ;
      BC000112_A2PaisNombre = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.devopsaazure.pais_bc__default(),
         new Object[] {
             new Object[] {
            BC00012_A1PaisId, BC00012_A2PaisNombre
            }
            , new Object[] {
            BC00013_A1PaisId, BC00013_A2PaisNombre
            }
            , new Object[] {
            BC00014_A1PaisId, BC00014_A2PaisNombre
            }
            , new Object[] {
            BC00015_A1PaisId
            }
            , new Object[] {
            BC00016_A1PaisId, BC00016_A2PaisNombre
            }
            , new Object[] {
            BC00017_A1PaisId, BC00017_A2PaisNombre
            }
            , new Object[] {
            }
            , new Object[] {
            BC00019_A1PaisId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000112_A1PaisId, BC000112_A2PaisNombre
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1PaisId ;
   private short A1PaisId ;
   private short RcdFound1 ;
   private short nIsDirty_1 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z2PaisNombre ;
   private String A2PaisNombre ;
   private String sMode1 ;
   private boolean mustCommit ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.devopsaazure.SdtPais bcPais ;
   private IDataStoreProvider pr_default ;
   private short[] BC00014_A1PaisId ;
   private String[] BC00014_A2PaisNombre ;
   private short[] BC00015_A1PaisId ;
   private short[] BC00016_A1PaisId ;
   private String[] BC00016_A2PaisNombre ;
   private short[] BC00017_A1PaisId ;
   private String[] BC00017_A2PaisNombre ;
   private short[] BC00019_A1PaisId ;
   private short[] BC000112_A1PaisId ;
   private String[] BC000112_A2PaisNombre ;
   private short[] BC00012_A1PaisId ;
   private String[] BC00012_A2PaisNombre ;
   private short[] BC00013_A1PaisId ;
   private String[] BC00013_A2PaisNombre ;
}

final  class pais_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00012", "SELECT `PaisId`, `PaisNombre` FROM `Pais` WHERE `PaisId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00013", "SELECT `PaisId`, `PaisNombre` FROM `Pais` WHERE `PaisId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00014", "SELECT TM1.`PaisId`, TM1.`PaisNombre` FROM `Pais` TM1 WHERE TM1.`PaisId` = ? ORDER BY TM1.`PaisId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00015", "SELECT `PaisId` FROM `Pais` WHERE `PaisId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00016", "SELECT `PaisId`, `PaisNombre` FROM `Pais` WHERE `PaisId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00017", "SELECT `PaisId`, `PaisNombre` FROM `Pais` WHERE `PaisId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC00018", "INSERT INTO `Pais`(`PaisNombre`) VALUES(?)", GX_NOMASK)
         ,new ForEachCursor("BC00019", "SELECT LAST_INSERT_ID() ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000110", "UPDATE `Pais` SET `PaisNombre`=?  WHERE `PaisId` = ?", GX_NOMASK)
         ,new UpdateCursor("BC000111", "DELETE FROM `Pais`  WHERE `PaisId` = ?", GX_NOMASK)
         ,new ForEachCursor("BC000112", "SELECT TM1.`PaisId`, TM1.`PaisNombre` FROM `Pais` TM1 WHERE TM1.`PaisId` = ? ORDER BY TM1.`PaisId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

