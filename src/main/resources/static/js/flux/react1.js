class Photo extends React.Component{
    constructor(){
        super();
        this.state = {
           width:"300px",
           borderWidth:"2px",
           borderColor:"red",
           borderStyle:"solid"
        };
    }

    widthChange(e){ //너비
        this.setState({
            width:e.target.value
        })
    }
    
    borderColorChange(e){ //경계선 색상
        this.setState({
            borderColor:e.target.value
        })
    }

    borderWidthChange(e){ //경계선 두께
        this.setState({
            borderWidth:e.target.value
        })
    }

    render(){

        let imgStyle = {
                        width:this.state.width
                        , borderStyle:this.state.borderStyle
                        , borderWidth:this.state.borderWidth
                        , borderColor:this.state.borderColor

                    }
    
        return <section>
                    <div>
                        <label>너비:</label>
                        <input type="text" value={this.state.width} onChange={this.widthChange.bind(this)}/>
                        <label>경계선 색상:</label>
                        <input type="text" value={this.state.borderColor} onChange={this.borderColorChange.bind(this)}/>
                        <label>경계선 두께:</label>
                        <input type="text" value={this.state.borderWidth} onChange={this.borderWidthChange.bind(this)}/>
                        <input type="button" value="적용"/>                                                
                    </div>
                    <div>
                        <img style={imgStyle} src="밥표.jpg"/>
                    </div>
                </section>;
    }
}

ReactDOM.render(<Photo/> , document.querySelector("#root"));