## Tips

1. For implementation of tests next statements was taken as true:
 - count and values of available insurance plan could not be changed and it actual for all days 
 - default params on main page include Hong Kong as default trip destination  
2. verifying of tests base on count of results (in most of cases), it's not good design for real tests it should be verify values on card or on different available params
3. Implementations of the next custom elements like Calendar DropDown and RangeSlider is not enough for real test, but enough for test task
4. Implementation test was made only for Chrome browser (latest version) for any operation systems
5. ass test reporter i took basic surefire, coz different companies use different test reporters and it is not so hard to include some custom reporter if it needed 
6. test plan is not clear coz i don't know ur test strategy, test priority and etc. and it can not be useful also i don't know about ur CI/CD process

## framework contains from next base modules 
1. test package - contains tests scenarios
2. pages package - contains pages by POM model
3. elements package - contains custom elements
4. base package - contains all additional methods 

## how to run
1. u should have Java 11
2. u should have Maven 
3. run `mvn test`

## which tools was used
- testNG - as test framework
- PageFactory
- java 11
- surefire plugin
- selenium


 

