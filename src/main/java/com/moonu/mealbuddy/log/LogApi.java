package com.moonu.mealbuddy.log;

import com.moonu.mealbuddy.response.PlainMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/matching")
@Tag(name= "Log Api", description = "For logging")
public class LogApi {
    private static final Logger LOG = LoggerFactory.getLogger(LogApi.class);

    @GetMapping(value = "/log", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Demo log API", description = "Demo log API, have random delay between 10-1000 ms.")
    public ResponseEntity<PlainMessage> demoLog() throws InterruptedException{
        LOG.debug("demoLog() starts");

        var startTime = System.currentTimeMillis();
        // random delay
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(10, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        var processTime = System.currentTimeMillis() - startTime;
        var response = new PlainMessage("It took " + processTime + " ms to generate this message.");

        LOG.debug("demoLog() ends");

        return ResponseEntity.ok().body(response);
    }
}
