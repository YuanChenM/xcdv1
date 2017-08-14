<?xml version="1.0" encoding="UTF-8"?>
<xmlTests>
<#list entity as field>
        <xmlTest>
        <age>${field.age}</age>
        <id>${field.id}</id>
        </xmlTest>
</#list>
</xmlTests>