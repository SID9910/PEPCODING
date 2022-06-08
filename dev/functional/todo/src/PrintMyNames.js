//import
import React from 'react';
function PrintMyName(props){
    let {name ,age} =props;
    return <h1> my name is {name} and my age is {age}</h1>
  
  }
  //ye static function hai
  //is function ke through multiple values return kar sakte hai uper vale ki help se
  function PrintMyNames(){
    return(
  <>
  <PrintMyName name ="siddharth" age={25}></PrintMyName>
  <PrintMyName name ="kunal" age={20}></PrintMyName>
  <PrintMyName name ="rajesh" age={21}></PrintMyName>
  <PrintMyName name ="pratham" age={22}></PrintMyName>
  </>
    )
  
  }

  //export
  export default PrintMyNames;