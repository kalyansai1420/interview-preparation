# React Interview Questions – Complete Guide
## Iteration 1/4 (Q1–Q25)
_Source: react.pdf_

---

## Q1. What is React and why is it used?

**Answer:**  
React is a JavaScript library for building user interfaces using a component-based architecture. It focuses on declarative UI, efficient updates via the virtual DOM, and unidirectional data flow.

**Scenario:**  
Large applications where UI changes frequently based on state.

**Pitfalls:**  
- Treating React as a full framework  
- Poor state management  

**Trade-offs:**  
High UI performance and modularity vs need for additional libraries.

---

## Q2. How is React different from Angular or Vue?

**Answer:**  
React is a UI library focused only on the view layer, whereas Angular is a full framework and Vue sits in between.

**Scenario:**  
Teams wanting flexibility choose React.

**Pitfalls:**  
- Expecting React to provide routing/state by default  

**Trade-offs:**  
Flexibility vs configuration responsibility.

---

## Q3. What is a React component?

**Answer:**  
A component is a reusable, self-contained unit of UI with its own logic and rendering.

**Scenario:**  
Buttons, forms, dashboards as independent units.

**Pitfalls:**  
- Overloading components with logic  

**Trade-offs:**  
Reusability vs component complexity.

---

## Q4. How do you create a component in React?

**Answer:**  
Components are created using functions or classes (functions preferred).

**Scenario:**  
Functional components with hooks.

**Pitfalls:**  
- Mixing patterns unnecessarily  

**Trade-offs:**  
Simplicity vs legacy support.

---

## Q5. What is JSX and why do we use it in React?

**Answer:**  
JSX is a syntax extension allowing HTML-like code in JavaScript.

**Scenario:**  
Declarative UI definitions.

**Pitfalls:**  
- Forgetting JSX is just JavaScript  

**Trade-offs:**  
Readability vs tooling dependency.

---

## Q6. Can you explain the virtual DOM in React?

**Answer:**  
The virtual DOM is a lightweight in-memory representation of the real DOM that enables efficient diffing and updates.

**Scenario:**  
Only changed UI parts are updated.

**Pitfalls:**  
- Assuming virtual DOM eliminates all performance issues  

**Trade-offs:**  
Efficient updates vs memory overhead.

---

## Q7. What are the differences between a class component and a functional component?

**Answer:**  
Class components use lifecycle methods; functional components use hooks.

**Scenario:**  
Modern apps prefer functional components.

**Pitfalls:**  
- Mixing lifecycle and hooks logic  

**Trade-offs:**  
Hooks simplicity vs learning curve.

---

## Q8. How do you handle events in React?

**Answer:**  
Events are handled using synthetic events and callback functions.

**Scenario:**  
User clicks, form submissions.

**Pitfalls:**  
- Forgetting to bind handlers  

**Trade-offs:**  
Cross-browser consistency vs abstraction.

---

## Q9. What are state and props in React?

**Answer:**  
Props are inputs passed to components; state is internal, mutable data.

**Scenario:**  
Props for configuration, state for UI changes.

**Pitfalls:**  
- Mutating props  

**Trade-offs:**  
Predictability vs verbosity.

---

## Q10. How do you pass data between components in React?

**Answer:**  
Data flows down via props; callbacks lift data up.

**Scenario:**  
Parent controls child behavior.

**Pitfalls:**  
- Excessive prop drilling  

**Trade-offs:**  
Clear flow vs boilerplate.

---

## Q11. What is a stateful component?

**Answer:**  
A component that maintains and updates its own state.

**Scenario:**  
Forms, toggles, modals.

**Pitfalls:**  
- Too much state in UI components  

**Trade-offs:**  
Local control vs global coordination.

---

## Q12. Can you explain how useState works?

**Answer:**  
`useState` provides a state variable and a setter function that triggers re-render.

**Scenario:**  
Track form inputs.

**Pitfalls:**  
- Assuming state updates are synchronous  

**Trade-offs:**  
Simplicity vs async mental model.

---

## Q13. How do you update the state of a parent component from a child component?

**Answer:**  
By passing a callback function from parent to child.

**Scenario:**  
Child triggers parent update.

**Pitfalls:**  
- Tight coupling  

**Trade-offs:**  
Control vs indirection.

---

## Q14. What is lifting state up in React?

**Answer:**  
Moving shared state to the closest common ancestor.

