Demo project for new feature @GetMapping since Spring 4.3

@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).

Create package:
- mvn package

Check Cobertura:
- target\site\jacoco\index.html

Execute app:
- java -jar target\getmapping-0.0.1-SNAPSHOT.jar

Testing @GetMapping for reception the http parameters, without using: @RequestParam
- Invoke: http://localhost:8080/personGetMapping?name=Pepe&surname=Garcia

Testing @GetMapping for reception the http parameters, without using: @RequestParam
- Invoke: http://localhost:8080/personRequestMapping?name=Pepe&surname=Garcia