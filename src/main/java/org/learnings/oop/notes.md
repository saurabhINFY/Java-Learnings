1. Can we Override static and private methods ? 
   1. we cannot override private method as they are only accessible inside the class
   2. so if we write a same private method with name and return type same as parent it creates new method in child
   3. For static methods it cannot be overridden and if we create same static method then base class static method will be hidden (method hiding)
2. How can we make any class immutable?
   1. Declare all method as private and final.
   2. class should be final so that it cannot be extended.
   3. do not provide the setter method to change the fields directly but could have getter methods.
   4. all initialization should be done at constructor level while object creation.
3. How to Create Singleton Class ?
   1. create a private constructor.
   2. create a static final variable of class type and a static method.
   3. return the static field value from the above method.
4. what is a JIT compiler?
   1. since JVM and JRE(Interprator + JIT compiler ) are machine dependent to run the ByteCode(machine independent) on JRE only 
      interprator will slow down its performance for converting byte code to machine dependent code hence JIT compiler comes in picture.