**Scenario:**  
Synchronized sibling components.

**Pitfalls:**  
- Over-lifting state  

**Trade-offs:**  
Consistency vs component independence.

---

## Q15. When do you use Redux or Context API for state management?

**Answer:**  
Context for small shared state; Redux for complex, global state.

**Scenario:**  
Authentication vs application-wide workflows.

**Pitfalls:**  
- Overusing Redux  

**Trade-offs:**  
Scalability vs boilerplate.

---

## Q16. Explain the lifecycle methods of a React class component.

**Answer:**  
Lifecycle methods manage mounting, updating, and unmounting phases.

**Scenario:**  
Fetch data on mount, cleanup on unmount.

**Pitfalls:**  
- Deprecated lifecycle methods  

**Trade-offs:**  
Explicit lifecycle control vs verbosity.

---

## Q17. How do hooks work in React?

**Answer:**  
Hooks let functional components use state and lifecycle features.

**Scenario:**  
Replace class-based logic.

**Pitfalls:**  
- Breaking hook rules  

**Trade-offs:**  
Powerful abstraction vs strict rules.

---

## Q18. Can you describe the useEffect hook and its purpose?

**Answer:**  
`useEffect` handles side effects like data fetching and subscriptions.

**Scenario:**  
API calls on component load.

**Pitfalls:**  
- Incorrect dependency arrays  

**Trade-offs:**  
Unified lifecycle vs subtle bugs.

---

## Q19. How do you fetch data with hooks in React?

**Answer:**  
Use `useEffect` combined with async logic.

**Scenario:**  
Load data on mount.

**Pitfalls:**  
- Memory leaks without cleanup  

**Trade-offs:**  
Declarative data flow vs async complexity.

---

## Q20. What rules do you have to follow when using hooks?

**Answer:**  
Hooks must be called at the top level and only inside React functions.

**Scenario:**  
Predictable hook ordering.

**Pitfalls:**  
- Conditional hook calls  

**Trade-offs:**  
Reliability vs flexibility.

---

## Q21. How do props work in React?

**Answer:**  
Props pass immutable data from parent to child.

**Scenario:**  
Configuration and customization.

**Pitfalls:**  
- Treating props as state  

**Trade-offs:**  
Immutability vs update flexibility.

---

## Q22. What is prop drilling and how can you avoid it?

**Answer:**  
Prop drilling is passing props through many layers unnecessarily.

**Scenario:**  
Deep component trees.

**Pitfalls:**  
- Reduced readability  

**Trade-offs:**  
Simplicity vs maintainability.

---

## Q23. Explain the Context API and its use cases.

**Answer:**  
Context provides global data without prop drilling.

**Scenario:**  
Theme, auth state.

**Pitfalls:**  
- Overusing context  

**Trade-offs:**  
Convenience vs re-render cost.

---

## Q24. How do you use render props?

**Answer:**  
Render props pass a function to control rendering logic.

**Scenario:**  
Reusable behavior patterns.

**Pitfalls:**  
- Nested render functions  

**Trade-offs:**  
Flexibility vs readability.

---

## Q25. What is the children prop?

**Answer:**  
`children` represents nested JSX passed to a component.

**Scenario:**  
Layout and wrapper components.

**Pitfalls:**  
- Uncontrolled rendering  

**Trade-offs:**  
Composition vs predictability.

---
# React Interview Questions – Complete Guide
## Iteration 2/4 (Q26–Q50)
_Source: react.pdf_

---

## Q26. How does React handle rendering?

**Answer:**  
React renders components by computing a virtual DOM tree from state and props, diffing it against the previous tree, and applying the minimal set of changes to the real DOM.

**Scenario:**  
A list updates only the changed item instead of re-rendering the entire page.

**Pitfalls:**  
- Assuming every state change is expensive  
- Forcing unnecessary re-renders  

**Trade-offs:**  
Efficient UI updates vs need to understand render triggers.

---

## Q27. What causes a React component to re-render?

**Answer:**  
A component re-renders when its state changes, its props change, or its parent re-renders.

**Scenario:**  
Updating a parent state causes child re-renders.

**Pitfalls:**  
- Unintentional re-renders due to new object references  

**Trade-offs:**  
Predictable updates vs performance tuning effort.

---

## Q28. How do you prevent unnecessary re-renders in React?

**Answer:**  
Use memoization techniques like `React.memo`, `useMemo`, and `useCallback`.

