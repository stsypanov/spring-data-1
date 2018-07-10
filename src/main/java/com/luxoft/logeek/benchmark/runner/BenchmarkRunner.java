package com.luxoft.logeek.benchmark.runner;

import com.luxoft.logeek.benchmark.RedundantSaveBenchmark;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class BenchmarkRunner {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
//				.include(ByteCodeInstrumentationBenchmarkForSingleEntity.class.getSimpleName())
//				.include(DistinctVsSetBenchmark.class.getSimpleName())
//				.include(ProjectionVsDataBenchmark.class.getSimpleName())
                .include(RedundantSaveBenchmark.class.getSimpleName())
                .warmupIterations(10)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(10)
                .measurementTime(TimeValue.seconds(1))
                .shouldFailOnError(true)
                .forks(2)//0 makes debugging possible
                .addProfiler(GCProfiler.class)
                .build();

        new Runner(opt).run();
    }
}