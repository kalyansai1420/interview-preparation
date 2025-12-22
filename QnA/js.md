# JavaScript Interview Questions – Complete Guide
## Iteration 1/4 (Q1–Q25)
_Source: javascript-interview-questions.pdf_

---

## Q1. What are the data types present in JavaScript?

**Answer:**  
JavaScript has **primitive** and **non-primitive** data types. Primitive types include `string`, `number`, `boolean`, `null`, `undefined`, `symbol`, and `bigint`. The non-primitive type is `object`, which includes arrays, functions, and objects.

**Scenario:**  
A user profile may store primitives (name, age) and objects (address).

**Pitfalls:**  
- Assuming arrays are a separate type  
- Confusing `null` as an object (historical JS quirk)

**Trade-offs:**  
Dynamic typing increases flexibility but can cause runtime errors.

---

## Q2. What is the difference between null and undefined?

**Answer:**  
`undefined` means a variable is declared but not assigned, while `null` represents an intentional absence of value.

**Scenario:**  
A function parameter not passed is `undefined`; resetting a value intentionally uses `null`.

**Pitfalls:**  
- Treating both as identical  
- Loose equality confusion (`null == undefined` is true)

**Trade-offs:**  
Clear distinction improves intent but requires discipline.

---

## Q3. How does JavaScript handle type coercion?

**Answer:**  
JavaScript automatically converts values between types during operations, known as **implicit coercion**.

**Scenario:**  
`"5" + 1` results in `"51"` due to string coercion.

**Pitfalls:**  
- Relying on coercion unknowingly  
- Unexpected comparisons

**Trade-offs:**  
Convenience vs unpredictability.

---

## Q4. Explain the concept of hoisting in JavaScript.

**Answer:**  
Hoisting moves variable and function declarations to the top of their scope during compilation.

**Scenario:**  
Functions can be called before they are defined.

**Pitfalls:**  
- Assuming variables are initialized  
- Confusion with `let` and `const`

**Trade-offs:**  
Hoisting aids flexibility but can reduce readability.

---

## Q5. What is the scope in JavaScript?

**Answer:**  
Scope defines where variables are accessible. JavaScript has global, function, block, and lexical scope.

**Scenario:**  
Variables inside a function aren’t accessible outside.

**Pitfalls:**  
- Global variable leakage  

**Trade-offs:**  
Lexical scoping improves predictability.

---

## Q6. What is the difference between == and === ?

**Answer:**  
`==` compares values after type coercion, while `===` compares both value and type strictly.

**Scenario:**  
`"5" == 5` is true; `"5" === 5` is false.

**Pitfalls:**  
- Overusing `==`

**Trade-offs:**  
Strict equality prevents subtle bugs.

---

## Q7. Describe closure in JavaScript. Can you give an example?

**Answer:**  
A closure allows a function to access variables from its outer scope even after the outer function has executed.

**Scenario:**  
A counter function remembers its count value.

**Pitfalls:**  
- Memory leaks due to retained references  

**Trade-offs:**  
Closures enable powerful patterns but require awareness of memory usage.

---

## Q8. What is the ‘this’ keyword and how does its context change?

**Answer:**  
`this` refers to the execution context and changes based on how a function is called.

**Scenario:**  
Method calls bind `this` to the object; standalone functions bind to global or undefined (strict mode).

**Pitfalls:**  
- Losing `this` in callbacks  

**Trade-offs:**  
Flexible binding but confusing without understanding call context.

---

## Q9. What are arrow functions and how do they differ from regular functions?

**Answer:**  
Arrow functions provide shorter syntax and do not have their own `this`.

**Scenario:**  
Used in callbacks to preserve outer `this`.

**Pitfalls:**  
- Using arrows as object methods  

**Trade-offs:**  
Cleaner syntax vs limited use cases.

---

## Q10. What are template literals in JavaScript?

**Answer:**  
Template literals use backticks and allow string interpolation and multi-line strings.

**Scenario:**  
Embedding variables in strings without concatenation.

**Pitfalls:**  
- Overusing for simple strings  

**Trade-offs:**  
Improves readability.

---

## Q11. What is a higher-order function in JavaScript?

**Answer:**  
A higher-order function takes another function as an argument or returns one.