**Scenario:**  
Optimizing a frequently re-rendered list component.

**Pitfalls:**  
- Overusing memoization  

**Trade-offs:**  
Performance gains vs added complexity.

---

## Q29. What is `React.memo` and when should you use it?

**Answer:**  
`React.memo` memoizes functional components to avoid re-rendering when props don’t change.

**Scenario:**  
Pure presentational components.

**Pitfalls:**  
- Using it for components with frequently changing props  

**Trade-offs:**  
Reduced renders vs memory and comparison overhead.

---

## Q30. What is `useMemo` and how is it different from `useCallback`?

**Answer:**  
`useMemo` memoizes computed values; `useCallback` memoizes functions.

**Scenario:**  
Avoid recomputing expensive calculations.

**Pitfalls:**  
- Incorrect dependency arrays  

**Trade-offs:**  
Performance vs correctness risks.

---

## Q31. What is reconciliation in React?

**Answer:**  
Reconciliation is the process React uses to compare virtual DOM trees and update the real DOM efficiently.

**Scenario:**  
Updating only changed UI nodes.

**Pitfalls:**  
- Misusing keys in lists  

**Trade-offs:**  
Fast updates vs need for stable identifiers.

---

## Q32. Why are keys important in React lists?

**Answer:**  
Keys help React identify which items have changed, been added, or removed.

**Scenario:**  
Rendering dynamic lists.

**Pitfalls:**  
- Using array index as key  

**Trade-offs:**  
Correct diffing vs developer discipline.

---

## Q33. What happens if you don’t use keys properly?

**Answer:**  
React may reuse DOM nodes incorrectly, causing UI bugs.

**Scenario:**  
Wrong item updates in a list.

**Pitfalls:**  
- Hard-to-debug UI issues  

**Trade-offs:**  
Ease vs correctness.

---

## Q34. What is controlled vs uncontrolled component?

**Answer:**  
Controlled components manage form state via React state; uncontrolled rely on the DOM.

**Scenario:**  
Form validation and submission.

**Pitfalls:**  
- Mixing both patterns  

**Trade-offs:**  
Control vs simplicity.

---

## Q35. How do you handle forms in React?

**Answer:**  
Forms are handled using controlled components and event handlers.

**Scenario:**  
Validating user input.

**Pitfalls:**  
- Excessive re-renders on input change  

**Trade-offs:**  
Validation power vs verbosity.

---

## Q36. How do you perform form validation in React?

**Answer:**  
Validation can be done manually or with libraries.

**Scenario:**  
Show errors before submission.

**Pitfalls:**  
- Complex validation logic in components  

**Trade-offs:**  
Flexibility vs maintainability.

---

## Q37. How do you style components in React?

**Answer:**  
Styling can be done using CSS, CSS modules, inline styles, or CSS-in-JS.

**Scenario:**  
Component-scoped styles.

**Pitfalls:**  
- Global CSS conflicts  

**Trade-offs:**  
Encapsulation vs tooling overhead.

---

## Q38. What are CSS Modules and why use them?

**Answer:**  
CSS Modules scope styles locally to components.

**Scenario:**  
Avoid class name collisions.

**Pitfalls:**  
- Tooling configuration complexity  

**Trade-offs:**  
Isolation vs build setup.

---

## Q39. What is CSS-in-JS?

**Answer:**  
CSS-in-JS defines styles within JavaScript files using libraries.

**Scenario:**  
Dynamic styling based on props.

**Pitfalls:**  
- Runtime performance cost  

**Trade-offs:**  
Dynamic styling vs complexity.

---

## Q40. How does React Router work?

**Answer:**  
React Router maps URLs to components and manages navigation without page reloads.

**Scenario:**  
Single-page application navigation.

**Pitfalls:**  
- Deeply nested routes  

**Trade-offs:**  
Smooth navigation vs routing complexity.

---

## Q41. What is client-side routing?

**Answer:**  
Client-side routing updates the UI based on URL changes without server reloads.

**Scenario:**  
SPA navigation.

**Pitfalls:**  
- SEO challenges  

**Trade-offs:**  
Speed vs discoverability.

---

## Q42. How do you handle 404 pages in React?

**Answer:**  
Use catch-all routes to render fallback components.

**Scenario:**  
Unknown routes show error page.

**Pitfalls:**  
- Missing route ordering  

**Trade-offs:**  
User experience vs route management.

---

