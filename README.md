# Software-Eng-I-Assignment-2-Architectural-Refactoring-Optimization-
This project involved the comprehensive architectural analysis and refactoring of a monolithic, tightly coupled Java-based submission and evaluation system.

> **An enterprise-grade architectural analysis and refactoring project demonstrating the transition from a tightly coupled procedural monolith to a highly cohesive, event-driven, domain-centric application.**

## Project Overview
This project involves the comprehensive audit, redesign, and empirical benchmarking of a Java-based academic submission and peer-review system. 

The primary objective was to identify severe violations of software engineering principles (GRASP and S.O.L.I.D.) within a baseline application and refactor it into a modular, scalable architecture. The resulting optimized system achieved a **~77.5% reduction in computational latency** and a **~44% reduction in method call overhead**.

---

## The Problem: Baseline Technical Debt
The original legacy system (Task 1) suffered from severe anti-patterns and bottlenecks:
* **"God Object" Anti-patterns:** The `SubmissionController` illegally orchestrated backend domain logic and evaluation lifecycles, violating High Cohesion.
* **The N+1 Query Problem:** The application memory was used to filter massive datasets (`checkWorkload`, `filterConflicts`) rather than leveraging native database persistence layer queries.
* **Procedural Spaghetti Logic:** Business rules and grading thresholds were buried inside deeply nested, unmaintainable `if/else` statements relying on hidden state mutations.
* **Synchronous Bottlenecks:** The UI thread was forced to synchronously orchestrate long-running, asynchronous human tasks (peer reviewing), creating severe flow coupling.

---

## Architectural Solutions Implemented
The system was completely re-engineered using modern enterprise design patterns:

### 1. The Repository Pattern (Information Expert)
Replaced the monolithic `Database` class with specialized Data Access Objects (`SubmissionDB`, `ReviewerDB`, `EvaluationDB`). Data filtering was pushed to the persistence boundary, completely eliminating the in-memory N+1 data fetching problem.

### 2. Decision Management System (Strategy Pattern & OCP)
Extracted the procedural, string-matching grading logic into a mathematically proven, 7-Rule Decision Table (`DMS.java`). The system is now Open for Extension but Closed for Modification (OCP)—if university grading policies change, the core application control flow remains untouched.

### 3. Event-Driven Decoupling
Introduced an autonomous `SystemScheduler` to logically sever the *Submission Phase* from the *Evaluation Phase*. The system now accurately models asynchronous real-world actors, triggering evaluations autonomously only when all data conditions are met.

### 4. Polymorphic Dispatch
Streamlined system actions using a centralized `NotificationService` that responds dynamically to polymorphic `OutcomeObject` states, eliminating hardcoded procedural branching.

---

## Empirical Benchmarks (Before vs. After)
The architectural refactoring was verified using a custom `MetricTracker`, benchmarking 10,000 execution lifecycles to prove empirical impact:

| Metric | Task 1 (Baseline) | Task 5 (Optimised) | Empirical Impact |
| :--- | :--- | :--- | :--- |
| **Total Method Invocations** | 27 Calls | 15 Calls | **~44% Reduction in computational overhead** |
| **Execution Latency (10k runs)** | 9060.01 ms | 2041.98 ms | **~77.5% Faster execution (4.4x speedup)** |
| **Data Filtering Complexity** | $O(N)$ (In-memory loop) | $O(1)$ (Delegated to Repo) | **Eliminated the N+1 Problem** |
| **Control Flow Complexity** | High (Deeply nested `alt`) | Low ($O(1)$ lookup matrix) | **Flattened decision logic** |

---

## Repository Structure

```text
├── task1-baseline/           # The original, flawed procedural implementation
├── task5-optimised/          # The refactored, S.O.L.I.D. Clean Architecture codebase
│   ├── App.java              # Execution and benchmarking script
│   ├── DMS.java              # Decision Management System (Rule Engine)
│   ├── SubmissionController.java 
│   └── *DB.java              # Repository layer classes
└── docs/                     # Final Technical Report & Empirical Evaluations
