optional class have methods like
1. orElse() = takes single object and if a method call is there and container object is null it still executes the method
2. orElseGet() = takes supplier object(lambda expression) and if container object is null then only executes the supplier
3. orElseThrow() = takes supplier object (lambda expression) to throw some custom or user-friendly exception