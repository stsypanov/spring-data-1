package com.luxoft.logeek.benchmark;


import com.luxoft.logeek.AppConfig;
import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.service.impl.Modifier;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class RedundantSaveBenchmark {
    private long id;
    private Modifier modifier;

    @Setup
    public void setup() {
        modifier = SpringApplication.run(AppConfig.class).getBean(Modifier.class);
    }

    @Setup(Level.Iteration)
    public void setupIteration() {
        id = modifier.save(new BankAccount()).getId();
    }

    @TearDown(Level.Iteration)
    public void tearDownIteration() {
        modifier.clear();
    }

    @Benchmark
    public Object save() {
        return modifier.addAndSave(id);
    }

    @Benchmark
    public Object noSave() {
        return modifier.add(id);
    }

}
