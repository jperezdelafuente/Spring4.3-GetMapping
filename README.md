# Demo project for new feature @GetMapping since Spring 4.3

@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).

## Create package:
- mvn package

## Check Cobertura:
- target\site\jacoco\index.html

## Execute app:
- java -jar target\getmapping-0.0.1-SNAPSHOT.jar

## Testing @GetMapping
### For reception a http parameter, without using: @RequestParam
- Invoke: http://localhost:8080/personGetMappingById?id=1

### For reception several http parameters, without using: @RequestParam
- Invoke: http://localhost:8080/personGetMapping?name=Pepe&surname=Garcia

### For reception a http path variable, using: @PathVariable
- Invoke: http://localhost:8080/personGetMappingPath/1

### For reception a http path variable, using: @ModelAttribute
- Invoke: http://localhost:8080/personGetMappingPathWithModelAttribute/1

## Testing @RequestMapping
### For reception a http parameter, without using: @RequestParam
- Invoke: http://localhost:8080/personRequestMappingById?id=1

### For reception several http parameters, without using: @RequestParam
- Invoke: http://localhost:8080/personRequestMapping?name=Pepe&surname=Garcia

### For reception the http path variable, using: @PathVariable
- Invoke: http://localhost:8080/personRequestMappingPath/1

### For reception a http path variable, using: @ModelAttribute
- Invoke: http://localhost:8080/personRequestMappingPathWithModelAttribute/1