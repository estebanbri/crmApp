import React, { Component } from 'react';
import axios from 'axios';
import './App.css';

class App extends Component {
  state = {
            personas: [],
            persona : {}
          };

  componentDidMount(){
    // GET /clientes
    axios.get("http://localhost:8080/api/clientes")
         .then(response => { 
            this.setState({ personas : response.data});
          });
/*
    //GET /clientes/{id}
    const id = 1;
    axios.get( 'http://localhost:8080/clientes/' + id )
         .then( response => {
              this.setState( { persona: response.data } );
          } );  
    
    //POST /clientes
    const persona_data = {
      nombre: "Juan",
    };
    axios.post('http://localhost:8080/clientes', persona_data)
          .then(response => {
            console.log(response);
          });
    
    //DELETE
    axios.delete('http://localhost:8080/clientes/' + this.props.id)
         .then(response => {
            console.log(response);
          });
*/
}

  render() {

    let personas = this.state.personas.map(persona => {
      return (
        <div>
          <p>{persona.primerNombre}</p>
        </div>
      )
    })

    return (
      <div className="App">
        {personas}
      </div>
    );
  }
}

export default App;
