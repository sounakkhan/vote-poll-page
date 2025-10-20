package com.voting.votingpoll.controller;

import com.voting.votingpoll.moduler.Poll;
import com.voting.votingpoll.request.Vote;
import com.voting.votingpoll.sevices.Pollservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class Pollcontroller {
@Autowired
    private  Pollservices pollservice;

    @PostMapping
    public Poll createpoll(@RequestBody Poll poll){
        return pollservice.createpoll(poll);
    }
    @GetMapping
    public List<Poll> getAllpolls(){
        return pollservice.getAllpolls();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id){
        return pollservice.getPollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
//    post vote
    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote){
        pollservice.vote(vote.getPollId(),vote.getPollIndex());
    }
}