**Scenario:**  
Array methods like `map` and `filter`.

**Pitfalls:**  
- Overusing functional patterns  

**Trade-offs:**  
Encourages reusable logic.

---

## Q12. Can functions be assigned as values to variables in JavaScript?

**Answer:**  
Yes, functions are first-class citizens and can be stored, passed, and returned.

**Scenario:**  
Passing callback functions.

**Pitfalls:**  
- Anonymous function overuse  

**Trade-offs:**  
High flexibility.

---

## Q13. How do functional programming concepts apply in JavaScript?

**Answer:**  
JavaScript supports immutability, pure functions, and higher-order functions.

**Scenario:**  
Using `map` instead of loops.

**Pitfalls:**  
- Over-abstracting logic  

**Trade-offs:**  
Improves predictability.

---

## Q14. What are IIFEs (Immediately Invoked Function Expressions)?

**Answer:**  
IIFEs execute immediately after definition and create private scope.

**Scenario:**  
Encapsulating logic.

**Pitfalls:**  
- Readability issues  

**Trade-offs:**  
Useful before ES6 modules.

---

## Q15. How do you create private variables in JavaScript?

**Answer:**  
Private variables are created using closures or module scope.

**Scenario:**  
Encapsulating internal state.

**Pitfalls:**  
- Memory retention  

**Trade-offs:**  
Encapsulation vs complexity.

---

## Q16. How do you create an object in JavaScript?

**Answer:**  
Objects can be created using literals, constructors, or `Object.create()`.

**Scenario:**  
Creating configuration objects.

**Pitfalls:**  
- Overusing constructors  

**Trade-offs:**  
Object literals are simple and clear.

---

## Q17. What are prototypes in JavaScript?

**Answer:**  
Prototypes allow objects to inherit properties and methods from other objects.

**Scenario:**  
Sharing methods across instances.

**Pitfalls:**  
- Modifying prototype unexpectedly  

**Trade-offs:**  
Memory-efficient reuse.

---

## Q18. Explain prototypal inheritance.

**Answer:**  
Objects inherit directly from other objects via the prototype chain.

**Scenario:**  
Extending base behavior.

**Pitfalls:**  
- Deep prototype chains  

**Trade-offs:**  
Flexible inheritance model.

---

## Q19. What is the difference between object literals and constructor functions?

**Answer:**  
Object literals create single objects; constructors create multiple instances.

**Scenario:**  
Multiple user objects.

**Pitfalls:**  
- Forgetting `new`  

**Trade-offs:**  
Constructors enable reuse.

---

## Q20. How do you add or remove properties from an object?

**Answer:**  
Properties can be added using dot or bracket notation and removed using `delete`.

**Scenario:**  
Dynamic configuration updates.

**Pitfalls:**  
- Deleting frequently affecting performance  

**Trade-offs:**  
Dynamic objects vs performance.

---

## Q21. What is the event loop in JavaScript?

**Answer:**  
The event loop manages execution of synchronous code, microtasks, and macrotasks.

**Scenario:**  
Promises execute before timers.

**Pitfalls:**  
- Misunderstanding execution order  

**Trade-offs:**  
Non-blocking concurrency.

---

## Q22. Explain how callbacks work in JavaScript.

**Answer:**  
Callbacks are functions passed to be executed later.

**Scenario:**  
Handling async operations.

**Pitfalls:**  
- Callback hell  

**Trade-offs:**  
Simple but hard to scale.

---

## Q23. What are promises and how do they manage asynchronous code?

**Answer:**  
Promises represent future values and support chaining.

**Scenario:**  
Async API calls.

**Pitfalls:**  
- Missing error handling  

**Trade-offs:**  
Cleaner async flow.

---

## Q24. Explain async/await in JavaScript and how it differs from Promises.

**Answer:**  
`async/await` simplifies promise-based code using synchronous-like syntax.

**Scenario:**  
Sequential async logic.

**Pitfalls:**  
- Forgetting try/catch  

**Trade-offs:**  
Readable but still promise-based.

---

## Q25. What is the Job Queue (or Microtask Queue)?

**Answer:**  
The job queue processes microtasks like promises before macrotasks.

**Scenario:**  
Promise callbacks run before `setTimeout`.

