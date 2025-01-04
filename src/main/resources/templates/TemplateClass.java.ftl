package ${package};

import qrohan.eden.core.stream.*;

<#import "ParameterClass.java.ftl" as p>
<#import "ParameterListClass.java.ftl" as pl>
<#import "ContainerClass.java.ftl" as c>
<#import "ContainerListClass.java.ftl" as cl>
<#import "BufferClass.java.ftl" as b>
<#if type == "parameter">
    <#if multipliedBy??>
        <@pl.declare param=.data_model indent=0/>
    <#else>
        <@p.declare param=.data_model indent=0/>
    </#if>
<#elseif type == "container">
    <#if multipliedBy??>
        <@cl.declare container=.data_model indent=0/>
    <#else>
        <@c.declare container=.data_model indent=0/>
    </#if>
<#elseif type == "buffer">
    <@b.declare buffer=.data_model indent=0/>
</#if>