

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

const fs = require('fs')//ye file system module hai organise main use hoga 
const path = require('path')//ye path dega eek jagah se dusre jagah jane ke ley
//input processed array
//let input=process.argv[2] //array ki form main input jata hai command line per
//console.log(input)
//node js treats command line inputs as array and that array is your processed array

//another method for input
let inputarr = process.argv.slice(2) //ye input array ko slice kar deta hai jis index per ho
console.log(inputarr)

//ye uper vala starting ke do ko slice kar dega 
//to inputarr zero se start karenge
//ex- node FO.js organize,node FO.js tree,node FO.js help
//organize,tree,help slice hokar bachega
//to organise ko first index ki tarah treat karenge
//node FO.js haat jaega input se isley slice use kara
let command = inputarr[0] // organize aaega ya  tree ya help kuch bhi jo ham input denge


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
function organizefn(dirpath) {               //directory path
  //1.input of a directory path
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
  organizeHelper(dirpath,destPath); //source dena padega and destination(organised file)

}

function organizeHelper(src, dest) {
  let childNames = fs.readdirSync(src);//ye readdirSync source file(dirpath=testfolder)ko read karega ki konsi konsi files hai aander
  //test folder(source) ke ander
  // console.log(childname) //aaagr dekhna hai to uncomment karke dekh lo


  for (let i = 0; i < childNames.length; i++) { //childNames.length ke files ko traverse karega folder ke ander

    let childAddress = path.join(src, childNames[i]);//ye  jakar source file ke ander path ko link karega sab files se  

    let isFile = fs.lstatSync(childAddress).isFile();//ye check karega ki folder to nhi hai aaagr file hogi to true pass karega 
    //nhi to false karega aaagr folder hua to

    if (isFile == true) {  //file hui to true pass karega
      let fileCategory = getCategory(childNames[i]);
      console.log(childNames[i] + "  belongs to  " + fileCategory);//ye files point karega jis category main vo belong karti hai
      //childname as jpg,docx, belongs to file category  media,archieve,photos aaise
      sendFiles(childAddress, dest, fileCategory);//ye main function kaam karega ki konsi file kha se kha bedghni hai
                                        //like .jpg(childaddress)->  destination(organised files)->filecategory(media/documents,etc)

    }
  }

  }
  //ye category ko arrange karega
  function getCategory(name) {//idher childname pass hoga jis se pta chalega ki konsi file ko kha arrange karna haoi
    let ext = path.extname(name); //ye file ka extention niklane ke ley use hota hai
    // console.log(ext)
    ext = ext.slice(1); //.txt,.docx,.jpg in sab se dot hata dega
    //console.log(ext)

    //for in loop
    //ye types ke ander ke typer per jaega
    for (let type in types) { //ye uper jo type ka object banaya hai usme sab aander jakar sab array ko traverse karega type by type 
      let cTypeArr = types[type]; //ye ctype (category type hai) like mdeis,archieve,documents ye sab Ctype main aaega
      //console.log(cTypeArr) aaagr types dekhna hi
      for (let i = 0; i < cTypeArr.length; i++) {
        if (ext == cTypeArr[i]) { //aagr extension koi category se match karega to type return kardo
          //like .jpg(extension)belongs to documents(type) and return Type

          // we matched the extension
          return type; // we returned types of the file 
        }
      }
    }
    return "others";

  }

//ye he files ko idher se udher kar kar organised files(destination ) main karega send.
  function sendFiles(srcFilePath, dest, fileCategory) {
    //catpath=category path
    let catPath = path.join(dest, fileCategory);//destination(organised files) ko link kardo filecategory se(media ,documents,archieve) 
//examples-
    //D:\FJP2 Dev\test folder\organized_files\media
    //D:\FJP2 Dev\test folder\organized_files\documents
    //D:\FJP2 Dev\test folder\organized_files\app
    //D:\FJP2 Dev\test folder\organized_files\archives

    //ye check karega ki categorypath false hua to eek directory create kardo
    if (fs.existsSync(catPath) == false) {
      fs.mkdirSync(catPath);
    }

    //ye filename ka name bataega jpg,text,etc
    let fileName = path.basename(srcFilePath);

    //ye link karega organised folder ko file name se 
    let destFilePath = path.join(catPath, fileName);

    //example-
    //D:\FJP2 Dev\test folder\organized_files\media\test.mp4


    //ye copy karega source file ko destination taak
    //example-jpg,text,exe ,etc to organised files
    fs.copyFileSync(srcFilePath, destFilePath); // copyFileSync is used to copy files from source to dest
    fs.unlinkSync(srcFilePath); // unlinkSync is used to remove files from outside the orgnaised folder 
                               //jo pehle thi use bahar jo thi
    
  console.log(fileName + " copied to " + fileCategory); //ye console bta dega konsi file kha jaegi idher se udher                           

  }



  //help function
  function helpFn() {
    console.log(`List of all the commands -
                   1)Tree Command - node FO.js tree <dirName>
                   2) Organize- node FO.js organize <dirName
                   3) Help - node FO.js help `);
  }