**Pitfalls:**  
- Starving macrotasks  

**Trade-offs:**  
Ensures predictable async behavior.

---
# JavaScript Interview Questions – Complete Guide
## Iteration 2/4 (Q26–Q50)
_Source: javascript-interview-questions.pdf_

---

## Q26. What is the difference between synchronous and asynchronous JavaScript?

**Answer:**  
Synchronous JavaScript executes code line by line, blocking execution until each operation completes, while asynchronous JavaScript allows long-running operations to run in the background without blocking the main thread.

**Scenario:**  
A network request runs asynchronously so the UI remains responsive.

**Pitfalls:**  
- Blocking the main thread with heavy synchronous work  

**Trade-offs:**  
Async improves responsiveness but requires careful error handling.

---

## Q27. How does JavaScript handle asynchronous operations?

**Answer:**  
JavaScript handles async operations using callbacks, promises, and async/await, coordinated by the event loop.

**Scenario:**  
A fetch request is queued and handled once the response arrives.

**Pitfalls:**  
- Misunderstanding execution order  

**Trade-offs:**  
Event-driven async enables concurrency without threads.

---

## Q28. What is callback hell, and how can it be avoided?

**Answer:**  
Callback hell occurs when deeply nested callbacks make code unreadable and hard to maintain.

**Scenario:**  
Multiple dependent async operations nested inside each other.

**Pitfalls:**  
- Hard-to-debug logic  

**Trade-offs:**  
Promises and async/await improve readability.

---

## Q29. What is the DOM, and how does JavaScript interact with it?

**Answer:**  
The DOM represents the structure of a web page, and JavaScript manipulates it to update content dynamically.

**Scenario:**  
Updating a list of items without page reload.

**Pitfalls:**  
- Frequent DOM manipulation hurting performance  

**Trade-offs:**  
Dynamic UI vs performance cost.

---

## Q30. How do you select elements in the DOM?

**Answer:**  
Elements are selected using methods like `getElementById`, `querySelector`, and `querySelectorAll`.

**Scenario:**  
Selecting a form input to read user input.

**Pitfalls:**  
- Overusing expensive selectors  

**Trade-offs:**  
`querySelector` is flexible but slower than ID-based selection.

---

## Q31. What is event bubbling and event capturing?

**Answer:**  
Event bubbling propagates events from target to root; capturing propagates from root to target.

**Scenario:**  
Click on a button triggers handlers on parent elements.

**Pitfalls:**  
- Unintended event propagation  

**Trade-offs:**  
Event delegation improves performance.

---

## Q32. What is event delegation, and why is it useful?

**Answer:**  
Event delegation uses a single handler on a parent element to manage events for child elements.

**Scenario:**  
Handling clicks on dynamically added list items.

**Pitfalls:**  
- Incorrect target identification  

**Trade-offs:**  
Reduces memory usage and improves performance.

---

## Q33. How do you prevent default behavior of events?

**Answer:**  
Use `event.preventDefault()` to stop default browser actions.

**Scenario:**  
Prevent form submission to validate input first.

**Pitfalls:**  
- Preventing defaults unnecessarily  

**Trade-offs:**  
Control vs expected browser behavior.

---

## Q34. What is the difference between `innerHTML` and `textContent`?

**Answer:**  
`innerHTML` parses HTML; `textContent` treats content as plain text.

**Scenario:**  
Displaying user input safely using `textContent`.

**Pitfalls:**  
- XSS vulnerabilities with `innerHTML`  

**Trade-offs:**  
Flexibility vs security.

---

## Q35. How does JavaScript handle memory management?

**Answer:**  
JavaScript uses automatic garbage collection to reclaim unused memory.

**Scenario:**  
Objects no longer referenced are cleaned up.

**Pitfalls:**  
- Memory leaks via closures or global references  

**Trade-offs:**  
Automatic management reduces burden but hides control.

---

## Q36. What are memory leaks, and how can they be avoided?

**Answer:**  
Memory leaks occur when references prevent garbage collection.

**Scenario:**  
Event listeners not removed from DOM nodes.

**Pitfalls:**  
- Long-lived global objects  

**Trade-offs:**  
Careful lifecycle management improves performance.

---

## Q37. What is debouncing and throttling?

