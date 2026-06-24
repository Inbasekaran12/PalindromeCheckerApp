# Contributing to Palindrome Checker App

Thank you for your interest in contributing to the Palindrome Checker App! We appreciate your help and feedback.

## Getting Started

1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/your-username/PalindromeCheckerApp.git
   ```
3. **Create a new branch** for your feature:
   ```bash
   git checkout -b feature/your-feature-name
   ```

## Development Setup

```bash
# Install dependencies (Maven will handle this)
mvn clean install

# Run tests to ensure everything works
mvn test

# Run the application
mvn exec:java -Dexec.mainClass="PalindromeCheckerApp"
```

## Code Style & Standards

- **Java Conventions**: Follow standard Java naming conventions
- **JavaDoc**: Document all public classes and methods
- **Formatting**: Use 4-space indentation
- **Line Length**: Keep lines under 120 characters
- **Comments**: Write clear, concise comments explaining WHY, not WHAT

### Example:

```java
/**
 * Validates if the input string is a valid palindrome candidate.
 *
 * @param input The input string to validate
 * @return true if input is valid, false otherwise
 */
public static boolean isValidInput(String input) {
    // Check for null or whitespace-only input
    return input != null && !input.trim().isEmpty();
}
```

## Testing Requirements

- **Write tests** for all new features
- **Minimum coverage**: 80%
- **Test naming**: Use descriptive names like `testPalindromeWithSpaces()`
- **Run tests locally** before pushing:
  ```bash
  mvn test
  ```

## Commit Message Guidelines

Use **Conventional Commits** format:

- `feat:` New feature (e.g., `feat: add recursive palindrome strategy`)
- `fix:` Bug fix (e.g., `fix: handle edge case for single character`)
- `docs:` Documentation update (e.g., `docs: update README with examples`)
- `refactor:` Code refactoring (e.g., `refactor: extract validation logic`)
- `perf:` Performance improvement (e.g., `perf: optimize two-pointer algorithm`)
- `test:` Add or update tests (e.g., `test: add edge case tests`)
- `chore:` Maintenance (e.g., `chore: update dependencies`)

### Examples:

```
feat: implement recursive strategy for palindrome checking
fix: correct off-by-one error in two-pointer algorithm
docs: add performance comparison table to README
test: increase test coverage to 95%
```

## Creating a Pull Request

1. **Push to your fork**:

   ```bash
   git push origin feature/your-feature-name
   ```

2. **Create a Pull Request** on GitHub with:
   - Clear title describing the change
   - Detailed description of what and why
   - Reference to any related issues
   - Screenshots/output if applicable

3. **PR Template**:

   ```markdown
   ## Description

   [Brief description of your changes]

   ## Motivation

   [Why is this change needed?]

   ## Testing

   [How was this tested?]

   ## Checklist

   - [ ] Tests added/updated
   - [ ] Documentation updated
   - [ ] All tests passing locally
   - [ ] Code follows style guidelines
   ```

## Feature Request & Bug Reports

### Bug Report

```markdown
**Description**: [Clear description of the issue]
**Steps to Reproduce**:

1. [Step 1]
2. [Step 2]

**Expected Behavior**: [What should happen]
**Actual Behavior**: [What actually happens]
**Environment**: Java version, OS, etc.
```

### Feature Request

```markdown
**Title**: [Clear, concise title]
**Motivation**: [Why is this feature needed?]
**Proposed Solution**: [How should it work?]
**Alternative Solutions**: [Any alternatives?]
```

## Review Process

1. We'll review your PR as soon as possible
2. May request changes or improvements
3. Once approved, your PR will be merged
4. You'll be credited in the CONTRIBUTORS file

## Code Review Criteria

- **Correctness**: Does the code work as intended?
- **Quality**: Is it well-structured and readable?
- **Testing**: Are there sufficient tests?
- **Documentation**: Is it well-documented?
- **Performance**: Are there any performance concerns?
- **Security**: Any security vulnerabilities?

## Running CI/CD Locally

```bash
# Run full test suite
mvn clean test

# Generate coverage report
mvn jacoco:report

# Build JAR
mvn package

# Run static analysis
mvn checkstyle:check
```

## Questions or Need Help?

- 📖 Check existing [Issues](https://github.com/yourusername/PalindromeCheckerApp/issues)
- 💬 Start a [Discussion](https://github.com/yourusername/PalindromeCheckerApp/discussions)
- 📧 Email: your.email@example.com

## License

By contributing, you agree that your contributions will be licensed under the MIT License.

---

Thank you for contributing! 🎉
