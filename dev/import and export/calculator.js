                   //topic -IMPORT and EXPORT


function add(a,b){
    console.log("the sum is ",a+b)
}

function subtract(a,b){
    console.log("the subtraction  is ",a-b)
}

function mul(a,b){
    console.log("the mul is ",a*b)
}
function dev(a,b){
    console.log("the dev is ",a/b)
}
//function call 
//method 1:
//add(2,3)
//subtract(34,3)
//mul(2,3)
//dev(4,2)


//method 2:export
//module.export eek object hai java ka
module.exports ={
    addition:add,
    subtraction:subtract,      //ye pura module moduleTest.js main export hokar work karega
    multiply:mul,
    division:dev,
}
//module.exports is a object provided by node.js by which you can create your own module and export them in another