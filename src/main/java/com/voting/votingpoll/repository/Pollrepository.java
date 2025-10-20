package com.voting.votingpoll.repository;

import com.voting.votingpoll.moduler.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pollrepository extends JpaRepository<Poll,Long> {
}
