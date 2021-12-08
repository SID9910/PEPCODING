

//1. First Activity with Node.js

// We will be creating a File System Organizer//
//Features of the Project -
//If you have numerous Files in a folder and they are not Properly arranged
//So you can use this tool to arrange them in specific directory according to their extension
// like text files will go into text File Folder .exe files will go into application folder and so on
// so at the end you will have a arranged set of files in specific folders

// we will be using built in node modules like fs and path to  create this project


//______________________________________________________________________________________________________________________________
                                          //project started

const fs=require('fs')//ye file system module hai organise main use hoga 
const path=require('path')//ye path dega eek jagah se dusre jagah jane ke ley
//input processed array
//let input=process.argv[2] //array ki form main input jata hai command line per
//console.log(input)
//node js treats command line inputs as array and that array is your processed array

//another method for input
let inputarr=process.argv.slice(2) //ye input array ko slice kar deta hai jis index per ho
console.log(inputarr) 

//ye uper vala starting ke do ko slice kar dega 
//to inputarr zero se start karenge
//ex- node FO.js organize,node FO.js tree,node FO.js help
//organize,tree,help slice hokar bachega
//to organise ko first index ki tarah treat karenge
//node FO.js haat jaega input se isley slice use kara
let command=inputarr[0] // organize aaega ya  tree ya help kuch bhi jo ham input denge


//ye eek object create kara hai taaki vaise bhi file ho uss type ke extension isme mill jay
//ye organise karne ke kaam aaega baad main 
let types = {
    media: ["mp4", "mkv", "mp3"],
    archives: ["zip", "7z", "rar","jpg","tar", "gz", "ar", "iso", "xz"],
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

switch(command){
    case 'tree':
        treeFn()
        break;
     case 'organize':
        organizefn(inputarr[1])//kyuki pehle inputarr[0]main organise aaega fhir inputarr[1]main directory path
                             //--> // node FO.js organize "dirpath"    
     break;
     case 'help':
         helpFn()
         break;
         
      default:
       console.log('PLEASE ENTER THE VALID COMMAND')
       break;      

}
//tree function
function treeFn() {
    console.log('Tree Function Implemented');
  }
//organise function
function organizefn(dirpath){               //directory path
    //1.input of a directory path
    if(dirpath==undefined){                   //directory path aaagr undefined ho                 
        console.log("please enter a directory path")
    }
    else{
        let doesExist=fs.existsSync(dirpath)  //ye function pehle paada hai aaagr exist karegi to true aaega
                                              //nhi to false aaega
       // console.log(doesexist) //dekh sakte ho

           if (doesExist == true) { //jaise he file exist karegi uper check karne ke baad hoga kya ki eek folder.
                                    // aandar banana padega
            //2 . create a Organized files Directory
            destPath = path.join(dirpath, 'organized_files'); //ye eek folder aandar join karega test folder ke sath organise ko
            //dirpath ->C:\dev\test folder\organized_files
            
            //aaagr aander destpath (organised folder)exist nhi karega to ye eek create kar dega
              //destpath false hoga mtlb nhi karta pehle se exist so isse false kar .eek aanader create kar denge organised folder.
               //test folder ke ander             
             if (fs.existsSync(destPath) == false) {
              fs.mkdirSync(destPath); // we will only creata a directory(organised folder) in test folder if it does not exist
            } else {
              console.log("The Folder Already Exists"); //true hua to folder pehle se exist karta hai
            }
          } else {
            console.log("Please enter a valid Path");//dest path nhi karega exit to ye aaega
          }
       
    }
    //ye organizehelper hamari files ko arrange karaega
    organizeHelper(dirpath) //source dena padega
    
}

function organizeHelper(src,dest){
    let childNames=fs.readdirSync(src);//ye readdirSync source file(dirpath=testfolder)ko read karega ki konsi konsi files hai aander
                                     //test folder(source) ke ander
   // console.log(childname) //aaagr dekhna hai to uncomment karke dekh lo

 
   for (let i = 0; i < childNames.length; i++) {
     
    let childAddress = path.join(src, childNames[i]);//ye  jakar source file ke ander path ko link karega sab files se  

     let isFile = fs.lstatSync(childAddress).isFile();//ye check karega ki folder to nhi hai aaagr file hogi to true pass karega 
                                                      //nhi to false karega aaagr folder hua to
 
     if (isFile == true) {  //file hui to true pass karega
       let fileCategory = getCategory(childNames[i]);
       console.log(childNames[i] + "  belongs to  " + fileCategory);//ye files point karega jis category main vo belong karti hai
     }


}
//ye category ko arrange karega
function getCategory(name) {
    let ext = path.extname(name); //
   // console.log(ext)
   ext = ext.slice(1); //.txt,.docx,.jpg in sab se dot hata dega
  //console.log(ext)

  for (let type in types) { //ye uper jo type ka object banaya hai usme sab aander jakar sab array ko traverse karega type by type 
   let cTypeArr = types[type]; //ye ctype (category type hai)
   console.log(cTypeArr)
  }


 }

//help function
  function helpFn() {
    console.log(`List of all the commands -
                   1)Tree Command - node FO.js tree <dirName>
                   2) Organize- node FO.js organize <dirName
                   3) Help - node FO.js help `);
  }
  

}
