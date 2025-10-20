package com.voting.votingpoll.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Vote {

    private Long pollId;
    private int pollIndex;

}
