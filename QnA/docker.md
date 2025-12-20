# Docker Interview Questions

## Q1. What is Docker, and how is it different from virtual machines?

**Answer:**  
Docker is a containerization platform that packages an application and its dependencies into a container that runs on a shared host OS kernel. Virtual machines, on the other hand, virtualize entire operating systems on top of a hypervisor.

**Scenario:**  
Running 10 Docker containers shares one OS kernel, while running 10 VMs requires 10 full operating systems.

**Pitfalls:**  
- Assuming containers are as isolated as VMs  
- Running security-sensitive workloads without proper hardening  

**Trade-offs:**  
Containers are lightweight and fast, but VMs provide stronger isolation.

---

## Q2. Can you explain what a Docker image is?

**Answer:**  
A Docker image is an immutable, read-only template that contains the application code, runtime, libraries, and configuration needed to run a container.

**Scenario:**  
A Java image includes JDK, application JAR, and startup command.

**Pitfalls:**  
- Treating images as mutable  
- Storing secrets inside images  

**Trade-offs:**  
Immutability improves consistency but requires rebuilding images for changes.

---

## Q3. How does a Docker container differ from a Docker image?

**Answer:**  
A Docker image is a static blueprint, while a Docker container is a running instance of that image with a writable layer on top.

**Scenario:**  
Image = recipe, container = cooked dish.

**Pitfalls:**  
- Expecting container changes to persist after restart  
- Confusing image updates with container state  

**Trade-offs:**  
Containers are disposable; persistence must be externalized.

---

## Q4. What is Docker Hub, and what is it used for?

**Answer:**  
Docker Hub is a public container registry used to store, share, and distribute Docker images.

**Scenario:**  
Teams pull official images like `nginx` or push their own application images.

**Pitfalls:**  
- Pulling untrusted images  
- Using `latest` tag in production  

**Trade-offs:**  
Public registries are convenient but less controlled than private registries.

---

## Q5. Explain the Dockerfile and its significance.

**Answer:**  
A Dockerfile is a text file containing instructions to build a Docker image in a reproducible way.

**Scenario:**  
It defines base image, dependencies, environment variables, and startup command.

**Pitfalls:**  
- Large images due to poor layering  
- Not pinning base image versions  

**Trade-offs:**  
Declarative builds improve consistency but require optimization knowledge.

---

## Q6. How does Docker use layers to build images?

**Answer:**  
Each instruction in a Dockerfile creates a new image layer, which Docker caches and reuses to speed up builds.

**Scenario:**  
If dependencies don’t change, Docker reuses cached layers.

**Pitfalls:**  
- Changing files early in Dockerfile invalidates cache  
- Too many layers increase complexity  

**Trade-offs:**  
Layer caching speeds builds but requires careful instruction ordering.

---

## Q7. What’s the difference between COPY and ADD in a Dockerfile?

**Answer:**  
COPY simply copies files, while ADD supports extra features like extracting archives and fetching URLs.

**Scenario:**  
Use COPY for clarity; use ADD only when extraction is needed.

**Pitfalls:**  
- Using ADD unnecessarily  
- Hidden behavior causing confusion  

**Trade-offs:**  
COPY is predictable; ADD is powerful but less explicit.

---

## Q8. What’s the purpose of the .dockerignore file?

**Answer:**  
`.dockerignore` prevents unnecessary files from being sent to the Docker build context.

**Scenario:**  
Ignoring `node_modules` speeds up builds.

**Pitfalls:**  
- Forgetting to exclude large directories  
- Accidentally ignoring required files  

**Trade-offs:**  
Smaller build context improves performance.

---

## Q9. How would you create a Docker image from an existing container?

**Answer:**  
Use `docker commit`, which creates an image from a container’s current state.

**Scenario:**  
Debugging or quick prototyping.

**Pitfalls:**  
- Not reproducible  
- Not suitable for production  

**Trade-offs:**  
Fast but not recommended for long-term workflows.

