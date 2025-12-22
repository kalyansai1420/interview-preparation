# MongoDB Interview Questions – Complete Guide
## Iteration 1/4 (Q1–Q25)
_Source: mongoDB-interview-questions.pdf_

---

## Q1. What is MongoDB and what are its main features?

**Answer:**  
MongoDB is a NoSQL, document-oriented database designed for scalability, flexibility, and high performance. It stores data in JSON-like BSON documents and supports horizontal scaling, indexing, replication, and rich queries.

**Scenario:**  
An application with rapidly changing data structures benefits from MongoDB’s flexible schema.

**Pitfalls:**  
- Treating MongoDB like a relational database  
- Poor schema design  

**Trade-offs:**  
Flexibility vs strict schema enforcement.

---

## Q2. How does MongoDB differ from relational databases?

**Answer:**  
MongoDB uses a document-based model instead of tables and rows, supports schema flexibility, and scales horizontally more naturally than relational databases.

**Scenario:**  
Storing nested user profiles without joins.

**Pitfalls:**  
- Expecting ACID joins like SQL  

**Trade-offs:**  
Schema flexibility vs strong relational constraints.

---

## Q3. Can you describe the structure of data in MongoDB?

**Answer:**  
Data is stored as documents inside collections, and collections belong to databases.

**Scenario:**  
A user document contains embedded address data.

**Pitfalls:**  
- Over-embedding large data  

**Trade-offs:**  
Denormalization improves read speed but increases document size.

---

## Q4. What is a Document in MongoDB?

**Answer:**  
A document is a BSON object containing field-value pairs, similar to a JSON object.

**Scenario:**  
Each user is represented as a single document.

**Pitfalls:**  
- Deeply nested documents  

**Trade-offs:**  
Self-contained documents vs update complexity.

---

## Q5. How is data stored in collections in MongoDB?

**Answer:**  
Collections store groups of documents and do not enforce a strict schema.

**Scenario:**  
Different documents in the same collection can have different fields.

**Pitfalls:**  
- Inconsistent field naming  

**Trade-offs:**  
Flexibility vs data consistency.

---

## Q6. Describe what a MongoDB database is.

**Answer:**  
A database is a container for collections, providing logical separation of data.

**Scenario:**  
Separate databases for development and production.

**Pitfalls:**  
- Too many databases increasing overhead  

**Trade-offs:**  
Isolation vs management complexity.

---

## Q7. What is the default port on which MongoDB listens?

**Answer:**  
MongoDB listens on port **27017** by default.

**Scenario:**  
Clients connect using `mongodb://localhost:27017`.

**Pitfalls:**  
- Exposing the port publicly  

**Trade-offs:**  
Default simplicity vs security risks.

---

## Q8. How does MongoDB provide high availability and disaster recovery?

**Answer:**  
MongoDB uses replica sets with automatic failover to ensure availability.

**Scenario:**  
If the primary node fails, a secondary is promoted automatically.

**Pitfalls:**  
- Not monitoring replica health  

**Trade-offs:**  
High availability vs replication lag.

---

## Q9. What are indexes in MongoDB, and why are they used?

**Answer:**  
Indexes improve query performance by avoiding full collection scans.

**Scenario:**  
Indexing user email for fast lookup.

**Pitfalls:**  
- Too many indexes slowing writes  

**Trade-offs:**  
Read speed vs write overhead.

---

## Q10. What is the role of the `_id` field in MongoDB documents?

**Answer:**  
The `_id` field uniquely identifies each document and is indexed automatically.

**Scenario:**  
Used as the primary key.

**Pitfalls:**  
- Custom `_id` causing collisions  

**Trade-offs:**  
Uniqueness vs flexibility.

---

## Q11. How do you create a new MongoDB collection?

**Answer:**  
Collections are created implicitly on first insert or explicitly using a command.

**Scenario:**  
Insert first document to auto-create collection.

**Pitfalls:**  
- Relying on implicit creation in production  

**Trade-offs:**  
Ease vs control.

---

## Q12. What is the syntax to insert a document into a MongoDB collection?

**Answer:**  
Documents are inserted using `insertOne()` or `insertMany()`.

