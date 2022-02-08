package com.rukon.springreactivepractice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<String> stringMono = Mono.just("Rukon Khan").log();
        stringMono.subscribe(System.out::println);
    }


    @Test
    public void testFlux() {
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices").log();

        fluxString.subscribe(System.out::println);
    }
}
