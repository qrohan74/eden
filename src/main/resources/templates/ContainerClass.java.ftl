<#import "ParameterClass.java.ftl" as p>
<#import "ParameterListClass.java.ftl" as pl>
<#import "ContainerListClass.java.ftl" as cl>
<#import "BufferClass.java.ftl" as b>
<#macro declare container indent=0 isStatic=false>
    <#local padding = ""?left_pad(4*indent)/>
${padding}/**
${padding} * Class ${container.name?cap_first}
${padding} * This represents the container: ${container.name}
${padding} * Description: ${container.description}
${padding} */
${padding}public <#if isStatic == true>static </#if>class ${container.name?cap_first} extends Container
${padding}{
    <#list container.fields as field>
        <#if field.type == "parameter">
            <#if field.multipliedBy??>
                <@pl.declare param=field indent=indent+1 isStatic=true/>
            <#else>
                <@p.declare param=field indent=indent+1 isStatic=true/>
            </#if>
        <#elseif field.type == "container">
            <#if field.multipliedBy??>
                <@cl.declare container=field indent=indent+1 isStatic=true/>
            <#else>
                <@declare container=field indent=indent+1 isStatic=true/>
            </#if>
        <#elseif field.type == "buffer">
            <@b.declare buffer=field indent=indent+1 isStatic=true/>
        </#if>
    </#list>
${padding}    // --- BEGIN FIELDS ---
${padding}
    <#list container.fields as field>
${padding}    /**
${padding}     * field ${field.name}
${padding}     * Description: ${field.description}
${padding}     */
${padding}    ${field.name?cap_first}<#if field.multipliedBy??>List</#if> ${field.name};
${padding}
    </#list>
${padding}
${padding}    // --- END FIELDS ---
${padding}
${padding}    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
${padding}
${padding}    /**
${padding}     * Default constructor
${padding}     * @param name field name
${padding}     * @param parent parent container holding this field
${padding}     */
${padding}    public ${container.name?cap_first}(String name, Container parent)
${padding}    {
${padding}        super(name, parent);
<#list container.fields as field>
${padding}        this.${field.name} = new ${field.name?cap_first}<#if field.multipliedBy??>List</#if>("${field.name}", this);
</#list>
${padding}
<#list container.fields as field>
    <#if field.type == "parameter" && field.multiplierOf??>
${padding}        // ${field.name} multiplies ${field.multiplierOf}
${padding}        this.${field.name}.setFactor(this.${field.multiplierOf});
    </#if>
</#list>
${padding}    }
${padding}
${padding}    // --- END CONSTRUCTORS/DESTRUCTORS ---
${padding}
${padding}    // --- BEGIN FIELDS METHODS ---
${padding}
<#list container.fields as field>
    <#if field.type == "parameter">
        <#if field.multipliedBy??>
${padding}    /**
${padding}     * Get value of parameter ${field.name} at index
${padding}     * @param index list index
${padding}     * @return value of parameter
${padding}     */
${padding}    public long get_${field.name}(int index)
${padding}    {
${padding}        return this.${field.name}.getAt(index);
${padding}    }
${padding}
${padding}    /**
${padding}     * Set value of parameter ${field.name} at index
${padding}     * @param index list index
${padding}     * @param value new value
${padding}     */
${padding}    public void set_${field.name}(int index, long value)
${padding}    {
${padding}        this.${field.name}.setAt(index, value);
            <#if field.multiplierOf??>
${padding}        // a parameter should not be multiplied and multiplier at the same time, right?
            </#if>
${padding}    }
${padding}
        <#else>
${padding}    /**
${padding}     * Get value of parameter ${field.name}
${padding}     * @return value of parameter
${padding}     */
${padding}    public long get_${field.name}()
${padding}    {
${padding}        return this.${field.name}.get();
${padding}    }
${padding}
${padding}    /**
${padding}     * Set value of parameter ${field.name}
${padding}     * @param value new value
${padding}     */
${padding}    public void set_${field.name}(long value)
${padding}    {
${padding}        this.${field.name}.set(value);
${padding}    }
${padding}
        </#if>
    <#elseif field.type == "container">
        <#if field.multipliedBy??>
${padding}    /**
${padding}     * Get value of container ${field.name} at index
${padding}     * @param index list index
${padding}     * @return container
${padding}     */
${padding}    public ${field.name?cap_first} get_${field.name}(int index)
${padding}    {
${padding}        return this.${field.name}.getAt(index);
${padding}    }
${padding}
        <#else>
${padding}    /**
${padding}     * Get value of container ${field.name}
${padding}     * @return container
${padding}     */
${padding}    public ${field.name?cap_first} get_${field.name}()
${padding}    {
${padding}        return this.${field.name};
${padding}    }
${padding}
        </#if>
    <#elseif field.type == "buffer">
${padding}    /**
${padding}     * Get value of buffer ${field.name}
${padding}     * @return buffer
${padding}     */
${padding}    public ${field.name?cap_first} get_${field.name}()
${padding}    {
${padding}        return this.${field.name};
${padding}    }
${padding}
    </#if>
</#list>
${padding}    // --- END FIELDS METHODS ---
${padding}} // END OF CLASS ${container.name?cap_first}

</#macro>