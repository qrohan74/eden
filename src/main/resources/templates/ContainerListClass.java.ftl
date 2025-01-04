<#import "ContainerClass.java.ftl" as c>
<#macro declare container indent=0 isStatic=false>
    <@c.declare container=container indent=indent isStatic=isStatic/>
    <#local padding = ""?left_pad(4*indent)/>
${padding}/**
${padding} * Class ${container.name?cap_first}List
${padding} * This represents a list of containers: ${container.name}
${padding} * Description: ${container.description}
${padding} */
${padding}public <#if isStatic == true>static </#if>class ${container.name?cap_first}List extends ContainerList<${container.name?cap_first}>
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
${padding}    public ${container.name?cap_first}List(String name, Container parent)
${padding}    {
${padding}        super(name, parent, ${container.name?cap_first}.class);
${padding}    }
${padding}
${padding}    // --- END CONSTRUCTORS/DESTRUCTORS ---
${padding}
${padding}    // --- BEGIN FIELDS METHODS ---
${padding}
${padding}    // --- END FIELDS METHODS ---
${padding}} // END OF CLASS ${container.name?cap_first}List

</#macro>