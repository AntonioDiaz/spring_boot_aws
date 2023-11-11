<h1>POC Spring Boot and AWS</h1>

<!-- TOC -->
  * [Functionalities](#functionalities)
  * [Links](#links)
  * [Parameter Store](#parameter-store)
<!-- TOC -->

## Functionalities
* Display content of an **S3** bucket with Thymeleaf.
* Subscribe to an **SQS** queue.
* Externalize the configuration of our application using the **Parameter Store**.

![image](https://github.com/AntonioDiaz/spring_boot_aws/assets/725743/b8fbbb52-c090-49ae-aba7-ce4b76728777)

## Links

[Getting started with Spring Boot on AWS (part 1)](https://aws.amazon.com/blogs/opensource/getting-started-with-spring-boot-on-aws-part-1/)  
[Getting started with Spring Boot on AWS (part 2)](https://aws.amazon.com/blogs/opensource/getting-started-with-spring-boot-on-aws-part-2/)  
[GitHub Spring Cloud AWS](https://github.com/awspring/spring-cloud-aws)  
[AWS Spring Reference](https://docs.awspring.io/spring-cloud-aws/docs/3.0.3/reference/html/index.html)  

* Make bucket public policy
```
{
    "Version": "2008-10-17",
    "Id": "policy_public_objects",
    "Statement": [
        {
            "Sid": "1",
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:GetObject",
            "Resource": "arn:aws:s3:::testing-cloud-front-adiaz/*"
        }
    ]
}
```

## Parameter Store
https://docs.awspring.io/spring-cloud-aws/docs/3.0.3/reference/html/index.html#spring-cloud-aws-parameter-store

* Add dependence to pom.xml:
```xml
<dependency>
    <groupId>io.awspring.cloud</groupId>
    <artifactId>spring-cloud-aws-starter-parameter-store</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```
* Add property:
````properties
spring.config.import=optional:aws-parameterstore:/my-app/dev
````
* Create the parameter: 
![image](https://github.com/AntonioDiaz/spring_boot_aws/assets/725743/afadb8d1-4f89-4176-b0c0-07a9e16cbfe9)
