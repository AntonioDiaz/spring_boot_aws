<h1>POC Spring Boot and AWS</h1>

<!-- TOC -->
  * [Links](#links)
<!-- TOC -->
* Shows a list of all object of a S3 bucket.
![image](https://github.com/AntonioDiaz/spring_boot_aws/assets/725743/b8fbbb52-c090-49ae-aba7-ce4b76728777)

## Links
[Getting started with Spring Boot on AWS](https://aws.amazon.com/blogs/opensource/getting-started-with-spring-boot-on-aws-part-1/)    
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