**Answer:**  
Debouncing delays execution until events stop firing; throttling limits execution rate.

**Scenario:**  
Debounce search input; throttle scroll events.

**Pitfalls:**  
- Choosing wrong strategy  

**Trade-offs:**  
Performance vs responsiveness.

---

## Q38. What is the difference between `setTimeout` and `setInterval`?

**Answer:**  
`setTimeout` runs once after delay; `setInterval` runs repeatedly.

**Scenario:**  
Polling server every few seconds.

**Pitfalls:**  
- Overlapping executions  

**Trade-offs:**  
Intervals are simple but harder to control.

---

## Q39. How does JavaScript handle errors?

**Answer:**  
Errors are handled using `try/catch`, error objects, and promise rejection handlers.

**Scenario:**  
Gracefully handling API failures.

**Pitfalls:**  
- Swallowing errors  

**Trade-offs:**  
Explicit handling improves reliability.

---

## Q40. What is the purpose of `try...catch`?

**Answer:**  
`try...catch` handles runtime errors to prevent application crashes.

**Scenario:**  
Parsing JSON safely.

**Pitfalls:**  
- Catching too broadly  

**Trade-offs:**  
Stability vs debugging clarity.

---

## Q41. What are ES6 modules, and how do they work?

**Answer:**  
ES6 modules allow code organization using `import` and `export`.

**Scenario:**  
Split logic into reusable modules.

**Pitfalls:**  
- Circular dependencies  

**Trade-offs:**  
Modularity improves maintainability.

---

## Q42. What is destructuring in JavaScript?

**Answer:**  
Destructuring extracts values from arrays or objects into variables.

**Scenario:**  
Simplify object property access.

**Pitfalls:**  
- Overusing in complex structures  

**Trade-offs:**  
Concise syntax vs readability.

---

## Q43. What are default parameters?

**Answer:**  
Default parameters provide fallback values for function arguments.

**Scenario:**  
Avoid undefined checks.

**Pitfalls:**  
- Hidden defaults  

**Trade-offs:**  
Convenience vs clarity.

---

## Q44. What are rest and spread operators?

**Answer:**  
Rest gathers arguments; spread expands elements.

**Scenario:**  
Copy arrays or merge objects.

**Pitfalls:**  
- Shallow copying only  

**Trade-offs:**  
Cleaner syntax vs deep copy needs.

---

## Q45. What is the difference between `map`, `filter`, and `reduce`?

**Answer:**  
`map` transforms data, `filter` selects data, `reduce` aggregates data.

**Scenario:**  
Processing collections functionally.

**Pitfalls:**  
- Overusing `reduce`  

**Trade-offs:**  
Functional style improves clarity.

---

## Q46. How do you optimize JavaScript code for performance?

**Answer:**  
Optimize by reducing DOM operations, minimizing reflows, and efficient algorithms.

**Scenario:**  
Batch DOM updates.

**Pitfalls:**  
- Premature optimization  

**Trade-offs:**  
Optimization should be data-driven.

---

## Q47. What is lazy loading in JavaScript?

**Answer:**  
Lazy loading defers loading resources until needed.

**Scenario:**  
Load images when scrolled into view.

**Pitfalls:**  
- Poor UX if delayed  

**Trade-offs:**  
Faster initial load vs delayed content.

---

## Q48. What is the difference between `localStorage`, `sessionStorage`, and cookies?

**Answer:**  
localStorage persists data; sessionStorage lasts per tab; cookies are sent with requests.

**Scenario:**  
Store user preferences locally.

**Pitfalls:**  
- Storing sensitive data  

**Trade-offs:**  
Persistence vs security.

---

## Q49. How does JavaScript interact with browser APIs?

**Answer:**  
JavaScript accesses browser features via APIs like Fetch, Storage, and Geolocation.

**Scenario:**  
Fetch API for HTTP requests.

**Pitfalls:**  
- Browser compatibility issues  

**Trade-offs:**  
Rich APIs vs cross-browser concerns.

---

## Q50. What is the Fetch API and how does it differ from XMLHttpRequest?

**Answer:**  
Fetch provides a promise-based API for HTTP requests, simpler than XMLHttpRequest.

**Scenario:**  
Fetching JSON data cleanly.

