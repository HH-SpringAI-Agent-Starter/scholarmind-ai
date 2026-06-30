package com.agentstack.scholarmind.controller;

import com.agentstack.scholarmind.agent.AgentService;
import com.agentstack.scholarmind.dto.AgentRequest;
import com.agentstack.scholarmind.dto.AgentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/ask")
    public AgentResponse ask(@RequestBody AgentRequest request) {
        return agentService.ask(request);
    }
}
