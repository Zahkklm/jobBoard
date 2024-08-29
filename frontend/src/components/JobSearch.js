import React, { useState } from 'react';
import axios from 'axios';

function JobSearch() {
  const [searchCriteria, setSearchCriteria] = useState('');
  const [jobs, setJobs] = useState([]);

  const handleChange = (e) => {
    setSearchCriteria(e.target.value);
  };

  const handleSearch = async () => {
    const response = await axios.get('http://localhost:8080/api/jobs');
    setJobs(response.data);
  };

  return (
    <div>
      <h2>Job Search</h2>
      <input type="text" placeholder="Search Criteria" value={searchCriteria} onChange={handleChange} />
      <button onClick={handleSearch}>Search</button>
      <div>
        <h3>Job Results</h3>
        <ul>
          {jobs.map(job => (
            <li key={job.id}>{job.title} - {job.company}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default JobSearch;
