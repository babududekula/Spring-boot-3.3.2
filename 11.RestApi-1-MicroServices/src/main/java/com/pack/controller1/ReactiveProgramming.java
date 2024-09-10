package com.pack.controller1;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.binding.Event;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = "/welcome")
public class ReactiveProgramming 
{
	@GetMapping(value = "/event")
	public Mono<Event> getEvent()
	{
		Event event = new Event("CricBuzz", new Date());
		Mono<Event> mono = Mono.just(event);
		return mono;
	}
	
	@GetMapping(value = "/events" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<Event>> getStream()
	{
		Event event = new Event("CricBuzz", new Date());
		
		Stream<Event> generate = Stream.generate(() -> event);
		
		Flux<Event> fromStream = Flux.fromStream(generate);
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(3));
		
		Flux<Tuple2<Long,Event>> zip = Flux.zip(interval, fromStream);
		
		Flux<Event> map = zip.map(Tuple2::getT2);
		return new ResponseEntity<Flux<Event>>(map, HttpStatus.OK);
	}
}
