//import
import React,{component} from 'react'
class counterclass extends React.Component {
  //state he hai jo change kar sakta hai aagar render main kuch karna ho
   state = {
     count: 0
   }
   //userdefined function
   incrementCounter = () => {
     //ye state badane main help karega
     this.setState({
       count: this.state.count + 1
     })
   }
   decrementCounter = () => {
     //ye state badane main help karega
     this.setState({
       count: this.state.count - 1
     })
   }
   render(){
     return (
       <div>
         <button onClick={this.incrementCounter}>+</button>
         <p>{this.state.count}</p>
         <button onClick={this.decrementCounter} >-</button>
       </div>
     )
   }
 }