**Scenario:**  
Insert a user profile document.

**Pitfalls:**  
- Ignoring validation errors  

**Trade-offs:**  
Simplicity vs validation rigor.

---

## Q13. Describe how to read data from a MongoDB collection.

**Answer:**  
Data is read using queries that filter documents based on criteria.

**Scenario:**  
Fetch active users only.

**Pitfalls:**  
- Full scans without indexes  

**Trade-offs:**  
Flexible queries vs performance.

---

## Q14. Explain how to update documents in MongoDB.

**Answer:**  
Updates modify fields using operators like `$set`, `$inc`, or `$push`.

**Scenario:**  
Increment login count.

**Pitfalls:**  
- Overwriting entire documents accidentally  

**Trade-offs:**  
Powerful updates vs careful operator usage.

---

## Q15. What are the MongoDB commands for deleting documents?

**Answer:**  
Documents are deleted using `deleteOne()` or `deleteMany()`.

**Scenario:**  
Remove inactive user records.

**Pitfalls:**  
- Deleting without filters  

**Trade-offs:**  
Efficiency vs safety.

---

## Q16. Can you join two collections in MongoDB? If so, how?

**Answer:**  
MongoDB supports joins using the `$lookup` aggregation stage.

**Scenario:**  
Join orders with customers.

**Pitfalls:**  
- Heavy joins impacting performance  

**Trade-offs:**  
Convenience vs scalability.

---

## Q17. How do you limit the number of documents returned by a MongoDB query?

**Answer:**  
Use the `limit()` method.

**Scenario:**  
Display only top 10 results.

**Pitfalls:**  
- No sort before limit  

**Trade-offs:**  
Performance vs result accuracy.

---

## Q18. What is the difference between `find()` and `findOne()` in MongoDB?

**Answer:**  
`find()` returns a cursor; `findOne()` returns a single document.

**Scenario:**  
Fetch a single user profile.

**Pitfalls:**  
- Assuming `find()` returns one document  

**Trade-offs:**  
Flexibility vs simplicity.

---

## Q19. How can you achieve pagination in MongoDB?

**Answer:**  
Pagination is done using `skip()` and `limit()` or range-based queries.

**Scenario:**  
Paginate results in UI.

**Pitfalls:**  
- Large `skip()` causing performance issues  

**Trade-offs:**  
Ease vs scalability.

---

## Q20. What are the differences between MongoDB’s `insertOne` and `insertMany` methods?

**Answer:**  
`insertOne` inserts a single document; `insertMany` inserts multiple documents in bulk.

**Scenario:**  
Bulk data ingestion.

**Pitfalls:**  
- Partial failures in bulk inserts  

**Trade-offs:**  
Efficiency vs error handling complexity.

---

## Q21. Describe a compound index in MongoDB.

**Answer:**  
A compound index indexes multiple fields in a defined order.

**Scenario:**  
Index `{ country: 1, city: 1 }`.

**Pitfalls:**  
- Incorrect field order  

**Trade-offs:**  
Query optimization vs index size.

---

## Q22. What is the aggregation pipeline in MongoDB?

**Answer:**  
Aggregation pipeline processes data through stages to transform and analyze documents.

**Scenario:**  
Generate analytics reports.

**Pitfalls:**  
- Large pipelines consuming memory  

**Trade-offs:**  
Powerful analytics vs complexity.

---

## Q23. How can you create an index in MongoDB and when should you do it?

**Answer:**  
Indexes are created using `createIndex()` and should be added based on query patterns.

**Scenario:**  
Index frequently queried fields.

**Pitfalls:**  
- Premature indexing  

**Trade-offs:**  
Performance vs storage overhead.

---

## Q24. Explain how MongoDB’s `$match`, `$group`, and `$sort` operators work in an aggregation pipeline.

**Answer:**  
`$match` filters documents, `$group` aggregates data, and `$sort` orders results.

**Scenario:**  
Compute total sales per category.

**Pitfalls:**  
- Sorting before matching  

**Trade-offs:**  
Correct order improves performance.

---

## Q25. What is the purpose of the `explain()` method?

**Answer:**  
`explain()` shows how MongoDB executes a query, including index usage.

