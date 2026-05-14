# Software-Eng-I-Assignment-2-Architectural-Refactoring-Optimization
This project involved the comprehensive architectural analysis and refactoring of a monolithic, tightly coupled Java-based submission and evaluation system.

> **An architectural analysis and refactoring project demonstrating the transition from a tightly coupled procedural monolith to a highly cohesive application.**

## Project Overview
This project involves the audit, redesign, and empirical benchmarking of a Java-based academic submission.

This project demonstrates the complete end-to-end refactoring of an "Intelligent Submission and Review System." The primary objective was to translate a flawed behavioural model into a baseline implementation, critically evaluate its inefficiencies, and re-implement a highly optimized, decoupled architecture. The resulting optimized system achieved a **77.5% reduction in computational latency** and a **44% reduction in method call overhead**.

### Please note that this is an **architectural proof-of-concept and mock implementation** designed specifically to evaluate backend design patterns (S.O.L.I.D. and GRASP). 
**No External UI/Database:** The system does not connect to a physical relational database or a web-based frontend. Data is persisted using simulated, in-memory Java objects.
**Simulated Asynchrony:** To benchmark the decoupled evaluation lifecycle without requiring real human reviewers to log in days later, the system utilizes a mock test stub (`simulateScoreSubmission()`). This programmatically replicates the passage of time and asynchronous data entry.

---
### Decoupled Execution Flow
#### Phase 1: The Submission Sequence
The boundary controller now handles validation and assignment, delegating data persistence to the Information Expert (`SubmissionDB` and `ReviewerDB`) before terminating its lifecycle.

![Submission Sequence Diagram](task4-architecture/submission-sequence.png)

#### Phase 2: The Evaluation Sequence
Triggered asynchronously by the `SystemScheduler`, this phase uses the `DMS` (Decision Management System) to evaluate scores and dispatches an outcome to the `NotificationService`.

![Evaluation Sequence Diagram](task4-architecture/evaluation-sequence.png)
---

## Benchmarks (Before vs. After)
The architectural refactoring was verified using a custom `MetricTracker`, benchmarking 1000 execution impact:

| Metric | Task 1 (Baseline) | Task 5 (Optimised) | Empirical Impact |
| :--- | :--- | :--- | :--- |
| **Total Method Invocations (1 run)** | 27 Calls | 15 Calls | **44% computational overhead difference** |
| **Execution Latency (1k runs)** | 9060.01 ms | 2041.98 ms | **77.5% execution speedup** |