---

## Q10. How do you reduce the size of Docker images?

**Answer:**  
Use minimal base images, multi-stage builds, clean package caches, and remove unused files.

**Scenario:**  
Multi-stage build separates build tools from runtime.

**Pitfalls:**  
- Leaving build dependencies in final image  

**Trade-offs:**  
Smaller images improve security and startup time.

---

## Q11. What command is used to run a Docker container from an image?

**Answer:**  
`docker run` is used to create and start a container from an image.

**Scenario:**  
`docker run -d -p 80:80 nginx`

**Pitfalls:**  
- Forgetting port mappings  
- Running containers interactively in production  

**Trade-offs:**  
Simple command but many flags require understanding.

---

## Q12. What is a Docker namespace and its benefits?

**Answer:**  
Namespaces isolate container resources like processes, networking, and users.

**Scenario:**  
Two containers can have process ID 1 without conflict.

**Pitfalls:**  
- Assuming full isolation  

**Trade-offs:**  
Lightweight isolation compared to VMs.

---

## Q13. What is a Docker volume, and when would you use it?

**Answer:**  
A Docker volume is managed storage used to persist data outside containers.

**Scenario:**  
Database data stored in volumes survives container restarts.

**Pitfalls:**  
- Storing persistent data inside container filesystem  

**Trade-offs:**  
Volumes are portable and managed but abstract filesystem details.

---

## Q14. Explain the use and significance of docker-compose.

**Answer:**  
Docker Compose defines and runs multi-container applications using a YAML file.

**Scenario:**  
Run app + database + cache together locally.

**Pitfalls:**  
- Using Compose in production without orchestration  

**Trade-offs:**  
Great for dev/testing, limited for large-scale production.

---

## Q15. Can Docker containers on the same host communicate by default?

**Answer:**  
Yes, via the default bridge network using container IPs.

**Scenario:**  
App container talks to DB container on same host.

**Pitfalls:**  
- Using IPs instead of container names  

**Trade-offs:**  
Default bridge works, but user-defined networks are better.

---

## Q16. Describe the different types of Docker networks.

**Answer:**  
Bridge, host, none, overlay, and macvlan networks.

**Scenario:**  
Overlay network enables multi-host container communication.

**Pitfalls:**  
- Using host network unintentionally  

**Trade-offs:**  
Network choice impacts isolation and performance.

---

## Q17. How do you create a Docker network?

**Answer:**  
Using `docker network create`.

**Scenario:**  
Create a custom bridge network for app services.

**Pitfalls:**  
- Using default bridge for complex apps  

**Trade-offs:**  
Custom networks improve DNS and isolation.

---

## Q18. How do you connect a container to a specific network?

**Answer:**  
Use `--network` flag during `docker run` or `docker network connect`.

**Scenario:**  
Connect app container to backend network.

**Pitfalls:**  
- Forgetting network at runtime  

**Trade-offs:**  
Explicit networks improve clarity.

---

## Q19. What is a user-defined bridge network?

**Answer:**  
A custom bridge network that provides automatic DNS resolution and better isolation.

**Scenario:**  
Services communicate using container names.

**Pitfalls:**  
- Sticking to default bridge  

**Trade-offs:**  
More setup but better reliability.

---

## Q20. How do you enable communication between Docker containers on different hosts?

**Answer:**  
Use overlay networks with Docker Swarm or orchestration tools.

**Scenario:**  
Containers on different machines communicate as if on same network.

**Pitfalls:**  
- Assuming bridge networks work across hosts  

**Trade-offs:**  
Overlay networks add complexity.

---

## Q21. How can resource constraints be applied to containers?

**Answer:**  
Using CPU and memory limits via Docker run flags.

**Scenario:**  
Prevent one container from consuming all memory.

**Pitfalls:**  
- No limits → host exhaustion  

**Trade-offs:**  
Limits protect system but may cause throttling.

---

## Q22. What are Docker security profiles?