**Scenario:**  
Diagnose slow queries.

**Pitfalls:**  
- Ignoring execution stats  

**Trade-offs:**  
Insight vs complexity.

---
# MongoDB Interview Questions – Complete Guide
## Iteration 2/4 (Q26–Q50)
_Source: mongoDB-interview-questions.pdf_

---

## Q26. What is a replica set in MongoDB?

**Answer:**  
A replica set is a group of MongoDB nodes that maintain the same data set, providing redundancy and high availability. It consists of one primary node and one or more secondary nodes.

**Scenario:**  
If the primary node crashes, a secondary is automatically elected as the new primary.

**Pitfalls:**  
- Not configuring odd number of voting members  
- Ignoring replication lag  

**Trade-offs:**  
High availability vs additional infrastructure cost.

---

## Q27. How does MongoDB handle automatic failover?

**Answer:**  
MongoDB uses an election process where secondary nodes vote to select a new primary when the current primary becomes unavailable.

**Scenario:**  
Primary server goes down; within seconds, a new primary is elected.

**Pitfalls:**  
- Network partitions causing split-brain fears  
- Slow elections due to misconfiguration  

**Trade-offs:**  
Automatic recovery vs brief write unavailability during elections.

---

## Q28. What is replication lag and why is it important?

**Answer:**  
Replication lag is the delay between a primary writing data and secondaries replicating it.

**Scenario:**  
A read from a secondary returns stale data.

**Pitfalls:**  
- Reading critical data from secondaries  
- Ignoring lag in analytics  

**Trade-offs:**  
Improved read scalability vs data freshness.

---

## Q29. What are read preferences in MongoDB?

**Answer:**  
Read preferences control where queries are routed—primary, secondary, or nearest nodes.

**Scenario:**  
Analytics queries routed to secondaries to reduce load on primary.

**Pitfalls:**  
- Using secondary reads for transactional data  

**Trade-offs:**  
Load distribution vs consistency.

---

## Q30. What is write concern in MongoDB?

**Answer:**  
Write concern specifies the level of acknowledgment requested from MongoDB for write operations.

**Scenario:**  
Require acknowledgment from majority of replica set members.

**Pitfalls:**  
- Using low write concern for critical data  

**Trade-offs:**  
Durability vs write latency.

---

## Q31. What is journaling in MongoDB?

**Answer:**  
Journaling records write operations to disk before applying them to data files to ensure crash recovery.

**Scenario:**  
Server crash occurs; MongoDB replays journal on restart.

**Pitfalls:**  
- Disabling journaling for performance  

**Trade-offs:**  
Crash safety vs write performance.

---

## Q32. What is sharding in MongoDB?

**Answer:**  
Sharding distributes data across multiple machines to support horizontal scaling.

**Scenario:**  
Large user collection split across shards by user ID.

**Pitfalls:**  
- Poor shard key selection  

**Trade-offs:**  
Scalability vs operational complexity.

---

## Q33. What is a shard key and why is it important?

**Answer:**  
A shard key determines how data is distributed across shards.

**Scenario:**  
Using a hashed user ID as shard key for even distribution.

**Pitfalls:**  
- Monotonically increasing shard keys  

**Trade-offs:**  
Query efficiency vs even data distribution.

---

## Q34. What happens if you choose a bad shard key?

**Answer:**  
A bad shard key causes uneven data distribution and hotspots.

**Scenario:**  
All writes go to a single shard.

**Pitfalls:**  
- Inability to reshard easily  

**Trade-offs:**  
Early design decisions have long-term impact.

---

## Q35. How does MongoDB balance data across shards?

**Answer:**  
MongoDB uses a balancer process that migrates chunks between shards to maintain even distribution.

**Scenario:**  
New shard added; data redistributed automatically.

**Pitfalls:**  
- Balancer impacting performance during peak load  

**Trade-offs:**  
Balanced load vs migration overhead.

---

## Q36. What is a chunk in MongoDB sharding?

**Answer:**  
A chunk is a contiguous range of shard key values stored on a shard.

**Scenario:**  
Chunks move between shards during rebalancing.

