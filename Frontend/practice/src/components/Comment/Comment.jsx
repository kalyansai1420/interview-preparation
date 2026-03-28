import React from "react";
import { CommentsList } from "../CommentsList/CommentsList";

export const Comment = ({ comment }) => {
  return (
    <div style={{ marginLeft: "20px" }}>
        <p>{comment.text}</p>
              {comment.children && comment.children.length > 0 && (
                  <CommentsList comments = {comment.children}/>
        )}
      </div>
  );
};
