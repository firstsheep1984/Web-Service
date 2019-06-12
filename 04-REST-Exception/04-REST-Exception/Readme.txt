08-Development Process

1.Create a custom error response class (StudentErrorResponse)
2.Create a custom exception class (StudentNotFoundException)
3.Update Student getStudent(@PathVariable int studentId) in StudentRestController to throw exception if student not found
4.Add an exception handler method using @ExceptionHandler in StudentRestController class


How to test the exception handler?
http://localhost:8080/04-REST-Exception/api/students/9
http://localhost:8080/04-REST-Exception/api/students/randomText