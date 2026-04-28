# Software-Eng-I-Assignment-2-Architectural-Refactoring-Optimization
This project involved the comprehensive architectural analysis and refactoring of a monolithic, tightly coupled Java-based submission and evaluation system.

> **An architectural analysis and refactoring project demonstrating the transition from a tightly coupled procedural monolith to a highly cohesive application.**

## Project Overview
This project involves the audit, redesign, and empirical benchmarking of a Java-based academic submission.

The primary objective was to identify severe violations of software engineering principles (GRASP and S.O.L.I.D.) within a baseline application and refactor it into a modular, scalable architecture. The resulting optimized system achieved a **~77.5% reduction in computational latency** and a **~44% reduction in method call overhead**.

Please note that this is an **architectural proof-of-concept and mock implementation** designed specifically to evaluate backend design patterns (S.O.L.I.D. and GRASP). 
* **No External UI/Database:** The system does not connect to a physical relational database or a web-based frontend. Data is persisted using simulated, in-memory Java objects.
* **Simulated Asynchrony:** To benchmark the decoupled evaluation lifecycle without requiring real human reviewers to log in days later, the system utilizes a mock test stub (`simulateScoreSubmission()`). This programmatically replicates the passage of time and asynchronous data entry.

---

## Benchmarks (Before vs. After)
The architectural refactoring was verified using a custom `MetricTracker`, benchmarking 1000 execution impact:

| Metric | Task 1 (Baseline) | Task 5 (Optimised) | Empirical Impact |
| :--- | :--- | :--- | :--- |
| **Total Method Invocations (1 run)** | 27 Calls | 15 Calls | **44% computational overhead difference** |
| **Execution Latency (1k runs)** | 9060.01 ms | 2041.98 ms | **77.5% execution speedup** |