**Pitfalls:**  
- Fetch doesn’t reject on HTTP errors  

**Trade-offs:**  
Modern syntax vs manual error checks.

---
# JavaScript Interview Questions – Complete Guide
## Iteration 3/4 (Q51–Q75)
_Source: javascript-interview-questions.pdf_

---

## Q51. How do you handle errors in asynchronous JavaScript code?

**Answer:**  
Errors in async JavaScript are handled using `.catch()` on promises or `try...catch` blocks inside `async/await` functions.

**Scenario:**  
An API call fails and is caught to return a fallback UI instead of crashing.

**Pitfalls:**  
- Forgetting to return or await promises  
- Unhandled promise rejections  

**Trade-offs:**  
Explicit error handling improves stability but increases boilerplate.

---

## Q52. What is promise chaining, and why is it useful?

**Answer:**  
Promise chaining allows sequential execution of async operations by returning promises from `.then()` handlers.

**Scenario:**  
Fetch user data → fetch user orders → process results.

**Pitfalls:**  
- Deep chains reducing readability  

**Trade-offs:**  
Chaining improves flow control but `async/await` is often clearer.

---

## Q53. What is `Promise.all()` and when should you use it?

**Answer:**  
`Promise.all()` runs multiple promises in parallel and resolves when all succeed or rejects if any fail.

**Scenario:**  
Load dashboard widgets simultaneously.

**Pitfalls:**  
- One failure rejects all  

**Trade-offs:**  
Fast parallelism vs all-or-nothing behavior.

---

## Q54. What is `Promise.race()`?

**Answer:**  
`Promise.race()` resolves or rejects as soon as the first promise settles.

**Scenario:**  
Implement request timeout logic.

**Pitfalls:**  
- Ignoring slower promises  

**Trade-offs:**  
Useful for timeouts but not for aggregating results.

---

## Q55. What is `Promise.any()` and how is it different from `Promise.all()`?

**Answer:**  
`Promise.any()` resolves when the first promise fulfills and ignores rejections unless all fail.

**Scenario:**  
Fetch from multiple mirrors and use the fastest success.

**Pitfalls:**  
- Unhandled rejections if not careful  

**Trade-offs:**  
Resilience vs limited error visibility.

---

## Q56. How does JavaScript handle concurrency with a single thread?

**Answer:**  
JavaScript uses the event loop to handle concurrency by offloading async tasks and executing callbacks when ready.

**Scenario:**  
Multiple network requests handled without blocking UI.

**Pitfalls:**  
- Blocking the event loop with CPU-heavy work  

**Trade-offs:**  
Scalable I/O vs limited CPU parallelism.

---

## Q57. What is Web Workers, and when would you use them?

**Answer:**  
Web Workers run scripts in background threads for CPU-intensive tasks.

**Scenario:**  
Image processing without freezing UI.

**Pitfalls:**  
- Limited access to DOM  

**Trade-offs:**  
Improved responsiveness vs communication overhead.

---

## Q58. What is event delegation and how does it improve performance?

**Answer:**  
Event delegation attaches a single event listener to a parent element to handle events for its children.

**Scenario:**  
Handling clicks on a large, dynamic list.

**Pitfalls:**  
- Incorrect event target handling  

**Trade-offs:**  
Better performance vs added logic.

---

## Q59. How does JavaScript support object-oriented programming?

**Answer:**  
JavaScript supports OOP via objects, prototypes, and ES6 classes.

**Scenario:**  
Define reusable components using classes.

**Pitfalls:**  
- Misunderstanding prototype chain  

**Trade-offs:**  
Flexible OOP model but less strict than classical languages.

---

## Q60. What are ES6 classes and how do they work?

**Answer:**  
ES6 classes are syntactic sugar over prototypes, providing clearer syntax for OOP.

**Scenario:**  
Create reusable service classes.

**Pitfalls:**  
- Assuming true classical inheritance  

**Trade-offs:**  
Readability vs understanding underlying prototypes.

---

## Q61. What are design patterns commonly used in JavaScript?

**Answer:**  
Common patterns include Module, Factory, Singleton, Observer, and Proxy.

**Scenario:**  
Observer pattern for event handling.

**Pitfalls:**  
- Overusing patterns  

**Trade-offs:**  
Patterns solve problems but add abstraction.

