// function Calc() { //mvc모델
//     // --- model ----
//     let x = 0;
//     let y = 0;
//     let result = 0;

//     //--- controller -------------
//     function btnClick() {
//         let inputs = document.querySelectorAll("inputs");
//         let xInput = inputs[0];
//         let yInput = inputs[1];
//         x = parseInt(xInput.value)
//         y = parseInt(yInput.value)
        
//         result = x + y;
//     }

//     function xInpuChange() {
//         console.log("x")
//     }

//     function yInpuChange() {
//         console.log("y")
//     }
//     // ------------------- View -----------------
//     //계산기 컴포넌트
//     const el = <div id="mvc">
//                     <label>x:</label>
//                     <input type="test" value={x} dir="rtl" onChange={xInpuChange}/>
//                     <label>y:</label>
//                     <input type="test" value={y} dir="rtl" onChange={yInpuChange}/>
//                     <input type="button" value="덧셈" onClick={btnClick}/>
//                     <br/>
//                     <span>x+y:</span>
//                     <span>{result}</span>
//                 </div>;
// }

// ReactDOM.render(<Calc/> , document.querySelector("#root"));

class Calc extends React.Component{
    constructor(){
        super();
        this.state = {
            x:10,
            y:20,
            result:0
        };
    }

    xInputChange(e){
        this.setState({
            x:e.target.value
        })
    }

    // yInputChange(){
    //     this.yInputChange({
    //         y:e.target.value
    //     })
    // }

    btnClick(){
        //1.객체를 얻어서 값을 얻는 방법
        // let inputs = document.querySelectorAll("input");
        // let xInput = inputs[0];
        // let yInput = inputs[1];
        // let x = parseInt(xInput.value)
        // let y = parseInt(yInput.value)

        // let result = x + y;

        // this.setState({result});
        
        //2.리엑트 방식으로 객체를 얻어서 값을 얻는방법(ref로 이름부여)
        // let x = parseInt(this.refs.xInput.value)
        // let y = parseInt(this.refs.yInput.value)
        
        // let result = x + y;

        // this.setState({result});
        
        //3.state를 이용하는 방법
        let x = parseInt(this.state.x)
        let y = parseInt(this.state.y)
        
        let result = x+y
        this.setState({result})
    }

    render(){
        const el = <div id="mvc">
                   <label>x:</label>
                   {/* bind통해서 this객체까지 전달 */}
                   <input ref="xInput" type="text" value={this.state.x} onChange={this.xInputChange.bind(this)} dir="rtl"/>
                   <label>y:</label>
                   <input ref="yInput" type="text" value={this.state.y} onChange={(e)=>{this.setState({y:e.target.value})}} dir="rtl"/>
                   <input type="button" value="덧셈" onClick={this.btnClick.bind(this)}/>
                   <br/>
                   <span>x+y:</span>
                   <span>{this.state.result}</span>
                </div>;

        return el;
    }
}

ReactDOM.render(<Calc/> , document.querySelector("#root"));