**Pitfalls:**  
- Too many small chunks  

**Trade-offs:**  
Granularity vs management overhead.

---

## Q37. How does MongoDB ensure data consistency in sharded clusters?

**Answer:**  
MongoDB ensures consistency through routing via mongos, write concerns, and replication within shards.

**Scenario:**  
Writes routed correctly to owning shard.

**Pitfalls:**  
- Misconfigured routers  

**Trade-offs:**  
Consistency vs performance.

---

## Q38. What is `mongos` in MongoDB?

**Answer:**  
`mongos` is a query router that directs client requests to the appropriate shards.

**Scenario:**  
Application connects to mongos, not individual shards.

**Pitfalls:**  
- Treating mongos as data store  

**Trade-offs:**  
Abstraction vs additional network hop.

---

## Q39. How does MongoDB handle transactions?

**Answer:**  
MongoDB supports multi-document ACID transactions across replica sets and shards.

**Scenario:**  
Transfer money between two accounts safely.

**Pitfalls:**  
- Overusing transactions for high-volume writes  

**Trade-offs:**  
Strong consistency vs performance.

---

## Q40. What are multi-document transactions used for?

**Answer:**  
They are used when multiple related updates must succeed or fail together.

**Scenario:**  
Order creation and inventory update.

**Pitfalls:**  
- Long-running transactions  

**Trade-offs:**  
Atomicity vs throughput.

---

## Q41. How does MongoDB handle schema design?

**Answer:**  
Schema design focuses on access patterns, using embedding or referencing appropriately.

**Scenario:**  
Embed frequently accessed child data.

**Pitfalls:**  
- Over-normalization  

**Trade-offs:**  
Read efficiency vs update flexibility.

---

## Q42. When should you embed documents vs reference them?

**Answer:**  
Embed when data is frequently accessed together; reference when data is large or shared.

**Scenario:**  
Embed user profile, reference orders.

**Pitfalls:**  
- Exceeding document size limit  

**Trade-offs:**  
Performance vs data duplication.

---

## Q43. What is the maximum document size in MongoDB?

**Answer:**  
The maximum document size is **16 MB**.

**Scenario:**  
Storing large logs exceeds document limit.

**Pitfalls:**  
- Unbounded arrays  

**Trade-offs:**  
Document size limit enforces good design.

---

## Q44. How do capped collections work?

**Answer:**  
Capped collections have fixed size and automatically overwrite old data.

**Scenario:**  
Storing application logs.

**Pitfalls:**  
- Data loss due to overwriting  

**Trade-offs:**  
Predictable storage vs limited flexibility.

---

## Q45. What are TTL indexes?

**Answer:**  
TTL indexes automatically delete documents after a specified time.

**Scenario:**  
Auto-expire session data.

**Pitfalls:**  
- Assuming immediate deletion  

**Trade-offs:**  
Automation vs deletion delay.

---

## Q46. How does MongoDB handle full-text search?

**Answer:**  
MongoDB supports text indexes for basic full-text search.

**Scenario:**  
Search blog posts by keywords.

**Pitfalls:**  
- Expecting advanced search features  

**Trade-offs:**  
Built-in simplicity vs dedicated search engines.

---

## Q47. What is the WiredTiger storage engine?

**Answer:**  
WiredTiger is MongoDB’s default storage engine, offering document-level locking and compression.

**Scenario:**  
High-concurrency workloads benefit from fine-grained locking.

**Pitfalls:**  
- Misconfigured cache size  

**Trade-offs:**  
Performance vs memory usage.

---

## Q48. What is document-level locking?

**Answer:**  
Document-level locking allows concurrent operations on different documents.

**Scenario:**  
Multiple users update different records simultaneously.

**Pitfalls:**  
- Assuming collection-level locks  

**Trade-offs:**  
High concurrency vs lock management overhead.

---

## Q49. How does MongoDB handle concurrency?

**Answer:**  
MongoDB uses locks, optimistic concurrency control, and document-level locking.

**Scenario:**  
Concurrent writes handled efficiently.

**Pitfalls:**  
- Long-running writes blocking others  

**Trade-offs:**  
Concurrency vs transaction complexity.

---

