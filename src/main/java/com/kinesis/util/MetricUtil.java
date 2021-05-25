package com.kinesis.util;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MetricUtil {
  private static final Logger logger =
      Logger.getLogger(MetricUtil.class.getCanonicalName());

  public static List<Metric> getMetricObject(List<String> metricStringList) {

    List<Metric> metrics = new ArrayList<>();
    Gson gson = new Gson();
    for (String var : metricStringList) {
      metrics.add(gson.fromJson(var, Metric.class));
    }
    return metrics;
  }
}
