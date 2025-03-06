# Stack Overflow

## high level overview

- Primary Goal
  - design a Q&A platform where 
    - user can post question or answer and moderators can open or close the answer.
    - users can upvote or downvote the answer
    - moderator can add tags
    - site displays questions sorted or filtered by tags or votes or time
- Core Features
  - User management(resgiter, login account details)
  - Posting(questions, answers, comments)
  - Voting (upvote/downvote for both q and a)
  - Tagging (oragnize questions by topic)
  - Moderation (close or reopen questions, approve answers, handle spam)
  - Search (full-text by tags, or by keywords)

## Key Use cases
- Ask a question
- Answer a Question
- Comment on Post
- Vote(Up/Down)
- Moderation
- Search & Browse

## high level architecture
- Presentation Layer(Frontend)
- Application Layer (backend)
- Database & Persistence Layer
- Seach/Indexing System(optional for large scale)

## Data modeling
- User
  - user_id
  - username
  - email
  - password_hash
  - reputation
  - is_moderator
- Question
  - question_id
  - title
  - body
  - author_id
  - creation_time
  - is_closed
  - closed_by
- Answer
  - answer_id
  - question_id
  - author_id
  - body
  - creation_time
  - is_accepted
  - accepted_by
- Comment Table
  - comment_id
  - author_id
  - post_type(ENUM QUESTION or ANSWER)
  - post_id
  - boyd
  - creaetion_time
- Vote Table
  - vote_id
  - post_type
  - post_id
  - voter_id
  - vote_type
  - creation_type
- Tag 
  - tag_id
  - tag_name
  - descrption
- QuestionTag
  - question_id
  - tag_id
## Class level design


## interaction flows

## scaling considerations
- Caching & Read-Heavy Optimization:
  - Q&A sites typically have for more reads than writes.
  - We might add caching (e.g. Redis) for frequently accessed questions
- Search Index 
  - For large datasets we might push new or updated question/anser data into an Elasticsearch index for efficient full-text search
- Load Balancing
  - Use multiple application servers behind a load balancer to handle high traffic
- Sharding or Partitioning 
  - For huge amounts of data, we might partition questions
- Image/ Atttachment Storage
  - If we allow images or code snippets, we might store them on a dedicated object storage service

## applying solid principles

- Single Responsibilty
  - Each class handles one main concern (e.g. User,Question, Answer)
  - The manager or service classes handle business logic(QuestionService might handle creating,fetching and updated)
- Open/Closed
  - New features(e.g, adding an "accepted answer" or new "post type") can be extended via inheritance or new classes without heavily modifying existing classes.
- Liskov Substitution
  - Moderator is specialized User; anywhere a User object is expected, a Moderator can be used without problems
- Interface Segragation
  - If certain roles(like reviewer, moderator, admin) differ widely, you could have specialized interface for each role rather than forcing a single monolithic interface
- Dependency Inversion
  - High-level modules(e.g controllers/services) depend on abstractions(DAO or Repository interfaces) not on low level DB implementations. This also aids testing(mock repositories)

## where to go next

## Summary