## Q50. How do you optimize MongoDB performance?

**Answer:**  
Optimize using proper indexing, efficient schema design, query analysis, and hardware tuning.

**Scenario:**  
Slow queries fixed using index analysis.

**Pitfalls:**  
- Guessing optimizations without metrics  

**Trade-offs:**  
Performance tuning improves speed but requires monitoring.

---
# MongoDB Interview Questions – Complete Guide
## Iteration 3/4 (Q51–Q75)
_Source: mongoDB-interview-questions.pdf_

---

## Q51. How does MongoDB handle authentication?

**Answer:**  
MongoDB supports authentication using mechanisms like SCRAM (default), x.509 certificates, LDAP, and cloud IAM integrations. Authentication verifies user identity before allowing access.

**Scenario:**  
Applications authenticate using SCRAM credentials scoped to specific databases.

**Pitfalls:**  
- Running MongoDB without authentication  
- Sharing admin credentials  

**Trade-offs:**  
Strong security vs configuration complexity.

---

## Q52. What is authorization in MongoDB and how is it enforced?

**Answer:**  
Authorization controls what authenticated users can do, enforced through roles and privileges.

**Scenario:**  
A read-only role can query data but cannot modify collections.

**Pitfalls:**  
- Overly permissive roles  

**Trade-offs:**  
Granular control vs role management overhead.

---

## Q53. Explain MongoDB roles and role-based access control (RBAC).

**Answer:**  
RBAC assigns predefined or custom roles to users, granting specific privileges.

**Scenario:**  
Developers have readWrite on one database, read on others.

**Pitfalls:**  
- Role sprawl  

**Trade-offs:**  
Security precision vs administrative effort.

---

## Q54. How does MongoDB encrypt data?

**Answer:**  
MongoDB supports encryption in transit (TLS) and at rest using storage engine encryption.

**Scenario:**  
Client connections secured with TLS.

**Pitfalls:**  
- Misconfigured certificates  

**Trade-offs:**  
Security vs performance overhead.

---

## Q55. What is auditing in MongoDB?

**Answer:**  
Auditing records database activities for security and compliance purposes.

**Scenario:**  
Track who accessed or modified sensitive collections.

**Pitfalls:**  
- Excessive audit logs  

**Trade-offs:**  
Compliance visibility vs storage cost.

---

## Q56. How do you back up data in MongoDB?

**Answer:**  
Backups are performed using logical dumps or filesystem snapshots.

**Scenario:**  
Nightly snapshots for disaster recovery.

**Pitfalls:**  
- Backups without restore testing  

**Trade-offs:**  
Data safety vs operational overhead.

---

## Q57. What is `mongodump` and `mongorestore`?

**Answer:**  
`mongodump` exports data to BSON; `mongorestore` imports it back.

**Scenario:**  
Migrate data between environments.

**Pitfalls:**  
- Using dumps for very large datasets  

**Trade-offs:**  
Portability vs performance.

---

## Q58. How do you ensure backup consistency in MongoDB?

**Answer:**  
Use filesystem snapshots or consistent dumps with appropriate write concern.

**Scenario:**  
Pause writes briefly to ensure snapshot consistency.

**Pitfalls:**  
- Inconsistent snapshots  

**Trade-offs:**  
Consistency vs availability.

---

## Q59. What is point-in-time recovery (PITR)?

**Answer:**  
PITR allows restoring data to a specific moment using backups and oplog.

**Scenario:**  
Recover from accidental deletion.

**Pitfalls:**  
- Insufficient oplog retention  

**Trade-offs:**  
Fine-grained recovery vs storage usage.

---

## Q60. How does MongoDB handle logging?

**Answer:**  
MongoDB logs events such as startup, queries, and errors to log files or system logs.

**Scenario:**  
Analyze slow queries using logs.

**Pitfalls:**  
- Logging too verbosely  

**Trade-offs:**  
Observability vs disk usage.

---

## Q61. What is the MongoDB oplog?

**Answer:**  
The oplog is a capped collection recording write operations for replication.

**Scenario:**  
Secondaries replay oplog entries to stay in sync.

**Pitfalls:**  
- Small oplog size causing lag  

