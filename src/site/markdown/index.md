# Encode Decode ENgine (EDEN)


Eden is a template engine that allows to generate the utility classes for packet encode/decode.

The engine takes as input a JSON file representing your packet.

![eden_overview.png](img/eden_overview.png)

## Definition

In this project, the term **field** is the generic term to refer to any of these:
- a **Parameter**: the most common field, which simply represents a scalar value
- a **List of parameters**: refers to a variable series of the same parameter (each element holds its own value)
- a **Container**: refers to a container of one or several fields (eventually other containers)
- a **List of containers**: refers to a variable series of the same container
- a **Buffer**: represents a vector of bytes

A **packet** (or **stream**) is an ordered series of fields.

_Note: the elements of a list (of parameters, or of containers) are ordered as well._

The length of a list is always given by the value of the parameter that immediately precede the list. Such a parameter is called a **factor**.

![eden_overview.png](img/packet.png)

## JSON format

### Common rules

Every JSON file must respect the following rules:

- The file must be a single JSON object
- Every field must be declared in a single JSON object
- Every field must declare a **name**, a **type** and a **description**
- A field **name** must be defined:
  - without any white space
  - ideally, in camel case
- A field **type** must be a valid value among:
  - parameter
  - container
  - buffer
- A field **description** must not be blank

### Parameter

A parameter is an entry object in the JSON file declared with the type "parameter".

A parameter must respect the following rules:
- the **type** value must be "parameter"
- the parameter must declare a mandatory **length** with an integer value expressed in bits (e.g. 8 for a byte, 16 for a short, etc.)
- the following declarations are optional:
  - **default**: the default integer value of the parameter
  - **multiplierOf**: the name of the list field that this parameter multiplies
  - **multipliedBy**: the name of the parameter that is the factor of this parameter
- **multiplierOf** and **multipliedBy** must not be used together. If you want your parameter to be both a list and a factor, please wrap it into a container.

_Note: a factorized parameter declared with the key **multipliedBy** will be generated in the form of a ParameterList field._

```json
{
  "name": "param1",
  "description": "Example of simple parameter",
  "type": "parameter",
  "length": 32,
  "default": 10,
  "multiplierOf": "param2"
}
```

### Container

A container is an entry object in the JSON file declared with the type "container".

A container must respect the following rules:
- the **type** value must be "container"
- the fields of the container must be declared in a mandatory JSON array named *fields*
- the following declarations are optional:
  - **multipliedBy**: the name of the parameter that is the factor of this parameter

```json
{
  "name": "simpleContainer",
  "description": "Example of simple container",
  "type": "container",
  "fields": [
    {
      "name": "param1",
      "description": "this is param1",
      "type": "parameter",
      "length": 8
    },
    {
      "name": "param2",
      "description": "this is param2",
      "type": "parameter",
      "length": 16
    },
    {
      "name": "buffer1",
      "description": "this is buffer1",
      "type": "buffer"
    }
  ]
}
```

### Buffer

A buffer is an entry object in the JSON file declared with the type "buffer".

A buffer must respect the following rules:
- the type value must be "buffer"
- the default length (in bytes) of the buffer may be specified using the key **defaultLength**. Otherwise, the value by default is zero.

```json
{
  "name": "myBuffer",
  "description": "Example of simple buffer",
  "type": "buffer",
  "defaultLength": 5
}
```

### Lists

A reciprocal consistency is mandatory between factors and lists. That is:
- If X is declared as a factor of Y, then Y must be declared as a factorized field of X.

Moreover:
- Only a parameter can be a factor
- A buffer cannot be a list (i.e. cannot be declared with the key "multipliedBy")
- A list and its factor must be declared in the same container.
- A list cannot be the top object of a JSON file (direct consequence of the previous point).

```json
{
  "name": "paramListExample",
  "type": "container",
  "description": "Example of simple container with a list of parameters",
  "fields": [
    {
      "name": "param1",
      "description": "this is param1, it is the factor of param2 list",
      "type": "parameter",
      "length": 32,
      "multiplierOf": "param2"
    },
    {
      "name": "param2",
      "description": "this is param2, a parameter list (N x param2). Its length N is given by the value of param1",
      "type": "parameter",
      "length": 8,
      "multipliedBy": "param3"
    }
  ]
}
```