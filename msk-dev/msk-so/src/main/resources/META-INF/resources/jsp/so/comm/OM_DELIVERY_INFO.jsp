<%--
  配送信息
  User: jiangnan
  Date: 15/12/23
  Time: 下午3:05
  update:gyh
  updateTime:2016.1.6
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="group-accordion" collapsible="true" active="false">
        <h3>
            <label>预计配送信息</label>
        </h3>
        <table style="width: 100%" CellSpacing=8>
            <tr>
             <td width="12.5%" align="right">习惯正常收货时间段</td>
             <td width="12.5%" align="left">${orderDelivery.receiveTime }</td>
             <td width="12.5%" align="right">习惯收货最早时间要求</td>
             <td width="12.5%" align="left">${orderDelivery.receiveEarliest }</td>
             <td width="12.5%" align="right">习惯收货最晚时间要求</td>
             <td width="12.5%" align="left">${orderDelivery.receiveLast }</td>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">预计发货时间</td>
             <td width="12.5%" align="left">${orderDelivery.forecastSendDateTime }</td>
             <td width="12.5%" align="right">预计到货时间</td>
             <td width="12.5%" align="left">${orderDelivery.forecastReceiveDateTime }</td>
             <td width="12.5%" align="right">发货时间</td>
             <td width="12.5%" align="left">${orderDelivery.sendDateTime }</td>
             <td width="12.5%" align="right">收货时间</td>
             <td width="12.5%" align="left">${orderDelivery.receiveDateTime}</td>
            </tr>
            <tr>
             <td width="12.5%" align="right">收货等待时间</td>
             <td width="12.5%" align="left">${orderDelivery.receiveWaitTime }</td>
             <td width="12.5%" align="right">提前通知时间</td>
             <td width="12.5%" align="left">${orderDelivery.advanceNoticeTime }</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">动检证要求</td>
             <td width="12.5%" align="left">${orderDelivery.vicFlg }</td>
             <td width="12.5%" align="right">装卸要求</td>
             <td width="12.5%" align="left">${orderDelivery.unloadReq }</td>
             <td width="12.5%" align="right">包装要求</td>
             <td width="12.5%" align="left">${orderDelivery.packingReq }</td>
             <td width="12.5%" align="right">距离门店最近停车距离(米)</td>
             <td width="12.5%" align="left">${orderDelivery.parkingDistance }</td>
            </tr>
            <tr>
             <td width="12.5%" align="right">其他配送服务要求</td>
             <td width="12.5%" align="left">${orderDelivery.otherDeliveryReq }</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">本次配送服务要求</td>
             <td width="12.5%" align="left">${orderDelivery.thisDeliveryReq }</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
        </table>
 </div>     

