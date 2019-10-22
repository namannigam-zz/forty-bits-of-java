package edu.forty.bits.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByStartAndEndDate {

    @Getter
    @AllArgsConstructor
    class ReleaseTime {
        private Date startDate;
        private Date endDate;
        private List<String> regions;

        ReleaseTime mergeRegions(ReleaseTime that) {
            return new ReleaseTime(this.startDate, this.endDate,
                    Stream.concat(this.getRegions().stream(), that.getRegions().stream())
                            .collect(Collectors.toList()));
        }
    }

    public static void main(String... ar) {
        List<ReleaseTime> ungrouppedAvailabilites = List.of();
        Collection<ReleaseTime> mergedRegionsCollection = ungrouppedAvailabilites.stream()
                .collect(Collectors.toMap(t -> Arrays.asList(t.getStartDate(), t.getEndDate()),
                        Function.identity(), ReleaseTime::mergeRegions))
                .values();
    }
}