**Trade-offs:**  
Replication reliability vs storage.

---

## Q62. How does MongoDB handle crash recovery?

**Answer:**  
MongoDB replays journal files on restart to recover from crashes.

**Scenario:**  
Server restarts after power failure without data loss.

**Pitfalls:**  
- Disabled journaling  

**Trade-offs:**  
Crash safety vs write throughput.

---

## Q63. What is a storage engine in MongoDB?

**Answer:**  
A storage engine manages how data is stored and retrieved on disk.

**Scenario:**  
WiredTiger handles most modern workloads.

**Pitfalls:**  
- Choosing inappropriate engine  

**Trade-offs:**  
Performance vs feature set.

---

## Q64. How does MongoDB handle data compression?

**Answer:**  
MongoDB compresses data at rest to reduce storage and I/O.

**Scenario:**  
Large datasets consume less disk.

**Pitfalls:**  
- CPU overhead for compression  

**Trade-offs:**  
Storage efficiency vs CPU cost.

---

## Q65. What is the difference between MMAPv1 and WiredTiger?

**Answer:**  
WiredTiger provides document-level locking and compression; MMAPv1 is deprecated.

**Scenario:**  
High concurrency workloads benefit from WiredTiger.

**Pitfalls:**  
- Using legacy engines  

**Trade-offs:**  
Modern features vs legacy compatibility.

---

## Q66. How does MongoDB handle read and write locks?

**Answer:**  
MongoDB uses fine-grained locks, primarily at document level with WiredTiger.

**Scenario:**  
Concurrent updates on different documents proceed in parallel.

**Pitfalls:**  
- Long-running operations blocking others  

**Trade-offs:**  
Concurrency vs lock management.

---

## Q67. What is a covered query in MongoDB?

**Answer:**  
A covered query is served entirely from an index without accessing documents.

**Scenario:**  
Query returns fields already in index.

**Pitfalls:**  
- Forgetting projection alignment  

**Trade-offs:**  
Speed vs index size.

---

## Q68. How does MongoDB optimize query execution?

**Answer:**  
MongoDB uses query planners, indexes, and execution statistics to choose optimal plans.

**Scenario:**  
Planner selects best index automatically.

**Pitfalls:**  
- Ignoring plan cache issues  

**Trade-offs:**  
Automatic optimization vs occasional manual tuning.

---

## Q69. What is the plan cache in MongoDB?

**Answer:**  
The plan cache stores winning query plans for reuse.

**Scenario:**  
Repeated queries execute faster.

**Pitfalls:**  
- Stale plans after schema changes  

**Trade-offs:**  
Performance vs adaptability.

---

## Q70. How do you analyze slow queries in MongoDB?

**Answer:**  
Use profiling, logs, and `explain()` to identify bottlenecks.

**Scenario:**  
Investigate slow aggregation pipelines.

**Pitfalls:**  
- Not correlating with workload  

**Trade-offs:**  
Insight vs monitoring overhead.

---

## Q71. What is MongoDB profiling?

**Answer:**  
Profiling records database operations based on execution time.

**Scenario:**  
Capture slow queries automatically.

**Pitfalls:**  
- Profiling all operations  

**Trade-offs:**  
Visibility vs performance cost.

---

## Q72. How does MongoDB handle large file storage?

**Answer:**  
MongoDB uses GridFS to store large files by splitting them into chunks.

**Scenario:**  
Store media files larger than 16 MB.

**Pitfalls:**  
- Using GridFS for simple file storage  

**Trade-offs:**  
Database integration vs specialized storage services.

---

## Q73. What is GridFS and when should it be used?

**Answer:**  
GridFS stores large binary data exceeding document size limits.

**Scenario:**  
Storing videos within MongoDB.

**Pitfalls:**  
- Overhead for small files  

**Trade-offs:**  
Convenience vs performance.

---

## Q74. How does MongoDB handle version upgrades?

**Answer:**  
Upgrades are performed incrementally, following compatibility guidelines.

**Scenario:**  
Upgrade replica set members one at a time.

**Pitfalls:**  
- Skipping major versions  

**Trade-offs:**  
Safety vs upgrade speed.

