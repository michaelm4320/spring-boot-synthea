// src/ApiButton.jsx
import React from 'react';

const ApiButton = () => {
  const handleClick = async () => {
    try {
      const response = await fetch('/api/test');
      const data = await response.json();
      console.log(data.message);
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <button onClick={handleClick}>
      Call API
    </button>
  );
};

export default ApiButton;
