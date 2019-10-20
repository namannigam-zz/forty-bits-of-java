package edu.forty.bits.functional;

public class ParallelStreamPerformance {
    /*
     * The previous installment identified several factors that might cause a parallel execution to lose efficiency:
     *
     * The source is expensive to split, or splits unevenly.
     * Merging partial results is expensive.
     * The problem doesn't admit sufficient exploitable parallelism.
     * The layout of the data results in poor access locality.
     * There's not enough data to overcome the startup costs of parallelism.
     */


    /*
     * Stream pipelines whose merge steps are O(n) - such as those using the sorted()
     * or collect(Collectors.joining()) terminal operations
     *  - might see their parallelism limited by this effect.
     */
}