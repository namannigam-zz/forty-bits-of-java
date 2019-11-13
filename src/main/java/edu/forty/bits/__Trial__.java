package edu.forty.bits;

import lombok.*;
import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;
import java.util.stream.*;

public class __Trial__ {

  public Map<String, DoubleSummaryStatistics> createStats(Map<String, List<Runner>> times) {
    return times.entrySet().stream()
        .collect(
            Collectors.toMap(
                Map.Entry::getKey,
                e ->
                    e.getValue().stream()
                        .map(Runner::getTime)
                        .mapToDouble(LocalTime::toSecondOfDay)
                        .summaryStatistics()));
  }

  @Getter
  @AllArgsConstructor
  static class Runner {
    private Integer lap;
    private LocalTime time;
  }
}