//                                   //20 march

// //  npx create-react-app todo  - is se todo app ban jaegi
// //todo ko use karne ke ley terminal  main npm start likhna

import ReactDOM from 'react-dom';
import React from 'react';
import './index.css' ;


class Board extends React.Component {
  render(){
    return (
      <div className='board'>
  <div className='title'>
    TIC TAK TOE

  </div>

  <div className='content'>
    <div className='ttt'>

    </div>

  </div>


      </div>
    );
  }
}

class Display extends React.Component {
  render(){
let gameStatus = 'Next move for X' ;


    return (

      <div className='display'>
      <div className='title'>
         {gameStatus}
      </div>
       <div className='content'>
         <div className='history'>

         </div>

  </div>
      
      </div>
    );
  }
}

class TTT extends React.Component {

 render(){
     

       return (
        <>
           <Board />
           <Display />
        </>
       );
    }
}
 //ye line hamesha likhni he padegi
ReactDOM.render(<TTT />, document.getElementById("root"));





    

