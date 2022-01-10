const fs = require('fs')//ye file system module hai organise main use hoga
path = require('path'),    



let inputArr = process.argv.slice(2) //ye input array ko slice kar deta hai jis index per ho
//console.log(inputArr)


let command = inputArr[0] // file aaegi aaega ya  tree ya help kuch bhi jo ham input denge
 

switch(command){
    case 'wkat.txt':
let content=fs.readFileSync('wkat.txt')
console.log(content+" ")
break;

default:
    console.log('PLEASE ENTER THE VALID COMMAND')
    break;
}

if (dirpath == undefined) {                   //directory path aaagr undefined ho                 
    console.log("please enter a directory path")
  }
  else {
    let doesExist = fs.existsSync(dirpath)  //ye function pehle paada hai aaagr exist karegi to true aaega
    //nhi to false aaega
    // console.log(doesexist) //dekh sakte ho

    if (doesExist == true) { //jaise he file exist karegi uper check karne ke baad hoga kya ki eek folder.
      // aandar banana padega
      //2 . create a Organized files Directory

let childNames = fs.readdirSync(src);//ye readdirSync source file(dirpath=testfolder)ko read karega ki konsi konsi files hai aander
    //test folder(source) ke ander
    // console.log(childname) //aaagr dekhna hai to uncomment karke dekh lo
  
  
    for (let i = 0; i < childNames.length; i++) { //childNames.length ke files ko traverse karega folder ke ander
  
      let childAddress = path.join(src, childNames[i]);//ye  jakar source file ke ander path ko link karega sab files se  