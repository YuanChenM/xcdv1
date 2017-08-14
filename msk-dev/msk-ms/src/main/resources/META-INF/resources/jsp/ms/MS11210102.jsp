<%--
  @author fjm
  @MS11210102.jsp_会员卡密码修改页面
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script src="${ctx}/js/ms/MS11210102.js"></script>
<div class="page-content detail-page" id="MS11210102_id">
    <form:form action="${ctx}/MS11210102/updatePW" id="MS11210102Form" name="MS11210102Form">
          <table id="MS11210102DataGrid" width="100%">
          	   <tr>
          		<td colspan="2" align="center"><span id="info_sp"></span></td>
          	   </tr>
               <tr>
                   <td align="right" width="50%">会员卡当前密码</td>
                   <td align="left" width="50%">
                   <input type="text"  name="msPrevpw" id="msPrevpw"/>
                   <input type="hidden" id="msCardno" name="msCardno" value="${msCardmanager.msCardno}"  readonly/>
                   </td>
               </tr>
               <tr>
                   <td align="right" width="50%">会员卡新密码</td>
                   <td align="left" width="50%">
                   <input type="password" name="msNowpw" id="msNowpw" onblur="pwdTest()"/>
                   <span id="pwd_sp"></span>
                   </td>
               </tr>
               <tr>
                   <td align="right" width="50%">新密码确认</td>
                   <td align="left" width="50%">
                   <input type="password" name="msNowpw2" id="msNowpw2" onblur="pwdSure()"/>
                   <span id="pwd_sp2"></span>
                   </td>
               </tr>
               <tr>                
                    <td align="right" width="50%">                  
                        <msk:button buttonValue="保存" buttonId="MS11210102.SAVE" buttonType="button"/>
                    </td> 
                    <td align="left" width="50%">                  
                        <msk:button buttonValue="取消" buttonId="MS11210102.BACK" buttonType="button"/>
                    </td>
                </tr>
          </table>
     </form:form>
</div>