## Q43. What is code splitting in React?

**Answer:**  
Code splitting loads parts of the app lazily to reduce initial bundle size.

**Scenario:**  
Load heavy pages on demand.

**Pitfalls:**  
- Over-splitting  

**Trade-offs:**  
Faster load vs extra requests.

---

## Q44. How does `React.lazy` work?

**Answer:**  
`React.lazy` dynamically imports components and loads them when needed.

**Scenario:**  
Lazy-loaded routes.

**Pitfalls:**  
- Missing fallback UI  

**Trade-offs:**  
Bundle optimization vs loading states.

---

## Q45. What is Suspense in React?

**Answer:**  
Suspense lets components wait for async resources before rendering.

**Scenario:**  
Show loaders during lazy loading.

**Pitfalls:**  
- Limited use cases without concurrent features  

**Trade-offs:**  
Cleaner async UI vs feature constraints.

---

## Q46. What is error boundary in React?

**Answer:**  
Error boundaries catch JavaScript errors in the component tree and render fallback UI.

**Scenario:**  
Prevent entire app crash.

**Pitfalls:**  
- Not catching async errors  

**Trade-offs:**  
Resilience vs partial coverage.

---

## Q47. How do you implement an error boundary?

**Answer:**  
Use a class component implementing specific lifecycle methods.

**Scenario:**  
Wrap risky components.

**Pitfalls:**  
- Overusing error boundaries  

**Trade-offs:**  
Fault isolation vs complexity.

---

## Q48. What is higher-order component (HOC)?

**Answer:**  
An HOC is a function that enhances a component with additional behavior.

**Scenario:**  
Add authentication logic.

**Pitfalls:**  
- Wrapper hell  

**Trade-offs:**  
Reuse vs readability.

---

## Q49. What is composition in React?

**Answer:**  
Composition builds complex UIs by combining simple components.

**Scenario:**  
Layout explainability.

**Pitfalls:**  
- Deep nesting  

**Trade-offs:**  
Flexibility vs structure.

---

## Q50. What are React fragments and why are they useful?

**Answer:**  
Fragments let you group elements without adding extra DOM nodes.

**Scenario:**  
Clean HTML structure.

**Pitfalls:**  
- Overusing fragments unnecessarily  

**Trade-offs:**  
DOM cleanliness vs readability.

---
# React Interview Questions – Complete Guide
## Iteration 3/4 (Q51–Q75)
_Source: react.pdf_

---

## Q51. What is Redux and why is it used with React?

**Answer:**  
Redux is a predictable state management library that centralizes application state and enforces unidirectional data flow, making complex state changes easier to reason about.

**Scenario:**  
A large app with shared state across many unrelated components.

**Pitfalls:**  
- Using Redux for simple local state  

**Trade-offs:**  
Predictability and debuggability vs boilerplate and learning curve.

---

## Q52. What are the core principles of Redux?

**Answer:**  
Single source of truth, state is read-only, and changes are made via pure functions (reducers).

**Scenario:**  
All UI state flows through a single store.

**Pitfalls:**  
- Mutating state in reducers  

**Trade-offs:**  
Strong guarantees vs strict discipline.

---

## Q53. What is a Redux store?

**Answer:**  
The store holds the entire state tree and manages state updates via reducers.

**Scenario:**  
Global app state accessed by multiple components.

**Pitfalls:**  
- Storing non-serializable data  

**Trade-offs:**  
Centralization vs memory footprint.

---

## Q54. What are actions and reducers in Redux?

**Answer:**  
Actions describe what happened; reducers define how state changes in response.

**Scenario:**  
User clicks “Add to Cart”.

**Pitfalls:**  
- Complex reducers  

**Trade-offs:**  
Clear flow vs verbosity.

---

## Q55. What is middleware in Redux?

**Answer:**  
Middleware intercepts actions to handle side effects like async logic or logging.

**Scenario:**  
API calls before state updates.

**Pitfalls:**  
- Too much logic in middleware  

**Trade-offs:**  
Separation of concerns vs debugging complexity.

---

## Q56. How does Redux handle asynchronous actions?

**Answer:**  
Async actions are handled via middleware such as thunks or sagas.

**Scenario:**  
Fetch data from an API before updating state.

**Pitfalls:**  
- Mixing async logic into reducers  

**Trade-offs:**  
Flexibility vs added abstractions.

---

## Q57. What is Redux Thunk?

