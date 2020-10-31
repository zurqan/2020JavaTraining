package com.aspire.training.ms.session1.restexample.restsample;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingRestAPI {

//    @Autowired
//    private GreetingMessage greetingMessage;

    private final GreetingMessage greetingMessage;


    public GreetingRestAPI(GreetingMessage greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

//    private final List<GreetingMessage> greetingMessagesList;
//
//    public GreetingRestAPI(List<GreetingMessage> greetingMessagesList) {
//        this.greetingMessagesList = greetingMessagesList;
//
//        greetingMessagesList
//                .stream()
//                .map(g->g.sayHello("Test"))
//                .forEach(System.out::println);
//        greetingMessage=greetingMessagesList.get(0);
//    }


//    @GetMapping("/{name}") //  /greeting/name
//    public String hello(@PathVariable("name") String clientName){
//
//        return greetingMessage.sayHello(clientName);
//    }

    @GetMapping("/{name}") //  /greeting/name
    public String hello(@PathVariable("name") String clientName,
                        @RequestParam("location") String location){

        return greetingMessage.sayHello(clientName )+" From "+location;
    }
}
