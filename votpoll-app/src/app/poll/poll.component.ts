import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll.service';
import { Poll } from '../poll.models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-poll',
  imports: [CommonModule,FormsModule],
  templateUrl: './poll.component.html',
  styleUrl: './poll.component.css'
})
export class PollComponent implements OnInit {
  newPoll: Poll={
    id:0,
    question:' ',
    options:[
      { optionText: '',voteCount:0 },
      { optionText: '',voteCount:0 }
    ]
    
  };
  polls:Poll[]=[];
  constructor(private pollservice:PollService){

  }
  ngOnInit(): void {
      this.loadpolls();
  }
loadpolls(){
  this.pollservice.getPolls().subscribe({
next: (data) =>{
  this.polls=data;
},
error:(error) =>{
  console.log("Error fatching polls:",error);
}
  }

  );
}
createPoll(){
  console.log("Creating poll:", this.newPoll); // ✅ ADD THIS LINE
  this.pollservice.createPoll(this.newPoll).subscribe({
    next:(createdPoll) =>{
      this.polls.push(createdPoll);
      this.resetPoll();
    },
    error:(error) =>{
      console.log("Error creating poll:", error); // ✅ MAKE THIS SPECIFIC
    }
  });
}
resetPoll(){
 this. newPoll={
    id:0,
    question:' ',
    options:[
      { optionText: '',voteCount:0 },
      { optionText: '',voteCount:0 }
    ]
    
  };

}
vote(pollId: number, optionIndex: number) {
this.pollservice.vote (pollId, optionIndex).subscribe({
next: () => {
const poll = this.polls.find(p => p.id === pollId);
if (poll) {

poll.options [optionIndex].voteCount++;
}
},
error: (error)=>{
 console.log("Error creating poll:", error); 
}
});
}
trackByIndex(index:number):number{
  return index;
}
}