**Answer:**  
Security profiles like seccomp and AppArmor restrict container system calls.

**Scenario:**  
Prevent containers from performing dangerous kernel operations.

**Pitfalls:**  
- Running containers in privileged mode  

**Trade-offs:**  
Improves security but may block required functionality.

---

## Q23. How would you scan a Docker image for vulnerabilities?

**Answer:**  
Use tools like Trivy, Clair, or Docker Scout.

**Scenario:**  
CI pipeline scans image before deployment.

**Pitfalls:**  
- Ignoring scan results  

**Trade-offs:**  
Scanning improves security but increases build time.

---

## Q24. What is the purpose of a Docker Healthcheck?

**Answer:**  
Healthchecks allow Docker to determine if a container is healthy.

**Scenario:**  
Restart container if application becomes unresponsive.

**Pitfalls:**  
- Healthcheck too strict or too loose  

**Trade-offs:**  
Improves reliability but requires tuning.

---

## Q25. How would you handle sensitive data in Docker?

**Answer:**  
Use environment variables, secrets managers, and avoid baking secrets into images.

**Scenario:**  
Inject DB passwords at runtime.

**Pitfalls:**  
- Hardcoding secrets  
- Logging sensitive values  

**Trade-offs:**  
Secure handling adds operational complexity.

---

## Q26. What is Docker Swarm, and when would you use it?

**Answer:**  
Docker Swarm is Docker’s native orchestration tool for managing clusters.

**Scenario:**  
Small production setup without Kubernetes.

**Pitfalls:**  
- Limited ecosystem compared to Kubernetes  

**Trade-offs:**  
Simpler than Kubernetes but less powerful.

---

## Q27. Difference between Docker Swarm and Kubernetes?

**Answer:**  
Swarm is simpler and easier to set up; Kubernetes is more powerful and extensible.

**Scenario:**  
Enterprise environments prefer Kubernetes.

**Pitfalls:**  
- Choosing Swarm for large-scale systems  

**Trade-offs:**  
Ease of use vs flexibility.

---

## Q28. What is a Docker Stack?

**Answer:**  
A Docker Stack is a group of services deployed together in Docker Swarm using a compose file.

**Scenario:**  
Deploying multi-service application to Swarm.

**Pitfalls:**  
- Assuming Compose and Stack are identical  

**Trade-offs:**  
Stack supports orchestration but is Swarm-specific.


---

## Q29. What happens when you run a Docker container?

**Answer:**  
When you run a Docker container, Docker creates a writable layer on top of the image, sets up namespaces and cgroups for isolation, configures networking, mounts volumes, and starts the container’s entrypoint process.

**Scenario:**  
Running `docker run nginx` pulls the image (if needed), creates a container, and starts the web server.

**Pitfalls:**  
- Assuming containers start instantly (startup scripts still run)  
- Ignoring entrypoint vs command behavior  

**Trade-offs:**  
Fast startup compared to VMs, but still dependent on image size and init logic.

---

## Q30. What is the difference between CMD and ENTRYPOINT?

**Answer:**  
`ENTRYPOINT` defines the main executable, while `CMD` provides default arguments that can be overridden at runtime.

**Scenario:**  
ENTRYPOINT = `python app.py`, CMD = `--port 8080`.

**Pitfalls:**  
- Using only CMD when ENTRYPOINT is needed  
- Overwriting ENTRYPOINT unintentionally  

**Trade-offs:**  
ENTRYPOINT enforces behavior; CMD offers flexibility.

---

## Q31. What is the purpose of EXPOSE in Dockerfile?

**Answer:**  
EXPOSE documents which ports the container listens on; it does not publish ports by itself.

**Scenario:**  
EXPOSE 8080 indicates the app listens on port 8080.

**Pitfalls:**  
- Thinking EXPOSE opens ports automatically  

**Trade-offs:**  
Useful for documentation, not networking control.

---

## Q32. How do you publish ports in Docker?

