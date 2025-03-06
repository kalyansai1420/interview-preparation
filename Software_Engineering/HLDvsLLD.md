# HLD vs LLD

## Key differences

- Level of details
  - HLD is about what major components exist and how they communicate
  - LLD is about how those components are implemented internally (class structures, mehtods, etc)
- Audience
  - HLD is typically for a broader audience (architects, product owners, etc) who need to see how the system fits together at a big-picture level
  - LLD is primarily for developers who need to know how implement system's internals
- Timing
  - HLD often comes first, to ensure the architecture fits the product requirements
  - LLD follows to detail how each piece of HLD will be concretely built.
- Artifacts
  - HLD might produce diagrams such as components diagrams or system context diagrams
  - LLD might produce class diagrams, ER diagrams, sequence diagrams or even pseudocode
- Abstraction vs. Implementation
  - HDL stays at a level of conceptual abstraction (services, data flows,APIs)
  - LLD deals with real implementation details (class interface, method signatures, desgin patterns)

## Overall
- High-Level Design = Architecture + Major Components + System Interactions
- Low-Level Design = Class Diagrams + Detailed Logic + Internal Workings