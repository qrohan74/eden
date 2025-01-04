JSON example
============

```json
{
  "name": "TM_PACKET_EXAMPLE",
  "type": "container",
  "description": "Example of telemetry packet contents",
  "fields": [
    {
      "name": "packetId",
      "description": "packet identifier",
      "type": "parameter",
      "length": 32
    },
    {
      "name": "timeCoarse",
      "description": "external time",
      "type": "parameter",
      "length": 32,
      "unit": "s"
    },
    {
      "name": "timeFine",
      "description": "external time fractional",
      "type": "parameter",
      "length": 16,
      "unit": "2^-16s"
    },
    {
      "name": "spare1",
      "description": "-",
      "type": "parameter",
      "length": 7
    },
    {
      "name": "coordinateSystem",
      "description": "defines if packet contains cartesian or spherical",
      "type": "parameter",
      "length": 1
    },
    {
      "name": "numberOfImages",
      "description": "number of images contained in the packet",
      "type": "parameter",
      "length": 8,
      "multiplierOf": "image"
    },
    {
      "name": "image",
      "description": "image data cartesian / spherical",
      "type": "container",
      "multipliedBy": "numberOfImages",
      "fields": [
        {
          "name": "imageId",
          "description": "image identifier",
          "type": "parameter",
          "length": 8
        },
        {
          "name": "quality",
          "description": "Overall image quality",
          "type": "parameter",
          "length": 8
        },
        {
          "name": "timeTagRelative",
          "description": "Time information relative to image shooting",
          "type": "parameter",
          "length": 16,
          "unit": "0.001s"
        },
        {
          "name": "x",
          "description": "Cartesian coordinate X",
          "type": "parameter",
          "length": 24,
          "unit": "0.001m"
        },
        {
          "name": "y",
          "description": "Cartesian coordinate Y",
          "type": "parameter",
          "length": 24,
          "unit": "0.001m"
        },
        {
          "name": "z",
          "description": "Cartesian coordinate Z",
          "type": "parameter",
          "length": 24,
          "unit": "0.001m"
        },
        {
          "name": "spare2",
          "description": "-",
          "type": "parameter",
          "length": 8
        }
      ]
    }
  ]
}
```