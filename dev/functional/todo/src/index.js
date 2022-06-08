
import ReactDOM from 'react-dom/client';
import './index.css';
// import PrintMyNames from './PrintMyNames';
import counterclass from './counterclass'
// bottom to top approach
//functional component means at the end component ya html return milegi
// props(property) eek object he hai jisme value jaegi


//jaab humme static function ka use nhoi karna ho 
//and component ka interaction karana ho ya dynamic change karna ko 
//then hum class ko extend karte hai
//and state main jo changes honge vo render state ki help se usme changes
//karega render main jo ki dynamic honge
//and render ke through html return karenge
// class counter extends React.Component {
//   //state he hai jo change kar sakta hai aagar render main kuch karna ho
//    state = {
//      count: 0
//    }
//    //userdefined function
//    incrementCounter = () => {
//      //ye state badane main help karega
//      this.setState({
//        count: this.state.count + 1
//      })
//    }
//    decrementCounter = () => {
//      //ye state badane main help karega
//      this.setState({
//        count: this.state.count - 1
//      })
//    }
//    render(){
//      return (
//        <div>
//          <button onClick={this.incrementCounter}>+</button>
//          <p>{this.state.count}</p>
//          <button onClick={this.decrementCounter} >-</button>
//        </div>
//      )
//    }
//  }
//aab function ki help se count aaise karenge hooks ki help se usestate eek function hai jo react ne he dea hai
import React , { useState }  from 'react';
 function CounterFn() {
   //iski help se update karenge hook ki madad se
let [count ,updatecount]=useState(0);
  //userdefined function
   const incrementCounter = () => {
   //ye count +1 ka function banaega hook ki help se updaet count main
    updatecount(count+1);
  }
  const decrementCounter = () => {
    //ye count -1 ka function banaega hook ki help se update count main 
    updatecount(count-1);
  }
  
    return (
      <div>
        <button onClick={incrementCounter}>+</button>
        <p>{count}</p>
        <button onClick={decrementCounter} >-</button>
      </div>
    )

}

ReactDOM.render(
  // <PrintMyNames></PrintMyNames>,
  // <h1> hi sid</h1>,
  <CounterFn></CounterFn>
  ,
  document.getElementById('root')
);

