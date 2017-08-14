﻿<?xml version="1.0" encoding="utf-8"?>
<DATACOLLECTION>
    <DATA>
        <RECEIPT>${(entity.receipt)!''}</RECEIPT>
        <NOTES>${(entity.notes)!''}</NOTES>
        <SCHEDULEDDATE>${(entity.scheduledDate)!''}</SCHEDULEDDATE>
        <STARTRECEIPTDATE>${(entity.startReceiptDate)!''}</STARTRECEIPTDATE>
        <LINES>
            <#list entity.detailList as field>
                <LINE>
                    <RECEIPTLINE>${(field.receiptLine)!''}</RECEIPTLINE>
                    <CONSIGNEE>0000000</CONSIGNEE>
                    <NAME>神农客</NAME>
                    <AREA>${(field.area)!''}</AREA>
                    <COMPANY>${(field.consignee)!''}</COMPANY>
                    <COMPANYTYPE>SUPPLY</COMPANYTYPE>
                    <COMPANYNAME>${(field.companyName)!''}</COMPANYNAME>
                    <SKU>${(field.sku)!''}</SKU>
                    <SKUDESC>${(field.skuDesc)!''}</SKUDESC>
                    <SKUGROUP>${(field.skuGroup)!''}</SKUGROUP>
                    <GROUPNAME>${(field.groupName)!''}</GROUPNAME>
                    <UOM>${(field.uom)!''}</UOM>
                    <GROSSWEIGHT>${(field.grossWeight)!''}</GROSSWEIGHT>
                    <NETWEIGHT>${(field.netWeight)!''}</NETWEIGHT>
                    <LENGTH>${(field.length)!''}</LENGTH>
                    <WIDTH>${(field.width)!''}</WIDTH>
                    <HEIGHT>${(field.height)!''}</HEIGHT>
                    <VOLUME>${(field.volume)!''}</VOLUME>
                    <QTYEXPECTED>${(field.qtyExpected)!''}</QTYEXPECTED>
                    <QTYORIGINAL>${(field.qtyOriginal)!''}</QTYORIGINAL>
                    <INVENTORYSTATUS>AVAILABLE</INVENTORYSTATUS>
                    <ATTRIBUTES />
                </LINE>
            </#list>
        </LINES>
    </DATA>
</DATACOLLECTION>
