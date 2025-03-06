package StackOverFlow;
class User {
    String uid;
    String details...........;
    List<question_id> questionList;
    List<answer_id> answerList;
    int rewards;

    function Add/Delete/Update question();
    function Add/Update/Delete answer();
    function Add/Update/Delete comment();
}

class Moderator extends User {
    function Close or Open questions();
    function Approve or Disapprove answer();
    function AddTag();
}

class Question {
    String questionId;
    String questionTitle;
    String questionDescription;
    String user_id;
    Time questionAdded;
    Vote vote;
    List<Tag> tagList;
    List<answer_id> AnswerList;
    List<comment_id> CommentList;

}

class Answer {
    String answerId;
    String questionId;
    String owner_Id;
    Time answerAdded;
    String ans;
    List<comment_id> commentList;
    
}

enum CommentType {
    QUESTION_COMMENT,ANSWER_COMMENT;
}

class Comment {
    String commentId;
    String userId;
    Time commentAdded;
    String commentStr;
    CommentType commentType;
}

class Tag {
    String userId;
    String tagStr;
}

class Vote {
    String voteId;
    int totalUpVote;
    int totalDownVote;

}