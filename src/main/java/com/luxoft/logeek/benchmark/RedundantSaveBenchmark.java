package com.luxoft.logeek.benchmark;


import com.luxoft.logeek.AppConfig;
import com.luxoft.logeek.entity.Ученик;
import com.luxoft.logeek.service.impl.Modifier;
import org.openjdk.jmh.annotations.*;
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
        id = modifier.save(new Ученик()).getId();
    }

    @Benchmark
    public Object save() {
        return modifier.накинутьГодикДаСохранить(id);
    }

    @Benchmark
    public Object noSave() {
        return modifier.накинутьГодик(id);
    }

}
