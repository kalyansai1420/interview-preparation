import React, { useState } from "react";

export const Tabs = () => {
  const tabs = [
    { id: 1, label: "Home", content: "Home Content" },
    { id: 2, label: "About", content: "About Content" },
    { id: 3, label: "Settings", content: "Settings Content" },
  ];

  const [activeTab, setActiveTab] = useState(1);

  return (
    <>
      <h2>Tabs</h2>
      {/* Tab Buttons */}
      <div>
        {tabs.map((tab) => (
          <button
            key={tab.id}
            onClick={() => setActiveTab(tab.id)}
            style={{
              margin: "5px",
              fontWeight: activeTab === tab.id ? "bold" : "normal",
            }}
          >
            {tab.label}
          </button>
        ))}
      </div>
      {/* Tab Content */}
      <div>
        {tabs.map((tab) => {
          if (tab.id === activeTab) {
            return <p key={tab.id}>{tab.content} </p>;
          }
          return null;
        })}
      </div>
    </>
  );
};
