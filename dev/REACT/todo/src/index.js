//                                   //19 march

// //  npx create-react-app todo  - is se todo app ban jaegi
// //todo ko use karne ke ley terminal  main npm start likhna

import ReactDOM from 'react-dom';
import React from 'react';
import './index.css' ;

class AddTask extends React.Component {
    //ye constructor har bar banana he padega
    constructor(props){
        super(props);
        this.state = {
            taskDesc: ''
        }
    }
    handleTaskTextChange(e){
        // set state ki help se value updated jati hai
        this.setState({
            taskDesc: e.target.value
        })
    }

    handleAddTaskClick(){
        this.props.handlerToCollectTaskInfo(this.state.taskDesc);
        this.setState({
            taskDesc: ''
        })
    }

    render(){
        return(
            //ye from button and text dalne ke ley
            <form>
                   {/* button ke aander bss text ja sakta hai */}
                <input type="text" value={this.state.taskDesc} onChange={(e) => this.handleTaskTextChange(e)} />
                {/* add task name ka button banega  */}
                <input type="button" value="Add Task" onClick={() => this.handleAddTaskClick()}/>
            </form>
        )
    }
}

class TaskList extends React.Component {

   handleTaskClick(taskDesc){
        this.props.handlerToCollectTaskClickInfo(taskDesc);
   }

   render(){
         //ye task hamara app se lega and 
         //pehle todolist task ka kaam hoga pura fhir finished task ka
         //ye array main store karenge
        let list = [];
//ye loop task nikaega app se and chalega uske according
        for(let i = 0; i < this.props.tasks.length; i++){
             //eek eek task use karte jao
            let task = this.props.tasks[i];
            let spanAction;
   //ye conditions hai taaki icons sahi jagah aay     
            if(task.isFinished){
                spanAction = (
                    <span class="material-icons" onClick={() => this.handleTaskClick(task.desc)}>close</span>
                );
            } else {
                spanAction = (
                    <span class="material-icons" onClick={() => this.handleTaskClick(task.desc)}>done</span>
                );
            }

            let listItem = (
                <div key={i}>
                    <span>{task.desc}</span>
                    {spanAction}
                </div>
            );
            //list main store karte jao
            list.push(listItem);
        }

        return(
            // props ki help se app ke ander se purpose vale tasklist ka saman mill rha hai
          //means parent(app) ko child(tasklist) se information dena

            <div className={this.props.purpose == "Todo"? "todo": "finished"}>
                  {/* ye class he bna di list conatiner ki taaki is se lele */}
                <div className="list-container">
                    <div className='title'>{this.props.purpose}</div>
                    <div className='content'>
                        {list}
                    </div>
                </div>
            </div>
        )
    }
}

class App extends React.Component {
    constructor(props){
        super(props);

        this.state = {
            tasks: [{
                desc: 'Switch off light',
                isFinished: false
            }, {
                desc: 'Turn on fan',
                isFinished: false
            }, {
                desc: 'Make tea',
                isFinished: true
            }, {
                desc: 'Make dinner',
                isFinished: true
            }]
        }
    }

    handleNewTask(taskDesc){
        //isme jo pehle vala state main hoga vo aaega
        //and haat jaega slice se and nai value push kar denge
        let oldTasks = this.state.tasks.slice();

        oldTasks.push({
            desc: taskDesc,
            isFinished: false
        });
        // set state ki help se value updated jati hai
        this.setState({
            tasks: oldTasks
        })
    }

    handleTaskStatusUpdate(taskDesc, newStatus){
        let oldTasks = this.state.tasks.slice();

        let taskItem = oldTasks.find(ot => ot.desc == taskDesc);
        taskItem.isFinished = newStatus;

        this.setState({
            tasks: oldTasks
        })
    }
    handleTaskStatusUpdate(taskDesc, newStatus){
        let oldTasks = this.state.tasks.slice();

        let taskItem = oldTasks.find(ot => ot.desc == taskDesc);
        taskItem.isFinished = newStatus;

        this.setState({
            tasks: oldTasks
        })
    }

        //iske ander uper se task aajenge

        //aab hum filter kar lenge mtlb true vale eek taraf and false vale eek taraf
    render(){
        
       let tasks = this.state.tasks;
       //ye todo and done aab filter ho gay hai
       let todoTasks = tasks.filter(t => t.isFinished == false);
       let doneTasks = tasks.filter(t => t.isFinished == true);

       return (
           <>
              <div className="add-task">
                <AddTask handlerToCollectTaskInfo={(taskDesc) => this.handleNewTask(taskDesc)}/>
              </div>
              <div className='task-lists'>
              <TaskList handlerToCollectTaskClickInfo={(taskDesc) => this.handleTaskStatusUpdate(taskDesc, true)} tasks={todoTasks} purpose="Todo"/>
                <TaskList handlerToCollectTaskClickInfo={(taskDesc) => this.handleTaskStatusUpdate(taskDesc, false)} tasks={doneTasks} purpose="Finished"/>
           
              </div>
           </>
       );
    }
}
 //ye line hamesha likhni he padegi
ReactDOM.render(<App />, document.getElementById("root"));





    

