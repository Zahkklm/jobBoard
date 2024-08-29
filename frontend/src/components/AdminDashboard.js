import React, { useState, useEffect } from 'react';
import axios from 'axios';

function AdminDashboard() {
  const [users, setUsers] = useState([]);
  const [filter, setFilter] = useState({ militaryService: false, yearsOfExperience: 0 });

  useEffect(() => {
    const fetchUsers = async () => {
      const response = await axios.get('/api/users', { params: filter });
      setUsers(response.data);
    };
    fetchUsers();
  }, [filter]);

  const handleFilterChange = (e) => {
    setFilter({ ...filter, [e.target.name]: e.target.value });
  };

  return (
    <div>
      <h2>Admin Dashboard</h2>
      <div>
        <label>
          Military Service:
          <input type="checkbox" name="militaryService" onChange={handleFilterChange} />
        </label>
        <label>
          Years of Experience:
          <input type="number" name="yearsOfExperience" onChange={handleFilterChange} />
        </label>
      </div>
      <div>
        <h3>Users List</h3>
        <ul>
          {users.map(user => (
            <li key={user.id}>{user.firstName} {user.lastName} - {user.jobExperience}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default AdminDashboard;
