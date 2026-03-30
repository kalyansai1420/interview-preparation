import React, { useState } from "react";

export const FileNode = ({ node, setData }) => {
  const [isOpen, setIsOpen] = useState(false);

  const addNode = (tree, parentId, newNode) => {
    return tree.map((node) => {
      if (node.id === parentId && node.isFolder) {
        return {
          ...node,
          children: [...(node.children || [] ), newNode],
        };
      }

      if (node.children) {
        return {
          ...node,
          children: addNode(node.children, parentId, newNode),
        };
      }

      return node;
    });
  };

  const deleteNode = (tree, id) => {
    return tree
      .filter((node) => node.id !== id)
      .map((node) => {
        if (node.children) {
          return {
            ...node,
            children: deleteNode(node.children, id),
          };
        }
        return node;
      });
  };
  return (
    <div style={{ marginLeft: "20px" }}>
      <span
        onClick={() => node.isFolder && setIsOpen(!isOpen)}
        style={{ cursor: node.isFolder ? "pointer" : "default" }}
      >
        {node.isFolder ? (isOpen ? "📂" : "📁") : "📄"} {node.name}
      </span>
      {node.isFolder && (
        <button
          onClick={() => {
            const name = prompt("Enter name");
            if (!name) return;

            const newNode = {
              id: Date.now(),
              name,
              isFolder: false,
            };
            setData((prev) => addNode(prev, node.id, newNode));
          }}
        >
          + File
        </button>
      )}

      <button onClick={() => setData((prev) => deleteNode(prev, node.id))}>
        ❌
      </button>
      {node.isFolder &&
        isOpen &&
        node.children?.map((child) => <FileNode key={child.id} node={child} setData={setData} />)}
    </div>
  );
};
