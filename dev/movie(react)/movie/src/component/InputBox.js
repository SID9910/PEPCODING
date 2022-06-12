
//16 April 
import React from 'react'
// upload this stylesheet in index.html to add styles in sheet
{/* <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet"></link> */}
function InputBox() {
  let [searchText , setSearchtext] =React.useState("");
  let [numberofItems , setNumberOfItems] =React.useState("");
  const handletext = (e) => {
    setSearchtext(e.target.value);
  }
  const handleCount = (e) => {
    setNumberOfItems(e.target.value);
  }
  return (
   
    <>
  <button className="bg-red-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">NEW</button>
  <input className="border rounded py-1 px-1 mx-2 font-bold" type ="text" value={searchText} onChange={handletext}></input>
  <input className="border rounded py-1 px-1 mx-2 font-bold" type ="number" value={numberofItems} onChange={handleCount}></input>
  </>
  )
}

export default InputBox