**Answer:**  
Redux Thunk allows action creators to return functions for async logic.

**Scenario:**  
Dispatch actions after an API call completes.

**Pitfalls:**  
- Unstructured async flows  

**Trade-offs:**  
Simplicity vs scalability.

---

## Q58. What is Redux Saga and how is it different from Thunk?

**Answer:**  
Redux Saga uses generator functions to manage complex async workflows.

**Scenario:**  
Coordinated background tasks.

**Pitfalls:**  
- Steep learning curve  

**Trade-offs:**  
Powerful orchestration vs complexity.

---

## Q59. What is the Context API compared to Redux?

**Answer:**  
Context is for simple global state; Redux is for complex, frequently changing state.

**Scenario:**  
Theme vs application workflows.

**Pitfalls:**  
- Overusing context for high-frequency updates  

**Trade-offs:**  
Simplicity vs performance.

---

## Q60. How do you connect React components to Redux?

**Answer:**  
Using hooks or higher-order components to subscribe to store updates.

**Scenario:**  
Component reads global state.

**Pitfalls:**  
- Unnecessary re-renders  

**Trade-offs:**  
Ease of access vs render optimization.

---

## Q61. What is `useSelector` and `useDispatch`?

**Answer:**  
`useSelector` reads state; `useDispatch` sends actions to the store.

**Scenario:**  
Functional components interacting with Redux.

**Pitfalls:**  
- Selecting large state slices  

**Trade-offs:**  
Convenience vs performance tuning.

---

## Q62. How do you structure a large React application?

**Answer:**  
Structure by features, separating UI, state, and services.

**Scenario:**  
Scalable enterprise applications.

**Pitfalls:**  
- Layer-based over feature-based structure  

**Trade-offs:**  
Scalability vs initial setup effort.

---

## Q63. What is separation of concerns in React?

**Answer:**  
Separate UI rendering from business logic and data fetching.

**Scenario:**  
Maintainable components.

**Pitfalls:**  
- Mixing logic and presentation  

**Trade-offs:**  
Clean design vs abstraction overhead.

---

## Q64. How do you handle side effects in React?

**Answer:**  
Side effects are handled using hooks or middleware.

**Scenario:**  
API calls and subscriptions.

**Pitfalls:**  
- Missing cleanup  

**Trade-offs:**  
Control vs complexity.

---

## Q65. What is testing in React and why is it important?

**Answer:**  
Testing ensures components behave correctly under different conditions.

**Scenario:**  
Prevent regressions.

**Pitfalls:**  
- Testing implementation instead of behavior  

**Trade-offs:**  
Confidence vs maintenance effort.

---

## Q66. What types of tests can be written for React applications?

**Answer:**  
Unit tests, integration tests, and end-to-end tests.

**Scenario:**  
Component logic vs full user flows.

**Pitfalls:**  
- Over-reliance on unit tests  

**Trade-offs:**  
Coverage vs execution time.

---

## Q67. How do you test React components?

**Answer:**  
Test by rendering components and asserting on output and interactions.

**Scenario:**  
Simulate user clicks.

**Pitfalls:**  
- Testing internal state  

**Trade-offs:**  
User-centric testing vs detailed assertions.

---

## Q68. What is snapshot testing?

**Answer:**  
Snapshot testing captures component output and compares future renders.

**Scenario:**  
Detect unexpected UI changes.

**Pitfalls:**  
- Blindly updating snapshots  

**Trade-offs:**  
Fast feedback vs false confidence.

---

## Q69. How do you test asynchronous behavior in React?

**Answer:**  
Use async test utilities to wait for updates.

**Scenario:**  
Testing data fetches.

**Pitfalls:**  
- Flaky tests  

**Trade-offs:**  
Realism vs stability.

---

## Q70. How do you mock APIs in React tests?

**Answer:**  
Mock APIs using test doubles or mock servers.

**Scenario:**  
Isolate UI logic.

**Pitfalls:**  
- Over-mocking  

**Trade-offs:**  
Speed vs realism.

---

## Q71. How does React work with TypeScript?

**Answer:**  
TypeScript adds static typing to React components, improving safety.

**Scenario:**  
Catch bugs at compile time.

**Pitfalls:**  
- Overly complex types  

**Trade-offs:**  
Safety vs verbosity.

---

## Q72. What are the benefits of using TypeScript with React?

**Answer:**  
Improved developer experience, refactoring safety, and self-documentation.

