

//1. First Activity with Node.js

// We will be creating a File System Organizer//
//Features of the Project -
//If you have numerous Files in a folder and they are not Properly arranged
//So you can use this tool to arrange them in specific directory according to their extension
// like text files will go into text File Folder .exe files will go into application folder and so on
// so at the end you will have a arranged set of files in specific folders

// we will be using built in node modules like fs and path to  create this project


//______________________________________________________________________________________________________________________________
//project started(FILE SYSTEM ORGANISER)

//format for input (node FO.js organise/tree/help "testfolder ki path")
//ye project modular banaya hua hai
//isme hisse kare hue hai github main 
//FILE SYSTEM ORGANISER ke commands main hisse hai exporty or import hai 

const fs = require('fs')//ye file system module hai organise main use hoga 
const path = require('path')//ye path dega eek jagah se dusre jagah jane ke ley

//modularity ke hai ye 3
const heplObj = require('./commands/help') // imported help script
const treeObj = require('./commands/tree')
const organizeObj = require('./commands/organize')

//input processed array
//let input=process.argv[2] //array ki form main input jata hai command line per
//console.log(input)
//node js treats command line inputs as array and that array is your processed array

//another method for input
let inputArr = process.argv.slice(2) //ye input array ko slice kar deta hai jis index per ho
console.log(inputArr)

//ye uper vala starting ke do ko slice kar dega 
//to inputarr zero se start karenge
//ex- node FO.js organize,node FO.js tree,node FO.js help
//organize,tree,help slice hokar bachega
//to organise ko first index ki tarah treat karenge
//node FO.js haat jaega input se isley slice use kara
let command = inputArr[0] // organize aaega ya  tree ya help kuch bhi jo ham input denge


//ye eek object create kara hai taaki vaise bhi file ho uss type ke extension isme mill jay
//ye organise karne ke kaam aaega baad main 
let types = {
  media: ["mp4", "mkv", "mp3"],
  archives: ["zip", "7z", "rar", "jpg", "tar", "gz", "ar", "iso", "xz"],
  documents: [
    "docx",
    "doc",
    "pdf",
    "xlsx",
    "xls",
    "odt",
    "ods",
    "odp",
    "odg",
    "odf",
    "txt",
    "ps",
    "tex",

  ],
  app: ["exe", "dmg", "pkg", "deb"],
};



//switch case se haam command denge

switch (command) {
  case 'tree':
    treeObj.treeKey(inputArr[1]);  //kyuki pehle inputarr[0]main tree aaega fhir inputarr[1]main directory path
                                  //--> // node FO.js tree "dirpath"  
    break;
  case 'organize':
    organizeObj.organizeKey(inputArr[1]); //kyuki pehle inputarr[0]main organise aaega fhir inputarr[1]main directory path
                    //--> // node FO.js organize "dirpath"    
    break;
  case 'help':
    heplObj.helpFnKey()
    break;

  default:
    console.log('PLEASE ENTER THE VALID COMMAND')
    break;

}







