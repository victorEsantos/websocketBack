package com.example.websocket.api;

import com.example.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class ExampleController {

    @Autowired
    private WebSocketService webSocketService;

    @PutMapping
    public ResponseEntity<String> example() {
        webSocketService.execute();

        return ResponseEntity.ok().body("suceso");
    }
}
