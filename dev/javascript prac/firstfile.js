//npm install minimist
//npm install jsdom
//for read
//node firstfile.js --source=teams.json --dest=f1.txt

// let minimist = require("minimist");//it is use to read console command like node firstfile.js --source=download.js
// let fs = require("fs");//file module for read and write 
// let args =minimist(process.argv);
// let jsdom = require("jsdom");
//we use jsdom to load html of a  page 
//will load the html and prepare the dom for programmers just like a browser would have

//json means javascript object notation
//json means saving data in the same format as of javascript objects
//basically we use json to save file


//activity-1
// let minimist = require("minimist");
// let fs = require("fs"); 
// let args =minimist(process.argv);
// let jsdom = require("jsdom");
//object s1 and s2
// let s1 = {
// name: "sid",
// age:21
// }
// let s2 = {
//     name: "pratham",
//     age:17
//     }
//     let s1os2 =[s1,s2];//an array of object which is again an object = jso
    // (javascript object)
// let json =JSON.stringify(s1os2);//Jso to json (javascript object notation)
//means object ko data main karke file main save karke return simple
// fs.writeFileSync(args.dest,json,"utf-8");//isme write ho jaenge object
//utf-8 hamara file ki ander binary main likhe words ko humme samaj aay usme karta hai


//activity-2 //objects concept
// let minimist = require("minimist");
// let fs = require("fs");
// let args =minimist(process.argv);
// let jsdom = require("jsdom");
// let teams =[
//     {
//         team:"india",
//         rank:1
//     },{
//         team:"england",
//         rank:2
//     },{
//         team:"russia",
//         rank:3
//     }

// ];
// let json =JSON.stringify(teams);
// fs.writeFileSync(args.dest ,json,"utf-8");


//json se jso banane ke ley json.parse use karte hai 
//kyuki hum json main modification nhi kar sakte but hum jso main kar sakte hai
// let jso = JSON.parse(json);
//jsois javascript object

//jso
//if you want to print or save a jso, convert the jso to json using JSON>stringify
//if uou want to manupulate a json ,convert the json to jso using json.parse



// activity-3 to make excel file
//now we are making excelfile
//npm install excel4node
//npm init
//node firstfile.js --source=teams.json --dest=f1.csv
// let minimist = require("minimist");
// let fs = require("fs");
// let excel = require("excel4node");
// let args =minimist(process.argv);

// let teamJSON =fs.readFileSync(args.source , "utf-8");//jso main karne se pehle humesha pehle file ko read karo
// let teams = JSON.parse(teamJSON); //jso main convert ho gai hai aab manipulate kar sakte ho file
// // console.log(teams[2].matches[1].vs);
// // console.log(teams[2].matches[1].result);
// let wb = new excel.Workbook();
// for(let i=0;i<teams.length;i++){
//    let sheet = wb.addWorksheet(teams[i].name);
//     sheet.cell(1,1).string("rank");
//     sheet.cell(1,2).number(teams[i].rank);
//     sheet.cell(2,1).string("vs");
//     sheet.cell(2,2).string("result");
//     for(let j=0;j<teams[i].matches.length;j++){
//         sheet.cell(j+3,1).string(teams[i].matches[j].vs);
//         sheet.cell(j+3,2).string(teams[i].matches[j].result);
//     }
// }
// wb.write(args.dest);

//activity-4 to make pdf
// node firstfile.js --source=teams.json --dest=root
// let minimist = require("minimist");
// let fs = require("fs");
// let path =require("path");//to make folder paths,never append slashes yourself
// let args =minimist(process.argv);
// let teamJSON =fs.readFileSync(args.source ,"utf-8");
// let teams =JSON.parse(teamJSON);
// fs.mkdirSync(args.dest);
// for(let i=0;i<teams.length;i++){
//     let teamfn =path.join(args.dest , teams[i].name);
//     fs.mkdirSync(teamfn);
//     for(let j=0;j<teams[i].matches.length;j++){
//         let matchesfileName =path.join(teamfn,teams[i].matches[j].vs+".pdf");
//         createscorecard(teams[i].name ,teams[i].matches[j],matchesfileName);
//     }
    
// }
// //this fn creates pdf for match in appropriate folder with correct details
// function createscorecard(teamname,match,matchesfileName){
// let t1 =teamname;
// let t2 =match.vs;
// let result =t1+ " " + match.result;
// let originalbytes =fs.readFileSync("template.pdf");//for bytes
// let promisetoloadbytes =pdf.PDFDocument.load(originalbytes);
// promisetoloadbytes.then(function(pdfdoc){
//     let page =pdfdoc.getpage(0);
//     page.drawtest("hello wolrd");
//     let promisetosave =pdfdoc.save();
//     promisetosave.then(function(chnagebyte){
//         fs.writeFileSync(matchesfileName,chnagebyte);
//     })
// })
// }

//activity-5 to use time function
//node firstfile.js --n=10 --d=500 
let minimist = require("minimist");
let args =minimist(process.argv);

let count =args.n;
let time =args.d;
let id =setInterval(function(){
    console.log(count+ "tus to go");
    count--;
    if(count==0){
        console.log("timeout");
        clearInterval(id);
    }

},time);