**Scenario:**  
Large team collaboration.

**Pitfalls:**  
- Steep learning curve  

**Trade-offs:**  
Maintainability vs onboarding cost.

---

## Q73. How do you type props and state in React with TypeScript?

**Answer:**  
Define interfaces or types for component props and state.

**Scenario:**  
Clear component contracts.

**Pitfalls:**  
- Inaccurate type definitions  

**Trade-offs:**  
Precision vs flexibility.

---

## Q74. What is GraphQL and how is it used with React?

**Answer:**  
GraphQL allows clients to request exactly the data they need.

**Scenario:**  
Efficient data fetching.

**Pitfalls:**  
- Over-fetching with poor query design  

**Trade-offs:**  
Flexibility vs backend complexity.

---

## Q75. How do you handle GraphQL state in React?

**Answer:**  
Use client libraries that manage caching and queries.

**Scenario:**  
Optimized UI updates.

**Pitfalls:**  
- Cache inconsistencies  

**Trade-offs:**  
Performance vs cache management complexity.

---
# React Interview Questions – Complete Guide
## Iteration 4/4 (Q76–Q100)
_Source: react.pdf_

---

## Q76. What is accessibility (a11y) and why is it important in React applications?

**Answer:**  
Accessibility ensures that applications are usable by people with disabilities, including keyboard users and screen-reader users.

**Scenario:**  
A form can be fully navigated using only a keyboard.

**Pitfalls:**  
- Ignoring semantic HTML  
- Relying only on visual cues  

**Trade-offs:**  
Inclusive UX vs additional implementation effort.

---

## Q77. How do you improve accessibility in React applications?

**Answer:**  
Use semantic HTML, ARIA attributes when needed, proper labels, and keyboard navigation support.

**Scenario:**  
Buttons and inputs are correctly announced by screen readers.

**Pitfalls:**  
- Overusing ARIA instead of native elements  

**Trade-offs:**  
Better accessibility vs developer discipline.

---

## Q78. What is server-side rendering (SSR) in React?

**Answer:**  
SSR renders React components on the server and sends HTML to the client.

**Scenario:**  
Improve initial load time and SEO.

**Pitfalls:**  
- Complex server setup  

**Trade-offs:**  
Better SEO and performance vs infrastructure complexity.

---

## Q79. What is hydration in React?

**Answer:**  
Hydration attaches React event handlers to server-rendered HTML.

**Scenario:**  
SSR app becomes interactive on the client.

**Pitfalls:**  
- Mismatched server/client renders  

**Trade-offs:**  
Fast initial render vs strict consistency requirements.

---

## Q80. What is static site generation (SSG)?

**Answer:**  
SSG generates HTML at build time rather than runtime.

**Scenario:**  
Marketing or documentation sites.

**Pitfalls:**  
- Stale content  

**Trade-offs:**  
Performance vs content freshness.

---

## Q81. How does React support SEO?

**Answer:**  
SEO is supported through SSR, SSG, and proper metadata handling.

**Scenario:**  
Search engines index content correctly.

**Pitfalls:**  
- Client-only rendering for SEO-heavy pages  

**Trade-offs:**  
Visibility vs architectural complexity.

---

## Q82. How do you optimize bundle size in React?

**Answer:**  
Use code splitting, tree shaking, and remove unused dependencies.

**Scenario:**  
Faster initial page loads.

**Pitfalls:**  
- Over-splitting  

**Trade-offs:**  
Performance vs maintainability.

---

## Q83. What is tree shaking?

**Answer:**  
Tree shaking removes unused code during bundling.

**Scenario:**  
Smaller JavaScript bundles.

**Pitfalls:**  
- Improper module imports  

**Trade-offs:**  
Smaller bundles vs build configuration complexity.

---

## Q84. How do you handle environment-specific configurations in React?

**Answer:**  
Use environment variables and build-time configuration.

**Scenario:**  
Different API endpoints for dev and prod.

**Pitfalls:**  
- Exposing secrets in frontend  

**Trade-offs:**  
Flexibility vs security considerations.

---

## Q85. What is the role of build tools like Webpack or Vite?

**Answer:**  
They bundle, optimize, and transform code for browsers.

**Scenario:**  
Transpile modern JavaScript.

**Pitfalls:**  
- Over-customized configs  

**Trade-offs:**  
Control vs simplicity.

---

## Q86. How do you deploy a React application?

