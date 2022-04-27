//                                   //20 march

// //  npx create-react-app todo  - is se todo app ban jaegi
// //todo ko use karne ke ley terminal  main npm start likhna

import ReactDOM from 'react-dom';
import React from 'react';
import './index.css';


class Board extends React.Component {
  handleBoxClick(i){
    this.props.handlerForBoxClick(i);

  }
  renderSquare(i){
    return(
    <button onClick={() => this.handleBoxClick(i)}>{this.props.boxes[i] == null? "": this.props.boxes[i]}</button>
    );
  }
  render() {
    return (
      <div className='board'>
        <div className='title'>
          TIC TAK TOE

        </div>

        <div className='content'>
          <div className='ttt'>

            <div className='row'>
          {this.renderSquare(0)}
          {this.renderSquare(1)}
          {this.renderSquare(2)}
            </div>

            <div className='row'>
            {this.renderSquare(3)}
            {this.renderSquare(4)}
            {this.renderSquare(5)}
            </div>
            <div className='row'>
            {this.renderSquare(6)}
            {this.renderSquare(7)}
            {this.renderSquare(8)}
            </div>

          </div>

        </div>


      </div>
    );
  }
}

class Display extends React.Component {
  render() {
    let gameTitle = null;

    if(this.props.gameStatus !=null){
      gameTitle = this.props.gameStatus
    } else{
      if(this.props.stepNumber %2 ==0){
        gameTitle = "Next move for X";
      }else {
        gameTitle = "Next move for O";
      }
    }
let buttons =[];
for(let i = 0; i <=this.props.stepNumber; i++){
  let button = null;

  if(i == 0){
    button = (<button> Go to Start</button>);

  }else {
    button = (<button>Go to step number {i}</button>);
  } 
buttons.push(button);
}

    return (

      <div className='display'>
        <div className='title'>
          {gameTitle}
        </div>
        <div className='content'>
          <div className='history'>
            {buttons}

          </div>

        </div>

      </div>
    );
  }
}

class TTT extends React.Component {
   constructor(props) {
     super(props);

     this.state = {
       history : [
         [null, null, null, null, null, null, null, null, null]
       ],
       stepNumber: 0,
       gameStatus: null
     }
   }

   handleSquareClick(i) {
     let oldhistory =this.state.history.slice();
    let lastStateOFSquares =oldhistory[oldhistory.length -1].slice();

    if(lastStateOFSquares[i] != null){
      return;
    }
    lastStateOFSquares[i] =this.state.stepNumber % 2 == 0? 'X': 'O';
    oldhistory.push(lastStateOFSquares);
   
    this.setState({
      history:oldhistory,
      stepNumber: this.state.stepNumber + 1,
      gameStatus: null
    })
  
  
  
  
    }
  render() {

  let squares = this.state.history[this.state.history.length - 1];
    return (
      <>
        <Board handlerForBoxClick={(i) => this.handleSquareClick(i)} boxes={squares}/>
        <Display stepNumber={this.state.stepNumber} gameStatus={this.state.gameStatus} />
      </>
    );
  }
}
//ye line hamesha likhni he padegi
ReactDOM.render(<TTT />, document.getElementById("root"));







