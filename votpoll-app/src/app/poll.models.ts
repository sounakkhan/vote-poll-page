
export interface OptionVote{
    optionText:String;
    voteCount:number;
}




export interface Poll {
    id:number;
    question:String;
    options:OptionVote[]
}
