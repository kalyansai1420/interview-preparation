import React from "react";
import { Comment } from "../Comment/Comment";

export const CommentsList = ({ comments }) => {
  return (
    <>
      <h2> CommentsList</h2>
      {comments.map((comment) => (
        <Comment comment={comment} key={comment.id} />
      ))}
    </>
  );
};
