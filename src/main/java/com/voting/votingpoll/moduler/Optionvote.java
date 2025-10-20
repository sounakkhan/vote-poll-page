package com.voting.votingpoll.moduler;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
@Builder
public class Optionvote {

    private String OptionText;
    private Long voteCount=0L;
}
