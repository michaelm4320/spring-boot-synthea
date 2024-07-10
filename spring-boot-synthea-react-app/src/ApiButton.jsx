import React from 'react';
import './ApiButton.css';

const ApiButton = () => {
  const handleClick = async () => {
    try {
      const url = '/api/test';
      console.log('Requesting URL:', url);
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      console.log(data.message);
    } catch (error) {
      console.error('Error:', error);
    }
  };

    const handleGeneratePatient = async () => {
    try {
        const response = await fetch('http://localhost:8080/myendpoint/api/generate-patient', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            credentials: 'include', // Send cookies, required for CORS with credentials
        });

        if (!response.ok) {
            throw new Error('Error generating patient');
        }

        const data = await response.json();
        console.log('Generated patient:', data);
    } catch (error) {
        console.error('Error generating patient:', error);
    }
};



  return (
    <div className="buttons">
      <button onClick={handleClick}>
        Call API
      </button>
      <button onClick={handleGeneratePatient}>
        Generate Patient Data
      </button>
    </div>
  );
};

export default ApiButton;
