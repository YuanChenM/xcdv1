<%-- 
    Title:计划管理
    author:gyh
    createDate:2016-6-8
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<style type="text/css">
    table.dataTable tbody tr:nth-child(odd) td:nth-child(6),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(7),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(8),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(9),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(10){
        background-color:#E0EEE0;
    }
    table.dataTable tbody tr:nth-child(even) td:nth-child(2),
    table.dataTable tbody tr:nth-child(even) td:nth-child(3),
    table.dataTable tbody tr:nth-child(even) td:nth-child(4),
    table.dataTable tbody tr:nth-child(even) td:nth-child(5),
    table.dataTable tbody tr:nth-child(even) td:nth-child(6){
        background-color:#E0EEE0;
    }

    table.dataTable tbody tr:nth-child(odd) td:nth-child(11),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(12),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(13),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(14),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(15){
        background-color: #FFF8DC;
    }
    table.dataTable tbody tr:nth-child(even) td:nth-child(7),
    table.dataTable tbody tr:nth-child(even) td:nth-child(8),
    table.dataTable tbody tr:nth-child(even) td:nth-child(9),
    table.dataTable tbody tr:nth-child(even) td:nth-child(10),
    table.dataTable tbody tr:nth-child(even) td:nth-child(11){
        background-color: #FFF8DC;
    }

    table.dataTable tbody tr:nth-child(odd) td:nth-child(16),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(17),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(18),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(19),
    table.dataTable tbody tr:nth-child(odd) td:nth-child(20){
        background-color: #E0FFFF;
    }
    table.dataTable tbody tr:nth-child(even) td:nth-child(12),
    table.dataTable tbody tr:nth-child(even) td:nth-child(13),
    table.dataTable tbody tr:nth-child(even) td:nth-child(14),
    table.dataTable tbody tr:nth-child(even) td:nth-child(15),
    table.dataTable tbody tr:nth-child(even) td:nth-child(16){
        background-color: #E0FFFF;
    }


</style>
<c:if test="${type eq '1' && admin eq '1'}">
    <navigation:header title="生产计划管理" backTitleArray="合同管理"
                       backUrlArray="${ctx}/TSC10004/init"></navigation:header>
</c:if>
<c:if test="${type eq '1' && admin eq null}">
    <navigation:header title="生产计划管理" backTitleArray="合同管理"
                       backUrlArray="${ctx}/TSC20001/init/${type}"></navigation:header>
</c:if>
<c:if test="${type eq '2' && admin eq '2'}">
    <navigation:header title="待运计划管理" backTitleArray="合同管理"
                       backUrlArray="${ctx}/TSC10004/init"></navigation:header>
</c:if>
<c:if test="${type eq '2' && admin==null}">
    <navigation:header title="待运计划管理" backTitleArray="合同管理"
                       backUrlArray="${ctx}/TSC20001/init/${type}"></navigation:header>
</c:if>
<c:if test="${type eq '3' && admin eq '3'}">
    <navigation:header title="交货计划管理" backTitleArray="合同管理"
                       backUrlArray="${ctx}/TSC10004/init"></navigation:header>
</c:if>
<c:if test="${type eq '3' && admin == null}">
    <navigation:header title="交货计划管理" backTitleArray="合同管理"
                       backUrlArray="${ctx}/TSC20001/init/${type}"></navigation:header>
