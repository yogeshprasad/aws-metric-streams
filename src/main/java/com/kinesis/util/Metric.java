package com.kinesis.util;

/*
  This represents:
  {"metric_stream_name":"yogi-test-stream","account_id":"368241472902","region":"us-west-2","namespace":"AWS/EC2","metric_name":"NetworkOut",
  "dimensions":{"ImageId":"ami-07be7092831897fd6"},"timestamp":1621596360000,"value":{"count":3.0,"sum":1213090.0,"max":551729.0,"min":214220.0},"unit":"Bytes"}
 */
import java.util.HashMap;

public class Metric {
  private String metric_stream_name;
  private Long account_id;
  private String region;
  private String namespace;
  private String metric_name;
  private HashMap<String, String> dimensions;
  private Long timestamp;
  private HashMap<String, Double> value;
  private String unit;

  public String getMetric_stream_name() {
    return metric_stream_name;
  }

  public void setMetric_stream_name(String metric_stream_name) {
    this.metric_stream_name = metric_stream_name;
  }

  public Long getAccount_id() {
    return account_id;
  }

  public void setAccount_id(Long account_id) {
    this.account_id = account_id;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public String getMetric_name() {
    return metric_name;
  }

  public void setMetric_name(String metric_name) {
    this.metric_name = metric_name;
  }

  public HashMap<String, String> getDimensions() {
    return dimensions;
  }

  public void setDimensions(HashMap<String, String> dimensions) {
    this.dimensions = dimensions;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public HashMap<String, Double> getValue() {
    return value;
  }

  public void setValue(HashMap<String, Double> value) {
    this.value = value;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }
  @Override
  public String toString() {
    return metric_stream_name + " " + account_id + " " + region +
        " " + namespace + " " + " " + metric_name + " " + timestamp + " " +
        unit + " " + dimensions + " " + value;
  }
}
