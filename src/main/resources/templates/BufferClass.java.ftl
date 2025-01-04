<#macro declare buffer indent=0 isStatic=false>
    <#local padding = ""?left_pad(4*indent)/>
${padding}/**
${padding} * Class ${buffer.name?cap_first}
${padding} * This represents the buffer: ${buffer.name}
${padding} * Description: ${buffer.description}
${padding} */
${padding}public <#if isStatic == true>static </#if>class ${buffer.name?cap_first} extends Buffer
${padding}{
${padding}    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
${padding}
${padding}    /**
${padding}     * Default constructor
${padding}     * @param name field name
${padding}     * @param parent parent container holding this field
${padding}     */
${padding}    public ${buffer.name?cap_first}(String name, Container parent)
${padding}    {
${padding}        super(name, parent);
<#if buffer.defaultLength??>
${padding}
${padding}        // set default length
${padding}        this.setLength(${buffer.defaultLength});
</#if>
${padding}    }
${padding}
${padding}    // --- END CONSTRUCTORS/DESTRUCTORS ---
${padding}
${padding}    // --- BEGIN ABSTRACT FIELD METHODS ---
${padding}
${padding}    // --- END ABSTRACT FIELD METHODS ---
${padding}
${padding}} // END OF CLASS ${buffer.name?cap_first}

</#macro>