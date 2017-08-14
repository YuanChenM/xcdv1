/**
 *JS
 *@author puxigui
 */
var $List_Grid;
var SL24110333 = {
    initData: function(){
        $.core.bindImgView();
        $( "#SL241103012accordion" ).accordion({ heightStyle: "content" });
        $( "#SL241103022accordion" ).accordion({ heightStyle: "content" });
        $( "#SL241103032accordion" ).accordion({ heightStyle: "content" });
        $( "#SL241103042accordion" ).accordion({ heightStyle: "content" });
        $( "#SL241103052accordion" ).accordion({ heightStyle: "content" });
        $( "#SL241103062accordion" ).accordion({ heightStyle: "content" });
        $( "#SL241103072accordion" ).accordion({ heightStyle: "content" });
        $( "#SL241103082accordion" ).accordion({ heightStyle: "content" });
        $( "#SL241103122accordion" ).accordion({ heightStyle: "content" });
        $('#SL241103012accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110301").postUrl(Main.contextPath+"/SL241103/initSL24110301",{slCode:slCode,epId:epId});
            }
        } );
        $('#SL241103022accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110302").postUrl(Main.contextPath+"/SL241103/initSL24110302",{slCode:slCode,epId:epId});
            }
        } );
        $('#SL241103032accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110303").postUrl(Main.contextPath+"/SL241103/initSL24110303",{slCode:slCode,epId:epId});
            }
        } );
        $('#SL241103042accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110304").postUrl(Main.contextPath+"/SL241103/initSL24110304",{slCode:slCode,epId:epId});
            }
        } );
        $('#SL241103052accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110305").postUrl(Main.contextPath+"/SL241103/initSL24110305",{slCode:slCode,epId:epId});
            }
        } );
        $('#SL241103062accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110306").postUrl(Main.contextPath+"/SL241103/initSL24110306",{slCode:slCode,epId:epId});
            }
        } );
        $('#SL241103072accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110307").postUrl(Main.contextPath+"/SL241103/initSL24110307",{slCode:slCode,epId:epId});
            }
        } );
        $('#SL241103082accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110308").postUrl(Main.contextPath+"/SL241103/initSL24110308",{slCode:slCode,epId:epId});
            }
        } );
        $('#SL241103122accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL24110312").postUrl(Main.contextPath+"/SL241103/initSL24110312",{epId:epId});
            }
        } );
    }
}
$(document).ready(function() {
    //初始化调用
    SL24110333.initData();
});