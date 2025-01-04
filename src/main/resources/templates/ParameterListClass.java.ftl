<#import "ParameterClass.java.ftl" as p>
<#macro declare param indent=0 isStatic=false>
    <@p.declare param=param indent=indent isStatic=isStatic/>
    <#local padding = ""?left_pad(4*indent)/>
${padding}/**
${padding} * Class ${param.name?cap_first}List
${padding} * This represents a list of parameters: ${param.name}
${padding} * Description: ${param.description}
${padding} */
${padding}public <#if isStatic == true>static </#if>class ${param.name?cap_first}List extends ParameterList<${param.name?cap_first}>
${padding}{
${padding}    // --- BEGIN FIELDS ---
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
${padding}    public ${param.name?cap_first}List(String name, Container parent)
${padding}    {
${padding}        super(name, parent, ${param.name?cap_first}.class);
${padding}    }
${padding}
${padding}    // --- END CONSTRUCTORS/DESTRUCTORS ---
${padding}
${padding}    // --- BEGIN FIELDS METHODS ---
${padding}
${padding}    // --- END FIELDS METHODS ---
${padding}} // END OF CLASS ${param.name?cap_first}List

</#macro>