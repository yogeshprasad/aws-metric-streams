package com.kinesis.util;

import java.util.HashMap;
import java.util.List;

public class KinesisPayLoad {
  String requestId;
  Long timestamp;
  List<HashMap<String, String>> records;

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public List<HashMap<String, String>> getRecords() {
    return records;
  }

  public void setRecords(List<HashMap<String, String>> records) {
    this.records = records;
  }
}