</c:if>
<div class="page-content list-page">
    <div>
        <table width="100%">
            <tr>
                <td align="right">分销月度：</td>
                <td align="left">
                    <select>
                        <option selected="selected">2016-07</option>
                        <option>2016-08</option>
                    </select>
                </td>
                <td align="right">物流区：</td>
                <td align="left">
                    <select>
                        <option selected="selected">上海</option>
                    </select>
                </td>
                <td align="right">供应商：</td>
                <td align="left">
                    <select>
                        <option selected="selected">山东荣达农业发展有限公司</option>
                    </select>
                </td>
            </tr>
        </table>
    </div>
    <div class="group-accordion" active="true" collapsible="true">
        <h3>
            <label>生产计划管理</label>
        </h3>

        <div>

            <table width="100%" class="dataTable no-footer" style="border-collapse: collapse" bgcolor="#a52a2a">
                <thead>
                <tr>
                    <th rowspan="2">一级分类</th>
                    <th rowspan="2">二级分类</th>
                    <th rowspan="2">品种名称</th>
                    <th rowspan="2">特征</th>
                    <th rowspan="2"></th>
                    <th colspan="10">2016年6月</th>
                    <th colspan="5">2016年7月</th>
                    <th rowspan="2">合计</th>
                    <th rowspan="2">需求总量</th>
                </tr>
                <tr>
                    <th>21</th>
                    <th>22</th>
                    <th>23</th>
                    <th>24</th>
                    <th>25</th>
                    <th>26</th>
                    <th>27</th>
                    <th>28</th>
                    <th>29</th>
                    <th>30</th>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                    <th>4</th>
                    <th>5</th>
                </tr>
                </thead>
                <tbody>
                <tr bgcolor="#a52a2a">
                    <td rowspan="2"></td>
                    <td rowspan="2"></td>
                    <td rowspan="2"></td>
                    <td rowspan="2"></td>
                    <td>计划</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>900</td>
                    <td>900</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>900</td>
                    <td>900</td>
                </tr>
                <tr>
                    <td rowspan="2">鸭产品</td>
                    <td rowspan="2">分割品</td>
                    <td rowspan="2">带皮鸭胸</td>
                    <td rowspan="2">220-240g</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td rowspan="2">鸭产品</td>
                    <td rowspan="2">副产品</td>
                    <td rowspan="2">鸭胗</td>
                    <td rowspan="2">220-240g</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td rowspan="2">鸭产品</td>
                    <td rowspan="2">分割品</td>
                    <td rowspan="2">鸭锁骨</td>
                    <td rowspan="2">220-240g</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div
            <c:if test="${type eq '1'}">hidden="hidden"</c:if> class="group-accordion" active="true" collapsible="true">
        <h3>
            <label>待运计划管理</label>
        </h3>

        <div>

            <table width="100%" class="dataTable no-footer">
                <thead>
                <tr>
                    <th rowspan="2">一级分类</th>
                    <th rowspan="2">二级分类</th>
                    <th rowspan="2">品种名称</th>
                    <th rowspan="2">特征</th>
                    <th rowspan="2"></th>
                    <th colspan="10">2016年6月</th>
                    <th colspan="5">2016年7月</th>
                    <th rowspan="2">合计</th>
                    <th rowspan="2">需求总量</th>
                </tr>
                <tr>
                    <th>21</th>
                    <th>22</th>
                    <th>23</th>
                    <th>24</th>
                    <th>25</th>
                    <th>26</th>
                    <th>27</th>
                    <th>28</th>
                    <th>29</th>
                    <th>30</th>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                    <th>4</th>
                    <th>5</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td rowspan="2"></td>
                    <td rowspan="2"></td>
                    <td rowspan="2"></td>
                    <td rowspan="2"></td>
                    <td>计划</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>900</td>
                    <td>900</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>60</td>
                    <td>900</td>
                    <td>900</td>
                </tr>
                <tr>
                    <td rowspan="2">鸭产品</td>
                    <td rowspan="2">分割品</td>
                    <td rowspan="2">带皮鸭胸</td>
                    <td rowspan="2">220-240g</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td rowspan="2">鸭产品</td>
                    <td rowspan="2">副产品</td>
                    <td rowspan="2">鸭胗</td>
                    <td rowspan="2">220-240g</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td rowspan="2">鸭产品</td>
                    <td rowspan="2">分割品</td>
                    <td rowspan="2">鸭锁骨</td>
                    <td rowspan="2">220-240g</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div
            <c:if test="${type eq '1'||type eq '2'}">hidden="hidden"</c:if> class="group-accordion" active="true"
            collapsible="true">
        <h3>
            <label>交货计划管理</label>
        </h3>

        <div>

            <table width="100%" class="dataTable no-footer">
                <thead>
                <tr>
                    <th rowspan="2">一级分类</th>
                    <th rowspan="2">二级分类</th>
                    <th rowspan="2">品种名称</th>
                    <th rowspan="2">特征</th>
                    <th rowspan="2"></th>
                    <th colspan="10">2016年6月</th>
                    <th colspan="5">2016年7月</th>
                    <th rowspan="2">合计</th>
                    <th rowspan="2">需求总量</th>
                </tr>
                <tr>
                    <th>21</th>
                    <th>22</th>
                    <th>23</th>
                    <th>24</th>
                    <th>25</th>
                    <th>26</th>
                    <th>27</th>
                    <th>28</th>
                    <th>29</th>
                    <th>30</th>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                    <th>4</th>
                    <th>5</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td rowspan="2">鸡产品</td>
                    <td rowspan="2">白条鸡</td>
                    <td rowspan="2">白条肉鸡</td>
                    <td rowspan="2">1kg/只(10只)</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td rowspan="2">鸡产品</td>
                    <td rowspan="2">分割品</td>
                    <td rowspan="2">鸡边腿</td>
                    <td rowspan="2">大边腿</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td rowspan="2">鸡产品</td>
                    <td rowspan="2">分割品</td>
                    <td rowspan="2">鸡排腿</td>
                    <td rowspan="2">250-300g</td>
                    <td>计划</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>实际</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td class="editable1">20</td>
                    <td>300</td>
                    <td>300</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div><msk:button buttonValue="保存" buttonId="TSC20011.SAVE" buttonType="button"/></div>
</div>
<script src="${ctx}/js/ds/TSC20011.js"></script>
