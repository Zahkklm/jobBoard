import React, { useState } from 'react';
import axios from 'axios';

function UserProfile() {
  const [profileData, setProfileData] = useState({
    firstName: '',
    lastName: '',
    phoneNumber: '',
    jobExperience: '',
    workExperience: ''
  });

  const handleChange = (e) => {
    setProfileData({ ...profileData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put('/api/changeInfo/', profileData);
      alert('Profile updated successfully!');
    } catch (error) {
      console.error('Profile update error', error);
    }
  };

  return (
    <div>
      <h2>User Profile</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="firstName" placeholder="First Name" value={profileData.firstName} onChange={handleChange} required />
        <input type="text" name="lastName" placeholder="Last Name" value={profileData.lastName} onChange={handleChange} required />
        <input type="text" name="phoneNumber" placeholder="Phone Number" value={profileData.phoneNumber} onChange={handleChange} required />
        <input type="text" name="jobExperience" placeholder="Job Experience" value={profileData.jobExperience} onChange={handleChange} required />
        <input type="text" name="workExperience" placeholder="Work Experience" value={profileData.workExperience} onChange={handleChange} required />
        <button type="submit">Update Profile</button>
      </form>
    </div>
  );
}

export default UserProfile;
