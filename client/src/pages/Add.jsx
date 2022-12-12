import axios from 'axios';
import React from 'react';
import { useState } from 'react';
import { Link, useNavigate } from "react-router-dom";

const Add = () => {
    const [newCPU, setNewCPU]=useState({
        id: null,
        brand: "",
        model: "",
        socketId: null,
        clockSpeed: "",
        cores: null,
        threads: null,
        tdp: null,
        price: null,  
    });



    const navigate = useNavigate();

    const handleChange = (e) =>{
        setNewCPU((prev) => ({...prev, [e.target.name]: e.target.value}));
    };

    const handleClick = async e =>{
        e.preventDefault();
        if (newCPU.brand==="" || newCPU.model==="" || newCPU.socketId===null) return;
        try {
            // newCPU.id=20;
            await axios.post("http://localhost:8080/cpus/cpulist", newCPU);
            navigate("/");
        } catch (err) {
            console.log(err);
        };
    };

    // console.log(newCPU);
    return(
        <div className="form">
            <h1>Add New CPU</h1>
            <input type="text" placeholder="Brand" name="brand" onChange={handleChange} />
            <input type="text" placeholder="Model" name="model" onChange={handleChange} />
            <input type="number" placeholder="SocketID" name="socketId" onChange={handleChange} />  
            <input type="text" placeholder="Clockspeed [GHz]" name="clockSpeed" onChange={handleChange} />
            <input type="number" placeholder="Cores" name="cores" onChange={handleChange} />
            <input type="number" placeholder="Threads" name="threads" onChange={handleChange} />     
            <input type="number" placeholder="TDP [W]" name="tdp" onChange={handleChange} />     
            <input type="number" placeholder="Price [Euro]" name="price" onChange={handleChange} />    
            <button onClick={handleClick}>Add</button>
            <Link to="/">List of CPUs</Link>
        </div>

    );
};

export default Add;