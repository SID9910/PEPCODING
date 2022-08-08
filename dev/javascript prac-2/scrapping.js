                           //5 oct 2022
//ye project working nhi hai kyuki source ka backend change ho gya hai
//in this project we basically do scrappping as cricinfo ki side se datA LEKAR usse excel main dalenge
//we just make this project for fun
//we basicaly learn how to extract info and get experience with js
//npm init -y
// npm install minimist
// npm install axios
// npm install jsdom
// npm install excel4node
// npm install pdf-lib
//source world cup 2019 ka  fixtures ka hai crick info ka

//node scrapping.js --source=https://www.espncricinfo.com/series/icc-cricket-world-cup-2019-1144415/match-results  --excel=Worldcupt.csv  --dataFolder=data

let minimist =require("minimist");
let axios = require("axios");
let jsdom = require("jsdom");
let excel4node =require("excel4node");
let pdflib =require("pdf-lib");
let args =minimist(process.argv);
let fs = require("fs");
//we do basically
//download html  using axios and get html from it 
//read using jsdom from html
//make excel using excel4node
//make pdf using pdf-lib

//using axios
let responsekaPromise =axios.get(args.source);//source se uska html lekar aaega aaisa promise kar rahe hai
//using callback means uper se aaega data and isme chala jaega
responsekaPromise.then(function(response){
let html =response.data;
// console.log(html);//html dekhna ho to
let dom =new jsdom.JSDOM(html);//html lekar uper se dom bna lo
let document =dom.window.document;//dom uper se lekar page bna lo html ka 
let title =document.title;
// console.log(title);//agr title dekhna ho cric info ka
 let matches =[];
let matchInfoDivs =document.querySelectorAll("div.match-score-block");
// console.log(matchInfoDivs.length);
for(let i=0;i<matchInfoDivs.length;i++){
    //object match
    let match ={

    };
//matches jiske bich main hai uska name nikal lenge
    let nameps = matchInfoDivs[i].querySelectorAll("p.name");
    match.t1 =nameps[0].textContent;
    match.t2 =nameps[1].textContent;


    //ab scores nikal lenge teams ka
    let scoreSpans = matchInfoDivs[i].querySelectorAll("div.score-details > span.score");
    //yte isley kyuki kya pta match hue nhi ya eek team ki batting hui ho
    if(scoreSpans.length == 2){
        match.t1s =scoreSpans[0].textContent;
        match.t2s =scoreSpans[1].textContent;
    }else if(scoreSpans.length ==1){
        match.t1s = scoreSpans[0].textContent;
        match.t2s ="";
    }else {
        match.t1s ="";
        match.t2s ="";
    }


    //result nikal lo
    let spanResult = matchInfoDivs[i].querySelector("div.status-text >span");
    match.result =spanResult.textContent;
    matches.push(match);
}

//aalag se matches ka file bna lo usme bss
//bss matches honge 
let matchjason = JSON.stringify(matches); //stringify isley kyuki save kar rahe hai jso se json
fs.writeFileSync("matches.json",matchjason,"utf-8");


//aab teams manga lo
let teams =[];
for(let i=0;i<matches.length;i++){
    putteamarrayifmissing(teams,matches[i]);
   
}
//aab jiske nich match hua uska data manga lo
for(let i=0;i<matches.length;i++){
    putmatchinappropriate(teams,matches[i]);
   
}

//teams nikal lo and eek file main sarri teams store karlo
let teamjason = JSON.stringify(teams);
fs.writeFileSync("teams.json",teamjason,"utf-8");



})


//kya karo teams add karo aagar nhi mill to add karo and push kardo
//pehle bari main loop nhi chalega kyuki team hai he nhi teams vale array main so
//poehle add hoga fhir loop chal kar bahar aenge
//dono teams ko
function putteamarrayifmissing(teams,match){
    let t1idx =-1;
    for(let i=0;i<teams.length;i++){
        if(teams[i].name == match.t1){
            t1idx=i;
            break;
        }
    }
    if(t1idx ==-1){
        let team = { 
            name:match.t1,
            matchmatches: []
        };
        teams.push(team);
    });


let t2idx =-1;
for(let i=0;i<teams.length;i++){
    if(teams[i].name == match.t2){
        t2idx=i;
        break;
    }
}
if(t2idx ==-1){
    let team = {
        name:match.t2,
        matchmatches: []
    };
    teams.push(team);
});

//isme teams ka data means matches kis kis ke bich hua vo manga lo
//and sarra data store karlo
function putmatchinappropriate(teams, match){
    let t1idx =-1;
    for(let i=0;i<teams.length;i++){
        if(teams[i].name == match.t1){
            t1idx=i;
            break;
        }
    }
    let team1 =teams[t1idx];
    team1.matches.push({
        vs:match.t2,
        selfscore:match.t1
        oppscore:match.t2s,
        result:match.result
    });

    let t2idx =-1;
    for(let i=0;i<teams.length;i++){
        if(teams[i].name == match.t2){
            t2idx=i;
            break;
        }
    }
    let team2=teams[t2idx];
    team1.matches.push({
        vs:match.t1,
        selfscore:match.t2s,
        oppscore:match.t2s,
        result:match.result
    });
     
}

