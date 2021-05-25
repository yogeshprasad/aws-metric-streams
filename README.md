# AWS Metric Stream Processor
AWS CloudWatch  Metric Streams is a highly scalable and efficient way to gain access to all the CloudWatch Metrics.
Metric Stream delivers metrics to the Kinesis Data Firehose and then firehose takes care of delivering the metrics
to the destination. Hence we do not require a polling mechanism to receive the metrics.

This java project helps you in building an application that processes the data coming form Kinesis Data Firehose.
This application will just accept the request and print the data and headers. Definitely, this can be extended to send data
to any monitoring solutions.

## Start Application
- Clone this repository.
- Build the jar 
  `mvn clean install`
- Start the application 
  `java -jar target/kinesis-0.4-SNAPSHOT.jar`
  
## How to Use
Let say you have started this application and this is running at `http://192.134.20.31:8080`

Definitely above endpoint can not be used in the Kinesis Data Firehose you need an HTTPS endpoint, to get the HTTPS endpoint [click here](#).

After enabling the HTTPS endpoint you might have got an URL something like below:
`https://ac5ec21beef1.ngrok.io`

Configure `https://ac5ec21beef1.ngrok.io/Kinesis/v1` endpoint in the Kinesis Data Firehose and wait for some time all data will start
printing in the console like below
```aidl
2021-05-25 13:55:31.608  INFO 6472 --- [nio-9001-exec-8] com.kinesis.AWSMetricStreamController    : Request Metric: yogi-test-stream 157824852901 us-west-2 AWS/EC2  EBSReadBytes 1621950780000 Bytes {InstanceType=m5.large} {min=0.0, max=0.0, count=8.0, 
```

## How to Contribute
While following this doc if you have found any issue or any suggestions please file an github issue [here](#)  

#### !!! Cheers 😊