**Answer:**  
Ports are published using `-p hostPort:containerPort` during `docker run`.

**Scenario:**  
`-p 8080:80` maps container port 80 to host port 8080.

**Pitfalls:**  
- Port conflicts on host  
- Exposing unnecessary ports  

**Trade-offs:**  
Port mapping enables access but increases attack surface.

---

## Q33. What is Docker caching and how does it work?

**Answer:**  
Docker caches image layers so unchanged steps don’t rebuild, speeding up builds.

**Scenario:**  
Dependencies installed before copying app code are reused across builds.

**Pitfalls:**  
- Poor Dockerfile ordering invalidates cache  

**Trade-offs:**  
Cache speeds builds but can hide outdated dependencies if not managed.

---

## Q34. What is a dangling image?

**Answer:**  
Dangling images are unused image layers not referenced by any tag.

**Scenario:**  
Rebuilding images frequently creates dangling layers.

**Pitfalls:**  
- Disk space consumption  

**Trade-offs:**  
Safe to remove, but requires cleanup discipline.

---

## Q35. How do you clean up unused Docker resources?

**Answer:**  
Use commands like `docker system prune` to remove unused containers, images, networks, and volumes.

**Scenario:**  
Free disk space on a CI runner.

**Pitfalls:**  
- Accidentally deleting needed volumes  

**Trade-offs:**  
Cleanup frees space but can remove cached layers.

---

## Q36. What is the Docker build context?

**Answer:**  
The build context is the set of files sent to the Docker daemon during image build.

**Scenario:**  
Entire project directory sent unless filtered by `.dockerignore`.

**Pitfalls:**  
- Large context slows builds  

**Trade-offs:**  
Smaller context improves performance.

---

## Q37. What are multi-stage builds?

**Answer:**  
Multi-stage builds use multiple FROM statements to separate build and runtime environments.

**Scenario:**  
Compile app in one stage, copy binary to slim runtime image.

**Pitfalls:**  
- Forgetting to remove build tools  

**Trade-offs:**  
Smaller images with cleaner runtime environments.

---

## Q38. What is the difference between Docker stop and Docker kill?

**Answer:**  
`docker stop` gracefully shuts down containers, while `docker kill` immediately terminates them.

**Scenario:**  
Stop allows app to clean up resources.

**Pitfalls:**  
- Using kill in production  

**Trade-offs:**  
Graceful shutdown vs immediate termination.

---

## Q39. How does Docker handle logging?

**Answer:**  
Docker captures container stdout/stderr and forwards logs using logging drivers.

**Scenario:**  
Logs are collected by centralized logging systems.

**Pitfalls:**  
- Logging inside container files  

**Trade-offs:**  
Stdout logging is simple but less structured.

---

## Q40. What is Docker inspect?

**Answer:**  
`docker inspect` provides detailed metadata about containers, images, and networks.

**Scenario:**  
Debugging environment variables or mount paths.

**Pitfalls:**  
- Overlooking inspect during debugging  

**Trade-offs:**  
Powerful but verbose output.

---

## Q41. How do you troubleshoot a failing Docker container?

**Answer:**  
Check logs, inspect configuration, exec into container, and verify resource limits.

**Scenario:**  
Container crashes due to missing environment variable.

**Pitfalls:**  
- Debugging inside image instead of container  

**Trade-offs:**  
Containers are ephemeral; fixes should go into Dockerfile.

---

## Q42. What is Docker exec and when is it used?

**Answer:**  
`docker exec` runs commands inside a running container.

**Scenario:**  
Access shell for debugging.

**Pitfalls:**  
- Treating exec as permanent fix  

**Trade-offs:**  
Useful for debugging, not for configuration.

---

## Q43. How do you update a running Docker container?

**Answer:**  
You cannot update a running container; you rebuild the image and redeploy.

**Scenario:**  
New version → new image → new container.

**Pitfalls:**  
- Modifying live containers  

