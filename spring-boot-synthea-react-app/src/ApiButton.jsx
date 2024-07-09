import React from 'react';

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

  return (
    <button onClick={handleClick}>
      Call API
    </button>
  );
};

export default ApiButton;
