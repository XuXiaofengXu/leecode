!!!# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a personal LeetCode practice repository written in Java. The codebase contains solutions to various algorithmic problems organized by data structure categories.

## Project Structure

```
src/
├── dp/           # Dynamic Programming problems
├── queue/        # Queue-related problems
├── stack/        # Stack-related problems
└── unitTest.java # JUnit test file
```

- **Problem Naming**: Files follow the pattern `no_[problem_number]_[description].java` for LeetCode problems, or `面试题_[id]_[description].java` for interview questions
- **Package Structure**: Each category (dp, queue, stack) has its own package
- **Testing**: Uses JUnit 5 for unit tests (see `src/unitTest.java`)

## Development Commands

Since this is a plain Java project without Maven/Gradle:

### Running Tests
```bash
# Compile test file (JUnit 5 dependency needed in classpath)
javac -cp ".:junit-platform-console-standalone.jar" src/unitTest.java

# Run tests
java -jar junit-platform-console-standalone.jar --class-path . --scan-class-path
```

### Compiling Individual Solutions
```bash
# Compile a specific solution
javac src/stack/no_20_有效的括号.java

# Run if it has a main method
java stack.no_20_有效的括号
```

## Code Architecture

- **Package Organization**: Solutions are organized by data structure categories:
  - `dp/` - Dynamic Programming problems
  - `queue/` - Queue-related problems
  - `stack/` - Stack-related problems
  - Additional categories may be added as needed

- **Class Structure**: Each problem solution is a standalone Java class focused on algorithm implementation
  - Classes use descriptive Chinese names for educational purposes
  - Many solutions include `main()` methods for manual testing and debugging
  - Package-private access is common since each file serves as an independent solution

- **Algorithm Patterns**: The codebase demonstrates common algorithmic approaches:
  - Stack-based validation and traversal (e.g., bracket matching, tree traversals)
  - Queue-based scheduling and data processing
  - Priority queue usage for optimization problems
  - Dynamic programming for recursive problem-solving

## Testing Approach

- **Centralized Testing**: Unit tests are located in `src/unitTest.java` using JUnit 5
- **Test Coverage**: Currently has limited test coverage - only `no_621_任务调度器` is tested
- **Manual Testing**: Many classes include `main()` methods for ad-hoc testing
- **Testing Pattern**: Tests focus on edge cases and algorithm verification with specific input/output validation

## Key Implementation Details

- **String Handling**: Uses `toCharArray()` for efficient string processing in stack/queue problems
- **Data Structure Usage**:
  - Standard Java collections (Stack, Queue, PriorityQueue, HashMap)
  - Custom comparators for priority queue ordering
  - Temporal storage patterns for batching operations
- **Algorithm Optimization**: Solutions prioritize time/space complexity over OOP design patterns