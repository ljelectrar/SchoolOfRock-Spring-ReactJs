import { useState } from "react";

function StudentList({name, data, onCreate, onUpdate, onDelete, error}) {
    const [formData, setFormData] = useState({ id: '', name: '', birthDay: '', fallWinterSemester: '', springSummerSemester: '', average: ''});
    const [editingId, setEditingId] = useState(null);

    const handleFormChange = (event) => {
        const { name, value } = event.tartget;
        setFormData(prevData => ({
            ...prevData,
            [name]: value,
        }));
    };

    const handleSubmit = (event) =>{
        event.preventDefault();
        if(editingId) {
            onUpdate(formData);
            setEditingId(null);
        } 
        else {
            onCreate(formData);
        }
        setFormData({ id: '', name: '', birthDay: '', fallWinterSemester: '', springSummerSemester: '', average: '' })
    };

    const handleEdit = (event) => {
        setEditingId(item.id);
        setFormData({
            id: item.id,
            name: item.birthDay,
            fallWinterSemester: item.fallWinterSemester,
            springSummerSemester: item.springSummerSemester,
            average: item.average,  
        });
    };

    const handleCancelEdit = () => {
        setEditingId(null);
        setFormData({
            id: item.id,
            name: item.birthDay,
            fallWinterSemester: item.fallWinterSemester,
            springSummerSemester: item.springSummerSemester,
            average: item.average,  
        });
    };

    return (
        <div>
            <h2>{name}</h2>
            <form onSubmit={handleSubmit}>
                <input type="text"
                name = {name}
                placeholder= {name}
                value={formData.name}
                onChange={handleFormChange}
                />
            </form>

            <form onSubmit={handleSubmit}>
                <input type="text"
                name = {birthDay}
                placeholder= {birthDay}
                value={formData.birthDay}
                onChange={handleFormChange}
                />
            </form>

            <form onSubmit={handleSubmit}>
                <input type="number"
                name = {fallWinterSemester}
                placeholder= {fallWinterSemester}
                value={formData.fallWinterSemester}
                onChange={handleFormChange}
                />
            </form>
            <form onSubmit={handleSubmit}>
                <input type="number"
                name = {springSummerSemester}
                placeholder= {springSummerSemester}
                value={formData.springSummerSemester}
                onChange={handleFormChange}
                />
            </form>

            {error && <div>{error.message}</div>}

            <h2>{name}s</h2>
            <ul>
                {data.map(item => (
                <li key={item.id}>
                    <div>{item.name} - {item.birthDay} - {item.fallWinterSemester} = {item.springSummerSemester} - {item.average}</div>
                    <div><button onClick={() => handleEdit(item)}>Edit</button>
                    <button onClick={() => onDelete(item.id)}>Delete</button></div>
                </li>
                ))}
            </ul>

        </div>
    );
}

export default StudentList;