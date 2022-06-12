//16 April 
import React from 'react'
import {useEffect} from 'react';
function Moviestable() {
  const [isLoaded,setLoaded] =React.useState(true);
  const [content , setcontent] =React.useState("");
  //useEffect
  //so i will run only once after return statement is executed
  //ye sara kaam data ko load karane main help karega 
  useEffect(async function () {
    //fetch is inbulit feature of browser that makes the request to get data -> promise based
    let response = await fetch('https://react-backend101.herokuapp.com/movies');
    response =await response.json();
    console.log(response);
    setLoaded();//ye load hua data uper bedghega
    setcontent(JSON.stringify(response)); //string ki form main chaheye
  },[])
  //data
  return (
    //ye important hai har jagah use hota hai data load main help karta hai ye
    <div>{isLoaded == true ? <div className='font-bold'>LOADING....</div>:<div>{content}</div>}
    </div>
  )
}

export default Moviestable