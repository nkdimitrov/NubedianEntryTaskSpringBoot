import React, { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";

// const CPU_API_BASE_URL = "http://localhost:8080/cpus";

const CPUs = () => {
    
    const [CPUs, setCPUs] = useState([]);
    useEffect(()=>{
        const fetchAllCPUs = async()=>{
           try{
                const res = await axios.get("http://localhost:8080/cpus/cpulist");
                setCPUs(res.data);
           } catch(err) {
                console.log(err);
           };
        };
        fetchAllCPUs();
    },[]);

    const [sockets, setSocket] = useState([]);
    useEffect(()=>{
        const fetchAllSockets = async()=>{
            try{
                const res = await axios.get("http://localhost:8080/cpus/socketlist");
                setSocket(res.data);
            } catch(err) {
                console.log(err);
             };
        };
        fetchAllSockets();
    },[]);

    console.log(CPUs);
    console.log("<><><><><><><><>");

    function renameSocket (currentSocketId) {
        for (let j in sockets) {
            console.log(currentSocketId);
            console.log("<><><><><><><><>");
            if (currentSocketId===sockets[j].id) return sockets[j].socket
        };

    };
    
    const handleDelete = async (id) => {
        try {
          await axios.delete("http://localhost:8080/cpus/cpulist/"+id);
          window.location.reload();
        } catch (err) {
          console.log(err);
        }
    };

    return <div>
        <h1>List of CPUs</h1>
        <div className="CPUs">
            {CPUs.map((cpu)=>(
                <div className="cpuItem" key={cpu.id}>
                    <p>{cpu.brand} || {cpu.model} || {renameSocket(cpu.socketId)} ||
                    <button className="delete" onClick={() => handleDelete(cpu.id)}>Delete</button>
                    <button className="update"><Link to={`/update/${cpu.id}`}>View/Update</Link></button>
                    </p>

                </div>
            ))}
        </div>
        <button>
            <Link to= "/add">Add new entry</Link>
        </button>
    </div>;
    
};

export default CPUs;