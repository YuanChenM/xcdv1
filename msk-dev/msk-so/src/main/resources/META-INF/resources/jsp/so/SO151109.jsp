<%-- 
    Title:会员卡列表
    author:rwf
    createDate:2015-12-31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="page-header">
    <span class="page-title">
        <label>会员卡列表</label>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/SO151109/search" method="post">
        <table id="so151109_list_grid" showAddBtn="true">
            <thead>
                <tr>
                    <th coltype="text" width="15%" name="memberCode"  filter="true">会员卡编码</th>
                    <th coltype="text" width="15%" name="buyersCode" filter="true">买家编码</th>
                    <th coltype="text" width="15%" name="buyersName" filter="true">买家名称</th>
                    <th coltype="select" width="15%" name="activateFlag" filter="true">是否已经激活
                        <select>
                            <option value="1">是</option>
                            <option value="2">否</option>
                        </select>
                    </th>
                    <th coltype="select" width="15%" name="issueFlag" filter="true">是否已经激活
                        <select>
                            <option value="1">是</option>
                            <option value="2">否</option>
                        </select>
                    </th>
                    <th coltype="date" width="15%" name="issueDate" filter="true">发放日期</th>
                    <th coltype="action" width="10%">
                         <input type="button"  hidden="true" id="checkBtn" value="查看" coltype="check" title="查看"  class="h-button" />
                    </th>
                </tr>
            </thead>
            <tbody>
            <table id="useForButton">
                <tr>
                    <td>
                        <msk:button buttonId="SO151109.UPDATE"  buttonValue="上传会员卡"/>
                    </td>
                </tr>
            </table>    
            </tbody>
        </table>
    </form>
</div>
<script src="${ctx}/js/so/SO151109.js"></script>