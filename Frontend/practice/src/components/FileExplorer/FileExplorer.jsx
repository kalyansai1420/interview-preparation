import React from "react";
import { FileNode } from "../FileNode/FileNode";

export const FileExplorer = ({ data,setData }) => {
  return (
    <div>
      {data.map((node) => (
          <FileNode key={node.id} node={node} setData={setData} />
      ))}
    </div>
  );
};