---

## Q75. What deployment strategies are used for MongoDB in production?

**Answer:**  
Production deployments use replica sets, sharding, monitoring, and backups.

**Scenario:**  
Sharded cluster with replicas for HA and scale.

**Pitfalls:**  
- Single-node deployments  

**Trade-offs:**  
Reliability vs operational complexity.

---
# MongoDB Interview Questions – Complete Guide
## Iteration 4/4 (Q76–Q100)
_Source: mongoDB-interview-questions.pdf_

---

## Q76. What is MongoDB Atlas?

**Answer:**  
MongoDB Atlas is a fully managed cloud database service that handles provisioning, scaling, backups, monitoring, and security.

**Scenario:**  
Teams deploy databases without managing servers.

**Pitfalls:**  
- Blind reliance on defaults  

**Trade-offs:**  
Operational simplicity vs reduced low-level control.

---

## Q77. How does MongoDB Atlas ensure high availability?

**Answer:**  
Atlas deploys replica sets across multiple availability zones with automatic failover.

**Scenario:**  
A zone outage triggers automatic primary election.

**Pitfalls:**  
- Single-region deployment  

**Trade-offs:**  
Availability vs higher cloud cost.

---

## Q78. What monitoring tools are available for MongoDB?

**Answer:**  
MongoDB provides built-in monitoring, Atlas dashboards, and integration with external tools.

**Scenario:**  
Track CPU usage, query latency, and replication lag.

**Pitfalls:**  
- Ignoring alert thresholds  

**Trade-offs:**  
Visibility vs monitoring overhead.

---

## Q79. How does MongoDB support autoscaling?

**Answer:**  
Atlas supports automatic scaling of storage and compute based on usage.

**Scenario:**  
Cluster scales during traffic spikes.

**Pitfalls:**  
- Cost overruns  

**Trade-offs:**  
Elasticity vs budget predictability.

---

## Q80. What is MongoDB Compass?

**Answer:**  
MongoDB Compass is a GUI tool for querying, schema visualization, and index management.

**Scenario:**  
Developers analyze schema and queries visually.

**Pitfalls:**  
- Using GUI in production workflows  

**Trade-offs:**  
Ease of use vs automation.

---

## Q81. How do you migrate data into MongoDB?

**Answer:**  
Data migration is done using import tools, connectors, or custom scripts.

**Scenario:**  
Migrate relational data into documents.

**Pitfalls:**  
- Poor schema translation  

**Trade-offs:**  
Flexibility vs migration complexity.

---

## Q82. How does MongoDB integrate with applications?

**Answer:**  
MongoDB integrates via official drivers supporting multiple languages.

**Scenario:**  
Application uses connection pooling.

**Pitfalls:**  
- Incorrect pool sizing  

**Trade-offs:**  
Ease of integration vs tuning needs.

---

## Q83. What are MongoDB drivers and why are they important?

**Answer:**  
Drivers enable applications to communicate with MongoDB using native language APIs.

**Scenario:**  
Driver handles serialization and retries.

**Pitfalls:**  
- Outdated driver versions  

**Trade-offs:**  
Abstraction vs understanding internals.

---

## Q84. How do you optimize MongoDB connection pooling?

**Answer:**  
Tune pool size based on workload and concurrency.

**Scenario:**  
Prevent connection exhaustion.

**Pitfalls:**  
- Too many open connections  

**Trade-offs:**  
Throughput vs resource usage.

---

## Q85. What is MongoDB Stitch / Realm?

**Answer:**  
MongoDB Realm provides backend services like auth, triggers, and serverless functions.

**Scenario:**  
Mobile apps sync data seamlessly.

**Pitfalls:**  
- Vendor lock-in  

**Trade-offs:**  
Rapid development vs portability.

---

## Q86. How does MongoDB handle real-time analytics?

**Answer:**  
MongoDB supports aggregation pipelines and change streams.

**Scenario:**  
Real-time dashboards update on data changes.

**Pitfalls:**  
- Heavy aggregations on primary  

**Trade-offs:**  
Real-time insight vs performance impact.

---

## Q87. What are change streams in MongoDB?