---

## Q62. Explain the Module pattern in JavaScript.

**Answer:**  
The Module pattern encapsulates private state and exposes a public API.

**Scenario:**  
Hide internal variables from global scope.

**Pitfalls:**  
- Memory retention via closures  

**Trade-offs:**  
Encapsulation vs memory usage.

---

## Q63. What is the Observer pattern and where is it used?

**Answer:**  
Observer pattern allows objects to subscribe and react to state changes.

**Scenario:**  
Event emitters and UI frameworks.

**Pitfalls:**  
- Memory leaks from unremoved listeners  

**Trade-offs:**  
Loose coupling vs complexity.

---

## Q64. How do you prevent XSS attacks in JavaScript?

**Answer:**  
Prevent XSS by sanitizing input, escaping output, and avoiding unsafe DOM APIs.

**Scenario:**  
Display user input using `textContent`.

**Pitfalls:**  
- Trusting user input  

**Trade-offs:**  
Security vs development speed.

---

## Q65. What is CSRF, and how can it be mitigated?

**Answer:**  
CSRF exploits authenticated sessions; mitigated using tokens and same-site cookies.

**Scenario:**  
Require CSRF token on form submissions.

**Pitfalls:**  
- Missing token validation  

**Trade-offs:**  
Security vs implementation effort.

---

## Q66. How do you secure sensitive data in JavaScript applications?

**Answer:**  
Avoid exposing secrets in client-side code; use secure storage and server-side handling.

**Scenario:**  
API keys kept on server, not frontend.

**Pitfalls:**  
- Storing secrets in localStorage  

**Trade-offs:**  
Security vs convenience.

---

## Q67. What is unit testing in JavaScript?

**Answer:**  
Unit testing verifies individual functions in isolation.

**Scenario:**  
Test utility functions.

**Pitfalls:**  
- Testing implementation details  

**Trade-offs:**  
Confidence vs maintenance cost.

---

## Q68. What are popular JavaScript testing frameworks?

**Answer:**  
Jest, Mocha, Jasmine, and Vitest.

**Scenario:**  
Automated test suites in CI.

**Pitfalls:**  
- Slow test suites  

**Trade-offs:**  
Coverage vs execution time.

---

## Q69. What is test-driven development (TDD)?

**Answer:**  
TDD writes tests before code to define expected behavior.

**Scenario:**  
Write failing test, then implement logic.

**Pitfalls:**  
- Over-specifying tests  

**Trade-offs:**  
Quality vs development speed.

---

## Q70. How do you mock APIs in JavaScript tests?

**Answer:**  
Use mocking tools to simulate API responses.

**Scenario:**  
Mock fetch calls in tests.

**Pitfalls:**  
- Over-mocking  

**Trade-offs:**  
Fast tests vs realism.

---

## Q71. What is tree shaking in JavaScript?

**Answer:**  
Tree shaking removes unused code during bundling.

**Scenario:**  
Reduce bundle size.

**Pitfalls:**  
- Using non-tree-shakable patterns  

**Trade-offs:**  
Smaller bundles vs build complexity.

---

## Q72. What is code splitting?

**Answer:**  
Code splitting loads code in chunks only when needed.

**Scenario:**  
Lazy-load routes.

**Pitfalls:**  
- Excessive splitting causing delays  

**Trade-offs:**  
Faster initial load vs more requests.

---

## Q73. How does JavaScript handle large data sets?

**Answer:**  
Use efficient algorithms, pagination, and background processing.

**Scenario:**  
Virtualized lists.

**Pitfalls:**  
- Loading all data at once  

**Trade-offs:**  
Performance vs complexity.

---

## Q74. What is virtual DOM, and how does it improve performance?

**Answer:**  
Virtual DOM minimizes direct DOM updates by batching changes.

**Scenario:**  
UI frameworks update efficiently.

**Pitfalls:**  
- Assuming zero cost  

**Trade-offs:**  
Better performance vs abstraction overhead.

---

## Q75. How do JavaScript frameworks optimize rendering?

**Answer:**  
By batching updates, diffing changes, and minimizing reflows.

**Scenario:**  
Efficient UI updates during user interaction.

**Pitfalls:**  
- Excessive re-renders  

