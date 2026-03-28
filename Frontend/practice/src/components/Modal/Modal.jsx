import React, { useState } from "react";
import "./Modal.css";

export const Modal = () => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <>
      <h2>Modal</h2>
      <button onClick={() => setIsOpen(true)}>Open Modal</button>
      {isOpen && (
        <div className="overlay" onClick={() => setIsOpen(false)}>
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <p>Modal Content</p>
            <button onClick={() => setIsOpen(false)}>Close</button>
          </div>
        </div>
      )}
    </>
  );
};