**Answer:**  
Build the app and serve static assets via hosting platforms or servers.

**Scenario:**  
Production-ready frontend.

**Pitfalls:**  
- Missing caching strategies  

**Trade-offs:**  
Ease of deployment vs optimization needs.

---

## Q87. What is CI/CD in React development?

**Answer:**  
CI/CD automates testing, building, and deployment.

**Scenario:**  
Automatic deployments on code merge.

**Pitfalls:**  
- Skipping tests  

**Trade-offs:**  
Consistency vs pipeline complexity.

---

## Q88. How do you handle errors in React applications?

**Answer:**  
Use error boundaries and graceful fallbacks.

**Scenario:**  
Prevent UI crashes.

**Pitfalls:**  
- Not handling async errors  

**Trade-offs:**  
Resilience vs incomplete coverage.

---

## Q89. How do you manage API calls in React?

**Answer:**  
Use hooks or data-fetching libraries to manage API requests.

**Scenario:**  
Consistent data loading and caching.

**Pitfalls:**  
- Duplicate fetch logic  

**Trade-offs:**  
Control vs abstraction.

---

## Q90. How do you handle authentication in React applications?

**Answer:**  
Authentication is handled via tokens, context, or global state.

**Scenario:**  
Protect private routes.

**Pitfalls:**  
- Storing tokens insecurely  

**Trade-offs:**  
Security vs convenience.

---

## Q91. How do you protect routes in React?

**Answer:**  
Use route guards and conditional rendering.

**Scenario:**  
Only authenticated users access protected pages.

**Pitfalls:**  
- Client-side only security  

**Trade-offs:**  
UX vs reliance on backend enforcement.

---

## Q92. What is lazy loading of images in React?

**Answer:**  
Lazy loading defers loading images until needed.

**Scenario:**  
Improve page load performance.

**Pitfalls:**  
- Poor placeholder UX  

**Trade-offs:**  
Performance vs perceived loading behavior.

---

## Q93. How do you handle internationalization (i18n) in React?

**Answer:**  
Use libraries to manage translations and locale switching.

**Scenario:**  
Multi-language support.

**Pitfalls:**  
- Hardcoded strings  

**Trade-offs:**  
Global reach vs setup complexity.

---

## Q94. How do you manage large forms in React?

**Answer:**  
Split forms into components and manage state efficiently.

**Scenario:**  
Complex enterprise forms.

**Pitfalls:**  
- Excessive re-renders  

**Trade-offs:**  
Control vs performance tuning.

---

## Q95. What is React’s concurrent rendering?

**Answer:**  
Concurrent rendering allows React to interrupt rendering to keep UI responsive.

**Scenario:**  
Smooth interactions under heavy load.

**Pitfalls:**  
- Non-idempotent logic  

**Trade-offs:**  
Responsiveness vs mental model complexity.

---

## Q96. What is React Strict Mode?

**Answer:**  
Strict Mode highlights potential problems during development.

**Scenario:**  
Detect unsafe lifecycle usage.

**Pitfalls:**  
- Misinterpreting double renders  

**Trade-offs:**  
Early warnings vs confusion for beginners.

---

## Q97. How do you migrate a large application to a new React version?

**Answer:**  
Migrate incrementally, update dependencies, and test thoroughly.

**Scenario:**  
Avoid breaking production systems.

**Pitfalls:**  
- Big-bang migrations  

**Trade-offs:**  
Safety vs migration duration.

---

## Q98. What are common React anti-patterns?

**Answer:**  
Direct DOM manipulation, excessive state, and tightly coupled components.

**Scenario:**  
Unmaintainable UI code.

**Pitfalls:**  
- Ignoring React’s declarative model  

**Trade-offs:**  
Quick hacks vs long-term health.

---

## Q99. How do you design scalable React applications?

**Answer:**  
Use modular architecture, feature-based structure, and predictable state management.

**Scenario:**  
Enterprise-scale frontends.

**Pitfalls:**  
- Poor component boundaries  

**Trade-offs:**  
Scalability vs initial complexity.

---

## Q100. What best practices should be followed in production React applications?

**Answer:**  
Follow clean component design, performance optimization, accessibility, and observability.

**Scenario:**  
Stable, maintainable UI systems.

**Pitfalls:**  
- Ignoring monitoring and performance  

**Trade-offs:**  
Engineering rigor vs rapid delivery.

---
