import React, {useEffect, useState} from 'react';
import './Agenda.css';
import axios from 'axios';

function Agenda() {

  const [agenda, setAgenda] = useState({nomeContato:'', numeroContato:''});

  const [agendas, setAgendas] = useState([]);

  const [atualizar, setAtualizar] = useState();

  useEffect(()=>{
    axios.get("http://localhost:8090/api/agenda/").then(result=>{
      setAgendas(result.data);
    });
  },[atualizar]);

  function handleChange(event){
    setAgenda({...agenda,[event.target.name]:event.target.value});
  }

  function limpar(){
    setAgenda({
      nomeContato: "",
      numeroContato: "",
    });
  }

  function handleSubmit(event){
    event.preventDefault();
    if(agenda.id){
    axios.post("http://localhost:8090/api/agenda/", agenda).then((result) => {
      setAtualizar(result);
    });
    }else{
      axios.put("http://localhost:8090/api/agenda/", agenda).then((result) => {
        setAtualizar(result);
      });
    }
    limpar();
  }

  function excluir(id){
    axios.delete("http://localhost:8090/api/agenda/"+id).then(result=>{
      setAtualizar(result);
    });
  }



    return(
        <div className="container">
            <h1>Cadastro de Contatos</h1>
            <form onSubmit={handleSubmit}>
              <div className='col-6'> 
                <label className='form-label'>Nome: </label>
                <input onChange={handleChange} value={agenda.nomeContato || ''} name='nomeContato' type='text' className='form-control'></input>
              </div>
              <div className='col-3'> 
                <label className='form-label'>Nº do Contato: </label>
                <input onChange={handleChange} value={agenda.numeroContato || ''} name='numeroContato' type='number' className='form-control'></input>
              </div>
              <br/>
             <input type='submit' className='btn btn-success' value='Cadastrar'></input>
            </form>
            <hr/>
            <table className="table">
                <thead>
                  <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Nº do Contato</th>
                    <th scope="col">Opções</th>
                  </tr>
                </thead>
                <tbody>
                  {
                    agendas.map(serv=> (
                      <tr key={serv.id}>
                        <td>{serv.nomeContato}</td>
                        <td>{serv.numeroContato}</td>
                        <td>
                        <button onClick={()=>setAgenda(serv)} className="btn btn-primary">Editar</button>&nbsp;&nbsp;
                        <button onClick={()=>excluir(serv.id)} className="btn btn-danger">Excluir</button>
                        </td>
                    </tr>
                    ))}
                </tbody>
             </table> 
        </div>
    
    );
}

export default Agenda;