**Trade-offs:**  
Performance vs learning curve.

---
# JavaScript Interview Questions – Complete Guide
## Iteration 4/4 (Q76–Q100)
_Source: javascript-interview-questions.pdf_

---

## Q76. What are ESNext features, and why are they important?

**Answer:**  
ESNext refers to upcoming JavaScript features proposed for future ECMAScript releases. They are important because they improve language expressiveness, performance, and developer productivity.

**Scenario:**  
Using optional chaining (`?.`) prevents runtime errors when accessing nested properties.

**Pitfalls:**  
- Using ESNext without transpilation  
- Browser compatibility issues  

**Trade-offs:**  
Early adoption improves productivity but may require build tooling.

---

## Q77. What is optional chaining?

**Answer:**  
Optional chaining allows safe access to nested object properties without throwing errors.

**Scenario:**  
`user?.profile?.email` safely accesses email.

**Pitfalls:**  
- Masking bugs due to silent `undefined`  

**Trade-offs:**  
Safety vs hiding data issues.

---

## Q78. What is nullish coalescing (`??`)?

**Answer:**  
Nullish coalescing returns a fallback value only when the left operand is `null` or `undefined`.

**Scenario:**  
Provide default values without overriding valid falsy values like `0`.

**Pitfalls:**  
- Confusing with logical OR (`||`)  

**Trade-offs:**  
Precision vs learning curve.

---

## Q79. What is the difference between `Object.freeze()` and `Object.seal()`?

**Answer:**  
`freeze()` prevents any changes, while `seal()` allows modifying existing properties but prevents adding/removing.

**Scenario:**  
Protect configuration objects from accidental mutation.

**Pitfalls:**  
- Shallow immutability only  

**Trade-offs:**  
Safety vs flexibility.

---

## Q80. How does JavaScript handle immutability?

**Answer:**  
JavaScript supports immutability through patterns like copying objects, using `const`, and libraries.

**Scenario:**  
Create new objects instead of mutating state.

**Pitfalls:**  
- Assuming `const` means immutable  

**Trade-offs:**  
Immutability improves predictability but may increase memory usage.

---

## Q81. What is currying in JavaScript?

**Answer:**  
Currying transforms a function with multiple arguments into a sequence of single-argument functions.

**Scenario:**  
Create reusable partially applied functions.

**Pitfalls:**  
- Overusing currying  

**Trade-offs:**  
Reusability vs readability.

---

## Q82. What is memoization, and when should it be used?

**Answer:**  
Memoization caches function results to avoid repeated expensive calculations.

**Scenario:**  
Cache results of recursive computations.

**Pitfalls:**  
- Memory leaks from unbounded cache  

**Trade-offs:**  
Speed vs memory consumption.

---

## Q83. How does JavaScript handle floating-point precision issues?

**Answer:**  
JavaScript uses IEEE 754 double-precision floats, which can cause rounding errors.

**Scenario:**  
`0.1 + 0.2 !== 0.3`

**Pitfalls:**  
- Direct equality comparisons  

**Trade-offs:**  
Performance vs precision.

---

## Q84. What is the purpose of `Intl` API?

**Answer:**  
The `Intl` API provides language-sensitive formatting for numbers, dates, and currencies.

**Scenario:**  
Formatting currency based on user locale.

**Pitfalls:**  
- Inconsistent browser support in older environments  

**Trade-offs:**  
Globalization support vs bundle size.

---

## Q85. How do JavaScript bundlers work?

**Answer:**  
Bundlers combine multiple modules into optimized files for deployment.

**Scenario:**  
Bundle frontend code into a single file.

**Pitfalls:**  
- Large bundle sizes  

**Trade-offs:**  
Fewer requests vs build complexity.

---

## Q86. What is the role of transpilers like Babel?

**Answer:**  
Transpilers convert modern JavaScript into backward-compatible versions.

**Scenario:**  
Use ESNext syntax while supporting older browsers.

**Pitfalls:**  
- Over-transpiling affecting performance  

**Trade-offs:**  
Compatibility vs build time.

---

## Q87. What is source mapping?

**Answer:**  
Source maps map compiled code back to original source for debugging.

**Scenario:**  
Debug production errors using original code.

**Pitfalls:**  
- Exposing source maps publicly  

