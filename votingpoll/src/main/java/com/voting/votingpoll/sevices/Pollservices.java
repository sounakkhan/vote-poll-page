package com.voting.votingpoll.sevices;

import com.voting.votingpoll.moduler.Optionvote;
import com.voting.votingpoll.moduler.Poll;
import com.voting.votingpoll.repository.Pollrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class Pollservices {
    @Autowired
    private  Pollrepository pollrepository;

    public Poll createpoll(Poll poll) {
        pollrepository.save(poll);
        return poll;
    }

    public List<Poll> getAllpolls() {
       return pollrepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollrepository.findById(id);
    }

    public void vote(Long pollId, int pollIndex) {
//        get poll from DB
        Poll poll= pollrepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("poll not found"));
//        get all options
        List<Optionvote> options=poll.getOptions();
//        if index for vote is not valid
        if(pollIndex<0 || pollIndex>=options.size()){
            throw new IllegalArgumentException("not valid index");
        }
//        get selected options
        Optionvote selectedOption=options.get(pollIndex);
//        increment vote
        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);
//        save increment option into db
        pollrepository.save(poll);

    }
}
