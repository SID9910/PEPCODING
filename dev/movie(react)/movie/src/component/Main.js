//16 April 
import React from 'react'
import Genere from './Genere'
import Movies from './Movies'
import Pagination from './Pagination'
function Main() {
  return (
    <>

    <div className="flex">
    <Genere></Genere>
    <Movies></Movies>
  
    </div>
    </>
  )
}

export default Main