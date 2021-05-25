/**
 * Restful endpoints for dealing with Catchpoint service.
 *
 * @author Yogesh Prasad Kurmi (ykurmi@vmware.com).
 * @version 1.0
 * @since 2020-04-01
 */
package com.kinesis;

import com.kinesis.util.KinesisPayLoad;
import com.kinesis.util.Metric;
import com.kinesis.util.MetricUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class AWSMetricStreamController {
  // Logger for the this class.
  private static final Logger logger =
      Logger.getLogger(AWSMetricStreamController.class.getCanonicalName());


  @RequestMapping(value = "/Kinesis/v1", method = RequestMethod.POST)
  public ResponseEntity<Map<String, String>> processKinesisMetrics(@RequestBody KinesisPayLoad payload,
                                                                   @RequestHeader Map<String, String> headers) {
    try {
      List<String> metrics = new ArrayList<>();
      for (HashMap<String, String> data : payload.getRecords()) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
          // decode the records as they comes as Base64 encoded
          metrics.addAll(Arrays.asList(new String(Base64.getDecoder().decode(entry.getValue())).split("\n")));
        }
      }

      List<Metric> metricList = MetricUtil.getMetricObject(metrics);
      for (Metric var : metricList) {
        logger.log(Level.INFO, "Request Metric: " + var);
      }
      headers.forEach((key, value) -> {
        logger.log(Level.INFO, "Request Headers: " + key + " " + value);
      });

      // Add your business logic here to process the metrics

      // Response in success case
      return ResponseEntity.status(HttpStatus.OK)
          .body(
              new HashMap<String, String>() {
                {
                  put("requestId", payload.getRequestId());
                  put("timestamp", payload.getTimestamp().toString());
                }
              });

    } catch (Exception ex) {

      // Response in error case
      // https://docs.aws.amazon.com/firehose/latest/dev/httpdeliveryrequestresponse.html
      logger.log(Level.SEVERE, "Request Error: " + ex);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(
              new HashMap<String, String>() {
                {
                  put("requestId", payload.getRequestId());
                  put("timestamp", payload.getTimestamp().toString());
                  put("errorMessage", "Unable to deliver records due to unknown error.");
                }
              });
    }
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseEntity<Map<String, String>> serviceStatus() {
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(
            new HashMap<String, String>() {
              {
                put("status", "running");
              }
            });
  }
}
