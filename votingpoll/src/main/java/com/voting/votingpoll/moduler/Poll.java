package com.voting.votingpoll.moduler;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("question")
    private String question;
    @ElementCollection
    @CollectionTable(name = "poll_options", joinColumns = @JoinColumn(name = "poll_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "voteOption", column = @Column(name = "vote_option")),
            @AttributeOverride(name = "voteCount", column = @Column(name = "vote_count"))
    })
    private List<Optionvote> options= new ArrayList<>();
//    @ElementCollection
//    private List<Long> votes = new ArrayList<>();
}