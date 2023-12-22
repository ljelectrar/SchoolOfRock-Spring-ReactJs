import { useState, useEffect } from 'react';
import StudentList from './StudentList';

const term = "Student";
const API_URL = '/Students';
const headers = {
  'Content-Type': 'application/json',
};

function Student() {
  const [data, setData] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchStudentData();
  }, []);

  const fetchStudentData = () => {
    fetch(API_URL)
      .then(response => response.json())
      .then(data => setData(data))
      .catch(error => setError(error));
  };

  const handleCreate = (item) => {

    console.log(`add item: ${JSON.stringify(item)}`)

    fetch(API_URL, {
      method: 'POST',
      headers,
      body: JSON.stringify({name: item.name, birthday: item.birthday, fallWinterSemester: item.fallWinterSemester, springSummerSemester: item.springSummerSemester, average: item.average}),
    })
      .then(response => response.json())
      .then(returnedItem => setData([...data, returnedItem]))
      .catch(error => setError(error));
  };

  const handleUpdate = (updatedItem) => {

    console.log(`update item: ${JSON.stringify(updatedItem)}`)

    fetch(`${API_URL}/${updatedItem.id}`, {
      method: 'PUT',
      headers,
      body: JSON.stringify(updatedItem),
    })
      .then(() => setData(data.map(item => item.id === updatedItem.id ? updatedItem : item)))
      .catch(error => setError(error));
  };

  const handleDelete = (id) => {
    fetch(`${API_URL}/${id}`, {
      method: 'DELETE',
      headers,
    })
      .then(() => setData(data.filter(item => item.id !== id)))
      .catch(error => console.error('Error deleting item:', error));
  };


  return (
    <div>
      <StudentList
        name={term}
        data={data}
        error={error}
        onCreate={handleCreate}
        onUpdate={handleUpdate}
        onDelete={handleDelete}
      />
    </div>
  );
}

export default Student;

/*
import { useState, useEffect } from "react";
import StudentList from "./StudentList";

const term = "Student";

function Student() {
    const [data, setData] = useState([]);
    const [maxId, setMaxId] = useState(0);

    useEffect(() => {
        fetchStudentData();
    }, []);

    const studentData = () => {
       //simulation data from API
        const Student = [
            { id: 1, name: "Leandro", birthDay: "13/12/1995", fallWinterSemester: 8.0, springSummerSemester: 8.0, average: 8.0 },
            { id: 2, name: "Junior", birthDay: "03/10/1997", fallWinterSemester: 9.0, springSummerSemester: 8.0, average: 9.0 },
            { id: 3, name: "Maiara", birthDay: "03/09/1996", fallWinterSemester: 10.0, springSummerSemester: 8.0, average: 10.0 },
        ];

        setData(studentData);
        setMaxId(Math.max(...studentData.map(Student => Student.id)));
    };

    //Simulate creating data on API
    const handleCreate = (item) => {    
        const newItem = { ...item, id: data.length + 1 };
        setData([...data, newItem]);
        setMaxId(maxId + 1);
    };

    //Simulate updating data on API
    const handleUpdate = (item) => {
        const updateData = data.map(student => student.id === item.id? item : student);
        setData(updateData);
    };

    //Simulate deleting data on API 
    const handleDelete = (id) => {
        const updateData = data.filter(student => student.id != id);
        setData(updateData);
    };

    return (
        <div>
            <StudentList 
                name={term}
                data={data}
                onCreate={handleCreate}
                onUpdate={handleUpdate}
                onDelete={handleUpdate}
            />
        </div>
    );
}

export default Student;

*/