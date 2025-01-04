<#macro declare param indent=0 isStatic=false>
    <#local padding = ""?left_pad(4*indent)/>
${padding}/**
${padding} * Class ${param.name?cap_first}
${padding} * This represents the parameter: ${param.name}
${padding} * Description: ${param.description}
${padding} */
${padding}public <#if isStatic == true>static </#if>class ${param.name?cap_first} extends Parameter
${padding}{
${padding}    /**
${padding}     * parameter length (in bits)
${padding}     */
${padding}    public static final int length = ${param.length};
${padding}
${padding}    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
${padding}
${padding}    /**
${padding}     * Default constructor
${padding}     * @param name field name
${padding}     * @param parent parent container holding this field
${padding}     */
${padding}    public ${param.name?cap_first}(String name, Container parent)
${padding}    {
${padding}        super(name, parent);
<#if param.default??>
${padding}
${padding}        // set default value
${padding}        this.set(${param.default});
</#if>
${padding}    }
${padding}
${padding}    // --- END CONSTRUCTORS/DESTRUCTORS ---
${padding}
${padding}    // --- BEGIN ABSTRACT FIELD METHODS ---
${padding}
${padding}    /**
${padding}     * Get length
${padding}     * @return the length (in bits) of the parameter
${padding}     */
${padding}    public int getLength()
${padding}    {
${padding}        return length;
${padding}    }
${padding}
${padding}    // --- END ABSTRACT FIELD METHODS ---
${padding}
${padding}} // END OF CLASS ${param.name?cap_first}

</#macro>