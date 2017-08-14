<%--
  买家基本信息
  User: jiangnan
  Date: 15/12/23
  Time: 下午3:04
  To change this template use File | Settings | File Templates.
  update:gyh
  updateTime:2016.1.5
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="group-accordion" active="false">
	<h3>
		<label>买家基本信息</label>
	</h3>
		<table style="width: 100%"  CellSpacing=8>
            <tr>
             <td width="12.5%" align="right">买家编码</td>
             <td width="12.5%" align="left">${orderBuyers.buyersCode }</td>
             <td width="12.5%" align="right">买家名称</td>
             <td width="12.5%" align="left">${orderBuyers.buyersName }</td>
             <%--<td width="12.5%" align="right">买家类型</td>
             <td width="12.5%" align="left">${orderBuyers.buyersType }</td>--%>
             <td width="12.5%" align="right">买家类型</td>
             <td width="12.5%" align="left">${orderBuyers.buyersTypeName }</td>
             <td width="12.5%" />
             <td />
            </tr>
            <tr>
             <td width="12.5%" align="right">收货人姓名</td>
             <td width="12.5%" align="left">${orderBuyers.receiverName }</td>
             <td width="12.5%" align="right">收货人电话</td>
             <td width="12.5%" align="left">${orderBuyers.receiverTel }</td>
             <td width="12.5%" align="right">收货人微信</td>
             <td width="12.5%" align="left">${orderBuyers.receiverWeixin }</td>
             <td width="12.5%" align="right">收货人QQ</td>
             <td width="12.5%" align="left">${orderBuyers.receiverQq }</td>
            </tr>
            <tr>
             <td width="12.5%" align="right">收货人省份</td>
             <td width="12.5%" align="left">${orderBuyers.receiverProvince }</td>
             <td width="12.5%" align="right">城市</td>
             <td width="12.5%" align="left">${orderBuyers.receiverCity }</td>
             <td width="12.5%" align="right">区/街道</td>
             <td width="12.5%" align="left">${orderBuyers.receiverDistrict }</td>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">收货人详细信息</td>
             <td width="12.5%" align="left" colspan="2">${orderBuyers.receiverAddr }</td>
             <td width="12.5%"/>
             <td width="12.5%" align="right">辅助收货地址</td>
             <td width="12.5%" align="left" colspan="2">${orderBuyers.receiverAddr2}</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
		</table>
</div>

