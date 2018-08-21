package com.luxoft.logeek.benchmark;

import com.luxoft.logeek.AppConfig;
import com.luxoft.logeek.dto.HasIdAndName;
import com.luxoft.logeek.dto.IdAndNameDto;
import com.luxoft.logeek.entity.SimpleEntity;
import com.luxoft.logeek.repository.SimpleEntityRepository;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(value = Mode.AverageTime)
public class ProjectionVsDtoBenchmark  {
    private SimpleEntityRepository repository;

    @Setup
    public void before() {
        repository = SpringApplication.run(AppConfig.class).getBean(SimpleEntityRepository.class);
        IntStream.range(0, 10)
                .boxed()
                .map(id -> new SimpleEntity(id, "ivan"))
                .forEach(repository::save);
    }

    @TearDown
    public void after() {
        repository.deleteAllInBatch();
    }

    @Benchmark
    public List<IdAndNameDto> findAllByNameUsingObject() {
        return repository.findAllByNameUsingDto("ivan");
    }

    @Benchmark
    public List<HasIdAndName> findAllByName() {
        return repository.findAllByName("ivan");
    }
}