**Trade-offs:**  
Immutability improves reliability.

---

## Q44. What is Docker rollback?

**Answer:**  
Docker itself doesn’t provide rollback; rollback is achieved by redeploying previous images.

**Scenario:**  
Tag-based rollback in CI/CD.

**Pitfalls:**  
- No versioned images  

**Trade-offs:**  
Simple rollback but requires image discipline.

---

## Q45. How does Docker integrate with CI/CD pipelines?

**Answer:**  
Docker builds images in CI, runs tests, scans vulnerabilities, and pushes to registries.

**Scenario:**  
Pipeline builds and deploys image automatically.

**Pitfalls:**  
- No image scanning  
- Using latest tag  

**Trade-offs:**  
Automation increases speed but needs governance.

---

## Q46. What is Docker Registry?

**Answer:**  
A Docker Registry stores and distributes images (Docker Hub, ECR, ACR).

**Scenario:**  
Private registry for enterprise images.

**Pitfalls:**  
- Public images without validation  

**Trade-offs:**  
Private registries improve security but cost more.

---

## Q47. Difference between public and private Docker registries?

**Answer:**  
Public registries are open; private registries restrict access and improve control.

**Scenario:**  
Enterprise apps use private registries.

**Pitfalls:**  
- Exposing proprietary images  

**Trade-offs:**  
Control vs convenience.

---

## Q48. What is Docker secret management?

**Answer:**  
Docker secrets securely store sensitive data and inject them at runtime.

**Scenario:**  
Database password mounted as secret.

**Pitfalls:**  
- Secrets in environment variables  

**Trade-offs:**  
Secure but orchestration-dependent.

---

## Q49. How do you handle persistent storage in Docker?

**Answer:**  
Use volumes or bind mounts for data persistence.

**Scenario:**  
Database data stored in volume.

**Pitfalls:**  
- Writing data inside container filesystem  

**Trade-offs:**  
Volumes are portable; bind mounts give host control.

---

## Q50. What is the difference between volumes and bind mounts?

**Answer:**  
Volumes are managed by Docker; bind mounts map host paths directly.

**Scenario:**  
Bind mounts for local dev, volumes for production.

**Pitfalls:**  
- Hardcoding host paths  

**Trade-offs:**  
Control vs portability.

---

## Q51. How do you secure Docker images?

**Answer:**  
Use minimal base images, scan vulnerabilities, sign images, and keep dependencies updated.

**Scenario:**  
CI pipeline blocks vulnerable images.

**Pitfalls:**  
- Ignoring CVEs  

**Trade-offs:**  
Security checks slow builds but prevent breaches.

---

## Q52. What is Docker content trust?

**Answer:**  
Docker Content Trust ensures image authenticity using digital signatures.

**Scenario:**  
Only signed images allowed in production.

**Pitfalls:**  
- Not enforcing trust policies  

**Trade-offs:**  
Improves security but adds key management.

---

## Q53. How does Docker support microservices architecture?

**Answer:**  
Docker packages each microservice independently, enabling consistent deployment and scaling.

**Scenario:**  
Each service runs in its own container.

**Pitfalls:**  
- Running multiple services in one container  

**Trade-offs:**  
Isolation improves reliability but increases container count.

---

## Q54. What are common Docker best practices?

**Answer:**  
Use small images, multi-stage builds, non-root users, pinned versions, and proper cleanup.

**Scenario:**  
Optimized images deploy faster and safer.

**Pitfalls:**  
- Bloated images  
- Root containers  

**Trade-offs:**  
Best practices require discipline but pay off long-term.

---

## Q55. What are the limitations of Docker?

**Answer:**  
Docker provides weaker isolation than VMs, limited native orchestration, and requires external tools for advanced networking and security.

**Scenario:**  
Large production systems rely on Kubernetes.

**Pitfalls:**  
- Expecting Docker alone to handle everything  

**Trade-offs:**  
Docker excels at packaging, not full platform management.

---