**Answer:**  
Change streams provide real-time notifications of data changes.

**Scenario:**  
Trigger downstream processing on inserts.

**Pitfalls:**  
- Not handling resume tokens  

**Trade-offs:**  
Event-driven design vs operational complexity.

---

## Q88. How does MongoDB support time-series data?

**Answer:**  
MongoDB provides time-series collections optimized for time-based data.

**Scenario:**  
Store sensor or metrics data efficiently.

**Pitfalls:**  
- Using regular collections  

**Trade-offs:**  
Performance vs learning curve.

---

## Q89. What are transactions best practices in MongoDB?

**Answer:**  
Keep transactions short, limit scope, and avoid high contention.

**Scenario:**  
Atomic updates across collections.

**Pitfalls:**  
- Long-running transactions  

**Trade-offs:**  
Consistency vs throughput.

---

## Q90. How does MongoDB support ACID properties?

**Answer:**  
MongoDB provides ACID guarantees at document and transaction level.

**Scenario:**  
Financial operations require atomicity.

**Pitfalls:**  
- Assuming SQL-like performance  

**Trade-offs:**  
Strong consistency vs latency.

---

## Q91. How do you design MongoDB for multi-tenant applications?

**Answer:**  
Use tenant isolation via databases, collections, or fields.

**Scenario:**  
Separate data per tenant.

**Pitfalls:**  
- Shared noisy tenants  

**Trade-offs:**  
Isolation vs operational overhead.

---

## Q92. What are common anti-patterns in MongoDB schema design?

**Answer:**  
Over-normalization, large documents, and missing indexes.

**Scenario:**  
Using joins excessively.

**Pitfalls:**  
- SQL mindset  

**Trade-offs:**  
MongoDB requires access-pattern-driven design.

---

## Q93. How do you secure MongoDB in production?

**Answer:**  
Enable authentication, TLS, firewalls, and auditing.

**Scenario:**  
Restrict network access.

**Pitfalls:**  
- Exposing MongoDB publicly  

**Trade-offs:**  
Security vs setup complexity.

---

## Q94. How does MongoDB handle horizontal scaling?

**Answer:**  
MongoDB scales horizontally using sharding.

**Scenario:**  
Add shards as data grows.

**Pitfalls:**  
- Resharding difficulty  

**Trade-offs:**  
Scalability vs design complexity.

---

## Q95. How does MongoDB handle global deployments?

**Answer:**  
MongoDB supports global clusters with data locality.

**Scenario:**  
Users served from nearest region.

**Pitfalls:**  
- Cross-region latency  

**Trade-offs:**  
Low latency vs synchronization cost.

---

## Q96. How do you test MongoDB performance?

**Answer:**  
Use load testing, profiling, and monitoring.

**Scenario:**  
Benchmark queries before production.

**Pitfalls:**  
- Testing without realistic data  

**Trade-offs:**  
Accuracy vs test complexity.

---

## Q97. How do you monitor MongoDB health?

**Answer:**  
Monitor resource usage, replication lag, and error rates.

**Scenario:**  
Alerts for disk or lag thresholds.

**Pitfalls:**  
- Reactive monitoring only  

**Trade-offs:**  
Proactive monitoring reduces outages.

---

## Q98. What is the role of backups in MongoDB disaster recovery?

**Answer:**  
Backups ensure data restoration after catastrophic failures.

**Scenario:**  
Restore after data corruption.

**Pitfalls:**  
- Untested restores  

**Trade-offs:**  
Storage cost vs safety.

---

## Q99. How does MongoDB compare with other NoSQL databases?

**Answer:**  
MongoDB excels in flexibility and rich queries.

**Scenario:**  
Choose MongoDB for evolving schemas.

**Pitfalls:**  
- Wrong tool choice  

**Trade-offs:**  
Feature richness vs specialization.

---

## Q100. What best practices should be followed when using MongoDB?

**Answer:**  
Design schemas based on queries, index wisely, secure deployments, and monitor continuously.

**Scenario:**  
Well-tuned production cluster.

**Pitfalls:**  
- Ignoring performance metrics  

**Trade-offs:**  
Best practices require discipline but ensure stability.

---
