package com.devopsaazure ;
import com.devopsaazure.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pais_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      gxfirstwebparm_bkp = gxfirstwebparm ;
      gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         dyncall( httpContext.GetNextPar( )) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else
      {
         if ( ! httpContext.IsValidAjaxCall( false) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = gxfirstwebparm_bkp ;
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(0)) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_2-148375", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Pais", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPaisNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("Carmine");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public pais_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pais_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pais_impl.class ));
   }

   public pais_impl( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.devopsaazure.rwdmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.devopsaazure.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "WWAdvancedContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, divTitlecontainer_Internalname, 1, 0, "px", 0, "px", "TableTop", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.devopsaazure.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Pais", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, divFormcontainer_Internalname, 1, 0, "px", 0, "px", "FormContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, divToolbarcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3 ToolbarCellClass", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
      ClassString = "BtnFirst" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Select", bttBtn_select_Jsonclick, 5, "Select", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCellAdvanced", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaisNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.devopsaazure.GxWebStd.gx_label_element( httpContext, edtPaisNombre_Internalname, "Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.devopsaazure.GxWebStd.gx_single_line_edit( httpContext, edtPaisNombre_Internalname, GXutil.rtrim( A2PaisNombre), GXutil.rtrim( localUtil.format( A2PaisNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaisNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaisNombre_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirm", bttBtn_enter_Jsonclick, 5, "Confirm", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancel", bttBtn_cancel_Jsonclick, 1, "Cancel", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.devopsaazure.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.devopsaazure.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Delete", bttBtn_delete_Jsonclick, 5, "Delete", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pais.htm");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.devopsaazure.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Z1PaisId = (short)(localUtil.ctol( httpContext.cgiGet( "Z1PaisId"), ".", ",")) ;
         Z2PaisNombre = httpContext.cgiGet( "Z2PaisNombre") ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ".", ",")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ".", ",")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         A1PaisId = (short)(localUtil.ctol( httpContext.cgiGet( "PAISID"), ".", ",")) ;
         /* Read variables values. */
         A2PaisNombre = httpContext.cgiGet( edtPaisNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2PaisNombre", A2PaisNombre);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"Pais");
         forbiddenHiddens.add("PaisId", localUtil.format( DecimalUtil.doubleToDec(A1PaisId), "ZZZ9"));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("pais:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            AnyError = (short)(1) ;
            return  ;
         }
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A1PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PaisId), 4, 0));
            getEqualNoModal( ) ;
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            disable_std_buttons_dsp( ) ;
            standaloneModal( ) ;
         }
         else
         {
            Gx_mode = "INS" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            standaloneModal( ) ;
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_first( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_previous( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_next( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_last( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_select( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
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
            /* Clear variables for new insertion. */
            initAll011( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
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

   public void disable_std_buttons( )
   {
      if ( isIns( ) )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes011( ) ;
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void resetCaption010( )
   {
   }

   public void zm011( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2PaisNombre = T00013_A2PaisNombre[0] ;
         }
         else
         {
            Z2PaisNombre = A2PaisNombre ;
         }
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
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load011( )
   {
      /* Using cursor T00014 */
      pr_default.execute(2, new Object[] {Short.valueOf(A1PaisId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A2PaisNombre = T00014_A2PaisNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2PaisNombre", A2PaisNombre);
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
      Gx_BScreen = (byte)(1) ;
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
      /* Using cursor T00015 */
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
      /* Using cursor T00013 */
      pr_default.execute(1, new Object[] {Short.valueOf(A1PaisId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm011( 1) ;
         RcdFound1 = (short)(1) ;
         A1PaisId = T00013_A1PaisId[0] ;
         A2PaisNombre = T00013_A2PaisNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2PaisNombre", A2PaisNombre);
         Z1PaisId = A1PaisId ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load011( ) ;
         if ( AnyError == 1 )
         {
            RcdFound1 = (short)(0) ;
            initializeNonKey011( ) ;
         }
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound1 = (short)(0) ;
         initializeNonKey011( ) ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey011( ) ;
      if ( RcdFound1 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T00016 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1PaisId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T00016_A1PaisId[0] < A1PaisId ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T00016_A1PaisId[0] > A1PaisId ) ) )
         {
            A1PaisId = T00016_A1PaisId[0] ;
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T00017 */
      pr_default.execute(5, new Object[] {Short.valueOf(A1PaisId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T00017_A1PaisId[0] > A1PaisId ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T00017_A1PaisId[0] < A1PaisId ) ) )
         {
            A1PaisId = T00017_A1PaisId[0] ;
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey011( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPaisNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert011( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound1 == 1 )
         {
            if ( A1PaisId != Z1PaisId )
            {
               A1PaisId = Z1PaisId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PaisId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPaisNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update011( ) ;
               GX_FocusControl = edtPaisNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1PaisId != Z1PaisId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtPaisNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert011( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtPaisNombre_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert011( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void btn_delete( )
   {
      if ( A1PaisId != Z1PaisId )
      {
         A1PaisId = Z1PaisId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PaisId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "");
         AnyError = (short)(1) ;
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPaisNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound1 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      GX_FocusControl = edtPaisNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart011( ) ;
      if ( RcdFound1 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPaisNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd011( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound1 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPaisNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound1 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPaisNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart011( ) ;
      if ( RcdFound1 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound1 != 0 )
         {
            scanNext011( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPaisNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd011( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency011( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00012 */
         pr_default.execute(0, new Object[] {Short.valueOf(A1PaisId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2PaisNombre, T00012_A2PaisNombre[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z2PaisNombre, T00012_A2PaisNombre[0]) != 0 )
            {
               GXutil.writeLogln("pais:[seudo value changed for attri]"+"PaisNombre");
               GXutil.writeLogRaw("Old: ",Z2PaisNombre);
               GXutil.writeLogRaw("Current: ",T00012_A2PaisNombre[0]);
            }
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
                  /* Using cursor T00018 */
                  pr_default.execute(6, new Object[] {A2PaisNombre});
                  /* Retrieving last key number assigned */
                  /* Using cursor T00019 */
                  pr_default.execute(7);
                  A1PaisId = T00019_A1PaisId[0] ;
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
                        resetCaption010( ) ;
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
                  /* Using cursor T000110 */
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
                        resetCaption010( ) ;
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
               /* Using cursor T000111 */
               pr_default.execute(9, new Object[] {Short.valueOf(A1PaisId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound1 == 0 )
                     {
                        initAll011( ) ;
                        Gx_mode = "INS" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     else
                     {
                        getByPrimaryKey( ) ;
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                     resetCaption010( ) ;
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel011( ) ;
      Gx_mode = sMode1 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete011( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "pais");
         if ( AnyError == 0 )
         {
            confirmValues010( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "pais");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart011( )
   {
      /* Using cursor T000112 */
      pr_default.execute(10);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1PaisId = T000112_A1PaisId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext011( )
   {
      /* Scan next routine */
      pr_default.readNext(10);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1PaisId = T000112_A1PaisId[0] ;
      }
   }

   public void scanEnd011( )
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
      edtPaisNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisNombre_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes011( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues010( )
   {
   }

   public void renderHtmlHeaders( )
   {
      com.devopsaazure.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?20216810205390", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.devopsaazure.pais", new String[] {}, new String[] {}) +"\">") ;
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:none\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Pais");
      forbiddenHiddens.add("PaisId", localUtil.format( DecimalUtil.doubleToDec(A1PaisId), "ZZZ9"));
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("pais:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "Z1PaisId", GXutil.ltrim( localUtil.ntoc( Z1PaisId, (byte)(4), (byte)(0), ".", "")));
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "Z2PaisNombre", GXutil.rtrim( Z2PaisNombre));
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ".", "")));
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ".", "")));
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "PAISID", GXutil.ltrim( localUtil.ntoc( A1PaisId, (byte)(4), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.devopsaazure.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.devopsaazure.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.devopsaazure.pais", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Pais" ;
   }

   public String getPgmdesc( )
   {
      return "Pais" ;
   }

   public void initializeNonKey011( )
   {
      A2PaisNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2PaisNombre", A2PaisNombre);
      Z2PaisNombre = "" ;
   }

   public void initAll011( )
   {
      A1PaisId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PaisId), 4, 0));
      initializeNonKey011( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20216810205394", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages.eng.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("pais.js", "?20216810205394", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      divTitlecontainer_Internalname = "TITLECONTAINER" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      divToolbarcell_Internalname = "TOOLBARCELL" ;
      edtPaisNombre_Internalname = "PAISNOMBRE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("Carmine");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Pais" );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtPaisNombre_Jsonclick = "" ;
      edtPaisNombre_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtPaisNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
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

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A1PaisId',fld:'PAISID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      sPrefix = "" ;
      Z2PaisNombre = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A2PaisNombre = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      T00014_A1PaisId = new short[1] ;
      T00014_A2PaisNombre = new String[] {""} ;
      T00015_A1PaisId = new short[1] ;
      T00013_A1PaisId = new short[1] ;
      T00013_A2PaisNombre = new String[] {""} ;
      sMode1 = "" ;
      T00016_A1PaisId = new short[1] ;
      T00017_A1PaisId = new short[1] ;
      T00012_A1PaisId = new short[1] ;
      T00012_A2PaisNombre = new String[] {""} ;
      T00019_A1PaisId = new short[1] ;
      T000112_A1PaisId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.devopsaazure.pais__default(),
         new Object[] {
             new Object[] {
            T00012_A1PaisId, T00012_A2PaisNombre
            }
            , new Object[] {
            T00013_A1PaisId, T00013_A2PaisNombre
            }
            , new Object[] {
            T00014_A1PaisId, T00014_A2PaisNombre
            }
            , new Object[] {
            T00015_A1PaisId
            }
            , new Object[] {
            T00016_A1PaisId
            }
            , new Object[] {
            T00017_A1PaisId
            }
            , new Object[] {
            }
            , new Object[] {
            T00019_A1PaisId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000112_A1PaisId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1PaisId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1PaisId ;
   private short RcdFound1 ;
   private short nIsDirty_1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtPaisNombre_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String Z2PaisNombre ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPaisNombre_Internalname ;
   private String divMaintable_Internalname ;
   private String divTitlecontainer_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divFormcontainer_Internalname ;
   private String divToolbarcell_Internalname ;
   private String TempTags ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String A2PaisNombre ;
   private String edtPaisNombre_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String hsh ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode1 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T00014_A1PaisId ;
   private String[] T00014_A2PaisNombre ;
   private short[] T00015_A1PaisId ;
   private short[] T00013_A1PaisId ;
   private String[] T00013_A2PaisNombre ;
   private short[] T00016_A1PaisId ;
   private short[] T00017_A1PaisId ;
   private short[] T00012_A1PaisId ;
   private String[] T00012_A2PaisNombre ;
   private short[] T00019_A1PaisId ;
   private short[] T000112_A1PaisId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class pais__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00012", "SELECT `PaisId`, `PaisNombre` FROM `Pais` WHERE `PaisId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00013", "SELECT `PaisId`, `PaisNombre` FROM `Pais` WHERE `PaisId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00014", "SELECT TM1.`PaisId`, TM1.`PaisNombre` FROM `Pais` TM1 WHERE TM1.`PaisId` = ? ORDER BY TM1.`PaisId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00015", "SELECT `PaisId` FROM `Pais` WHERE `PaisId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00016", "SELECT `PaisId` FROM `Pais` WHERE ( `PaisId` > ?) ORDER BY `PaisId`  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00017", "SELECT `PaisId` FROM `Pais` WHERE ( `PaisId` < ?) ORDER BY `PaisId` DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T00018", "INSERT INTO `Pais`(`PaisNombre`) VALUES(?)", GX_NOMASK)
         ,new ForEachCursor("T00019", "SELECT LAST_INSERT_ID() ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000110", "UPDATE `Pais` SET `PaisNombre`=?  WHERE `PaisId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000111", "DELETE FROM `Pais`  WHERE `PaisId` = ?", GX_NOMASK)
         ,new ForEachCursor("T000112", "SELECT `PaisId` FROM `Pais` ORDER BY `PaisId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
      }
   }

}