**Trade-offs:**  
Debugging convenience vs security.

---

## Q88. How does JavaScript support functional programming?

**Answer:**  
JavaScript supports first-class functions, immutability patterns, and higher-order functions.

**Scenario:**  
Use pure functions for predictable logic.

**Pitfalls:**  
- Over-abstraction  

**Trade-offs:**  
Predictability vs verbosity.

---

## Q89. What is reactive programming in JavaScript?

**Answer:**  
Reactive programming focuses on data streams and propagation of changes.

**Scenario:**  
UI updates automatically when state changes.

**Pitfalls:**  
- Steep learning curve  

**Trade-offs:**  
Powerful state handling vs complexity.

---

## Q90. What is the difference between shallow copy and deep copy?

**Answer:**  
Shallow copy duplicates references; deep copy duplicates all nested objects.

**Scenario:**  
Avoid unintended mutations.

**Pitfalls:**  
- Assuming spread operator deep copies  

**Trade-offs:**  
Performance vs correctness.

---

## Q91. How does JavaScript handle security in the browser?

**Answer:**  
Browser security uses same-origin policy, CORS, sandboxing, and secure APIs.

**Scenario:**  
Prevent cross-site scripting attacks.

**Pitfalls:**  
- Trusting client-side security  

**Trade-offs:**  
Strong isolation vs restricted capabilities.

---

## Q92. What is Content Security Policy (CSP)?

**Answer:**  
CSP restricts which resources a page can load to prevent XSS.

**Scenario:**  
Allow scripts only from trusted domains.

**Pitfalls:**  
- Overly permissive policies  

**Trade-offs:**  
Security vs flexibility.

---

## Q93. How does JavaScript interact with mobile platforms?

**Answer:**  
JavaScript runs on mobile browsers and hybrid frameworks.

**Scenario:**  
Shared codebase across platforms.

**Pitfalls:**  
- Performance limitations  

**Trade-offs:**  
Cross-platform reuse vs native performance.

---

## Q94. What are Progressive Web Apps (PWAs)?

**Answer:**  
PWAs are web apps that offer offline support, caching, and installability.

**Scenario:**  
Offline-capable applications.

**Pitfalls:**  
- Poor cache strategies  

**Trade-offs:**  
Improved UX vs added complexity.

---

## Q95. What is Service Worker?

**Answer:**  
Service Workers intercept network requests and enable offline functionality.

**Scenario:**  
Cache assets for offline access.

**Pitfalls:**  
- Hard-to-debug caching issues  

**Trade-offs:**  
Powerful capabilities vs complexity.

---

## Q96. How does JavaScript support accessibility (a11y)?

**Answer:**  
JavaScript enhances accessibility by managing focus, keyboard events, and ARIA attributes.

**Scenario:**  
Ensure keyboard navigation works.

**Pitfalls:**  
- Overriding native behavior  

**Trade-offs:**  
Accessibility improves inclusivity but needs care.

---

## Q97. What is WebAssembly, and how does it relate to JavaScript?

**Answer:**  
WebAssembly enables running high-performance code alongside JavaScript.

**Scenario:**  
CPU-intensive logic written in other languages.

**Pitfalls:**  
- Overusing for simple tasks  

**Trade-offs:**  
Performance vs complexity.

---

## Q98. How does JavaScript handle backward compatibility?

**Answer:**  
Through transpilers, polyfills, and feature detection.

**Scenario:**  
Modern features work in older browsers.

**Pitfalls:**  
- Relying on user-agent detection  

**Trade-offs:**  
Compatibility vs bundle size.

---

## Q99. What are common JavaScript anti-patterns?

**Answer:**  
Global variables, blocking code, deep nesting, and weak error handling.

**Scenario:**  
Callback hell causing unreadable code.

**Pitfalls:**  
- Ignoring maintainability  

**Trade-offs:**  
Avoiding anti-patterns improves code quality.

---

## Q100. What best practices should be followed for writing clean JavaScript code?

**Answer:**  
Use clear naming, modular design, immutability, proper error handling, and consistent style.

**Scenario:**  
Readable code simplifies maintenance.

**Pitfalls:**  
- Over-engineering  

**Trade-offs:**  
Clean code takes effort but saves time long-term.

---

