<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="供应商详细信息" backTitleArray="供应商一览" backUrlArray=""></navigation:header>
<style type="text/css">
    #aa .border tr td {
        border: 0;
    }
</style>
<div class="page-content detail-page" style="margin-top:35px;" id="aa">
    <div class="group-accordion" collapsible="true" active="false">
        <h3 style="position: relative">
            <label>供应商基本信息</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="width: 100%" border="0">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>营业执照</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" frame="void" class="border">
                            <tr>
                                <td width="20%">名称：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>营业执照注册号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>住所：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>经营类型：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td> 经营范围：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>法人代表：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>注册资本：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>实收资本：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>成立日期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>营业期限：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>税务登记证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%"> 税务登记证号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>一般增值纳税人资格认定：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>组织代码证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">代码：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>银行开户许可证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">法定代表人：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>开户银行：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td> 账号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br/>
            <msk:button buttonValue="保存" buttonId="TSC300121.SAVE" buttonType="button"/>
        </form>
    </div>


    <div class="group-accordion" collapsible="true" active="false" id="">
        <h3 style="position: relative">
            <label>供应商专业资质</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>动物防疫条件合格证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">证号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>有效期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>畜禽定点屠宰证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">批准号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>定点屠宰代码：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>全国工业产品生产许可证(QS证)</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">证书编号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>有效期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>ISO14001环境管理体系认证证书</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">注册号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>认证标准：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>认证范围：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>有效期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>认证机构：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>清真食品生产经营许可证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">证书编号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>商检证书号码：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>签发日期及截止日期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>签发机构：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>进沪证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">单位名称：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>单位名称：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>登记日期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br>
            <msk:button buttonValue="保存" buttonId="TSC300122.SAVE" buttonType="button"/>
        </form>
    </div>


    <div class="group-accordion" collapsible="true" active="false" id="">
        <h3 style="position: relative">
            <label>企业基本能力描述</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>企业荣誉</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%"> 发证日期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>发证单位</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>荣誉描述</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>厂房平面图</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">总资产：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>占地面积：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td> 厂房面积：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>主要设备：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>设计产能：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td> 实际产能：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>外贸销售占比：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>直销占比：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td> 代理占比：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>全国工业产品生产许可证(QS证)</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">证书编号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>有效期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>ISO14001环境管理体系认证证书</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">注册号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>认证标准：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>认证范围：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>有效期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>认证机构：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>清真食品生产经营许可证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">证书编号：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>商检证书号码：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>签发日期及截止日期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>签发机构：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>进沪证</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">单位名称：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>品种：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>登记日期：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br>
            <msk:button buttonValue="保存" buttonId="TSC300123.SAVE" buttonType="button"/>
        </form>
    </div>


    <div class="group-accordion" collapsible="true" active="false" id="">
        <h3 style="position: relative">
            <label>企业生产车间、设备、产品工艺流程描述</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>车间概括</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">车间名称：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>生产产品：</td>
                                <td>
                                    <input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>工艺流程特点</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>库容概括</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">原料库容：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>成品库容：</td>
                                <td>
                                    <input type="text" value=""/></td>
                            </tr>
                        </table>
                </tr>
            </table>
            <br>
            <msk:button buttonValue="保存" buttonId="TSC300124.SAVE" buttonType="button"/>
        </form>
    </div>


    <div class="group-accordion" collapsible="true" active="false" id="">
        <h3 style="position: relative">
            <label>企业实验室、检测设备及产品质量控制系统描述</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>实验室</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">面积：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>功能：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>投资：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>人员数量：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>厂房平面图</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%"> 总资产：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>占地面积：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>厂房面积：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>主要设备：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>设计产能：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>实际产能：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>外贸销售占比：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>直销占比：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>代理占比：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>检测设备</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">主要设备及用途：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>

                </tr>
                <tr>
                    <td>品控组织架构</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>质量控制系统图</td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <br>
            <msk:button buttonValue="保存" buttonId="TSC300125.SAVE" buttonType="button"/>
        </form>
    </div>


    <div class="group-accordion" collapsible="true" active="false" id="">
        <h3 style="position: relative">
            <label>检测设备描述</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>检测设备</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">设备名称：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>设备用途：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br/>
            <msk:button buttonValue="保存" buttonId="TSC300126.SAVE" buttonType="button"/>
        </form>
    </div>


    <div class="group-accordion" collapsible="true" active="false" id="">
        <h3 style="position: relative">
            <label>企业管理团队描述</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>公司总经理</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">姓名：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>年龄：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>联系方式：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>文化程度：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br>
            <msk:button buttonValue="保存" buttonId="TSC300127.SAVE" buttonType="button"/>
        </form>
    </div>


    <div class="group-accordion" collapsible="true" active="false" id="">
        <h3 style="position: relative">
            <label>企业电商团队描述</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>电商团队负责人</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">姓名：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>年龄：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>文化程度：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>联系方式：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br>
            <msk:button buttonValue="保存" buttonId="TSC300128.SAVE" buttonType="button"/>
        </form>
    </div>


    <div class="group-accordion" collapsible="true" active="false" id="">
        <h3 style="position: relative">
            <label>企业产品品牌描述</label>
        </h3>

        <form action="" method="post">
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <thead>
                <tr align="center" style="background:#DBDBDB">
                    <th width="15%">证照</th>
                    <th width="25%">图片</th>
                    <th width="60%">资质</th>
                </tr>
                </thead>
                <tr>
                    <td>品牌证书</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%" >品牌名称：
                                </td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>商标注册证：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>所属企业：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>包装图片</td>
                    <td></td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td>品牌荣誉</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">证书编码：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>发证单位：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>发证时间：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>品牌证书</td>
                    <td></td>
                    <td>
                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">品牌名称：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>商标注册证：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>所属企业：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>包装图片</td>
                    <td></td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td>品牌荣誉</td>
                    <td></td>
                    <td>

                        <table style="width:100%;" border="0" rules="none" frame="void" class="border">
                            <tr>
                                <td width="20%">证书编码：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>发证单位：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                            <tr>
                                <td>发证时间：</td>
                                <td><input type="text" value=""/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br/>
            <msk:button buttonValue="保存" buttonId="TSC300129.SAVE" buttonType="button"/>
        </form>
    </div>
</div>
