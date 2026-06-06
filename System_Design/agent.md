# Design: AI Customer Support Agent

## Overview

Design an AI Customer Support Agent that can: answer customer questions, check order status, process refunds, create support tickets, access the company knowledge base, escalate complex issues to humans, and operate at scale.

## Clarifying Questions

- Input types: text, images, voice — which are required? Different inputs need different models and infrastructure.
- Data sources: company knowledge, customer-specific data, or both?
  - Company examples: return policies, FAQs, product manuals.
  - Customer examples: orders, refund history, profile.
- Allowed actions: read-only (answer questions) or perform actions (cancel orders, issue refunds, create tickets)?
- Scale and performance:
  - Daily active users, requests-per-second, global distribution.
  - Targets: max latency, availability (e.g., latency < 3s, availability > 99.9%).

## Requirements

- Functional: question answering, order lookup, refunds, ticketing, escalation.
- Non-functional: low latency, high availability, strong security and auditability, cost efficiency.

## Chatbot vs AI Agent

- Chatbot: primarily retrieves information. Flow: user -> RAG -> LLM -> answer.
- AI Agent: reasons and takes actions. Flow: user -> LLM -> tool selection -> tool execution -> final response. Requires decision logic, tool orchestration, and business-rule enforcement.

## Example Workflow

User request: "Where is my order #12345? If delayed more than 3 days, refund me."

1. Understand request (extract orderId, condition, action):

```json
{
  "orderId": "12345",
  "condition": "delay > 3",
  "action": "refund"
}
```

2. Call tool: `get_order_status(orderId)` -> {"delay_days": 5}
3. Evaluate condition: 5 > 3 -> true
4. Call refund service: `create_refund(orderId, reason, request_id)`
5. Respond to user: refund initiated successfully, status and next steps.

## High-level Architecture

Client (Web/Mobile/Chat)
-> API Gateway
-> Agent Service
-> LLM (reasoning)
-> RAG / Vector DB (knowledge retrieval)
-> Memory (conversation/session store)
-> Tool Executor (calls backend services)
-> Order Service, Refund Service, Ticketing Service, etc.

## Design Principles

- Keep business logic and authoritative decisions in backend services — LLM must not be the source of truth.
- Use LLM for interpretation, intent extraction, and orchestrating tools.
- Ensure auditable pathways for every action (who requested, what tool called, request IDs).

## Hallucination Protection

- Never trust the LLM alone for critical decisions (refund approval, cancelations).
- Always validate actions with the authoritative service: if LLM says "refund approved", require the Refund Service to confirm.

## Tooling and APIs

Common tool calls:

```text
get_order_status(orderId)
create_refund(orderId, amount, reason, request_id)
create_ticket(payload)
get_policy(policyId)
```

Agent chooses tools dynamically based on intent and confidence.

## Failure Handling and Idempotency

- Problem: network timeouts can make the agent unsure whether a tool action succeeded.
- Solution: attach a unique `request_id` to side-effecting calls. Backend services should detect duplicates and return canonical status.

Example:

```text
create_refund(order=123, key=R789)
```

If retried with the same `key`, the Refund Service responds "already processed".

## Scaling & Cost Optimization

- Decompose into independently scalable services: Agent Service, RAG Service, Tool Services.
- Cache frequent, low-cost answers (e.g., return policy) to avoid LLM calls.
- Route requests to model sizes by complexity: small model for FAQs, larger model for complex reasoning.

## Conversation Memory

- Use session or vector memory to resolve references ("it" -> previous order).
- Storage options: Redis (session), Vector DB (semantic memory), persistent user-store for long-term context.

## Human Escalation

- Escalate when: low-confidence, high financial risk, policy ambiguity, or repeated failures.
- Workflow: Agent flags and creates an escalation ticket or routes to human support with context and transcripts.

## Evaluation Metrics

- System: latency, availability, error rate.
- AI: task completion rate, tool success rate, hallucination rate, escalation rate.
- Business: customer satisfaction (CSAT), time-to-resolution.

## Next Steps

- Define precise SLA and traffic targets.
- List required backend APIs and their idempotency contracts.
- Decide supported input modalities and required models.

---

If you want, I can also:

- extract a one-page diagram, or
- add example API contracts for `create_refund` and `get_order_status`.
