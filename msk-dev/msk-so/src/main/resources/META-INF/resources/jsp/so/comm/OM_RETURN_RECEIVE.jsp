<%--
  Created by IntelliJ IDEA.
  User: jiangnan
  Date: 15/12/25
  Time: 上午10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="group-accordion"  active="false">
     <h3>
        <label>退货单物流收货信息</label>
     </h3>
        <table style="width: 100%">
            <tr>
                <td coltype="text" width="25%" height="20px" name="verification">是否开动检证&nbsp;:&nbsp;&nbsp;${returnReceiveBean.verification }</td>
                <%-- <td coltype="text" width="25%" height="20px" name="returnWaitTime">退货等待时间&nbsp;:&nbsp;&nbsp;${returnReceiveBean.returnWaitTime }</td> --%>
                <td coltype="text" width="25%" height="20px" name="noticeTime">提前通知时间&nbsp;:&nbsp;&nbsp;${returnReceiveBean.noticeTime }</td>
                <td coltype="text" width="25%" height="20px" name="distance">距离门店最近停车距离(米)&nbsp;:&nbsp;&nbsp;${returnReceiveBean.distance }</td>
                <td coltype="text" width="25%" height="20px" name="noticeTime"></td>
            </tr>
            <tr>
                <td coltype="text" width="25%" height="20px" name="normalTime">正常退货时间段&nbsp;:&nbsp;&nbsp;${returnReceiveBean.normalTime }</td>
                <td coltype="text" width="25%" height="20px" name="returnEarliestTime">退货最早时间要求&nbsp;:&nbsp;&nbsp;${returnReceiveBean.returnEarliestTime }</td>
                <td coltype="text" width="25%" height="20px" name="returnLatestTime">退货最晚时间要求&nbsp;:&nbsp;&nbsp;${returnReceiveBean.returnLatestTime }</td>
                <td coltype="text" width="25%" height="20px" name="totalAmount"></td>
            </tr>
            <tr>
                <td coltype="text" colspan="4"   height="20px" name="otherReturnRequest">其他退货服务要求&nbsp;:&nbsp;&nbsp;${returnReceiveBean.otherReturnRequest }</td>
                <td coltype="text" width="25%" height="20px" name="s0014"></td>
                <td coltype="text" width="25%" height="20px" name="s0014"></td>
                <td coltype="text" width="25%" height="20px" name="s0014"></td>
            </tr>
             <tr>
                <td coltype="text" colspan="4"   height="20px" name="thisTimeReturnRequest">本次退货服务要求&nbsp;:&nbsp;&nbsp;${returnReceiveBean.thisTimeReturnRequest }</td>
                <td coltype="text" width="25%" height="20px" name="s0014"></td>
                <td coltype="text" width="25%" height="20px" name="s0014"></td>
                <td coltype="text" width="25%" height="20px" name="s0014"></td>
            </tr>
        </table>
  </div>

