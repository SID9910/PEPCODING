            //topic variable declaration and other things
//variable declaration with let var and const


//var a  //first the variable is initiazed with undefined
//console.log(a)
//a=20
//console.log(a)
//javascript is a synchronous language and a single threaded language
//a='hello'
//a=null
//a=true //it is dynamic of javascript 
//console.log(a)
//let and const

//first problem with var -Redeclaration

//var b=2
//console.log(b)
//var b='i am string'
//console.log(b)

//var is a bad method because value eek variable main change ho jati hai

//use let to reduce this method
//let b=2
//console.log(b)
//var b='i am string'
//console.log(b)//ye work nhi karega
//let se b ki value uper vali fix ho gai hai console eek uper change kar sakte ho niche nhi



// method 1: loops anf if else


//let flag=true
//let num=13
//for(let i=2;i*i<=num;i++){
 //   if(num%i==0){
  //      flag=false
     //  break
    //}}
//if(flag){
  //  console.log('num is prime',num)

//}
//else{
  //console.log('num is not prime')
//}


//2 problem with var-scoping -function scoping and block scoping
//if(10%2==0){
  //  var c=2
    //console.log(c)
//}
//console.log(c)      //block ke bahar bhi var ki value same hai

//using let 
//if(10%2==0){
  //  let c=2
    //console.log(c)//let ka scope bss block taak rahega bahar nhi rahega
//}
//console.log(c)      // ye work nhi karega block ke bahar bhi var ki value same hai

//javascript main var ka use nhi karenge
//javascript main cons and let use karenge haam

//const a=2
//console.log(a)
//const main value ko change nhi kar sakte 
//let b=2
//b='hello'
//console.log(b)
//let main value uper he redefine kar sakte hai console ke niche nhi
//but const main value fix ho jati hai

//let a=2
//let a=3//not allowed reassigning

//let a=2
//a=3 //allowed reassinging bss eek bar hew let use karenge 


//string method
//string =str //string declaration
//let str='pepcoders'
//console.log(str)

//string Method
//.length //lengh calculate karte hai isse string ki
//console.log(str.length)

//extracting a part of string -slice ,substr
//slice(start,end)-returns sliced array from
//let sliceStr=str.slice(3,7)//last index is excluded slice main eek index kaam likhte hai
//console.log(sliceStr)

//substr method
//substr(start,length)-starting and length of the word
//let substring=str.substr(3,4)
//console.log(substring)

//replace method
 //let sayhello='hello mukesh'
 //console.log(sayhello)
  //sayhello=sayhello.replace('hello','bye')
//console.log(sayhello)

//toUppercase and tolowwercase
//let text1='hello world'
//let text2=text1.toUpperCase()
//console.log(text2)
//let text3='HELLO WORLD'
//let text4=text1.toLowerCase()
//console.log(text4)
//do worlds ko jodne ko conationation kehte hai 
//let firstStr='hello'
//let secondStr='world'
//let concatenatedStr=firstStr.concat( ' ' ,secondStr)
//console.log(concatenatedStr)

//trim method
//let text='  hellow world  '

//console.log(text)
//let trimmedText=text.trim()
//console.log(trimmedText)















